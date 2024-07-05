package org.example.controller;

import org.example.dto.LoginDTO;
import org.example.dto.LoginResult;
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
    public LoginResult login(@RequestBody LoginDTO loginDTO) {
        String username = loginDTO.getId();
        String password = loginDTO.getPassword();

        // 管理员账号
        if (username.equals("admin") && password.equals("123456")) {
            return new LoginResult(true, "", "", "Admin");
        }

        LoginResult userRes = new LoginResult();
        userRes = userLogin.login(userRes, loginDTO);
        return userRes;
    }

}
