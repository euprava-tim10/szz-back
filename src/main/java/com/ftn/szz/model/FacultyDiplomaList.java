package com.ftn.szz.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
public class FacultyDiplomaList {
    List<FacultyDiploma> facultyDiplomaList = new ArrayList<>();
}
