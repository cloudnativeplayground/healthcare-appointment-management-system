package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.model.Appointment;
import com.cloudnativeplayground.healthcare.model.AppointmentStatus;
import com.cloudnativeplayground.healthcare.model.Doctor;
import com.cloudnativeplayground.healthcare.model.Patient;
import com.cloudnativeplayground.healthcare.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@WebMvcTest(AppointmentController.class)
class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

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
    void shouldGetAllAppointments() throws Exception {
        List<Appointment> appointments = Collections.singletonList(new Appointment(1L, patient, doctor, appointmentDate, status));
        Mockito.when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/api/appointments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].patientName").value("John Doe"));
    }
}
