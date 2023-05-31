package com.ftn.szz.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Getter
@Setter
public class FacultyDiploma {
    private String firstName;
    private String lastName;
    private String jmbg;
    private String facultyName;
    private String courseName;
    private String level;
    private Double gpa;
    private LocalDate date;
}
