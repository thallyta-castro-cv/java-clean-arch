package com.thallyta.user.clean.architecture.user.infra.gateway.ticket;

import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TicketRepository;
import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.EventEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.RepositorySale;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.SaleEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.RepositoryTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.RepositoryTypeTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TicketEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TypeTicketEntity;
import jakarta.transaction.Transactional;

public class TicketRepositoryJpa implements TicketRepository {

    private final RepositoryTypeTicket repositoryTypeTicket;
    private final TypeTicketEntityMapper typeTicketMapper;
    private final TicketEntityMapper ticketEntityMapper;
    private final RepositoryTicket repositoryTicket;
    private final RepositorySale repositorySale;

    public TicketRepositoryJpa(RepositoryTypeTicket repositoryTypeTicket, TypeTicketEntityMapper typeTicketMapper, TicketEntityMapper ticketEntityMapper, RepositoryTicket repositoryTicket, RepositorySale repositorySale) {
        this.repositoryTypeTicket = repositoryTypeTicket;
        this.typeTicketMapper = typeTicketMapper;
        this.ticketEntityMapper = ticketEntityMapper;
        this.repositoryTicket = repositoryTicket;
        this.repositorySale = repositorySale;
    }

    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket, Long saleId) {
        TypeTicketEntity typeTicketEntity = getTypeTicketEntity(ticket);
        SaleEntity saleEntity = getSaleEntity(saleId);

        TicketEntity ticketEntity = buildTicketEntity(ticket, typeTicketEntity, saleEntity);

        repositoryTicket.save(ticketEntity);

        return ticketEntityMapper.toDomain(ticketEntity);
    }

    private TypeTicketEntity getTypeTicketEntity(Ticket ticket) {
        return repositoryTypeTicket.findById(ticket.getTypeTicket().getId())
                .orElseThrow(() -> new IllegalArgumentException("Ingresso não encontrado com ID: " + ticket.getTypeTicket().getId()));
    }

    private SaleEntity getSaleEntity(Long saleId) {
        return repositorySale.findById(saleId)
                .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada"));
    }

    private TicketEntity buildTicketEntity(Ticket ticket, TypeTicketEntity typeTicketEntity, SaleEntity saleEntity) {
        TypeTicket typeTicket = typeTicketMapper.toDomain(typeTicketEntity);
        typeTicketEntity.getEvent().setId(ticket.getTypeTicket().getEventId());
        ticket.setTypeTicket(typeTicket);

        TicketEntity ticketEntity = ticketEntityMapper.toEntity(ticket);
        ticketEntity.setSale(saleEntity);
        ticketEntity.getType().setId(typeTicketEntity.getId());

        EventEntity eventEntity = new EventEntity(ticket.getTypeTicket().getEventId());
        ticketEntity.getType().setEvent(eventEntity);
        ticketEntity.setType(typeTicketEntity);

        return ticketEntity;
    }

}
