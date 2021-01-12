package com.gh.securityapp.user.mappers;

import com.gh.securityapp.common.mappers.DateMapper;
import com.gh.securityapp.user.UserEntity;
import com.gh.securityapp.user.dto.CreateUserRequest;
import com.gh.securityapp.user.dto.UserDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    @NonNull DateMapper dateMapper;
    @NonNull PasswordMapper passwordMapper;

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(entity -> UserDTO.builder()
                        .id(entity.getId())
                        .username(entity.getUsername())
                        .enabled(entity.isEnabled())
                        .createdDate(dateMapper.asOffsetDateTime(entity.getCreatedDate()))
                        .lastModifiedDate(dateMapper.asOffsetDateTime(entity.getLastModifiedDate()))
                        .roles(userEntity.getRoles())
                        .build())
                .orElse(null);
    }

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        return Optional.ofNullable(userDTO)
                .map(dto -> UserEntity.builder()
                        .id(dto.getId())
                        .username(dto.getUsername())
                        .password(passwordMapper.encode(dto.getPassword()))
                        .enabled(dto.isEnabled())
                        .roles(dto.getRoles())
                        .build())
                .orElse(null);
    }

    @Override
    public UserEntity toEntity(CreateUserRequest creatUserRequest) {
        return Optional.ofNullable(creatUserRequest)
                .map(request -> UserEntity.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .build())
                .orElse(null);
    }
}
