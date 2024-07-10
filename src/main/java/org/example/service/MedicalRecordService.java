package org.example.service;

import org.example.mapper.RecordMapper;
import org.example.pojo.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private RecordMapper recordMapper;

    public List<MedicalRecord> searchRecord(String id){

        if(recordMapper.findMedicalRecordById(id)==null)
            System.out.println("mapper null");
        return recordMapper.findMedicalRecordById(id);
    }
}
