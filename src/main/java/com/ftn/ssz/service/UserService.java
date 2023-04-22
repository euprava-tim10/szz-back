package com.ftn.ssz.service;

import com.ftn.ssz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends JpaRepository<String, User> {

}
