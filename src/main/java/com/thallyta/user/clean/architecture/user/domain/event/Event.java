package com.thallyta.user.clean.architecture.user.domain.event;

import com.thallyta.user.clean.architecture.user.domain.address.Address;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Event {

    private Long id;
    private UUID uuid;
    private Category category;
    private String description;
    private LocalDateTime date;
    private Address address;
    private List<TypeTicket> typeTickets = new ArrayList<>();

    public Event() {}

    public Event(Long id, Category category, String description, LocalDateTime date, Address address, List<TypeTicket> typeTickets) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.date = date;
        this.address = address;
        this.typeTickets = typeTickets;

        generateUniqueIdentifier();
    }

    private void generateUniqueIdentifier() {
        this.uuid = UUID.randomUUID();
    }
}
