package com.ftn.szz.service;

import com.ftn.szz.model.FacultyDiploma;
import com.ftn.szz.model.JobAlert;
import com.ftn.szz.model.enums.EFacultyLevel;
import com.ftn.szz.model.enums.ESchoolLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.ftn.szz.security.AuthHelper.authUser;


@Service
public class JobAlertService {

    Logger logger = LoggerFactory.getLogger(JobAlertService.class);

    @Value("${apr.url}")
    private String aprUrl;
    private final UserService userService;

    public JobAlertService(UserService userService) {
        this.userService = userService;
    }

    public List<JobAlert> getJobAlerts() {
        logger.info("Get job alerts");
        String aprJobAlerts = aprUrl + "/api/jobAdvertisements";
        RestTemplate restTemplate = new RestTemplate();
        JobAlert[] jobAlertsArray = restTemplate.getForObject(aprJobAlerts, JobAlert[].class);
        logger.info("Odg, {}", Arrays.toString(jobAlertsArray));
        if (jobAlertsArray != null) {
            logger.info("Odg if, {}", Arrays.toString(jobAlertsArray));
            return Arrays.asList(jobAlertsArray);
        }
        return null;
    }


    public JobAlert getJobAlert(long jobAlertId) {
        logger.info("Get job alert");
        String aprJobAlert = aprUrl + "/api/jobAdvertisements/" + jobAlertId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(aprJobAlert, JobAlert.class);
    }

    public Boolean canApplicate(Long jobAlertId) {
        JobAlert jobAlert = getJobAlert(jobAlertId);

        switch (jobAlert.getNeededEducation()) {
            case NO_EDUCATION_REQUIRED:
                return true;
            case PRIMARY_SCHOOL_DEGREE:
                return userService.getPrimarySchoolEducation().getSchoolType().equals(ESchoolLevel.OSNOVNA.toString());
            case SECONDARY_SCHOOL_DEGREE:
                return userService.getSecondarySchoolEducation().getSchoolType().equals(ESchoolLevel.SREDNJA.toString());
            case FACULTY_DEGREE:
                for (FacultyDiploma facultyDiploma : userService.getCollegeEducation()) {
                    String diplomaLevel = facultyDiploma.getLevel();
                    if (diplomaLevel.contains(EFacultyLevel.MASTER.toString()) || diplomaLevel.contains(EFacultyLevel.OSNOVNE.toString()) || diplomaLevel.contains(EFacultyLevel.DOKTORSKE.toString())) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public void sendApplication(Long id) {
        String aprJobApplication = aprUrl + "/api/jobAdvertisements/" + id + "/" + authUser().getUsername();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(aprJobApplication, null, Void.class);

    }
}
