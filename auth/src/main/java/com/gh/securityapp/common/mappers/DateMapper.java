package com.gh.securityapp.common.mappers;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Instant instant) {
        return Optional.ofNullable(instant).map(ins -> OffsetDateTime.ofInstant(ins, ZoneOffset.UTC)).orElse(null);
    }

}
