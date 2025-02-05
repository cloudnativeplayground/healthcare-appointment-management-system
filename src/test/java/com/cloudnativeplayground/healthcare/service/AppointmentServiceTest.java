package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.model.Appointment;
import com.cloudnativeplayground.healthcare.model.AppointmentStatus;
import com.cloudnativeplayground.healthcare.model.Doctor;
import com.cloudnativeplayground.healthcare.model.Patient;
import com.cloudnativeplayground.healthcare.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
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
    void shouldReturnAllAppointments() {
        List<Appointment> mockAppointments = Arrays.asList(
                new Appointment(1L, patient, doctor, appointmentDate, status),
                new Appointment(2L, patient, doctor, appointmentDate, status)
        );

        when(appointmentRepository.findAll()).thenReturn(mockAppointments);

        List<Appointment> appointments = appointmentService.getAllAppointments();
        assertEquals(2, appointments.size());
        verify(appointmentRepository, times(1)).findAll();
    }
}
