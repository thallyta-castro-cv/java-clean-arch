package com.thallyta.user.clean.architecture.user.application.gateway.ticket;

import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;

public interface TicketRepository {

    Ticket createTicket(Ticket ticket, Long saleId);
}
