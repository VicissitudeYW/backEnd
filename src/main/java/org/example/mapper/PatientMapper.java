package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Patient;

public interface PatientMapper {
    @Select("select #{id} from patient")
    Patient selectPatientById(@Param("id") String id);

    @Select("select #{id}, #{user_pswd} from patient")
    Patient selectPatientByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into patient (id, user_pswd, contact) " +
            "values (#{id}, #{userName}, #{contact})")
    void insertPatient(Patient patient);
}
