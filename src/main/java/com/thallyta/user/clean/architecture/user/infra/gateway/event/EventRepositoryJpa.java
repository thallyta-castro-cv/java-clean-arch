package com.thallyta.user.clean.architecture.user.infra.gateway.event;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.domain.event.Event;
import com.thallyta.user.clean.architecture.user.infra.exceptions.EventNotFoundException;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.EventEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.RepositoryEvent;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class EventRepositoryJpa implements EventRepository {

    private final RepositoryEvent repositoryEvent;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryJpa(RepositoryEvent repositoryEvent, EventEntityMapper eventEntityMapper) {
        this.repositoryEvent = repositoryEvent;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    @Transactional
    public Event create(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntity(event);
        repositoryEvent.save(eventEntity);
        return eventEntityMapper.toDomain(eventEntity);
    }

    @Override
    public List<Event> getAll() {
        return repositoryEvent.findAll().stream()
                .map(eventEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Event findById(Long eventId) {
        return repositoryEvent.findById(eventId)
                .map(eventEntityMapper::toDomain)
                .orElseThrow(() -> new EventNotFoundException("Evento não encontrado para o ID: " + eventId));
    }

}
