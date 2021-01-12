package com.gh.securityapp.permission.mappers;

import com.gh.securityapp.permission.PermissionDTO;
import com.gh.securityapp.permission.PermissionEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermissionMapperImpl implements PermissionMapper {
    @Override
    public PermissionDTO toDto(PermissionEntity permissionEntity) {
        return Optional.ofNullable(permissionEntity)
                .map(entity -> PermissionDTO.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .enabled(entity.isEnabled())
                        .roles(entity.getRoles())
                        .build())
                .orElse(null);
    }

    @Override
    public PermissionEntity toEntity(PermissionDTO permissionDTO) {
        return Optional.ofNullable(permissionDTO)
                .map(dto -> PermissionEntity.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .enabled(dto.isEnabled())
                        .roles(dto.getRoles())
                        .build())
                .orElse(null);
    }
}
