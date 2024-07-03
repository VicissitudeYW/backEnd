package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Doctor;

@Mapper
public interface DoctorMapper {
    @Select("select #{id} from tb_doctor")
    Doctor selectDoctorById(@Param("id") String id);

    @Insert("insert into doctor (id, user_pswd, doctor_no, speciality, position) " +
            "values (#{id}, #{userName}, #{doctorNo}, #{speciality}, #{position})")
    void insertDoctor(Doctor doctor);
}
