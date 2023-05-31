package com.ftn.szz.model;

import com.ftn.szz.model.enums.EEducation;
import com.ftn.szz.model.enums.EGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private EGender gender;
    private EEducation educationLevel;
    private int yearOfBirth;
    private List<JobAlert> jobAlerts;
}


