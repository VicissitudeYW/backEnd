package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.LoginResult;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    public LoginResult login(LoginResult loginResult, LoginDTO loginDTO) {
        boolean flag = loginDTO.getIsDoctor();
        if (flag) {
            Doctor doctor =
                    doctorService.selectDoctorByIdAndPswd(loginDTO.getId(), loginDTO.getPassword());
            loginResult.setRole("Doctor");
            if (doctor == null) {
                loginResult.setStatus(false);
                loginResult.setMsg("用户不存在或密码错误");
                return loginResult;
            }
            loginResult.setToken(doctor.getUserPswd());
            loginResult.setStatus(true);
            loginResult.setMsg("登录成功");
        } else {
            Patient patient =
                    patientService.selectPatientByIdAndPswd(loginDTO.getId(), loginDTO.getPassword());
            loginResult.setRole("Patient");
            if (patient == null) {
                loginResult.setStatus(false);
                loginResult.setMsg("用户不存在或密码错误");
                return loginResult;
            }
            loginResult.setToken(patient.getUserPswd());
            loginResult.setStatus(true);
            loginResult.setMsg("登录成功");
        }

        return loginResult;
    }
}
