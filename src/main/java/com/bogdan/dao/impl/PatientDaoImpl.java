package com.bogdan.dao.impl;

import com.bogdan.dao.PatientDao;
import com.bogdan.model.Patient;
import com.bogdan.util.PatientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDaoImpl implements PatientDao {

    private final Logger logger = LoggerFactory.getLogger(DoctorDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients " +
                "(first_name, last_name, patronymic, birth_date, doctor_id, phone_number) " +
                "VALUES (?,?,?,?,?,?)";
        int result = jdbcTemplate.update(query, patient.getFirstname(), patient.getLastname(),
                patient.getPatronymic(), patient.getBirthDate(), patient.getDoctorId(), patient.getPhone());
        if (result == 1) {
            logger.info("Patient was created: " + patient.getFirstname() + " " + patient.getLastname());
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        String query = "UPDATE patients SET " +
                "first_name=?, last_name=?, patronymic=?, birth_date=?, phone_number=? " +
                "WHERE id=?";
        int result = jdbcTemplate.update(query, patient.getFirstname(), patient.getLastname(), patient.getPatronymic(),
                patient.getBirthDate(), patient.getPhone(), patient.getId());
        if (result == 1) {
            logger.info("Patient was updated: " + patient.getFirstname() + " " + patient.getLastname());
        }
    }

    @Override
    public Patient getPatient(long id) {
        String query = "SELECT * FROM patients WHERE id=?";
        Patient patient = null;
        try {
            patient = jdbcTemplate.queryForObject(query, new Object[]{id}, new PatientMapper());
            logger.info("Get information about patient by id: " + id);
        } catch (DataAccessException ex) {
            logger.info("Patient not found by id: " + id);
        }
        return patient;
    }

    @Override
    public void deletePatient(long id) {
        String query = "DELETE FROM patients WHERE id=?";
        int result = jdbcTemplate.update(query, id);
        if (result == 1) {
            logger.info("Patient was deleted by id: " + id);
        }
    }

    @Override
    public List<Patient> getDoctorsPatients(long id) {
        String query = "SELECT * FROM patients INNER JOIN doctors ON doctors.id=patients.doctor_id " +
                "WHERE patients.doctor_id=? ORDER BY patients.id";
        logger.info("Get list of patients");
        return jdbcTemplate.query(query, new Object[]{id}, new PatientMapper());
    }
}
