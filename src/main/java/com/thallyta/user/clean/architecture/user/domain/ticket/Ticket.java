package com.thallyta.user.clean.architecture.user.domain.ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    private Long id;
    private int code;
    private Long saleId;
    private TypeTicket typeTicket;

    public Ticket(){}

    public Ticket(Long id, int code, Long saleId, TypeTicket typeTicket) {
        this.id = id;
        this.code = code;
        this.saleId = saleId;
        this.typeTicket = typeTicket;
    }

    public Ticket(int code, TypeTicket typeTicket) {
        this.code = code;
        this.typeTicket = typeTicket;
    }
}
