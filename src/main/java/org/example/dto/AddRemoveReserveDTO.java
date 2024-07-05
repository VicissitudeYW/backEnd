package org.example.dto;

public class AddRemoveReserveDTO {
    private String pid;

    private String did;

    private String resDate;

    private String timeSeg;

    public AddRemoveReserveDTO() {}

    public AddRemoveReserveDTO(String pid, String did, String resDate, String timeSeg) {
        this.pid = pid;
        this.did = did;
        this.resDate = resDate;
        this.timeSeg = timeSeg;
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

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }
}
