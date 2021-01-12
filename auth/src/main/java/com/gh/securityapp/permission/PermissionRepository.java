package com.gh.securityapp.permission;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends PagingAndSortingRepository<PermissionEntity, Integer> {
    List<PermissionEntity> findAllByRolesIn(List<Integer> roles);

    Optional<PermissionEntity> findByName(String name);
}
