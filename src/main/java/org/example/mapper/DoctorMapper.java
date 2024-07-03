package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Doctor;

@Mapper
public interface DoctorMapper {
    @Insert("INSERT INTO doctor (id, user_pswd, doctor_no, speciality, position) " +
            "VALUES (#{id}, #{userName}, #{doctorNo}, #{speciality}, #{position})")
    void insertDoctor(Doctor doctor);
}
