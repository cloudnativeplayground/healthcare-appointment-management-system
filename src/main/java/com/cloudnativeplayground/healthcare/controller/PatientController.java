package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.model.Patient;
import com.cloudnativeplayground.healthcare.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.createPatient(patient);
        return ResponseEntity.ok(newPatient);
    }
}
