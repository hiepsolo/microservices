package com.gh.securityapp.user.mappers;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PasswordMapper {
    @NonNull PasswordEncoder passwordEncoder;

    public String encode(String password) {
        return Optional.ofNullable(password).map(passwordEncoder::encode).orElse(null);
    }
}
