package org.example.pojo;

public class DataUser {
    protected String id;

    protected String userPswd;

    private String msg;

    public DataUser() {}

    public DataUser(String id, String userPswd) {
        this.id = id;
        this.userPswd = userPswd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DataUser{" +
                "id='" + id + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
