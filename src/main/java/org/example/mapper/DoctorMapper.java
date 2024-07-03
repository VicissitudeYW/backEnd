package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Doctor;
import org.example.pojo.Patient;

@Mapper
public interface DoctorMapper {
    @Select("select #{id} from doctor")
    Doctor selectDoctorById(@Param("id") String id);

    @Select("select #{id}, #{user_pswd} from doctor")
    Doctor selectDoctorByIdAndPswd(@Param("id") String id, @Param("userPswd") String userPswd);

    @Insert("insert into doctor (id, user_pswd, doctor_no, speciality, position) " +
            "values (#{id}, #{userName}, #{doctorNo}, #{speciality}, #{position})")
    void insertDoctor(Doctor doctor);
}
