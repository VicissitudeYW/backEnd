package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Patient;

@Mapper
public interface PatientMapper {
    @Select("select * from patient where id = #{id}")
    Patient selectPatientById(@Param("id") String id);

    @Select("select * from patient where id = #{id} and user_password = #{userPswd}")
    Patient selectPatientByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into patient (id, user_password, contact) " +
            "values (#{id}, #{userPswd}, #{contact})")
    void insertPatient(Patient patient);
}
