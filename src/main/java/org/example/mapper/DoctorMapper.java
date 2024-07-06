package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;

@Mapper
public interface DoctorMapper {
    @Select("select id, user_password as userPswd, doctor_no as doctorNo, " +
            "specialty, position from doctor where id = #{id}")
    Doctor selectDoctorById(@Param("id") String id);

    @Select("select id, user_password as userPswd, doctor_no as doctorNo," +
            "specialty, position from doctor where id = #{id} and user_password = #{userPswd}")
    Doctor selectDoctorByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into doctor (id, user_password, doctor_no, specialty, position) " +
            "values (#{id}, #{userPswd}, #{doctorNo}, #{specialty}, #{position})")
    void insertDoctor(Doctor doctor);

    @Update("<script>"
            + "update doctor"
            + "<set>"
            + "<if test='userPswd != null'> user_password = #{userPswd}, </if>"
            + "<if test='doctorNo != null'> doctor_no = #{doctorNo}, </if>"
            + "<if test='specialty != null'> specialty = #{specialty}, </if>"
            + "<if test='position != null'> position = #{position}, </if>"
            + "</set>"
            + "where id = #{id}"
            + "</script>")
    void updateDoctor(@Param("id") String id,
                      @Param("userPswd") String userPswd,
                      @Param("doctorNo") String doctorNo,
                      @Param("specialty") String specialty,
                      @Param("position") String position);
}
