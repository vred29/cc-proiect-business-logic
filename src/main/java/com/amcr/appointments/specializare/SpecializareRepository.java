package com.amcr.appointments.specializare;

import com.amcr.appointments.spital.Spital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializareRepository extends JpaRepository<Specializare, Long> {
    List<Specializare> findAllBySpitale(List<Spital> spitals);
}
