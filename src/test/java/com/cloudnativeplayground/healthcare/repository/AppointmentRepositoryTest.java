package com.cloudnativeplayground.healthcare.repository;

import com.cloudnativeplayground.healthcare.model.Appointment;
import com.cloudnativeplayground.healthcare.model.AppointmentStatus;
import com.cloudnativeplayground.healthcare.model.Doctor;
import com.cloudnativeplayground.healthcare.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;

    @BeforeEach
    void setUp() {
        patient = new Patient(1L, "John Doe", "john.doe@example.com", "1234567890");
        doctor = new Doctor(1L, "Dr. Smith", "Cardiology");
        appointmentDate = LocalDateTime.of(2025, 3, 1, 10, 0);
        status = AppointmentStatus.SCHEDULED;
    }

    @Test
    void shouldSaveAndFindAppointment() {
        Appointment appointment = new Appointment(null, doctor, appointmentDate , status);
        Appointment savedAppointment = appointmentRepository.save(appointment);

        assertNotNull(savedAppointment.getId());
        assertEquals("John Doe", savedAppointment.getPatient().getName());
    }
}
// Compare this snippet from src/test/java/com/cloudnativeplayground/healthcare/repository/UserRoleRepositoryTest.java: