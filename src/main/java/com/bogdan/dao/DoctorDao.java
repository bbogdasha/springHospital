package com.bogdan.dao;

import com.bogdan.model.Doctor;

import java.util.List;

public interface DoctorDao {

    void addDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    Doctor getDoctor(long id);

    void deleteDoctor(long id);

    List<Doctor> getAllDoctors();
}
