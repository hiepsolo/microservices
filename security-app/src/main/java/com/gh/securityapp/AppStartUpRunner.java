package com.gh.securityapp;

import com.gh.securityapp.permission.PermissionDTO;
import com.gh.securityapp.permission.services.PermissionService;
import com.gh.securityapp.role.RoleDTO;
import com.gh.securityapp.role.services.RoleService;
import com.gh.securityapp.user.dto.UserDTO;
import com.gh.securityapp.user.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AppStartUpRunner implements CommandLineRunner {
    @NonNull UserService userService;
    @NonNull RoleService roleService;
    @NonNull PermissionService permissionService;
    @NonNull ClientRegistrationService clientRegistrationService;

    @Override
    public void run(String... args) {
        clientRegistrationService.listClientDetails().stream().map(ClientDetails::getClientId).filter("security-app"::equalsIgnoreCase).findFirst()
                .orElseGet(() -> {
                    BaseClientDetails clientDetails = new BaseClientDetails();
                    clientDetails.setClientId("security-app");
                    clientDetails.setClientSecret("secret");
                    clientDetails.setScope(List.of("read", "write"));
                    clientDetails.setAuthorizedGrantTypes(List.of("password", "refresh_token", "client_credentials"));
                    clientDetails.setAuthorities(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
                    clientDetails.setAccessTokenValiditySeconds(300);
                    clientRegistrationService.addClientDetails(clientDetails);
                    return clientDetails.getClientId();
                });
        PermissionDTO fullacessPermission = permissionService.findByName("FULL_ACCESS").orElseGet(() -> permissionService.create(PermissionDTO.builder()
                .name("FULL_ACCESS")
                .enabled(true)
                .build()));
        RoleDTO rootRole = roleService.findByName("ROOT").orElseGet(() -> roleService.create(RoleDTO.builder()
                .name("ROOT")
                .enabled(true)
                .permission(fullacessPermission.getId())
                .build()));
        userService.findByName("root").orElseGet(() -> userService.create(UserDTO.builder()
                .username("root")
                .password("password")
                .enabled(true)
                .role(rootRole.getId())
                .build()));
    }
}
