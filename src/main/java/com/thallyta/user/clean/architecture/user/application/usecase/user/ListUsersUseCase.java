package com.thallyta.user.clean.architecture.user.application.usecase.user;

import com.thallyta.user.clean.architecture.user.application.gateway.user.UserRepository;
import com.thallyta.user.clean.architecture.user.domain.entities.user.User;

import java.util.List;

public class ListUsersUseCase {

    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers(){
        return this.userRepository.getAll();
    }
}
