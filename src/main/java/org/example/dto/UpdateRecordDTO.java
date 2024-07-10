package org.example.dto;

import java.sql.Timestamp;

public class UpdateRecordDTO {
    private String pid;
    private String time;
    private String updateInfo;

    public UpdateRecordDTO(String pid, String time, String updateInfo) {
        this.pid = pid;
        this.time = time;
        this.updateInfo = updateInfo;
    }

    public UpdateRecordDTO() {}

    public String getPid() {return pid;}

    public void setPid(String pid) {this.pid = pid;}

    public String getUpdateInfo() {return updateInfo;}

    public void setUpdateInfo(String updateInfo) {this.updateInfo = updateInfo;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}
}
