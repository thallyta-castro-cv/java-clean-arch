package com.thallyta.user.clean.architecture.user.infra.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<UserEntity, Long> {
}
