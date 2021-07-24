package com.bogdan.controller;

import com.bogdan.dao.PatientDao;
import com.bogdan.model.Doctor;
import com.bogdan.dao.DoctorDao;
import com.bogdan.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorDao doctorDao;
    private final PatientDao patientDao;

    public DoctorController(DoctorDao doctorDao, PatientDao patientDao) {
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "newDoctor";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("doctor") Doctor doctor) {
        doctorDao.addDoctor(doctor);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        Doctor doctor = doctorDao.getDoctor(id);
        List<Patient> patients = patientDao.getDoctorsPatients(id);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patients", patients);
        return "doctorInfo";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Doctor doctor = doctorDao.getDoctor(id);
        model.addAttribute("doctor", doctor);
        return "updateDoctor";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, @ModelAttribute("doctor") Doctor doctor) {
        doctorDao.updateDoctor(doctor);
        return "redirect:/doctor/" + id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        doctorDao.deleteDoctor(id);
        return "redirect:/";
    }
}
