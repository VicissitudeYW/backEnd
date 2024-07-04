package org.example.dto;

public class RegisterResult{
    private boolean status;
    private String msg;

    public RegisterResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public RegisterResult() {}

    public boolean isStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    public String getMsg() {return msg;}

    public void setMsg(String msg) {this.msg = msg;}
}
