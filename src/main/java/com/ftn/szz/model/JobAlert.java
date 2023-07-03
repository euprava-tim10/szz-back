package com.ftn.szz.model;

import com.ftn.szz.model.enums.EEducation;
import com.ftn.szz.model.enums.EProfession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAlert {
    @Id
    private Long id;
    private Date startDate;
    private Date endDate;
    private EEducation neededEducation;
    private EProfession profession;
    private Company company;
    private Set<User> users;
}
