package org.example.pojo;

import java.sql.Timestamp;

public class Chat_history {
    private String patient_id;

    private String doctor_id;

    private boolean is_patient;

    private String content;

    private Timestamp chat_time;

    public Chat_history(String patient_id, String doctor_id, boolean is_patient, String content, Timestamp chat_time) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.is_patient = is_patient;
        this.content = content;
        this.chat_time = chat_time;
    }

    public String getPatient_id() {return patient_id;}

    public void setPatient_id(String patient_id) {this.patient_id = patient_id;}

    public String getDoctor_id() {return doctor_id;}

    public void setDoctor_id(String doctor_id) {this.doctor_id = doctor_id;}

    public boolean isIs_patient() {return is_patient;}

    public void setIs_patient(boolean is_patient) {this.is_patient = is_patient;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public Timestamp getChat_time() {return chat_time;}

    public void setChat_time(Timestamp chat_time) {this.chat_time = chat_time;}
}
