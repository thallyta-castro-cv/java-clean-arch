package com.thallyta.user.clean.architecture.user.application.usecase.event;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.domain.event.Event;

public class CreateEventUseCase {

    public final EventRepository eventRepository;
    public final TypeTicketRepository typeTicketRepository;

    public CreateEventUseCase(EventRepository eventRepository, TypeTicketRepository typeTicketRepository) {
        this.eventRepository = eventRepository;
        this.typeTicketRepository = typeTicketRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.create(event);
    }

}
