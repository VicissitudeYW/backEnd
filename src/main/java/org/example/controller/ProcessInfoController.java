package org.example.controller;

import org.example.dto.GetInfoDTO;
import org.example.dto.UpdateInfoDTO;
import org.example.dto.UpdateInfoResult;
import org.example.pojo.DataUser;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;
import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Reno Ng
 * CreateTime: 2024-07-06
 * Description: 信息更新接口
 */

@RestController
public class ProcessInfoController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/api/getInfo")
    public DataUser getInfo(@RequestBody GetInfoDTO getInfoDTO) {
        boolean isDoctor = getInfoDTO.isDoctor();
        String id = getInfoDTO.getId();

        DataUser dataUser;
        if (isDoctor) {
            dataUser = doctorService.selectDoctorById(id);
        } else {
            dataUser = patientService.selectPatientById(id);
        }

        if (dataUser == null) {
            dataUser = new DataUser();
            dataUser.setMsg(isDoctor ? "找不到医生信息" : "找不到患者信息");
        }

        return dataUser;
    }

    @PostMapping("/api/updateInfo")
    public UpdateInfoResult updateInfo(@RequestBody UpdateInfoDTO updateInfoDTO) {
        String id = updateInfoDTO.getId();
        String role = updateInfoDTO.getRole();
        Map<String, Object> updateInfo = updateInfoDTO.getUpdateInfo();

        switch (role.toLowerCase()) {
            case "admin":
                if (!updateDoctorInfo(id, updateInfo) && !updatePatientInfo(id, updateInfo)) {
                    return new UpdateInfoResult(false, "未找到该医生或患者");
                }
                break;

            case "doctor":
                if (!updateDoctorInfo(id, updateInfo)) {
                    return new UpdateInfoResult(false, "未找到该医生");
                }
                break;

            case "patient":
                if (!updatePatientInfo(id, updateInfo)) {
                    return new UpdateInfoResult(false, "未找到该患者");
                }
                break;

            default:
                return new UpdateInfoResult(false, "查询有误，请检查输入");
        }

        return new UpdateInfoResult(true, "更新成功");
    }

    private boolean updateDoctorInfo(String id, Map<String, Object> updateInfo) {
        Doctor doctor = doctorService.selectDoctorById(id);
        if (doctor == null) {
            return false;
        }

        doctorService.updateDoctor(id,
                                   (String) updateInfo.get("userPswd"),
                                   (String) updateInfo.get("doctorNo"),
                                   (String) updateInfo.get("specialty"),
                                   (String) updateInfo.get("position"));

        return true;
    }

    private boolean updatePatientInfo(String id, Map<String, Object> updateInfo) {
        Patient patient = patientService.selectPatientById(id);
        if (patient == null) {
            return false;
        }

        patientService.updatePatient(id,
                                    (String) updateInfo.get("userPswd"),
                                    (String) updateInfo.get("contact"));

        return true;
    }
}
