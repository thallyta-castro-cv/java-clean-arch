package com.thallyta.user.clean.architecture.user.infra.gateway.event;

import com.thallyta.user.clean.architecture.user.domain.event.Event;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TypeTicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.EventEntity;

public class EventEntityMapper {

    public final TypeTicketEntityMapper typeTicketMapper;

    public EventEntityMapper(TypeTicketEntityMapper typeTicketMapper) {
        this.typeTicketMapper = typeTicketMapper;
    }

    public EventEntity toEntity(Event event) {
        return new EventEntity(event.getCategory(), event.getDescription(),
                               event.getDate(), event.getAddress(),
                               typeTicketMapper.toEntityList(event.getTypeTickets()));
    }

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getCategory(),
                eventEntity.getDescription(),
                eventEntity.getDate(),
                eventEntity.getAddress(),
                typeTicketMapper.toDomainList(eventEntity.getTypeTickets())
        );
    }

}
