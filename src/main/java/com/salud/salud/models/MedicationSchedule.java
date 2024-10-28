package com.salud.salud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MedicationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String medicationName;
    private LocalDateTime scheduledTime;

    public MedicationSchedule(){

    }

    public MedicationSchedule(Long patientId, String medicationName, LocalDateTime scheduledTime) {
        this.patientId = patientId;
        this.medicationName = medicationName;
        this.scheduledTime = scheduledTime;
    }
}
