package org.example.dto;

public class LoginDTO {
    private String id;
    private String password;
    private boolean isDoctor;

    public LoginDTO() {}

    public LoginDTO(String username, String password, boolean isDoctor) {
        this.id = username;
        this.password = password;
        this.isDoctor = isDoctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(boolean doctor) {
        this.isDoctor = doctor;
    }
}
