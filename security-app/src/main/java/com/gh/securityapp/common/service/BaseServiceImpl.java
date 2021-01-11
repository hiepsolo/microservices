package com.gh.securityapp.common.service;

import com.gh.securityapp.common.mappers.BaseMapper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseServiceImpl<D, ID, E> implements BaseService<D, ID> {

    protected abstract CrudRepository<E, ID> getRepository();

    protected abstract BaseMapper<D, E> getMapper();

    @Override
    public D create(D body) {
        return this.saveFlow().apply(body);
    }

    private Function<D, D> saveFlow() {
        BaseMapper<D, E> mapper = getMapper();
        Function<D, E> toEntity = mapper::toEntity;
        return toEntity.andThen(getRepository()::save).andThen(mapper::toDto);
    }

    @Override
    public D upsert(ID id, D body) {
        return this.saveFlow().apply(body);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public Optional<D> getById(ID id) {
        return getRepository().findById(id).map(getMapper()::toDto);
    }

    @Override
    public List<D> getAll() {
        return StreamSupport.stream(getRepository().findAll().spliterator(), false)
                .map(getMapper()::toDto)
                .collect(Collectors.toList());
    }
}
