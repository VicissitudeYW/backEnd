package org.example.service;

import org.example.mapper.DoctorMapper;
import org.example.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public void insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
    }
}
