package org.example.controller;

import org.example.dto.*;
import org.example.exception.DuplicateReserveException;
import org.example.pojo.Reserve;
import org.example.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Reno Ng
 * CreateTime: 2024-07-05
 * Description: 预约操作接口
 */

@RestController
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @PostMapping("/api/addReserve")
    public AddRemoveReserveResult addReserve(@RequestBody AddRemoveReserveDTO arrDTO) {
        String pid = arrDTO.getPatientId();
        String did = arrDTO.getDoctorId();
        String date = arrDTO.getResDate();
        String timeSeg = arrDTO.getTimeSeg();

        reserveService.insertReserve(new Reserve(pid, did, date, timeSeg));

        return new AddRemoveReserveResult(true, "预约成功");
    }

    @PostMapping("/api/removeReserve")
    public AddRemoveReserveResult removeReserve(@RequestBody AddRemoveReserveDTO arrDTO) {
        String pid = arrDTO.getPatientId();
        String did = arrDTO.getDoctorId();
        String date = arrDTO.getResDate();
        String timeSeg = arrDTO.getTimeSeg();

        int deletedRow =
                reserveService.deleteReserve(new Reserve(pid, did, date, timeSeg));

        if (deletedRow == 0) {
            return new AddRemoveReserveResult(false, "删除失败，不存在相关的预约记录");
        } else {
            return new AddRemoveReserveResult(true, "删除成功");
        }
    }

    @PostMapping("/api/searchReserve")
    public SearchReserveResult searchReserve(@RequestBody SearchReserveDTO srDTO) {
        String id = srDTO.getId();
        boolean isDoctor = srDTO.getIsDoctor();

        List<Reserve> row = isDoctor ?
                reserveService.selectByDoctorId(id) : reserveService.selectByPatientId(id);

        return new SearchReserveResult(row);
    }

    @PostMapping("/api/searchAvailableTime")
    public boolean[] searchAvailableTime(@RequestBody SearchAvailableReserveDTO sarDTO) {
        boolean[] availableTime = new boolean[8];
        Arrays.fill(availableTime, true);

        String doctorId = sarDTO.getId();
        String date = sarDTO.getDate();

        List<Reserve> reserveList = reserveService.selectByDoctorIdAndDate(doctorId, date);
        for (Reserve r : reserveList) {
            String[] timePart = r.getTimeSeg().split("-");
            String[] time = timePart[0].split(":");
            int hour = Integer.parseInt(time[0]);

            if (hour >= 8 && hour <= 12) {
                availableTime[hour - 8] = false;
            } else if (hour >= 14 && hour <= 16) {
                availableTime[hour - 9] = false;
            }
        }

        return availableTime;
    }

    @PostMapping("/api/modifiedReserve")
    public ModifyReserveResult modifiedReserve(@RequestBody ModifyReserveDTO mrDTO) {
        String newTimeSeg = mrDTO.getTimeSeg();
        Reserve reserve = mrDTO.getOld();
        String patientId = reserve.getPatientId();
        String doctorId = reserve.getDoctorId();
        String timeSeg = reserve.getTimeSeg();
        String resDate = reserve.getResDate();

        if (reserveService.selectByOldReserve(patientId, doctorId,
                timeSeg, resDate) != null) {
            reserveService.updateReserve(patientId, doctorId, timeSeg,
                    newTimeSeg, resDate);
            return new ModifyReserveResult(true, "修改预约成功");
        } else {
            return new ModifyReserveResult(false, "未找到该预约");
        }
    }

    @ExceptionHandler(DuplicateReserveException.class)
    public AddRemoveReserveResult handleDuplicateKeyException(DuplicateReserveException e) {
        return new AddRemoveReserveResult(false, e.getMessage());
    }
}
