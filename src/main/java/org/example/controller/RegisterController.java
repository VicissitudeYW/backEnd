package org.example.controller;

import org.example.dto.RegisterDTO;
import org.example.dto.RegisterResult;
import org.example.exception.ForeignKeyViolationException;
import org.example.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Liu
 * CreateTime: 2024-07-03
 * Description: 注册接口
 */

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping
    public RegisterResult register(@RequestBody RegisterDTO registerDTO) {
        RegisterResult registerRes = new RegisterResult();
        registerRes = userRegisterService.register(registerRes, registerDTO);
        return registerRes;
    }

    @ExceptionHandler(ForeignKeyViolationException.class)
    public RegisterResult handleForeignKeyViolationException(ForeignKeyViolationException e) {
        RegisterResult registerRes = new RegisterResult();
        registerRes.setStatus(false);
        registerRes.setMsg(e.getMessage());
        return registerRes;
    }
}
