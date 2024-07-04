package org.example.dto;

import org.example.pojo.Reserve;

import java.util.List;

public class SearchReserveResult {
    private List<Reserve> reserves;

    public SearchReserveResult(List<Reserve> reserves) {
        this.reserves = reserves;
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }
}
