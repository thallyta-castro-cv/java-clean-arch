package com.thallyta.user.clean.architecture.user.infra.persistence.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thallyta.user.clean.architecture.user.domain.ticket.Definition;
import com.thallyta.user.clean.architecture.user.domain.ticket.Sector;
import com.thallyta.user.clean.architecture.user.infra.persistence.event.EventEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_type_ticket")
public class TypeTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JsonIgnore
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    private Sector sector;

    @Enumerated(EnumType.STRING)
    private Definition definition;

    private Double value;

    private int totalAvailable;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<TicketEntity> tickets = new ArrayList<>();

    public TypeTicketEntity() {}

    public TypeTicketEntity(Sector sector, Definition definition, Double value, int totalAvailable) {
        this.sector = sector;
        this.definition = definition;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }
}
