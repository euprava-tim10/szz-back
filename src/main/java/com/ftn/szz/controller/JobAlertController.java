package com.ftn.szz.controller;

import com.ftn.szz.model.JobAlert;
import com.ftn.szz.service.JobAlertServiceMockup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class JobAlertController {
    private final JobAlertServiceMockup jobAlertService;

    JobAlertController(JobAlertServiceMockup jobAlertService) {
        this.jobAlertService = jobAlertService;
    }

    @GetMapping("/jobAlerts")
    public ResponseEntity<List<JobAlert>> getJobAlerts() {
        List<JobAlert> jobAlerts = jobAlertService.findAll();
        return new ResponseEntity<>(jobAlerts, HttpStatus.OK);
    }

    @GetMapping("/jobAlerts/{id}")
    public ResponseEntity<Boolean> sendJobApplication(@PathVariable long id) {
        return new ResponseEntity<>(this.jobAlertService.canApplicate(id), HttpStatus.OK);
    }

}