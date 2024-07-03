package org.example.pojo;

import java.sql.Timestamp;

public class Reserve {
    private String patient_id;

    private String doctor_id;

    private Timestamp res_time;

    public Reserve(String patient_id, String doctor_id, Timestamp res_time) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.res_time = res_time;
    }

    public String getPatient_id() {return patient_id;}

    public void setPatient_id(String patient_id) {this.patient_id = patient_id;}

    public String getDoctor_id() {return doctor_id;}

    public void setDoctor_id(String doctor_id) {this.doctor_id = doctor_id;}

    public Timestamp getRes_time() {return res_time;}

    public void setRes_time(Timestamp res_time) {
        this.res_time = res_time;
    }
}
