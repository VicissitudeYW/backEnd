package org.example.pojo;

public class ChatHistory {
    private String fromId;

    private String toId;

    private String fromRole;

    private String toRole;

    private String message;

    private String chatTime;

    public ChatHistory(String fromId, String toId, String fromRole,
                       String toRole, String message, String chatTime) {
        this.fromId = fromId;
        this.toId = toId;
        this.fromRole = fromRole;
        this.toRole = toRole;
        this.message = message;
        this.chatTime = chatTime;
    }

    public String getFromId() {return fromId;}

    public void setFromId(String fromId) {this.fromId = fromId;}

    public String getToId() {return toId;}

    public void setToId(String toId) {this.toId = toId;}

    public String getFromRole() {
        return fromRole;
    }

    public void setFromRole(String fromRole) {
        this.fromRole = fromRole;
    }

    public String getToRole() {
        return toRole;
    }

    public void setToRole(String toRole) {
        this.toRole = toRole;
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public String getChatTime() {return chatTime;}

    public void setChatTime(String chatTime) {this.chatTime = chatTime;}
}
