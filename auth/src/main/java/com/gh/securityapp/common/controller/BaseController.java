package com.gh.securityapp.common.controller;

import com.gh.securityapp.common.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<D, ID> {
    protected abstract BaseService<D, ID> getService();

    public ResponseEntity<D> create(D body) {
        return ResponseEntity.ok(getService().create(body));
    }

    public ResponseEntity<D> upsert(ID id, D body) {
        return ResponseEntity.ok(getService().upsert(id, body));
    }

    public ResponseEntity<Void> delete(ID id) {
        getService().delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<D> getById(ID id) {
        return getService().getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok(getService().getAll());
    }
}
