package com.gh.securityapp.permission;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class PermissionDTO {
    int id;
    String name;
    boolean enabled;
    @Singular
    List<Integer> roles;
}
