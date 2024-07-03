package org.example.controller;

import org.example.pojo.Doctor;
import org.example.mapper.DoctorMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: Reno Ng 吴益伟
 * CreateTime: 2024-07-02
 * Description: 测试接口
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private DoctorMapper doctorMapper;

    @GetMapping
    public String test() {
        // Doctor doctor = new Doctor("0", "0", "0", "0", "0");
        // doctorMapper.insertDoctor(doctor);
        return "接口调用成功！";
    }
}