package com.thallyta.user.clean.architecture.user.infra.gateway;


import com.thallyta.user.clean.architecture.user.application.gateway.UserRepository;
import com.thallyta.user.clean.architecture.user.domain.entities.user.User;
import com.thallyta.user.clean.architecture.user.infra.persistence.RepositoryUser;
import com.thallyta.user.clean.architecture.user.infra.persistence.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryJpa implements UserRepository {

    private final RepositoryUser repositoryUser;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryJpa(RepositoryUser repositoryUser, UserEntityMapper userEntityMapper) {
        this.repositoryUser = repositoryUser;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        repositoryUser.save(userEntity);
        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public List<User> getAll() {
        return repositoryUser.findAll().stream()
                .map(userEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
