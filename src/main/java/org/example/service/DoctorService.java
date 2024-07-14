package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.exception.ForeignKeyViolationException;
import org.example.mapper.DoctorMapper;
import org.example.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


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
                             String specialty,
                             String position) {
        doctorMapper.updateDoctor(id, userPswd, specialty, position);
    }

    public String selectDoctorByCredential(String doctorNo) {
        return doctorMapper.selectDoctorByCredential(doctorNo);
    }

    public List<Doctor> selectDoctorLimitOffset(int page, int eachPageNum) {
        int lim = eachPageNum;
        int off = (page - 1) * eachPageNum;
        return doctorMapper.selectDoctorLimitOffset(lim, off);
    }

    public int countRows() {
        return doctorMapper.countRows();
    }

    public List<String> selectDoctorByPositionAndSpecialty(String position, String specialty) {
        return doctorMapper.selectDoctorByPositionAndSpecialty(position, specialty);
    }
}
