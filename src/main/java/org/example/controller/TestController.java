package org.example.controller;

import org.example.dto.*;
import org.example.pojo.DataUser;
import org.example.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Reno Ng
 * CreateTime: 2024-07-02
 * Description: 测试接口
 */

@CrossOrigin(origins = "http://8.138.127.170")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private UserLogin userLogin;
    @Autowired
    private ProcessInfoController processInfoController;

    @GetMapping("/0")
    public LoginResult test0() {
        String id = "121";
        String password = "Pg7j7zD5v";
        boolean isDoctor = false;

        LoginDTO loginDTO = new LoginDTO(id, password, isDoctor);
        LoginResult loginResult = new LoginResult();

        return userLogin.login(loginResult, loginDTO);
    }

    @GetMapping("/1")
    public String test1() {
        UpdateInfoDTO updateInfoDTO = new UpdateInfoDTO();
        updateInfoDTO.setId("908");
        updateInfoDTO.setRole("doctor");
        updateInfoDTO.setPassword("1234567890");
        updateInfoDTO.setContact("123");
        updateInfoDTO.setSpecialty("心脏");
        updateInfoDTO.setPosition("");

        processInfoController.updateInfo(updateInfoDTO);

        return "医生信息更新测试完成！";
    }

    @GetMapping("/2")
    public String test2() {
        GetInfoDTO getInfoDTO = new GetInfoDTO();
        getInfoDTO.setId("10");
        getInfoDTO.setIsDoctor(true);

        DataUser dataUser = processInfoController.getInfo(getInfoDTO);

        return dataUser.toString();
    }

    @RequestMapping("/3")
    public String test3() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>WebSocket Test</title>" +
                "</head>" +
                "<body>" +
                "<h2>WebSocket Test</h2>" +
                "<div>" +
                "User ID: <input type='text' id='fromId' value='patient1'><br>" +
                "User Role: <input type='text' id='fromRole' value='patient'><br>" +
                "<button onclick='connect()'>Connect</button>" +
                "<button onclick='disconnect()'>Disconnect</button>" +
                "</div>" +
                "<div>" +
                "Message to ID: <input type='text' id='toId' value='doctor1'><br>" +
                "Message: <input type='text' id='message'><br>" +
                "To Role: <input type='text' id='toRole' value='doctor'><br>" +
                "Chat Time: <input type='text' id='chatTime' value='2024-07-08 14:30:00'><br>" +
                "<button onclick='sendMessage()'>Send Message</button>" +
                "</div>" +
                "<div id='chatBox' style='border: 1px solid black; height: 200px; overflow-y: scroll;'>" +
                "</div>" +
                "<script>" +
                "var ws;" +
                "function connect() {" +
                "    var fromId = document.getElementById('fromId').value;" +
                "    var fromRole = document.getElementById('fromRole').value;" +
                "    ws = new WebSocket('ws://8.138.127.170/chat/' + fromId + '/' + fromRole);" +
                "    ws.onmessage = function(event) {" +
                "        var chatBox = document.getElementById('chatBox');" +
                "        var newMessage = document.createElement('div');" +
                "        newMessage.textContent = event.data;" +
                "        chatBox.appendChild(newMessage);" +
                "    };" +
                "    ws.onopen = function() {" +
                "        var chatBox = document.getElementById('chatBox');" +
                "        var newMessage = document.createElement('div');" +
                "        newMessage.textContent = 'Connected';" +
                "        chatBox.appendChild(newMessage);" +
                "    };" +
                "    ws.onclose = function() {" +
                "        var chatBox = document.getElementById('chatBox');" +
                "        var newMessage = document.createElement('div');" +
                "        newMessage.textContent = 'Disconnected';" +
                "        chatBox.appendChild(newMessage);" +
                "    };" +
                "}" +
                "function disconnect() {" +
                "    if (ws) {" +
                "        ws.close();" +
                "    }" +
                "}" +
                "function sendMessage() {" +
                "    if (ws) {" +
                "        var toId = document.getElementById('toId').value;" +
                "        var message = document.getElementById('message').value;" +
                "        var toRole = document.getElementById('toRole').value;" +
                "        var chatTime = document.getElementById('chatTime').value;" +
                "        var msg = JSON.stringify({" +
                "            toId: toId," +
                "            message: message," +
                "            toRole: toRole," +
                "            chatTime: chatTime" +
                "        });" +
                "        ws.send(msg);" +
                "    }" +
                "}" +
                "</script>" +
                "</body>" +
                "</html>";
    }

}