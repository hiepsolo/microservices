package com.gh.securityapp.role.mappers;

import com.gh.securityapp.role.RoleDTO;
import com.gh.securityapp.role.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleDTO toDto(RoleEntity roleEntity) {
        return Optional.ofNullable(roleEntity)
                .map(entity -> RoleDTO.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .enabled(entity.isEnabled())
                        .permissions(entity.getPermissions())
                        .users(entity.getUsers())
                        .build())
                .orElse(null);
    }

    @Override
    public RoleEntity toEntity(RoleDTO roleDTO) {
        return Optional.ofNullable(roleDTO)
                .map(dto -> RoleEntity.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .enabled(dto.isEnabled())
                        .permissions(dto.getPermissions())
                        .users(dto.getUsers())
                        .build())
                .orElse(null);
    }
}
