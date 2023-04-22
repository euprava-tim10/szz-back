package com.ftn.ssz.service;

import com.ftn.ssz.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface JobApplicationService extends JpaRepository<Integer, JobApplication> {
}
