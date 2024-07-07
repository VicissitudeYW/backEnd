package org.example.dto;

public class getChatHistoryDTO {
    private String patientId;

    private String doctorId;

    public getChatHistoryDTO() {}

    public getChatHistoryDTO(String patientId, String doctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
