package org.example.pojo;

public class Doctor extends DataUser {
    private String doctorNo;

    private String specialty;

    private String position;

    public Doctor() {}

    public Doctor(String id, String userPswd, String doctorNo, String specialty, String position) {
        this.id = id;
        this.userPswd = userPswd;
        this.doctorNo = doctorNo;
        this.specialty = specialty;
        this.position = position;
    }


    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", userPswd='" + userPswd + '\'' +
                "doctorNo='" + doctorNo + '\'' +
                ", specialty='" + specialty + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
