package com.gh.securityapp.client;

import com.gh.securityapp.client.dto.OauthClientDTO;
import com.gh.securityapp.client.services.OauthClientService;
import com.gh.securityapp.common.controller.BaseController;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class OauthClientController extends BaseController<OauthClientDTO,String> {
    @NonNull
    @Getter(AccessLevel.PROTECTED)
    OauthClientService service;

    @Override
    @PostMapping("/")
    public ResponseEntity<OauthClientDTO> create(OauthClientDTO body) {
        return super.create(body);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OauthClientDTO> upsert(@PathVariable String id, OauthClientDTO body) {
        return super.upsert(id, body);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(String id) {
        return super.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OauthClientDTO> getById(@PathVariable String id) {
        return super.getById(id);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<OauthClientDTO>> getAll() {
        return super.getAll();
    }
}
