package com.bogdan.dao.impl;

import com.bogdan.dao.DoctorDao;
import com.bogdan.model.Doctor;
import com.bogdan.util.DoctorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDaoImpl implements DoctorDao {

    private final Logger logger = LoggerFactory.getLogger(DoctorDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public DoctorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors " +
                "(first_name, last_name, patronymic, work_position, birth_date, phone_number) " +
                "VALUES (?,?,?,?,?,?)";
        int result = jdbcTemplate.update(query, doctor.getFirstname(), doctor.getLastname(), doctor.getPatronymic(),
                doctor.getPosition(), doctor.getBirthDate(), doctor.getPhone());
        if (result == 1) {
            logger.info("New doctor was created: " + doctor.getFirstname() + " " + doctor.getLastname());
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        String query = "UPDATE doctors SET " +
                "first_name=?, last_name=?, patronymic=?, work_position=?, birth_date=?, phone_number=? " +
                "WHERE id=?";
        int result = jdbcTemplate.update(query, doctor.getFirstname(), doctor.getLastname(), doctor.getPatronymic(),
                doctor.getPosition(), doctor.getBirthDate(), doctor.getPhone(), doctor.getId());
        if (result == 1) {
            logger.info("Doctor was updated: " + doctor.getFirstname() + " " + doctor.getLastname());
        }
    }

    @Override
    public Doctor getDoctor(long id) {
        String query = "SELECT * FROM doctors WHERE id=?";
        Doctor doctor = null;
        try {
            doctor = jdbcTemplate.queryForObject(query, new Object[]{id}, new DoctorMapper());
            logger.info("Get information about doctor by id: " + id);
        } catch (DataAccessException ex) {
            logger.info("Doctor not found by id: " + id);
        }
        return doctor;
    }

    @Override
    public void deleteDoctor(long id) {
        String query = "DELETE FROM doctors WHERE id=?";
        int result = jdbcTemplate.update(query, id);
        if (result == 1) {
            logger.info("Doctor was deleted by id: " + id);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        String query = "SELECT * FROM doctors ORDER BY id";
        logger.info("Get list of doctors");
        return jdbcTemplate.query(query, new DoctorMapper());
    }
}
