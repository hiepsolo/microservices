package com.gh.securityapp.permission.services;

import com.gh.securityapp.common.service.BaseService;
import com.gh.securityapp.permission.PermissionDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface PermissionService extends BaseService<PermissionDTO, Integer> {
    Optional<PermissionDTO> findByName(String name);
}
