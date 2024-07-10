package org.example.pojo;


public class Reserve {
    private String patientId;

    private String doctorId;

    private String timeSeg;

    private String resDate;

    public Reserve() {}

    public Reserve(String patientId, String doctorId, String resDate, String timeSeg) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timeSeg = timeSeg;
        this.resDate = resDate;
    }

    public String getPatientId() {return patientId;}

    public void setPatientId(String patientId) {this.patientId = patientId;}

    public String getDoctorId() {return doctorId;}

    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }
}
