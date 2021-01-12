package com.gh.securityapp.client;

import com.gh.securityapp.client.services.OauthClientService;
import com.gh.securityapp.common.controller.BaseController;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OauthClientController extends BaseController {
    @NonNull
    @Getter(AccessLevel.PROTECTED)
    OauthClientService service;
}
