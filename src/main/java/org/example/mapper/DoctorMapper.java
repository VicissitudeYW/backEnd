package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;

@Mapper
public interface DoctorMapper {
    @Select("select * from doctor where id = #{id}")
    Doctor selectDoctorById(@Param("id") String id);

    @Select("select * from doctor where id = #{id} and user_password = #{userPswd}")
    Doctor selectDoctorByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into doctor (id, user_pswd, doctor_no, specialty, position) " +
            "values (#{id}, #{userPswd}, #{doctorNo}, #{specialty}, #{position})")
    void insertDoctor(Doctor doctor);
}
