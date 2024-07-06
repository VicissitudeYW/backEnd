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
    private ReserveController reserveController;
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

    // @GetMapping("/3")
    // public SearchReserveResult test3() {
    //     String id = "1";
    //     boolean isDoctor = true;
    //
    //     return reserveController.searchReserve(new SearchReserveDTO(id, isDoctor));
    // }
}