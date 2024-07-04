package org.example.dto;

public class AddRemoveReserveDTO {
    private String pid;

    private String did;

    private String startTime;

    private String endTime;

    public AddRemoveReserveDTO() {}

    public AddRemoveReserveDTO(String pid, String did, String startTime, String endTime) {
        this.pid = pid;
        this.did = did;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
