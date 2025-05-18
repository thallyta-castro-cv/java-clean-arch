package com.thallyta.user.clean.architecture.user.application.usecase.event;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.domain.event.Event;

import java.util.List;

public class ListEventUseCase {

    public final EventRepository eventRepository;

    public ListEventUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll() {
       return eventRepository.getAll();
    }
}
