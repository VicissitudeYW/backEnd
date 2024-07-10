package org.example.service;

import org.example.dto.UpdateRecordDTO;
import org.example.mapper.RecordMapper;
import org.example.pojo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecordService {
    @Autowired
    RecordMapper recordMapper;

    public boolean updateRecord(UpdateRecordDTO updateRecordDTO) {
        MedicalRecord medicalRecord = new MedicalRecord(updateRecordDTO.getPid(),
                updateRecordDTO.getUpdateInfo(), updateRecordDTO.getTime());
        recordMapper.updateMedicalRecord(medicalRecord.getPatientId(),
                medicalRecord.getMrTime(), medicalRecord.getContent());
        return true;
    }
}
