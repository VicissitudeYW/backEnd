package org.example.controller;


import org.example.pojo.Patient;
import org.example.service.PatientService;
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

@CrossOrigin(origins = "http://8.127.137.170")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String test() {
        Patient patient = new Patient("1", "123", "123@qq.com");
        patientService.insertPatient(patient);
        return "接口调用成功！";
    }

}