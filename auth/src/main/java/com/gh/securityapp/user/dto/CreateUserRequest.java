package com.gh.securityapp.user.dto;

import lombok.Value;

@Value
public class CreateUserRequest {
    String username;
    String password;
}
