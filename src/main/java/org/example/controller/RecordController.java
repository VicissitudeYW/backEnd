package org.example.controller;

import org.example.dto.*;
import org.example.exception.ForeignKeyViolationException;
import org.example.pojo.MedicalRecord;
import org.example.service.AddRecordService;
import org.example.service.MedicalRecordService;
import org.example.service.UpdateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RecordController {
    @Autowired
    private AddRecordService addRecordService;
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private UpdateRecordService updateRecordService;

    @RequestMapping("/api/addRecord")
    public AddRecordResult addRecord(@RequestBody AddRecordDTO recordDTO) {
        AddRecordResult addRecordRes =new AddRecordResult();
        addRecordRes = addRecordService.addRecord(addRecordRes,recordDTO);
        return addRecordRes;
    }

    @RequestMapping("/api/searchRecord")
    public SearchRecordResult searchRecord(@RequestBody SearchRecordDTO recordDTO) {
        List<MedicalRecord> mr = medicalRecordService.searchRecord(recordDTO.getId());
        if(mr==null)
            System.out.println("controller null");
        return new SearchRecordResult(mr);
    }

    @RequestMapping("/api/updateRecord")
    public boolean updateRecord(@RequestBody UpdateRecordDTO recordDTO) {
        return updateRecordService.updateRecord(recordDTO);
    }

    @ExceptionHandler(ForeignKeyViolationException.class)
    public AddRecordResult handleForeignKeyViolationException(ForeignKeyViolationException e) {
        AddRecordResult addRecordResult = new AddRecordResult();
        addRecordResult.setStatus(false);
        addRecordResult.setMsg(e.getMessage());
        return addRecordResult;
    }
}
