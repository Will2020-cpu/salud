package com.salud.salud.repository;

import com.salud.salud.models.MedicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule, Long> {
    List<MedicationSchedule> findByScheduleTimeBetween(LocalDateTime start, LocalDateTime end);
}
