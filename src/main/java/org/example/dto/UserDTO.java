package org.example.dto;

public class UserDTO {
    private String id;
    private String password;
    private boolean is_Doctor;

    public UserDTO() {}

    public UserDTO(String username, String password, boolean is_Doctor) {
        this.id = username;
        this.password = password;
        this.is_Doctor = is_Doctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIs_Doctor() {
        return is_Doctor;
    }

    public void setIs_Doctor(boolean is_Doctor) {
        this.is_Doctor = is_Doctor;
    }
}
