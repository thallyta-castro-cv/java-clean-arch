package com.thallyta.user.clean.architecture.user.application.gateway.event;

import com.thallyta.user.clean.architecture.user.domain.event.Event;

import java.util.List;

public interface EventRepository {

    Event create(Event event);

    List<Event> getAll();

    Event findById(Long eventId);
}
