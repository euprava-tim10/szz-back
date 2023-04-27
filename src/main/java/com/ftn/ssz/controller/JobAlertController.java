package com.ftn.ssz.controller;

import com.ftn.ssz.model.Company;
import com.ftn.ssz.model.JobAlert;
import com.ftn.ssz.model.enums.EEducation;
import com.ftn.ssz.model.enums.EProfession;
import com.ftn.ssz.service.JobAlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class JobAlertController {
    private JobAlertService jobAlertService;

    JobAlertController(JobAlertService jobAlertService) {
        this.jobAlertService = jobAlertService;
    }

    @GetMapping("/jobAlerts")
    public ResponseEntity<List<JobAlert>> getJobApplications() {
        Company company = new Company();
        company.setName("Company");
        company.setPIB("12084102124");
        company.setPIO("531523532");
        company.setRegistrationDate(new Date("2023/01/24"));
        company.setRegistrationNumber("64234522324");
        JobAlert jobAlert = new JobAlert(1L, new Date("2023/04/21"), new Date("2023/06/21"), EEducation.DOCTORAL_DEGREE, EProfession.MEDICINE, company, new ArrayList<>());
        ArrayList<JobAlert> jobAlerts = new ArrayList<>();
        jobAlerts.add(jobAlert);
        return new ResponseEntity<>(jobAlerts, HttpStatus.OK);
    }
}
