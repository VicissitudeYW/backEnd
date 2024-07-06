package org.example.pojo;

import java.sql.Timestamp;

public class ChatHistory {
    private String patientId;

    private String doctorId;

    private boolean isDoctor;

    private String content;

    private String chatTime;

    public ChatHistory(String patientId, String doctorId, boolean isDoctor, String content, String chatTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.isDoctor = isDoctor;
        this.content = content;
        this.chatTime = chatTime;
    }

    public String getPatientId() {return patientId;}

    public void setPatientId(String patientId) {this.patientId = patientId;}

    public String getDoctorId() {return doctorId;}

    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}

    public boolean isDoctor() {return isDoctor;}

    public void setDoctor(boolean doctor) {this.isDoctor = doctor;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public String getChatTime() {return chatTime;}

    public void setChatTime(String chatTime) {this.chatTime = chatTime;}
}
