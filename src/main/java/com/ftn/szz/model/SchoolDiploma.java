package com.ftn.szz.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolDiploma {
    private String firstName;
    private String lastName;
    private String jmbg;
    private String schoolName;
    private String schoolType;
    private String course;
    private String profession;
    private Map<Integer,Double> gpa;
    private LocalDate date;

}
