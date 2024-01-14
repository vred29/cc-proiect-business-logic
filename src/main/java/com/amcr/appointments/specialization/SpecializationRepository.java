package com.amcr.appointments.specialization;

import com.amcr.appointments.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpecializationRepository extends JpaRepository<Specialization, UUID> {
    List<Specialization> findAllBySpitaleIn(List<Hospital> spitale);
}
