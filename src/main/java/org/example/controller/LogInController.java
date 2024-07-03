package org.example.controller;

import cn.hutool.core.util.StrUtil;
import org.example.dto.UserDTO;
import org.example.dto.UserResult;
import org.example.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Reno Ng
 * CreateTime: 2024-07-03
 * Description: 登录接口
 */

@RestController
@RequestMapping("/login")
public class LogInController {
    @Autowired
    private UserLogin userLogin;

    @PostMapping
    public UserResult login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        // 判断是否为空
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return new UserResult(false, "", "输入为空，请重试");
        }

        // 管理员账号
        if (username.equals("admin") && password.equals("123456")) {
            return new UserResult(true, "", "");
        }

        UserResult userRes = new UserResult();
        userRes = userLogin.login(userRes, userDTO);
        return userRes;
    }
}
