package com.thallyta.user.clean.architecture.user.application.gateway.user;

import com.thallyta.user.clean.architecture.user.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User create(User user);

    List<User> getAll();

    Optional<User> getById(Long id);
}
