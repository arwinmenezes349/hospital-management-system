
package com.hospital.management.controller;

import com.hospital.management.entity.Appointment;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.PatientRepository;
import com.hospital.management.repository.DoctorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentController(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/appointments")
    public String showAppointments(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appointmentRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());

        return "appointments";
    }

    @PostMapping("/appointments")
    public String bookAppointment(
            @ModelAttribute Appointment appointment,
            RedirectAttributes redirectAttributes) {

        appointmentRepository.save(appointment);

        redirectAttributes.addFlashAttribute(
                "message", "Appointment booked successfully!");

        return "redirect:/appointments";
    }
}
