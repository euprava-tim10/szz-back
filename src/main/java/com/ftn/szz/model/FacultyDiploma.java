package com.ftn.szz.model;

import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
