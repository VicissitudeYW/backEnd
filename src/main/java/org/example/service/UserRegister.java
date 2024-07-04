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
    private DoctorService doctorService;

    public RegisterResult register(RegisterResult registerResult, RegisterDTO registerDTO){
        String username = registerDTO.getIdCard();
        if (registerDTO.getIsDoctor().equals("true")){
            if(doctorService.selectDoctorById(username) == null) {
                String password = registerDTO.getPassword();
                String specialty = registerDTO.getSpecialty();
                String position = registerDTO.getLocation();
                String doctorNo = registerDTO.getCertificate();
                doctorService.insertDoctor(new Doctor(username, password, specialty, position, doctorNo));
                registerResult.setStatus(true);
                registerResult.setMsg("注册成功");
                return registerResult;
            } else {
                registerResult.setStatus(false);
                registerResult.setMsg("已存在该用户，注册失败");
                return registerResult;
            }
        } else {
            if (patientService.selectPatientById(username) == null){
                String password = registerDTO.getPassword();
                String contact  = registerDTO.getContact();
                patientService.insertPatient(new Patient(username, password, contact));
                registerResult.setStatus(true);
                registerResult.setMsg("注册成功");
                return registerResult;
            } else {
                registerResult.setStatus(false);
                registerResult.setMsg("已存在该用户，注册失败");
                return registerResult;
            }
        }
    }
}
