package com.thallyta.user.clean.architecture.user.config;

import com.thallyta.user.clean.architecture.user.application.gateway.UserRepository;
import com.thallyta.user.clean.architecture.user.application.usecase.CreateUserUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.ListUsersUseCase;
import com.thallyta.user.clean.architecture.user.infra.gateway.UserEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.UserRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.persistence.RepositoryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserUseCase createUser(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    ListUsersUseCase listUsersUseCase(UserRepository userRepository){
        return new ListUsersUseCase(userRepository);
    }

    @Bean
    UserRepositoryJpa createRepositoryJpa(RepositoryUser repositoryUser, UserEntityMapper userEntityMapper){
        return new UserRepositoryJpa(repositoryUser, userEntityMapper);
    }

    @Bean
    UserEntityMapper entityMapper(){
        return new UserEntityMapper();
    }

}
