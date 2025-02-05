package com.cloudnativeplayground.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HealthcareAppointmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareAppointmentManagementApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/health")
class HealthCheckController {

    @GetMapping
    public String healthCheck() {
        return "Healthcare Appointment Management System is running!";
    }
}
