package com.amcr.appointments.specialization;

import com.amcr.appointments.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    List<Specialization> findAllBySpitale(List<Hospital> hospitals);
}
