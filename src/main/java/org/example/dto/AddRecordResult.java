package org.example.dto;

public class AddRecordResult {
    private boolean status;
    private String msg;

    public AddRecordResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public AddRecordResult() {

    }

    public boolean isStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    public String getMsg() {return msg;}

    public void setMsg(String msg) {this.msg = msg;}
}
