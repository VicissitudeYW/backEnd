package org.example.service;

import org.example.mapper.ReserveMapper;
import org.example.pojo.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private ReserveMapper reserveMapper;

    public List<Reserve> selectByPatientId(String id) {
        return reserveMapper.selectByPatientId(id);
    }

    public List<Reserve> selectByDoctorId(String id) {
        return reserveMapper.selectByDoctorId(id);
    }

    public List<Reserve> selectByDoctorIdAndDate(String id, String date) {
        return reserveMapper.selectByDoctorIdAndDate(id, date);
    }

    public void insertReserve(Reserve reserve) {
        reserveMapper.insertReserve(reserve);
    }

    public int deleteReserve(Reserve reserve) {
        return reserveMapper.deleteReserve(reserve);
    }

}