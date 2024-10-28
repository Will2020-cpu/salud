package com.salud.salud.service;

import com.salud.salud.models.MedicationSchedule;
import com.salud.salud.repository.MedicationScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicationNotificationService {

    @Autowired
    private MedicationScheduleRepository scheduleRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedRate = 60000)
    public void checkMedicationSchedules(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime upcomingTime = now.plusMinutes(5);
        List<MedicationSchedule> schedules = scheduleRepository.findByScheduleTimeBetween(now, upcomingTime);

        for (MedicationSchedule schedule: schedules){
            String notificationMessage = "Es hora de tomar " + schedule.getMedicationName();
            sendMedicationNotification(schedule.getPatientId(), notificationMessage);
        }
    }
    private void sendMedicationNotification(Long patientId, String message) {
        // Envía una notificación al canal del paciente
        messagingTemplate.convertAndSend("/topic/notifications/" + patientId, message);
    }

}
