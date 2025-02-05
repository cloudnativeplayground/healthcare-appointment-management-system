package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.model.*;
import com.cloudnativeplayground.healthcare.repository.AppointmentRepository;
import com.cloudnativeplayground.healthcare.repository.UserRepository;
import com.cloudnativeplayground.healthcare.repository.DoctorRepository;
import com.cloudnativeplayground.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public boolean cancelAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointment.get().setStatus(AppointmentStatus.CANCELLED);
            appointmentRepository.save(appointment.get());
            return true;
        }
        return false;
    }
}