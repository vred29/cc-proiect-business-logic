package com.amcr.appointments.appointment;

import com.amcr.appointments.appointment.Appointment;
import com.amcr.appointments.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPacient(User user);

    List<Appointment> findAllByMedic(User medic);
}
