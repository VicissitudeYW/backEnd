package org.example.controller;


import org.example.pojo.Patient;
import org.example.pojo.Reserve;
import org.example.service.PatientService;
import org.example.service.ReserveService;
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
    private ReserveService reserveService;

    @GetMapping
    public String test() {
        int deleted = reserveService.deleteReserve(
                new Reserve("121", "10", "2024-07-18", "14:00:00-15:00:00"));
        return deleted + "接口调用成功！";
    }

}