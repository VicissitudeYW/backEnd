package org.example.dto;

public class SearchReserveDTO {
    private String id;

    private boolean isDoctor;

    public SearchReserveDTO() {}

    public SearchReserveDTO(String id, boolean isDoctor) {
        this.id = id;
        this.isDoctor = isDoctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }
}
