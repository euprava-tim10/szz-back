package com.ftn.ssz.service;

import com.ftn.ssz.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService extends JpaRepository<String, Company> {
}
