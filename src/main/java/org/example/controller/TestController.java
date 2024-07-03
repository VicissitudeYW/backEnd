package org.example.controller;

import org.example.pojo.Doctor;
import org.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Reno Ng 吴益伟
 * CreateTime: 2024-07-02
 * Description: 测试接口
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String test() {
        return "接口调用成功！";
    }

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public void insertDoctor() {
        doctorService.insertDoctor(new Doctor("1", "123",
                "1", "心脏", "北京"));
    }
}