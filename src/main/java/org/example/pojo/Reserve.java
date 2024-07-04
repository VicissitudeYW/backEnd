package org.example.pojo;


public class Reserve {
    private String patientId;

    private String doctorId;

    private String startTime;

    private String endTime;

    private String resDate;

    public Reserve(String patientId, String doctorId, String startTime, String endTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPatientId() {return patientId;}

    public void setPatientId(String patientId) {this.patientId = patientId;}

    public String getDoctorId() {return doctorId;}

    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}

    public String getStartTime() {return startTime;}

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
