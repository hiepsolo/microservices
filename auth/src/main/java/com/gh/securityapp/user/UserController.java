package com.gh.securityapp.user;

import com.gh.securityapp.common.controller.BaseController;
import com.gh.securityapp.user.dto.UserDTO;
import com.gh.securityapp.user.service.UserService;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController extends BaseController<UserDTO, Integer> {

    @NonNull
    @Getter(PROTECTED)
    UserService service;

    @Override
    @PostMapping("/")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO body) {
        return super.create(body);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) {
        return super.getById(id);
    }


    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> upsert(@PathVariable Integer id, @RequestBody UserDTO body) {
        return super.upsert(id, body.toBuilder().id(id).build());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return super.delete(id);
    }
}
