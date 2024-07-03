package org.example.pojo;

public class Patient extends DataUser {
    private String contact;

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
