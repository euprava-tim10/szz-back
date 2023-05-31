package com.ftn.szz.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthUser {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String role;
}
