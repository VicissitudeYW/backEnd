package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.mapper.DoctorMapper;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public Doctor selectDoctorById(String id) {
        return doctorMapper.selectDoctorById(id);
    }

    public Doctor selectDoctorByIdAndPswd(String id, String userPswd) {
        return doctorMapper.selectDoctorByIdAndPswd(id, userPswd);
    }

    public void insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
    }
}
