package org.example.service;

import org.example.mapper.PatientMapper;
import org.example.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PatientService {
    @Resource
    private PatientMapper patientMapper;

    public Patient selectPatientById(String id) {
        return patientMapper.selectPatientById(id);
    }

    public Patient selectPatientByIdAndPswd(String id, String userPswd) {
        return patientMapper.selectPatientByIdAndPswd(id, userPswd);
    }

    public void insertPatient(Patient patient) {
        patientMapper.insertPatient(patient);
    }
}
