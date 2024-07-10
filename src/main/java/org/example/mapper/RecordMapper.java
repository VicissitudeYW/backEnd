package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.MedicalRecord;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Select("select * from medical_record where patient_id = #{patientId}")
    List<MedicalRecord> findMedicalRecordById(@Param("patientId") String patientId);

    @Insert("insert into medical_record (patient_id,content,mr_time)" +
            "values (#{patientId},#{content},#{mrTime})")
    void insertMedicalRecord(MedicalRecord medicalRecord);

    @Update("update medical_record" +
            " set content = #{content}" +
            " where patient_id = #{patientId} and mr_time = #{mrTime}")
    void updateMedicalRecord(@Param("patientId") String patientId,
                             @Param("mrTime") String mrTime,
                             @Param("content") String content);

}
