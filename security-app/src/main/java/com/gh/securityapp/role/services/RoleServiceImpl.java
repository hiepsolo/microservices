package com.gh.securityapp.role.services;

import com.gh.securityapp.common.service.BaseServiceImpl;
import com.gh.securityapp.role.RoleDTO;
import com.gh.securityapp.role.RoleEntity;
import com.gh.securityapp.role.RoleRepository;
import com.gh.securityapp.role.mappers.RoleMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, Integer, RoleEntity> implements RoleService {
    @NonNull
    @Getter(PROTECTED)
    RoleRepository repository;
    @NonNull
    @Getter(PROTECTED)
    RoleMapper mapper;

    @Override
    public Optional<RoleDTO> findByName(String name) {
        return repository.findByName(name).map(mapper::toDto);
    }
}

