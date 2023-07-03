package com.ftn.szz.service;

import com.ftn.szz.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.ftn.szz.security.AuthHelper.authUser;

@Service
public class NotificationService {
    private JobAlertService jobAlertService;
    @Value("${apr.url}")
    private String aprUrl;

    Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public NotificationService(JobAlertService jobAlertService) {
        this.jobAlertService = jobAlertService;
    }



    public List<Notification> getNotifications() {
        logger.info("get notification");
        String aprNotifications = aprUrl + "/api/notifications/" + authUser().getUsername();
        RestTemplate restTemplate = new RestTemplate();
        Notification[] notificationsArray = restTemplate.getForObject(aprNotifications, Notification[].class);
        if (notificationsArray != null){
            logger.info("odg get notification, {}", Arrays.toString(notificationsArray));
            return Arrays.asList(notificationsArray);
        }
        return null;
    }

}
