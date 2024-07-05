package org.example.dto;

public class AddRemoveReserveDTO {
    private String patientId;

    private String doctorId;

    private String resDate;

    private String timeSeg;

    public AddRemoveReserveDTO() {}

    public AddRemoveReserveDTO(String patientId, String doctorId, String resDate, String timeSeg) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.resDate = resDate;
        this.timeSeg = timeSeg;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }
}
