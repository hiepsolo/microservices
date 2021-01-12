package com.gh.securityapp.user.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Jacksonized
public class UserDTO {
    int id;
    String username;
    String password;
    boolean enabled;
    OffsetDateTime createdDate;
    OffsetDateTime lastModifiedDate;
    @Singular
    List<Integer> roles;
}
