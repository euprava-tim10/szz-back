package com.ftn.ssz.model;

import com.ftn.ssz.model.enums.EEducation;
import com.ftn.ssz.model.enums.EProfession;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
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
    @ManyToOne
    private Company company;
    @ManyToMany
    private List<User> users;
}
