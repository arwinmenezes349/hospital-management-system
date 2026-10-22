
package com.hospital.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {

    // Open the dashboard
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
