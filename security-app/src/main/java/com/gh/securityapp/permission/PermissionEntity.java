package com.gh.securityapp.permission;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permissions", schema = "public")
@FieldDefaults(makeFinal = false)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;

    @Column(name = "name", updatable = false, nullable = false)
    String name;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "permission_id"))
    @Column(name = "role_id")
    @Singular
    List<Integer> roles;
}
