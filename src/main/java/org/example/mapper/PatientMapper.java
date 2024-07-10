package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Patient;

@Mapper
public interface PatientMapper {
    @Select("select id, user_password as userPswd, contact from patient where id = #{id}")
    Patient selectPatientById(@Param("id") String id);

    @Select("select id, user_password as userPswd, contact " +
            " from patient where id = #{id} and user_password = #{userPswd}")
    Patient selectPatientByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into patient (id, user_password, contact) " +
            "values (#{id}, #{userPswd}, #{contact})")
    void insertPatient(Patient patient);

    @Update("<script>"
            + "update patient"
            + "<set>"
            + "<if test='password != null and password != \"\"'> user_password = #{password}, </if>"
            + "<if test='contact != null and contact != \"\"'> contact = #{contact}, </if>"
            + "</set>"
            + "where id = #{id}"
            + "</script>")
    void updatePatient(@Param("id") String id,
                       @Param("password") String password,
                       @Param("contact") String contact);
}
