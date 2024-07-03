package org.example.pojo;

public class Medical_record {
    private String patient_id;

    private String content;

    public Medical_record(String patient_id, String content) {
        this.patient_id = patient_id;
        this.content = content;
    }

    public String getPatient_id() {return patient_id;}

    public void setPatient_id(String patient_id) {this.patient_id = patient_id;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}
}
