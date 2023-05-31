package com.ftn.szz.model;

import com.ftn.szz.model.enums.EEducation;
import com.ftn.szz.model.enums.EProfession;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    private List<User> users;
}
