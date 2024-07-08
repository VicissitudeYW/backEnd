package org.example.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.example.pojo.ChatHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat/{fromId}/{fromRole}")
public class WebSocketService {
    // 设置服务器日志
    private static final Logger logger =
            LoggerFactory.getLogger(WebSocketService.class);

    /*
    * 记录当前在线患者和医生的会话
    * 1. 使用Map映射用户和会话
    * 2. 使用Map映射患者和医生，以及医生和患者（多对多的咨询）
    * */
    private static final Map<String, Session> patientSessions =
            new ConcurrentHashMap<>();
    private static final Map<String, Session> doctorSessions =
            new ConcurrentHashMap<>();
    private static final Map<String, List<String>> patientDoctorMap =
            new ConcurrentHashMap<>();
    private static final Map<String, List<String>> doctorPatientMap =
            new ConcurrentHashMap<>();

    @Autowired
    private ChatService chatService;

    /*
     * 连接建立
     *
     * @param session  WebSocket会话
     * @param userType 用户类型
     * @param username 用户名
     */
    @OnOpen
    public void handleOnOpen(Session session, @PathParam("fromId") String fromId,
                             @PathParam("fromRole") String fromRole) {
        if (fromRole.equals("Patient")) {
            patientSessions.put(fromId, session);
            logger.info("新患者 {} 进入咨询，当前在线患者数: {}", fromId, patientSessions.size());
        } else if (fromRole.equals("Doctor")) {
            doctorSessions.put(fromId, session);
            logger.info("新医生 {} 进入咨询，当前在线医生数: {}", fromId, doctorSessions.size());
        }

    }

    /*
     * 连接关闭
     *
     * @param session  WebSocket会话
     * @param userType 用户类型
     * @param username 用户名
     */
    @OnClose
    public void handleOnClose(Session session, @PathParam("fromId") String fromId,
                              @PathParam("fromRole") String fromRole) {
        if (fromRole.equals("Patient")) {
            patientSessions.remove(fromId);
            patientDoctorMap.remove(fromId);
            doctorPatientMap.forEach((doctor, patients) -> patients.remove(fromId));
            logger.info("患者 {} 关闭连接，当前在线患者数: {}", fromId, patientSessions.size());
        } else if (fromRole.equals("Doctor")) {
            doctorSessions.remove(fromId);
            doctorPatientMap.remove(fromId);
            patientDoctorMap.forEach((doctor, patients) -> patients.remove(fromId));
            logger.info("医生 {} 关闭连接，当前在线医生数: {}", fromId, doctorSessions.size());
        }
    }

    /*
     * 服务端接收客户端消息
     *
     * @param message  客户端发送过来的消息
     * @param session  WebSocket会话
     * @param userType 用户类型
     * @param username 用户名
     */
    @OnMessage
    public void handleOnMessage(Session session, String content,
                                @PathParam("fromId") String fromId,
                                @PathParam("fromRole") String fromRole) {
        JSONObject jsonObj = JSONUtil.parseObj(content);
        String toId = jsonObj.getStr("toId");
        String msg = jsonObj.getStr("message");
        String toRole = jsonObj.getStr("toRole");
        String chatTime = jsonObj.getStr("chatTime");

        chatService.saveChatHistory
                (new ChatHistory(fromId, toId, fromRole, toRole, msg, chatTime));

        if (fromRole.equals("Patient") && toRole.equals("Doctor")) {
            // 病人发送给医生
            handlePatientToDoctorMsg(fromId, toId, msg);
        } else if (fromRole.equals("Doctor") && toRole.equals("Patient")) {
            // 医生发送给病人
            handleDoctorToPatientMsg(fromId, toId, msg);
        }
    }

    /*
     * 病人发送消息给医生
     *
     * @param patientUsername 病人用户名
     * @param doctorUsername  医生用户名
     * @param text            消息文本
     */
    private void handlePatientToDoctorMsg(String fromId, String toId, String msg) {
        logger.info("服务端 收到 {} 用户 {} 的消息: {}", fromId, toId, msg);
        Session toSession = doctorSessions.get(toId);
        if (toSession != null) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.set("fromId", fromId);
            jsonObj.set("fromRole", "Patient");
            jsonObj.set("message", msg);
            sendMessage(jsonObj.toString(), toSession);
            logger.info("患者 {} 发送给 医生 {}，内容: {}", fromId, toId, jsonObj.toString());

            patientDoctorMap.putIfAbsent(fromId, new ArrayList<>());
            patientDoctorMap.get((fromId)).add(toId);

            doctorPatientMap.putIfAbsent(toId, new ArrayList<>());
            doctorPatientMap.get((toId)).add(fromId);
        } else {
            logger.info("发送失败，未找到 医生 {} 的会话", toId);
        }
    }

    /*
     * 医生发送消息给病人
     *
     * @param doctorUsername  医生用户名
     * @param patientUsername 病人用户名
     * @param text            消息文本
     */
    private void handleDoctorToPatientMsg(String fromId, String toId, String msg) {
        Session toSession = doctorSessions.get(toId);
        if (toSession != null) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.set("fromId", fromId);
            jsonObj.set("fromRole", "Doctor");
            jsonObj.set("message", msg);
            sendMessage(jsonObj.toString(), toSession);
            logger.info("医生 {} 发送给 患者 {}，内容: {}", fromId, toId, jsonObj.toString());

            patientDoctorMap.putIfAbsent(toId, new ArrayList<>());
            patientDoctorMap.get((toId)).add(fromId);

            doctorPatientMap.putIfAbsent(fromId, new ArrayList<>());
            doctorPatientMap.get((fromId)).add(toId);
        } else {
            logger.info("发送失败，未找到 患者 {} 的会话", toId);
        }
    }

    /*
     * 服务端发送消息给指定客户端
     *
     * @param message   消息内容
     * @param toSession 目标会话
     */
    private void sendMessage(String msg, Session toSession) {
        try {
            logger.info("服务端给客户端 {} 发送消息: {}", toSession.getId(), msg);
            toSession.getBasicRemote().sendText(msg);
        } catch (Exception e) {
            logger.error("服务端发送失败", e);
        }
    }

    /*
     * 错误处理
     *
     * @param session WebSocket会话
     * @param error   错误
     */
    @OnError
    public void handleOnError(Session session, Throwable error) {
        logger.error("突发错误，请稍后再试", error);
        error.printStackTrace();
    }
}
