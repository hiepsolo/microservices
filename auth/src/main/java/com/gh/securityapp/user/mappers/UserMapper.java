package com.gh.securityapp.user.mappers;

import com.gh.securityapp.common.mappers.BaseMapper;
import com.gh.securityapp.user.UserEntity;
import com.gh.securityapp.user.dto.CreateUserRequest;
import com.gh.securityapp.user.dto.UserDTO;

public interface UserMapper extends BaseMapper<UserDTO, UserEntity> {
    UserDTO toDto(UserEntity entity);

    UserEntity toEntity(UserDTO dto);

    UserEntity toEntity(CreateUserRequest userRequest);
}
