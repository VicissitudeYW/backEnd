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
        boolean isDoctor = getInfoDTO.getIsDoctor();
        String id = getInfoDTO.getId();

        DataUser dataUser = null;
        if (isDoctor) {
            Doctor doctor = doctorService.selectDoctorById(id);
            if (doctor != null) {
                dataUser = doctor;
            } else {
                dataUser = new DataUser();
                dataUser.setMsg("找不到医生信息");
            }
        } else {
            Patient patient = patientService.selectPatientById(id);
            if (patient != null) {
                dataUser = patient;
            } else {
                dataUser = new DataUser();
                dataUser.setMsg("找不到患者信息");
            }
        }

        return dataUser;
    }

    @PostMapping("/api/updateInfo")
    public UpdateInfoResult updateInfo(@RequestBody UpdateInfoDTO updateInfoDTO) {
        String id = updateInfoDTO.getId();
        String role = updateInfoDTO.getRole();
        String password = updateInfoDTO.getPassword();
        String specialty = updateInfoDTO.getSpecialty();
        String position = updateInfoDTO.getPosition();
        String contact = updateInfoDTO.getContact();

        switch (role.toLowerCase()) {
            case "admin":
                if (doctorService.selectDoctorById(id) != null) {
                    doctorService.updateDoctor(id, password, specialty, position);
                    return new UpdateInfoResult(true, "更新成功");
                } else if (patientService.selectPatientById(id) != null) {
                    patientService.updatePatient(id, password, contact);
                    return new UpdateInfoResult(true, "更新成功");
                } else {
                    return new UpdateInfoResult(false, "未找到该医生或患者");
                }


            case "doctor":
                if (doctorService.selectDoctorById(id) != null) {
                    doctorService.updateDoctor(id, password, specialty, position);
                    return new UpdateInfoResult(true, "更新成功");
                } else {
                    return new UpdateInfoResult(false, "未找到该医生");
                }

            case "patient":
                if (patientService.selectPatientById(id) != null) {
                    patientService.updatePatient(id, password, contact);
                    return new UpdateInfoResult(true, "更新成功");
                } else {
                    return new UpdateInfoResult(false, "未找到该患者");
                }

            default:
                return new UpdateInfoResult(false, "查询有误，请检查输入");
        }
    }

}
