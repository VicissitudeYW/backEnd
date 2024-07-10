package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {
    @Select("select * from reserve where patient_id = #{patientId}")
    List<Reserve> selectByPatientId(@Param("patientId") String id);

    @Select("select * from reserve where doctor_id = #{doctorId}")
    List<Reserve> selectByDoctorId(@Param("doctorId") String id);

    @Select("select patient_id as patientId, doctor_id as doctorId," +
            " time_seg as timeSeg, res_date as resDate " +
            " from reserve where patient_id = #{patientId} and doctor_id = #{doctorId} " +
            "and time_seg = #{timeSeg} and res_date = #{resDate}")
    Reserve selectByOldReserve(@Param("patientId") String pid, @Param("doctorId") String did,
                               @Param("timeSeg") String timeSeg, @Param("resDate") String resDate);

    @Select("select * from reserve where doctor_id = #{doctorId} and res_date = #{resDate}")
    List<Reserve> selectByDoctorIdAndDate(@Param("doctorId") String id, @Param("resDate") String resDate);

    @Insert("insert into reserve (patient_id, doctor_id, res_date, time_seg)" +
            "values (#{patientId}, #{doctorId}, #{resDate}, #{timeSeg})")
    void insertReserve(Reserve reserve);

    @Delete("delete from reserve where patient_id = #{patientId} " +
            "and doctor_id = #{doctorId} and time_seg = #{timeSeg} and res_date = #{resDate}")
    int deleteReserve(Reserve reserve);

    @Update("<script>" +
            "update reserve" +
            "<set>" +
            "<if test='patientId != null and patientId != \"\"'> patient_id = #{patientId}, </if>" +
            "<if test='doctorId != null and doctorId != \"\"'> doctor_id = #{doctorId}, </if>" +
            "<if test='newTimeSeg != null and newTimeSeg != \"\"'> time_seg = #{newTimeSeg}, </if>" +
            "<if test='resDate != null and resDate != \"\"'> res_date = #{resDate}, </if>" +
            "</set>" +
            "where time_seg = #{timeSeg}" +
            "</script>")
    void updateReserve(@Param("patientId") String patientId,
                       @Param("doctorId") String doctorId,
                       @Param("timeSeg") String timeSeg,
                       @Param("newTimeSeg") String newTimeSeg,
                       @Param("resDate") String resDate);
}
