package com.thallyta.user.clean.architecture.user.infra.gateway.ticket;

import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TicketEntity;

import java.util.List;

public class TicketEntityMapper {

    public final TypeTicketEntityMapper typeTicketEntityMapper;

    public TicketEntityMapper(TypeTicketEntityMapper typeTicketEntityMapper) {
        this.typeTicketEntityMapper = typeTicketEntityMapper;
    }

    public List<TicketEntity> toEntityList(List<Ticket> typeTickets) {
        return typeTickets.stream()
                .map(domain -> new TicketEntity(
                        domain.getCode(),
                        typeTicketEntityMapper.toEntity(domain.getTypeTicket())
                ))
                .toList();
    }

    public List<Ticket> toDomainList(List<TicketEntity> ticketEntities) {
        return ticketEntities.stream()
                .map(entity -> new Ticket(
                        entity.getId(),
                        entity.getCode(),
                        entity.getSale().getId(),
                        typeTicketEntityMapper.toDomain(entity.getType())
                ))
                .toList();
    }

    public TicketEntity toEntity(Ticket ticket){
        return new TicketEntity(
                ticket.getCode(),
                typeTicketEntityMapper.toEntity(ticket.getTypeTicket())
        );
    }

    public Ticket toDomain(TicketEntity ticketEntity){
        return new Ticket(
                ticketEntity.getId(),
                ticketEntity.getCode(),
                ticketEntity.getSale().getId(),
                typeTicketEntityMapper.toDomain(ticketEntity.getType())
        );
    }
}
