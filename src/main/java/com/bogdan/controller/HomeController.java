package com.bogdan.controller;

import com.bogdan.dao.DoctorDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DoctorDao doctorDao;

    public HomeController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("doctors", doctorDao.getAllDoctors());
        return "doctors";
    }
}
