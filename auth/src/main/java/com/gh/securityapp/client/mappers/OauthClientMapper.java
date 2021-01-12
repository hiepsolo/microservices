package com.gh.securityapp.client.mappers;

import com.gh.securityapp.client.dto.OauthClientDTO;
import com.gh.securityapp.client.entities.OauthClientDetailsEntity;
import com.gh.securityapp.common.mappers.BaseMapper;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public interface OauthClientMapper extends BaseMapper<OauthClientDTO, OauthClientDetailsEntity> {
}
