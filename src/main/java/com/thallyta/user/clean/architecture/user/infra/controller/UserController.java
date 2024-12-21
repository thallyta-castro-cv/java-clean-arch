package com.thallyta.user.clean.architecture.user.infra.controller;

import com.thallyta.user.clean.architecture.user.application.usecase.CreateUserUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.ListUsersUseCase;
import com.thallyta.user.clean.architecture.user.domain.entities.user.User;
import com.thallyta.user.clean.architecture.user.infra.controller.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;

    public UserController(CreateUserUseCase createUserUseCase, ListUsersUseCase listUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
    }

    @GetMapping
    public List<UserDTO> listUsers(){
        return listUsersUseCase.listAllUsers().stream()
                .map(user -> new UserDTO(user.getCpf(), user.getName(), user.getBornDate(), user.getEmail()))
                .collect(Collectors.toList());
    }


    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
       User userSave = createUserUseCase.createUser(new User(userDTO.cpf(), userDTO.name(), userDTO.bornDate(), userDTO.email()));
       return new UserDTO(userSave.getCpf(), userSave.getName(), userSave.getBornDate(), userSave.getEmail());
    }
}
