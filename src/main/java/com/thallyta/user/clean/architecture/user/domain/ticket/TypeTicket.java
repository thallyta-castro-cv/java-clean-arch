package com.thallyta.user.clean.architecture.user.domain.ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeTicket {

    Long id;
    Sector sector;
    Definition definition;
    Double value;
    Long eventId;
    int totalAvailable;

    public TypeTicket(){}

    public TypeTicket(Long id, Sector sector, Long eventId, Definition definition, Double value, int totalAvailable) {
        this.id = id;
        this.sector = sector;
        this.eventId = eventId;
        this.definition = definition;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }

    public TypeTicket(Long id){
        this.id = id;
    }
}
