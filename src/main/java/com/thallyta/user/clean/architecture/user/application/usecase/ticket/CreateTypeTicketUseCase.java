package com.thallyta.user.clean.architecture.user.application.usecase.ticket;

import com.thallyta.user.clean.architecture.user.application.gateway.event.EventRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.domain.event.Event;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.exceptions.EventNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

public class CreateTypeTicketUseCase {

    private final EventRepository eventRepository;
    private final TypeTicketRepository typeTicketRepository;

    public CreateTypeTicketUseCase(EventRepository eventRepository, TypeTicketRepository typeTicketRepository) {
        this.eventRepository = eventRepository;
        this.typeTicketRepository = typeTicketRepository;
    }

    @Transactional
    public void saveTypeTickets(Long eventId, List<TypeTicket> typeTicketList) {

        for (TypeTicket typeTicketOfList : typeTicketList) {
            Event event = eventRepository.findById(eventId);

            if (event == null) {
                throw new EventNotFoundException("Evento não encontrado para o ID: " + eventId);
            }

            TypeTicket typeTicket = new TypeTicket(
                    typeTicketOfList.getId(),
                    typeTicketOfList.getSector(),
                    typeTicketOfList.getEventId(),
                    typeTicketOfList.getDefinition(),
                    typeTicketOfList.getValue(),
                    typeTicketOfList.getTotalAvailable()
            );

            typeTicket.setEventId(event.getId());

            typeTicketRepository.create(typeTicket);
        }
    }
}
