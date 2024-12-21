package com.thallyta.user.clean.architecture.user.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<UserEntity, Long> {
}
