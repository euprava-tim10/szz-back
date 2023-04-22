package com.ftn.ssz.model;

import com.ftn.ssz.model.enums.EEducation;
import com.ftn.ssz.model.enums.EGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private EGender gender;
    private EEducation educationLevel;
    private int yearOfBirth;
    @ManyToMany
    private List<JobApplication> jobApplications;
}


