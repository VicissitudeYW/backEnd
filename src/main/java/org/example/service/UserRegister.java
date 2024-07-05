package org.example.service;

import org.example.dto.RegisterDTO;
import org.example.dto.RegisterResult;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegister {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    public RegisterResult register(RegisterResult registerResult, RegisterDTO registerDTO){
        String username = registerDTO.getIdCard();
        if (registerDTO.getIsDoctor()) {
            if (doctorService.selectDoctorById(username) == null) {
                String password = registerDTO.getPassword();
                String specialty = registerDTO.getSpecialty();
                String position = registerDTO.getLocation();
                String doctorNo = registerDTO.getCertificate();
                doctorService.insertDoctor(new Doctor(username, password, doctorNo, specialty, position));
                registerResult.setStatus(true);
                registerResult.setMsg("注册成功");
            } else {
                registerResult.setStatus(false);
                registerResult.setMsg("已存在该用户，注册失败");
            }
        } else {
            if (patientService.selectPatientById(username) == null){
                String password = registerDTO.getPassword();
                String contact  = registerDTO.getContact();
                patientService.insertPatient(new Patient(username, password, contact));
                registerResult.setStatus(true);
                registerResult.setMsg("注册成功");
            } else {
                registerResult.setStatus(false);
                registerResult.setMsg("已存在该用户，注册失败");
            }
        }
        return registerResult;
    }
}
