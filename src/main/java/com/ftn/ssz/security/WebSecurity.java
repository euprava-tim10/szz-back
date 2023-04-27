package com.ftn.ssz.security;

import org.springframework.stereotype.Component;

import static com.ftn.ssz.security.AuthHelper.authUser;

@Component
public class WebSecurity {

    public boolean checkSchoolAdmin(long id) {
        return authUser().getSchoolId() == id;
    }
}
