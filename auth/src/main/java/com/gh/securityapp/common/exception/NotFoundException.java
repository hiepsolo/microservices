package com.gh.securityapp.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {
    String objectName;
    Object objectId;
}
