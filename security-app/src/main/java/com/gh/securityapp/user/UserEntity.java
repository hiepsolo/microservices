package com.gh.securityapp.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
@FieldDefaults(makeFinal = false)
@Getter
@Setter(AccessLevel.PROTECTED)
@Immutable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
@Jacksonized
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "username", unique = true, updatable = false, nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    @Singular
    List<Integer> roles;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Builder.Default
    Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Builder.Default
    Instant lastModifiedDate = Instant.now();
}
