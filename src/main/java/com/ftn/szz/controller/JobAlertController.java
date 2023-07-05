package com.ftn.szz.controller;

import com.ftn.szz.model.JobAlert;
import com.ftn.szz.service.JobAlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class JobAlertController {
    private final JobAlertService jobAlertService;

    JobAlertController(JobAlertService jobAlertService) {
        this.jobAlertService = jobAlertService;
    }
    Logger logger = LoggerFactory.getLogger(JobAlertController.class);
    @GetMapping("/jobAlerts")
    public ResponseEntity<List<JobAlert>> getJobAlerts() {
        logger.info("lista job alerts");
        List<JobAlert> jobAlerts = jobAlertService.getJobAlerts();
        return new ResponseEntity<>(jobAlerts, HttpStatus.OK);
    }

    @GetMapping("/jobAlerts/{id}")
    public ResponseEntity<Boolean> sendJobApplication(@PathVariable Long id) {
        Boolean canApplicate = jobAlertService.canApplicate(id);

        if (canApplicate){
            logger.info("job alerts id");
            jobAlertService.sendApplication(id);
        }

        return new ResponseEntity<>(this.jobAlertService.canApplicate(id), HttpStatus.OK);
    }

}
