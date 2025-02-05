package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.model.Notification;
import com.cloudnativeplayground.healthcare.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    /**
     * Retrieves all notifications from the database.
     * @return List of notifications
     */
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    /**
     * Sends a notification and saves it in the database.
     * @param notification The notification object
     */
    public void sendNotification(Notification notification) {
        notificationRepository.save(notification);
    }
}
