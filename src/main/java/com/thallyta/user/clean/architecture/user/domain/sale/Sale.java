package com.thallyta.user.clean.architecture.user.domain.sale;

import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Sale {

    private Long id;
    private Long userId;
    private List<Ticket> tickets = new ArrayList<>();

    public Sale() {}

    public Sale(Long id, Long userId, List<Ticket> tickets) {
        this.id = id;
        this.userId = userId;
        this.tickets = tickets;
    }
}
