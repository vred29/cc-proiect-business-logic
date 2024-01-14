package com.amcr.appointments.appointment;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByPacient(User user);

    List<Appointment> findAllByMedic(User medic);
}
