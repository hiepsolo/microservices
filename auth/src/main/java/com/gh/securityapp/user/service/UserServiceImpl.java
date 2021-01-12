package com.gh.securityapp.user.service;

import com.gh.securityapp.common.service.BaseServiceImpl;
import com.gh.securityapp.user.UserEntity;
import com.gh.securityapp.user.UserRepository;
import com.gh.securityapp.user.dto.UserDTO;
import com.gh.securityapp.user.mappers.UserMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserDTO, Integer, UserEntity> implements UserService {

    @NonNull
    @Getter(PROTECTED)
    UserRepository repository;

    @NonNull
    @Getter(PROTECTED)
    UserMapper mapper;

    @Override
    public Optional<UserDTO> findByName(String name) {
        return repository.findByUsername(name).map(mapper::toDto);
    }
}
