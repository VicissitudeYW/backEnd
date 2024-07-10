package org.example.dto;

public class SearchRecordDTO {
    private String id;

    private boolean isDoctor;

    public SearchRecordDTO(String id) {
        this.id = id;
    }

    public SearchRecordDTO() {}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}
