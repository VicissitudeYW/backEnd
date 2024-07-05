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

    @Select("select * from reserve where doctor_id = #{doctorId} and res_date = #{resDate}")
    List<Reserve> selectByDoctorIdAndDate(@Param("doctorId") String id, @Param("resDate") String resDate);

    @Insert("insert into reserve (patient_id, doctor_id, res_date, time_seg)" +
            "values (#{patientId}, #{doctorId}, #{resDate}, #{timeSeg})")
    void insertReserve(Reserve reserve);

    @Delete("delete from reserve where patient_id = #{patientId} " +
            "and doctor_id = #{doctorId} and time_seg = #{timeSeg} and res_date = #{resDate}")
    int deleteReserve(Reserve reserve);
}
