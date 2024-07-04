package org.example.dto;

public class RegisterDTO {
    private String idCard;
    private String password;
    private String isDoctor;
    private String certificate;
    private String specialty;
    private String location;
    private String contact;

    public RegisterDTO(String idCard, String password, String isDoctor,
                       String certificate, String specialty, String location, String contact) {
        this.idCard = idCard;
        this.password = password;
        this.isDoctor = isDoctor;
        this.certificate = certificate;
        this.specialty = specialty;
        this.location = location;
        this.contact = contact;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(String isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
