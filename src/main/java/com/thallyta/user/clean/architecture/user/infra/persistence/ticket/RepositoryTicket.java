package com.thallyta.user.clean.architecture.user.infra.persistence.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTicket extends JpaRepository<TicketEntity, Long> {
}
