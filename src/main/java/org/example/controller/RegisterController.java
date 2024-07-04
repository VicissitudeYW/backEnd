package org.example.controller;

import org.example.dto.RegisterDTO;
import org.example.dto.RegisterResult;
import org.example.service.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private UserRegister userRegister;

    @PostMapping
    public RegisterResult register(@RequestBody RegisterDTO registerDTO) {
        RegisterResult registerRes = new RegisterResult();
        registerRes = userRegister.register(registerRes, registerDTO);
        return registerRes;
    }
}
