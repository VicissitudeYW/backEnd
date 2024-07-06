package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.exception.ForeignKeyViolationException;
import org.example.mapper.DoctorMapper;
import org.example.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


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
        try {
            doctorMapper.insertDoctor(doctor);
        } catch (DataIntegrityViolationException e) {
            throw new ForeignKeyViolationException("医生凭证不存在，请重新输入");
        }
    }

    public void updateDoctor(String id,
                             String userPswd,
                             String doctorNo,
                             String specialty,
                             String position) {
        doctorMapper.updateDoctor(id, userPswd, doctorNo, specialty, position);
    }
}
