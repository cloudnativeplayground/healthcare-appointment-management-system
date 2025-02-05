package com.cloudnativeplayground.healthcare;



import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.cloudnativeplayground.healthcare.model.Appointment;
import com.cloudnativeplayground.healthcare.model.AppointmentStatus;
import com.cloudnativeplayground.healthcare.model.Doctor;
import com.cloudnativeplayground.healthcare.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

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
    void shouldCreateAppointmentSuccessfully() {
        Appointment appointment = new Appointment(patient, doctor, appointmentDate, status);

        assertNotNull(appointment);
        assertEquals(patient, appointment.getPatient());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals(status, appointment.getStatus());
    }

    @Test
    void shouldUpdateAppointmentStatus() {
        Appointment appointment = new Appointment(patient, doctor, appointmentDate, AppointmentStatus.SCHEDULED);

        appointment.setStatus(AppointmentStatus.COMPLETED);

        assertEquals(AppointmentStatus.COMPLETED, appointment.getStatus());
    }

    @Test
    void shouldUpdateAppointmentDate() {
        Appointment appointment = new Appointment(patient, doctor, appointmentDate, AppointmentStatus.SCHEDULED);
        LocalDateTime newDate = LocalDateTime.of(2025, 4, 1, 12, 0);

        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test
    void shouldThrowExceptionWhenPatientIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Appointment(null, doctor, appointmentDate, status);
        });

        assertEquals("Patient cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDoctorIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Appointment(patient, null, appointmentDate, status);
        });

        assertEquals("Doctor cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAppointmentDateIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Appointment(patient, doctor, null, status);
        });

        assertEquals("Appointment date cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenStatusIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Appointment(patient, doctor, appointmentDate, null);
        });

        assertEquals("Appointment status cannot be null", exception.getMessage());
    }
}
