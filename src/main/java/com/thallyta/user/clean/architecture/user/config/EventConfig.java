package com.thallyta.user.clean.architecture.user.config;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.application.usecase.event.CreateEventUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.event.ListEventUseCase;
import com.thallyta.user.clean.architecture.user.infra.gateway.event.EventEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.event.EventRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TypeTicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.RepositoryEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class EventConfig {

    @Bean
    CreateEventUseCase createEvent(EventRepository eventRepository, TypeTicketRepository typeTicketRepository) {
        return new CreateEventUseCase(eventRepository, typeTicketRepository);
    }

    @Bean
    ListEventUseCase listEvent(EventRepository eventRepository) {
        return new ListEventUseCase(eventRepository);
    }

    @Bean
    EventRepositoryJpa createRepositoryEventJpa(RepositoryEvent repositoryEvent, EventEntityMapper eventEntityMapper){
        return new EventRepositoryJpa(repositoryEvent, eventEntityMapper);
    }

    @Bean
    EventEntityMapper entityEventMapper(@Lazy TypeTicketEntityMapper typeTicketMapper){
        return new EventEntityMapper(typeTicketMapper);
    }

}
