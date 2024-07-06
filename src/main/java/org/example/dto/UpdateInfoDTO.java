package org.example.dto;

import org.example.pojo.DataUser;

import java.util.Map;

public class UpdateInfoDTO {
    private String id;

    private String role;

    private String password;

    private String contact;

    private String specialty;

    private String position;

    public UpdateInfoDTO() {}

    public UpdateInfoDTO(String id, String role, String password, String contact,
                         String specialty, String position) {
        this.id = id;
        this.role = role;
        this.password = password;
        this.contact = contact;
        this.specialty = specialty;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
