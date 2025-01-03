package com.thallyta.user.clean.architecture.user.infra.persistence.ticket;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryTypeTicket extends JpaRepository<TypeTicketEntity, Long> {

    @Query(value = "select * from tb_type_ticket where id = ?1", nativeQuery = true)
    TypeTicketEntity getTypeTicketById(@NotNull Long id);
}
