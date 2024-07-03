package org.example.pojo;

public class Patient extends DataUser {
    private String contact;

    public Patient() {}

    public Patient(String id, String userPswd, String contact) {
        this.id = id;
        this.userPswd = userPswd;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
