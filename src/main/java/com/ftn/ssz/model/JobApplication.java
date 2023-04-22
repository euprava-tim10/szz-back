package com.ftn.ssz.model;

import com.ftn.ssz.model.enums.EEducation;
import com.ftn.ssz.model.enums.EProfession;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JobApplication {
    private int id;
    private Date startDate;
    private Date endDate;
    private EEducation neededEducation;
    private EProfession profession;
    @OneToMany(mappedBy = "jobAdvertisements")
    private Company company;
    @ManyToMany
    private List<User> users;
}
