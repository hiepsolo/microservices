package com.gh.securityapp.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    @Override
    Optional<RoleEntity> findById(Integer integer);

    List<RoleEntity> findAllByIdIn(List<Integer> id);

    Optional<RoleEntity> findByName(String name);
}
