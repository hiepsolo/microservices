package com.gh.securityapp.client.services;

import com.gh.securityapp.client.OauthClientDTO;
import com.gh.securityapp.client.OauthClientRepository;
import com.gh.securityapp.client.entities.OauthClientDetailsEntity;
import com.gh.securityapp.client.mappers.OauthClientMapper;
import com.gh.securityapp.common.service.BaseServiceImpl;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class OauthClientServiceImpl extends BaseServiceImpl<OauthClientDTO, String, OauthClientDetailsEntity> implements OauthClientService {
    @NonNull
    @Getter(PROTECTED)
    OauthClientRepository repository;

    @NonNull
    @Getter(PROTECTED)
    OauthClientMapper mapper;
}
