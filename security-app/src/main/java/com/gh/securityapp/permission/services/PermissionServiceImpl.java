package com.gh.securityapp.permission.services;

import com.gh.securityapp.common.service.BaseServiceImpl;
import com.gh.securityapp.permission.PermissionDTO;
import com.gh.securityapp.permission.PermissionEntity;
import com.gh.securityapp.permission.PermissionRepository;
import com.gh.securityapp.permission.mappers.PermissionMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl extends BaseServiceImpl<PermissionDTO, Integer, PermissionEntity> implements PermissionService {
    @NonNull
    @Getter(PROTECTED)
    PermissionRepository repository;

    @NonNull
    @Getter(PROTECTED)
    PermissionMapper mapper;


    @Override
    public Optional<PermissionDTO> findByName(String name) {
        return repository.findByName(name).map(mapper::toDto);
    }
}
