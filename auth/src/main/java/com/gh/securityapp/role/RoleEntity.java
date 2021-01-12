package com.gh.securityapp.role;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "public")
@FieldDefaults(makeFinal = false)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;

    @Column(name = "name", updatable = false, nullable = false)
    String name;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permission_id")
    @Singular
    List<Integer> permissions;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "user_id")
    @Singular
    List<Integer> users;
}
