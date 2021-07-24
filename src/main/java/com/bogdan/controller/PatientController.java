package com.bogdan.controller;

import com.bogdan.dao.DoctorDao;
import com.bogdan.dao.PatientDao;
import com.bogdan.model.Doctor;
import com.bogdan.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final DoctorDao doctorDao;
    private final PatientDao patientDao;

    public PatientController(DoctorDao doctorDao, PatientDao patientDao) {
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
    }

    @GetMapping("/create/doctor/{id}")
    public String create(@PathVariable("id") long doctorId, Model model) {
        Doctor doctor = doctorDao.getDoctor(doctorId);
        model.addAttribute("patient", new Patient());
        model.addAttribute("doctor", doctor);
        return "newPatient";
    }

    @PostMapping("/create/doctor/{doctorId}")
    public String create(@PathVariable("doctorId") long doctorId, @ModelAttribute("patient") Patient patient) {
        patientDao.addPatient(patient);
        return "redirect:/doctor/" + doctorId;
    }

    @GetMapping("/{patientId}/update/doctor/{doctorId}")
    public String update(@PathVariable("patientId") long patientId, @PathVariable("doctorId") long doctorId, Model model) {
        Patient patient = patientDao.getPatient(patientId);
        Doctor doctor = doctorDao.getDoctor(doctorId);
        model.addAttribute("patient", patient);
        model.addAttribute("doctor", doctor);
        model.addAttribute("doctors", doctorDao.getAllDoctors());
        return "updatePatient";
    }

    @PostMapping("/{patientId}/update/doctor/{doctorId}")
    public String update(@PathVariable("doctorId") long doctorId, @ModelAttribute("patient") Patient patient) {
        patientDao.updatePatient(patient);
        return "redirect:/doctor/" + doctorId;
    }

    @GetMapping("/{patientId}/delete/doctor/{doctorId}")
    public String delete(@PathVariable("patientId") long patientId, @PathVariable("doctorId") long doctorId) {
        patientDao.deletePatient(patientId);
        return "redirect:/doctor/" + doctorId;
    }
}
