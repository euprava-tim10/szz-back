package com.ftn.szz.service;

import com.ftn.szz.model.Company;
import com.ftn.szz.model.FacultyDiploma;
import com.ftn.szz.model.JobAlert;
import com.ftn.szz.model.SchoolDiploma;
import com.ftn.szz.model.enums.EEducation;
import com.ftn.szz.model.enums.EProfession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class JobAlertServiceMockup {
    private final UserService userService;

    public JobAlertServiceMockup(UserService userService) {
        this.userService = userService;
    }

    public List<JobAlert> findAll() {
        ArrayList<JobAlert> jobAlerts = new ArrayList<>();
        Company company = new Company("1298743709124", "Company name", "12430987142", "1209874412097", new Date("2023/01/24"), new ArrayList<>());
        Company company2 = new Company("234562345432", "Company name 2", "23423144523", "12341234234", new Date("2023/02/24"), new ArrayList<>());
        JobAlert jobAlert = new JobAlert(1L, new Date("2023/04/21"), new Date("2023/06/21"), EEducation.SECONDARY_SCHOOL_DEGREE, EProfession.MEDICINE, company, new ArrayList<>());
        JobAlert jobAlert2 = new JobAlert(2L, new Date("2023/04/15"), new Date("2023/06/1"), EEducation.NO_EDUCATION_REQUIRED, EProfession.ELECTRICAL_ENGINEERING_AND_TELECOMMUNICATIONS, company2, new ArrayList<>());
        JobAlert jobAlert3 = new JobAlert(3L, new Date("2023/04/15"), new Date("2023/06/1"), EEducation.FACULTY_DEGREE, EProfession.ELECTRICAL_ENGINEERING_AND_TELECOMMUNICATIONS, company2, new ArrayList<>());

        jobAlerts.add(jobAlert);
        jobAlerts.add(jobAlert2);
        jobAlerts.add(jobAlert3);
        return jobAlerts;
    }

    public JobAlert findOne(long id) {
        List<JobAlert> jobAlerts = findAll();
        for (JobAlert jobAlert : jobAlerts) {
            if (jobAlert.getId() == id) {
                return jobAlert;
            }
        }
        return null;
    }

    public boolean canApplicate(long jobAlertId) {
        JobAlert jobAlert = findOne(jobAlertId);

        switch (jobAlert.getNeededEducation()) {
            case NO_EDUCATION_REQUIRED:
                return true;
            case PRIMARY_SCHOOL_DEGREE:
                return userService.getPrimarySchoolEducation().getSchoolType().equals("OSNOVNA");
            case SECONDARY_SCHOOL_DEGREE:
                return userService.getSecondarySchoolEducation().getSchoolType().equals("SREDNJA");
            case FACULTY_DEGREE:
                for (FacultyDiploma facultyDiploma : userService.getCollegeEducation()) {
                    if (facultyDiploma.getLevel().contains("OSNOVNE, MASTER, DOKTORSKE")) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
