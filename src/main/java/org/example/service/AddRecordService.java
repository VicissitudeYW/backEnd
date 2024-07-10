package org.example.service;

import org.example.dto.AddRecordDTO;
import org.example.dto.AddRecordResult;
import org.example.exception.ForeignKeyViolationException;
import org.example.mapper.RecordMapper;
import org.example.pojo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AddRecordService {
    @Autowired
    private RecordMapper recordMapper;

    public AddRecordResult addRecord(AddRecordResult addRecordResult, AddRecordDTO addRecordDTO) {
        MedicalRecord medicalRecord = new MedicalRecord(addRecordDTO.getPid(),
                addRecordDTO.getRecord(), addRecordDTO.getTime());

        try {
            recordMapper.insertMedicalRecord(medicalRecord);
            addRecordResult.setStatus(true);
            addRecordResult.setMsg("新建成功");
            return addRecordResult;
        } catch(DataIntegrityViolationException e){
            throw new ForeignKeyViolationException("不存在该患者");
        }
    }
}
