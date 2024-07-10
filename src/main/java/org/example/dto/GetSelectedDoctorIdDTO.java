package org.example.dto;

public class GetSelectedDoctorIdDTO {
    private String position;

    private String specialty;

    public GetSelectedDoctorIdDTO() {}

    public GetSelectedDoctorIdDTO(String position, String specialty) {
        this.position = position;
        this.specialty = specialty;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
