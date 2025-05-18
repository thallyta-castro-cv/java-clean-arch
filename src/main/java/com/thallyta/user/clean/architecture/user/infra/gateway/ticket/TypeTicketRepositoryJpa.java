package com.thallyta.user.clean.architecture.user.infra.gateway.ticket;

import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.EventEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.RepositoryEvent;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.RepositoryTypeTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TypeTicketEntity;
import jakarta.transaction.Transactional;

public class TypeTicketRepositoryJpa implements TypeTicketRepository {

    private final RepositoryTypeTicket repositoryTypeTicket;
    private final TypeTicketEntityMapper typeTicketMapper;
    private final RepositoryEvent repositoryEvent;

    public TypeTicketRepositoryJpa(RepositoryTypeTicket repositoryTypeTicket, TypeTicketEntityMapper typeTicketMapper, RepositoryEvent repositoryEvent) {
        this.repositoryTypeTicket = repositoryTypeTicket;
        this.typeTicketMapper = typeTicketMapper;
        this.repositoryEvent = repositoryEvent;
    }

    @Override
    public TypeTicket getById(Long id) {
        TypeTicketEntity typeTicketEntity = repositoryTypeTicket.getTypeTicketById(id);
        return typeTicketMapper.toDomain(typeTicketEntity);
    }

    @Override
    @Transactional
    public TypeTicket create(TypeTicket typeTicket) {
        TypeTicketEntity typeTicketEntity = typeTicketMapper.toEntity(typeTicket);

        EventEntity eventEntity = repositoryEvent.findById(typeTicket.getEventId())
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com ID: " + typeTicket.getEventId()));

        typeTicketEntity.setEvent(eventEntity);
        repositoryTypeTicket.save(typeTicketEntity);
        return typeTicketMapper.toDomain(typeTicketEntity);
    }
}
