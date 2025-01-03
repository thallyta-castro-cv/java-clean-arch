package com.thallyta.user.clean.architecture.user.infra.gateway.ticket;

import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.gateway.event.EventEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TypeTicketEntity;

import java.util.List;

public class TypeTicketEntityMapper {

    public final EventEntityMapper eventEntityMapper;

    public TypeTicketEntityMapper(EventEntityMapper eventEntityMapper) {
        this.eventEntityMapper = eventEntityMapper;
    }

    public List<TypeTicket> toDomainList(List<TypeTicketEntity> typeTicketEntities) {
        return typeTicketEntities.stream()
                .map(entity -> new TypeTicket(
                        entity.getId(),
                        entity.getSector(),
                        entity.getEvent().getId(),
                        entity.getDefinition(),
                        entity.getValue(),
                        entity.getTotalAvailable()
                ))
                .toList();
    }

    public List<TypeTicketEntity> toEntityList(List<TypeTicket> typeTickets) {
        return typeTickets.stream()
                .map(domain -> new TypeTicketEntity(
                        domain.getSector(),
                        domain.getDefinition(),
                        domain.getValue(),
                        domain.getTotalAvailable()
                ))
                .toList();
    }

    public TypeTicket toDomain(TypeTicketEntity entity) {
        return new TypeTicket(
                entity.getId(),
                entity.getSector(),
                entity.getEvent().getId(),
                entity.getDefinition(),
                entity.getValue(),
                entity.getTotalAvailable()
        );
    }

    public TypeTicketEntity toEntity(TypeTicket typeTicket){
        return new TypeTicketEntity(
                typeTicket.getSector(),
                typeTicket.getDefinition(),
                typeTicket.getValue(),
                typeTicket.getTotalAvailable()
        );
    }
}
