package org.example.controller;

import org.example.dto.UserDTO;
import org.example.dto.UserResult;
import org.example.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Reno Ng
 * CreateTime: 2024-07-03
 * Description: 登录接口
 */

@RestController
public class LogInController {
    @Autowired
    private UserLogin userLogin;

    @PostMapping(value = "/api/login",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResult login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getId();
        String password = userDTO.getPassword();

        // 管理员账号
        if (username.equals("admin") && password.equals("123456")) {
            return new UserResult(true, "", "", "admin");
        }

        UserResult userRes = new UserResult();
        userRes = userLogin.login(userRes, userDTO);
        return userRes;
    }

}
