package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {
    @Select("select * from reserve where patient_id = #{id}")
    List<Reserve> selectByPatientId(@Param("id") String id);

    @Select("select * from reserve where doctor_id = #{id}")
    List<Reserve> selectByDoctorId(@Param("id") String id);

    @Insert("insert into reserve (patient_id, doctor_id, start_time, end_time, res_date)" +
            "values (#{patientId}, #{doctorId}, #{startTime}, #{endTime}, #{resDate})")
    void insertReserve(Reserve reserve);

    @Delete("delete from reserve where patient_id = #{pid} " +
            "and doctor_id = #{did} and start_time = #{startTime} and end_time = #{endTime}")
    void deleteReserve(Reserve reserve);
}
