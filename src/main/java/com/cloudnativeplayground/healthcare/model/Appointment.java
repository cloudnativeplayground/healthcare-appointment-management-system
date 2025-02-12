package com.cloudnativeplayground.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public Appointment() {}

    public Appointment(Long id, Patient patient, Doctor doctor, LocalDateTime appointmentDate, AppointmentStatus status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDate, AppointmentStatus status) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    // Getters and Setters



}
