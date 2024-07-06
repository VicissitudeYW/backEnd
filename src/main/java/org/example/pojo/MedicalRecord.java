package org.example.pojo;

import java.sql.Timestamp;

public class MedicalRecord {
    private String patientId;

    private String content;

    private String mrTime;

    public MedicalRecord(String patientId, String content, String mrTime) {
        this.patientId = patientId;
        this.content = content;
        this.mrTime = mrTime;
    }

    public String getPatientId() {return patientId;}

    public void setPatientId(String patientId) {this.patientId = patientId;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public String getMrTime() {
        return mrTime;
    }

    public void setMrTime(String mrTime) {
        this.mrTime = mrTime;
    }
}
