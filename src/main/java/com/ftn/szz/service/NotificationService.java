package com.ftn.szz.service;

import com.ftn.szz.model.Notification;
import com.ftn.szz.model.enums.ENotificationStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private JobAlertServiceMockup jobAlertService;

    public NotificationService(JobAlertServiceMockup jobAlertService) {
        this.jobAlertService = jobAlertService;
    }

    public List<Notification> getNotifications(String jmbg) {
        List<Notification> notifications = new ArrayList<>();

        notifications.add(new Notification(ENotificationStatus.ACCEPTED, jobAlertService.findOne(1L)));
        notifications.add(new Notification(ENotificationStatus.REJECTED, jobAlertService.findOne(2L)));
        notifications.add(new Notification(ENotificationStatus.PENDING, jobAlertService.findOne(3L)));
        return notifications;
    }

}
