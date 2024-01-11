package com.amcr.appointments.spital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpitalRepository extends JpaRepository<Spital, Long> {
}
