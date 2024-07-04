package org.example.dto;

public class LoginResult {
    private boolean status;
    private String token;
    private String msg;
    private String role;

    public LoginResult() {}

    public LoginResult(boolean status, String token, String msg, String role) {
        this.status = status;
        this.token = token;
        this.msg = msg;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
