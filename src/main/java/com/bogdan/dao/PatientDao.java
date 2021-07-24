package com.bogdan.dao;

import com.bogdan.model.Patient;

import java.util.List;

public interface PatientDao {

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    Patient getPatient(long id);

    void deletePatient(long id);

    List<Patient> getDoctorsPatients(long id);
}
