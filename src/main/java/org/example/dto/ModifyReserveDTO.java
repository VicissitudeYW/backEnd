package org.example.dto;

import org.example.pojo.Reserve;

public class ModifyReserveDTO {
    private Reserve old;

    private String timeSeg;

    public ModifyReserveDTO() {}

    public ModifyReserveDTO(Reserve old, String timeSeg) {
        this.old = old;
        this.timeSeg = timeSeg;
    }

    public Reserve getOld() {
        return old;
    }

    public void setOld(Reserve old) {
        this.old = old;
    }

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }
}
