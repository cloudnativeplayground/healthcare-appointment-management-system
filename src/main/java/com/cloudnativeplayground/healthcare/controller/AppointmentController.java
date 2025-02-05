package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.model.Appointment;
import com.cloudnativeplayground.healthcare.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping
    public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(newAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long id) {
        boolean isCancelled = appointmentService.cancelAppointment(id);
        if (isCancelled) {
            return ResponseEntity.ok("Appointment canceled successfully.");
        }
        return ResponseEntity.badRequest().body("Appointment cancellation failed.");
    }
}
