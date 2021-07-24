package com.bogdan.util;

import com.bogdan.model.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet rs, int i) throws SQLException {
        Patient patient = new Patient();
        patient.setId(rs.getLong("id"));
        patient.setFirstname(rs.getString("first_name"));
        patient.setLastname(rs.getString("last_name"));
        patient.setPatronymic(rs.getString("patronymic"));
        patient.setBirthDate(rs.getDate("birth_date").toLocalDate());
        patient.setDoctorId(rs.getLong("doctor_id"));
        patient.setPhone(rs.getString("phone_number"));
        return patient;
    }
}
