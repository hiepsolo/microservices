package com.gh.securityapp.client.mappers;

import com.gh.securityapp.client.dto.OauthClientDTO;
import com.gh.securityapp.client.entities.OauthClientDetailsEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OauthClientMapperImpl implements OauthClientMapper {
    @NonNull PasswordEncoder passwordEncoder;

    @Override
    public OauthClientDTO toDto(OauthClientDetailsEntity entity) {
        return null;
    }

    @Override
    public OauthClientDetailsEntity toEntity(OauthClientDTO dto) {
        return OauthClientDetailsEntity.builder()
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .scope(dto.getScopes().stream().collect(Collectors.joining(",")))
                .authorizedGrantTypes(dto.getAuthorizedGrantTypes().stream().collect(Collectors.joining(",")))
                .authorities(dto.getAuthorities().stream().collect(Collectors.joining(",")))
                .accessTokenValidity(300)
                .build();
    }
}
