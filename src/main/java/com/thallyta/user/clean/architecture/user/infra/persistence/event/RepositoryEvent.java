package com.thallyta.user.clean.architecture.user.infra.persistence.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEvent extends JpaRepository<EventEntity, Long> {
}
