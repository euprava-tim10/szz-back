package com.ftn.szz.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String PIB;
    private String name;
    private String PIO;
    private String registrationNumber;
    private Date registrationDate;
    private List<JobAlert> jobAlerts;
}
