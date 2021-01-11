package com.gh.securityapp.auth;

import com.gh.securityapp.permission.PermissionEntity;
import com.gh.securityapp.permission.PermissionRepository;
import com.gh.securityapp.role.RoleEntity;
import com.gh.securityapp.role.RoleRepository;
import com.gh.securityapp.user.UserEntity;
import com.gh.securityapp.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @NonNull UserRepository userRepository;

    @NonNull RoleRepository roleRepository;

    @NonNull PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(username);
        Function<PermissionEntity, String> toPermissionName = PermissionEntity::getName;

        return optionalUserEntity.map(userEntity -> User.builder()
                .username(username)
                .password(userEntity.getPassword())
                .authorities(permissionRepository.findAllByRolesIn(roleRepository.findAllByIdIn(userEntity.getRoles())
                        .stream()
                        .map(RoleEntity::getId)
                        .collect(Collectors.toList()))
                        .stream()
                        .map(toPermissionName.andThen(SimpleGrantedAuthority::new))
                        .collect(Collectors.toList()))
                .build()).orElse(null);
    }
}
