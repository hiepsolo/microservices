package com.gh.securityapp.role.services;

import com.gh.securityapp.common.service.BaseService;
import com.gh.securityapp.role.RoleDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface RoleService extends BaseService<RoleDTO, Integer> {
    Optional<RoleDTO> findByName(String name);
}
