package com.thallyta.user.clean.architecture.user.application.gateway.ticket;

import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;

public interface TypeTicketRepository {

    TypeTicket getById(Long id);

    TypeTicket create(TypeTicket typeTicket);
}
