package org.example.dto;

import org.example.pojo.MedicalRecord;
import org.example.service.MedicalRecordService;

import java.util.List;

public class SearchRecordResult {
    private List<MedicalRecord> records;

    public SearchRecordResult(List<MedicalRecord> records) {
        this.records = records;
    }

    public SearchRecordResult() {
    }

    public List<MedicalRecord> getRecords() {
        return records;
    }

    public void setRecords(List<MedicalRecord> records) {
        this.records = records;
    }
}
