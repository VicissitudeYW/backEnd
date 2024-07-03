package org.example.controller;

import org.example.pojo.Doctor;
import org.example.pojo.Patient;
import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Reno Ng
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
    private PatientService patientService;

    @GetMapping
    public void insertDoctor() {
        doctorService.insertDoctor(new Doctor("1", "123",
                "1", "心脏", "北京"));

        patientService.insertPatient(new Patient("1", "123", "12345"));
    }
}