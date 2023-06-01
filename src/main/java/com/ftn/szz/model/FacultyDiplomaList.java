package com.ftn.szz.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDiplomaList {
    List<FacultyDiploma> facultyDiplomaList = new ArrayList<>();
}
