package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Doctor;

import java.util.List;

@Mapper
public interface DoctorMapper {
    @Select("select id, user_password as userPswd, doctor_no as doctorNo, " +
            "specialty, position from doctor where id = #{id}")
    Doctor selectDoctorById(@Param("id") String id);

    @Select("select id, user_password as userPswd, doctor_no as doctorNo, " +
            "specialty, position from doctor where id = #{id} and user_password = #{userPswd}")
    Doctor selectDoctorByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Select("select id, user_password as userPswd, doctor_no as doctorNo, specialty, position" +
            " from doctor limit #{lim} offset #{off}")
    List<Doctor> selectDoctorLimitOffset(@Param("lim") int lim, @Param("off") int off);

    @Select("select id from doctor where doctor_no = #{doctorNo}")
    String selectDoctorByCredential(@Param("doctorNo") String doctorNo);

    @Select("select count(*) from doctor")
    int countRows();

    @Select("<script>" +
            "select id from doctor where 1=1" +
            "<if test='position != null and !position.isEmpty()'>" +
            " and position = #{position}" +
            "</if>" +
            "<if test='specialty != null and !specialty.isEmpty()'>" +
            " and specialty = #{specialty}" +
            "</if>" +
            "</script>")
    List<String> selectDoctorByPositionAndSpecialty(@Param("position") String position,
                                                    @Param("specialty") String specialty);

    @Insert("insert into doctor (id, user_password, doctor_no, specialty, position) " +
            "values (#{id}, #{userPswd}, #{doctorNo}, #{specialty}, #{position})")
    void insertDoctor(Doctor doctor);

    @Update("<script>"
            + "update doctor"
            + "<set>"
            + "<if test='password != null and password != \"\"'> user_password = #{password}, </if>"
            + "<if test='specialty != null and specialty != \"\"'> specialty = #{specialty}, </if>"
            + "<if test='position != null and position != \"\"'> position = #{position}, </if>"
            + "</set>"
            + "where id = #{id}"
            + "</script>")
    void updateDoctor(@Param("id") String id,
                      @Param("password") String password,
                      @Param("specialty") String specialty,
                      @Param("position") String position);
}
