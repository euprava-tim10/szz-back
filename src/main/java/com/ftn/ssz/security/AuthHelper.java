package com.ftn.ssz.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthHelper {

    public static AuthUser authUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof String)
            return null;

        return ((AuthUserDetails) principal).getUser();
    }
}
