package com.gh.securityapp.client.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;


@Value
@Builder(toBuilder = true)
@Jacksonized
public class OauthClientDTO {
    String clientId;
    String clientSecret;

    @Singular
    List<String> scopes;

    @Singular
    List<String> authorizedGrantTypes;

    String webServerRedirectUri;

    @Singular
    List<String> authorities;
}

