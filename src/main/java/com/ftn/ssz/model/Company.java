package com.ftn.ssz.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    private String PIB;
    private String name;
    private String PIO;
    private String registrationNumber;
    private Date registrationDate;
    @OneToMany(mappedBy = "company")
    private List<JobAlert> jobAlerts;
}
