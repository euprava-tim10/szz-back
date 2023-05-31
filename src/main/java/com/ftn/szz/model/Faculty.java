package com.ftn.szz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class Faculty {
    @Id
    private int id;
    private String name;
    private String courseName;
}
