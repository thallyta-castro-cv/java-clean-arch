package com.thallyta.user.clean.architecture.user.application.gateway.user;

import com.thallyta.user.clean.architecture.user.domain.entities.user.User;

import java.util.List;

public interface UserRepository {

    User create(User user);

    List<User> getAll();
}
