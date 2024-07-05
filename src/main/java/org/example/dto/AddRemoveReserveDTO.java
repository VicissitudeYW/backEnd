package org.example.dto;

public class AddRemoveReserveDTO {
    private String pid;

    private String did;

    private String date;

    private String timeSeg;

    public AddRemoveReserveDTO() {}

    public AddRemoveReserveDTO(String pid, String did, String date, String timeSeg) {
        this.pid = pid;
        this.did = did;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }
}
