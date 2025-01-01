package com.thallyta.user.clean.architecture.user.infra.gateway.user;

import com.thallyta.user.clean.architecture.user.domain.user.User;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getName(), user.getBornDate(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getCpf(), userEntity.getName(), userEntity.getBornDate(), userEntity.getEmail());
    }
}
