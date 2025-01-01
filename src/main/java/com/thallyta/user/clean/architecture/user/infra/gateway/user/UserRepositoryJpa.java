package com.thallyta.user.clean.architecture.user.infra.gateway.user;

import com.thallyta.user.clean.architecture.user.application.gateway.user.UserRepository;
import com.thallyta.user.clean.architecture.user.domain.user.User;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.RepositoryUser;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.UserEntity;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<User> getById(Long id) {
        Optional<UserEntity> userEntity = repositoryUser.findById(id);
        return userEntity.map(userEntityMapper::toDomain);
    }

}
