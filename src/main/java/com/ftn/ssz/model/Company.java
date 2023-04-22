package com.ftn.ssz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Company {
    private String name;
    private String PIB;
    private String PIO;
    private String registrationNumber;
    private Date registrationDate;
    private List<JobApplication> jobApplications;
}
