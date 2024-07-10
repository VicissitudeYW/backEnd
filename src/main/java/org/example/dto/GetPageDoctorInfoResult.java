package org.example.dto;

import org.example.pojo.Doctor;

import java.util.List;

public class GetPageDoctorInfoResult {
    private List<Doctor> data;

    private int allPage;

    public GetPageDoctorInfoResult(List<Doctor> data, int allPage) {
        this.data = data;
        this.allPage = allPage;
    }

    public List<Doctor> getData() {
        return data;
    }

    public void setData(List<Doctor> data) {
        this.data = data;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }
}
