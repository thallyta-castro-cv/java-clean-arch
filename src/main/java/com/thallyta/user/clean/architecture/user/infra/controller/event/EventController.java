package com.thallyta.user.clean.architecture.user.infra.controller.event;

import com.thallyta.user.clean.architecture.user.application.usecase.event.CreateEventUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.event.ListEventUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.ticket.CreateTypeTicketUseCase;
import com.thallyta.user.clean.architecture.user.domain.event.Event;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.controller.ticket.TypeTicketDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final ListEventUseCase listEventUseCase;
    private final CreateTypeTicketUseCase createTypeTicketUseCase;

    public EventController(CreateEventUseCase createEventUseCase, ListEventUseCase listEventUseCase, CreateTypeTicketUseCase createTypeTicketUseCase) {
        this.createEventUseCase = createEventUseCase;
        this.listEventUseCase = listEventUseCase;
        this.createTypeTicketUseCase = createTypeTicketUseCase;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> listEvents() {
        List<EventDTO> eventDTOs = listEventUseCase.getAll().stream()
                .map(event -> new EventDTO(
                        event.getId(),
                        event.getCategory(),
                        event.getDescription(),
                        event.getDate(),
                        event.getAddress(),
                        event.getTypeTickets()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(eventDTOs);
    }


    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {

        Event eventToSave = new Event(
                eventDTO.id(),
                eventDTO.category(),
                eventDTO.description(),
                eventDTO.date(),
                eventDTO.address(),
                eventDTO.typeTickets()
        );

        Event savedEvent = createEventUseCase.createEvent(eventToSave);

        EventDTO responseDTO = new EventDTO(
                savedEvent.getId(),
                savedEvent.getCategory(),
                savedEvent.getDescription(),
                savedEvent.getDate(),
                savedEvent.getAddress(),
                savedEvent.getTypeTickets()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/{eventId}/type-tickets")
    public ResponseEntity<Void> createTypeTickets(@PathVariable Long eventId, @RequestBody @Valid List<TypeTicketDTO> typeTicketDTOs) {
        List<TypeTicket> typeTickets = typeTicketDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        createTypeTicketUseCase.saveTypeTickets(eventId, typeTickets);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private TypeTicket convertToEntity(TypeTicketDTO typeTicketDTO) {
        TypeTicket typeTicket = new TypeTicket();
        typeTicket.setSector(typeTicketDTO.sector());
        typeTicket.setDefinition(typeTicketDTO.definition());
        typeTicket.setValue(typeTicketDTO.value());
        typeTicket.setEventId(typeTicketDTO.eventId());
        typeTicket.setTotalAvailable(typeTicketDTO.totalAvailable());

        return typeTicket;
    }

}
