package com.gh.securityapp.user.service;

import com.gh.securityapp.common.service.BaseService;
import com.gh.securityapp.user.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserService extends BaseService<UserDTO, Integer> {
    Optional<UserDTO> findByName(String name);
}
