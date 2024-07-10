package org.example.dto;

public class GetPageDoctorInfoDTO {
    private int page;

    private int eachPageNum;

    public GetPageDoctorInfoDTO() {}

    public GetPageDoctorInfoDTO(int page, int eachPageNum) {
        this.page = page;
        this.eachPageNum = eachPageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getEachPageNum() {
        return eachPageNum;
    }

    public void setEachPageNum(int eachPageNum) {
        this.eachPageNum = eachPageNum;
    }
}
