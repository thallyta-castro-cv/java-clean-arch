package com.thallyta.user.clean.architecture.user.infra.persistence.event;

import com.thallyta.user.clean.architecture.user.domain.address.Address;
import com.thallyta.user.clean.architecture.user.domain.event.Category;
import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TypeTicketEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private LocalDateTime date;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TypeTicketEntity> typeTickets = new ArrayList<>();

    public EventEntity(Category category, String description, LocalDateTime date, Address address, List<TypeTicketEntity> typeTickets) {
        this.category = category;
        this.description = description;
        this.date = date;
        this.address = address;
        this.typeTickets = typeTickets;
    }

    public EventEntity() {}

    public EventEntity(Long id) {
        this.id = id;
    }
}
