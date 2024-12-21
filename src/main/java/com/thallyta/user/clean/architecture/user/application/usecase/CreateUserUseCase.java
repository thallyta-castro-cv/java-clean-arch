package com.thallyta.user.clean.architecture.user.application.usecase;

import com.thallyta.user.clean.architecture.user.application.gateway.UserRepository;
import com.thallyta.user.clean.architecture.user.domain.entities.user.User;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.create(user);
    }

}
