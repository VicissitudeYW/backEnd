package org.example.dto;

import org.example.pojo.DataUser;

import java.util.Map;

public class UpdateInfoDTO {
    private String id;

    private String role;

    private Map<String, Object> updateInfo;

    public UpdateInfoDTO() {}

    public UpdateInfoDTO(String id, String role, Map<String, Object> updateInfo) {
        this.id = id;
        this.role = role;
        this.updateInfo = updateInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, Object> getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(Map<String, Object> updateInfo) {
        this.updateInfo = updateInfo;
    }
}
