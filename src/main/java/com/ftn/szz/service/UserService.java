package com.ftn.szz.service;

import com.ftn.szz.model.FacultyDiploma;
import com.ftn.szz.model.FacultyDiplomaList;
import com.ftn.szz.model.SchoolDiploma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.ftn.szz.security.AuthHelper.authUser;

@Service
public class UserService {
    @Value("${skola.url}")
    private String schoolUrl;

    @Value("${fakultet.url}")
    private String facultyUrl;

    public SchoolDiploma getPrimarySchoolEducation() {
        String primarySchoolUrl = schoolUrl + "/api/ucenici/" + authUser().getUsername() + "/diploma/OSNOVNA";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(primarySchoolUrl, SchoolDiploma.class);
    }

    public SchoolDiploma getSecondarySchoolEducation() {
        String secondarySchoolUrl = schoolUrl + "/api/ucenici/" + authUser().getUsername() + "/diploma/SREDNJA";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(secondarySchoolUrl, SchoolDiploma.class);
    }

    public List<FacultyDiploma> getCollegeEducation() {
        String collegeSchoolUrl = facultyUrl + "/api/public/studenti/" + authUser().getUsername() + "/diplome";
        RestTemplate restTemplate = new RestTemplate();
        FacultyDiploma[] facultyDiplomaArray = restTemplate.getForObject(collegeSchoolUrl, FacultyDiploma[].class);
        if (facultyDiplomaArray != null) {
            return Arrays.asList(facultyDiplomaArray);
            }
        return null;
    } 
}