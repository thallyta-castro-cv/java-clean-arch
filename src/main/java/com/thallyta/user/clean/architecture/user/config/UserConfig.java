package com.thallyta.user.clean.architecture.user.config;

import com.thallyta.user.clean.architecture.user.application.gateway.user.UserRepository;
import com.thallyta.user.clean.architecture.user.application.usecase.user.CreateUserUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.user.ListUsersUseCase;
import com.thallyta.user.clean.architecture.user.infra.gateway.user.UserEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.user.UserRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.RepositoryUser;
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
    UserRepositoryJpa createRepositoryUserJpa(RepositoryUser repositoryUser, UserEntityMapper userEntityMapper){
        return new UserRepositoryJpa(repositoryUser, userEntityMapper);
    }

    @Bean
    UserEntityMapper entityUserMapper(){
        return new UserEntityMapper();
    }

}
