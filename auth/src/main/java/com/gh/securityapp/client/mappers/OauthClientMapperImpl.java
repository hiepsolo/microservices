package com.gh.securityapp.client.mappers;

import com.gh.securityapp.client.OauthClientDTO;
import com.gh.securityapp.client.entities.OauthClientDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class OauthClientMapperImpl implements OauthClientMapper {
    @Override
    public OauthClientDTO toDto(OauthClientDetailsEntity entity) {
        return null;
    }

    @Override
    public OauthClientDetailsEntity toEntity(OauthClientDTO dto) {
        return null;
    }
}
