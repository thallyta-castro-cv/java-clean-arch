package com.thallyta.user.clean.architecture.user.config;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.application.usecase.ticket.CreateTypeTicketUseCase;
import com.thallyta.user.clean.architecture.user.infra.gateway.event.EventEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TicketRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TypeTicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TypeTicketRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.RepositoryEvent;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.RepositorySale;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.RepositoryTicket;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.RepositoryTypeTicket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class TicketConfig {

    @Bean
    TypeTicketEntityMapper entityTypeTicketMapper(EventEntityMapper eventEntityMapper){
        return new TypeTicketEntityMapper(eventEntityMapper);
    }

    @Bean
    TicketEntityMapper entityTicketMapper(@Lazy TypeTicketEntityMapper typeTicketEntityMapper) {
        return new TicketEntityMapper(typeTicketEntityMapper);
    }

    @Bean
    TypeTicketRepositoryJpa typeTicketRepositoryJpa(RepositoryTypeTicket repositoryTypeTicket, TypeTicketEntityMapper typeTicketMapper, RepositoryEvent repositoryEvent){
        return new TypeTicketRepositoryJpa(repositoryTypeTicket, typeTicketMapper, repositoryEvent);
    }

    @Bean
    TicketRepositoryJpa ticketRepositoryJpa(RepositoryTypeTicket repositoryTypeTicket, TypeTicketEntityMapper typeTicketMapper,
                                            TicketEntityMapper ticketEntityMapper, RepositoryTicket repositoryTicket,
                                            RepositorySale repositorySale){
        return new TicketRepositoryJpa(repositoryTypeTicket, typeTicketMapper, ticketEntityMapper, repositoryTicket, repositorySale);
    }

    @Bean
    CreateTypeTicketUseCase createTypeTicketUseCase(EventRepository eventRepository, TypeTicketRepository typeTicketRepository){
        return new CreateTypeTicketUseCase(eventRepository, typeTicketRepository);
    }
}
