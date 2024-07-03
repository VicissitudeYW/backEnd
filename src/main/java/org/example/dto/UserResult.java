package org.example.dto;

public class UserResult {
    private boolean status;
    private String token;
    private String msg;

    public UserResult() {}

    public UserResult(boolean status, String token, String msg) {
        this.status = status;
        this.token = token;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
