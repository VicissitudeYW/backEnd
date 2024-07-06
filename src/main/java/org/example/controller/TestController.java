package org.example.controller;


import org.example.dto.GetInfoDTO;
import org.example.dto.UpdateInfoDTO;
import org.example.pojo.DataUser;
import org.example.pojo.Patient;
import org.example.pojo.Reserve;
import org.example.service.PatientService;
import org.example.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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
    private ProcessInfoController processInfoController;

    @GetMapping("/1")
    public String test() {

        Map<String, Object> updateInfo = new HashMap<>();
        updateInfo.put("userPswd", "123");
        updateInfo.put("specialty", "HPXJHIXvbR");
        updateInfo.put("position", "UpD4UUE4y1");

        UpdateInfoDTO updateInfoDTO = new UpdateInfoDTO();
        updateInfoDTO.setId("908");
        updateInfoDTO.setRole("doctor");
        updateInfoDTO.setUpdateInfo(updateInfo);

        processInfoController.updateInfo(updateInfoDTO);

        return "医生信息更新测试完成！";
    }

    @GetMapping("/2")
    public String test2() {
        GetInfoDTO getInfoDTO = new GetInfoDTO();
        getInfoDTO.setId("121");
        getInfoDTO.setDoctor(false);

        DataUser dataUser = processInfoController.getInfo(getInfoDTO);

        return dataUser.toString();
    }

}