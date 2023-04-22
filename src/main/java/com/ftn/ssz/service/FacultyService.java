package com.ftn.ssz.service;

import com.ftn.ssz.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FacultyService extends JpaRepository<Integer, Faculty> {
}
