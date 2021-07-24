package com.bogdan.util;

import com.bogdan.model.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet rs, int i) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setId(rs.getLong("id"));
        doctor.setFirstname(rs.getString("first_name"));
        doctor.setLastname(rs.getString("last_name"));
        doctor.setPatronymic(rs.getString("patronymic"));
        doctor.setPosition(rs.getString("work_position"));
        doctor.setBirthDate(rs.getDate("birth_date").toLocalDate());
        doctor.setPhone(rs.getString("phone_number"));
        return doctor;
    }
}
