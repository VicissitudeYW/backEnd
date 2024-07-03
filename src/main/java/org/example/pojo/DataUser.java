package org.example.pojo;

public class DataUser {
    protected String id;

    protected String userPswd;

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
}
