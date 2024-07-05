package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.LoginResult;
import org.example.pojo.DataUser;
import org.example.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogin {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    public LoginResult login(LoginResult loginResult, LoginDTO loginDTO) {
        DataUser dataUser = null;
        boolean flag = loginDTO.getIs_Doctor();
        if (flag) {
            dataUser =
                    doctorService.selectDoctorByIdAndPswd(loginDTO.getId(), loginDTO.getPassword());
            loginResult.setRole("Doctor");
        } else {
            dataUser =
                    patientService.selectPatientByIdAndPswd(loginDTO.getId(), loginDTO.getPassword());
            loginResult.setRole("Patient");
        }

        if (dataUser == null) {
            loginResult.setStatus(false);
            loginResult.setMsg("用户不存在或密码错误");
            return loginResult;
        }


        loginResult.setStatus(true);
        loginResult.setMsg("登录成功");

        // 设置 token
        String token = TokenUtils.getToken(dataUser.toString(), dataUser.getUserPswd());
        loginResult.setToken(token);

        return loginResult;
    }

    public DataUser selectById(String id) {
        DataUser dataUser = null;
        dataUser = doctorService.selectDoctorById(id);
        if (dataUser == null) {
            dataUser = patientService.selectPatientById(id);
        }
        return dataUser;
    }
}
