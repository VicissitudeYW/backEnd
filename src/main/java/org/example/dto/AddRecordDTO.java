package org.example.dto;

import java.sql.Timestamp;

public class AddRecordDTO {
    private String pid;
    private String time;
    private String record;

    public AddRecordDTO(){}

    public AddRecordDTO(String pid, String time, String record) {
        this.pid = pid;
        this.time = time;
        this.record = record;
    }

    public String getPid() {return pid;}

    public void setPid(String pid) {this.pid = pid;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getRecord() {return record;}

    public void setRecord(String record) {this.record = record;}
}
