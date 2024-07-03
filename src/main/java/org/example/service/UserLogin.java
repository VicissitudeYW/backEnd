package org.example.service;

import org.example.dto.UserDTO;
import org.example.dto.UserResult;
import org.example.pojo.DataUser;
import org.example.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogin {
    @Autowired
    private PatientService patientService;
    private DoctorService doctorService;

    public UserResult login(UserResult userResult, UserDTO userDTO) {
        DataUser dataUser = null;
        if (userDTO.getIs_Doctor()) {
            dataUser =
                    doctorService.selectDoctorByIdAndPswd(userDTO.getUsername(), userDTO.getPassword());
        } else {
            dataUser =
                    patientService.selectPatientByIdAndPswd(userDTO.getUsername(), userDTO.getPassword());
        }

        if (dataUser == null) {
            userResult.setStatus(false);
            userResult.setMsg("用户不存在或密码错误");
            return userResult;
        }

        // 设置 token
        String token = TokenUtils.getToken(dataUser.toString(), dataUser.getUserPswd());
        userResult.setToken(token);

        return userResult;
    }

    public DataUser selectById(String id) {
        DataUser dataUser = null;
        dataUser = patientService.selectPatientById(id);
        if (dataUser == null) {
            dataUser = doctorService.selectDoctorById(id);
        }

        return dataUser;
    }
}
