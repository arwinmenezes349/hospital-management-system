
package com.hospital.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalPageController {

    @GetMapping("/patients-page")
    public String patientsPage() {
        return "patients";
    }

    @GetMapping("/doctors-page")
    public String doctorsPage() {
        return "doctors";
    }

    @GetMapping("/appointments-page")
    public String appointmentsPage() {
        return "appointments";
    }
}
