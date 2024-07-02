package org.example.pojo;

import java.sql.Timestamp;

public class Doctor {
    private String id;

    private String userPswd;

    private String doctorNo;

    private String specialty;

    private String position;

    public Doctor(String id, String userPswd, String doctorNo, String specialty, String position) {
        this.id = id;
        this.userPswd = userPswd;
        this.doctorNo = doctorNo;
        this.specialty = specialty;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
