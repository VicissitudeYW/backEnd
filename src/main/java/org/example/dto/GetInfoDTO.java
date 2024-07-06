package org.example.dto;

public class GetInfoDTO {
    private String id;

    private boolean isDoctor;

    public GetInfoDTO() {}

    public GetInfoDTO(String id, boolean isDoctor) {
        this.id = id;
        this.isDoctor = isDoctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(boolean doctor) {
        isDoctor = doctor;
    }
}
