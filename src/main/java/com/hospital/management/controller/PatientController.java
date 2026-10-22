
package com.hospital.management.controller;

import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public String showPatients(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientRepository.findAll());
        return "patients";
    }

    @PostMapping("/patients")
    public String savePatient(
            @ModelAttribute("patient") Patient patient,
            RedirectAttributes redirectAttributes) {

        patientRepository.save(patient);
        redirectAttributes.addFlashAttribute(
                "message", "Patient registered successfully!");

        return "redirect:/patients";
    }

    @PostMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }
        return "redirect:/patients";
    }
}
