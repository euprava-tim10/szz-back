package com.ftn.ssz.service;

import com.ftn.ssz.model.JobAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface JobAlertService extends JpaRepository<JobAlert, Long> {
}
