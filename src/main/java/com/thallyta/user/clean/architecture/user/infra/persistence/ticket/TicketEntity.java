package com.thallyta.user.clean.architecture.user.infra.persistence.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.SaleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int code;

    @ManyToOne
    private TypeTicketEntity type;

    @ManyToOne
    @JsonIgnore
    private SaleEntity sale;

    public TicketEntity() {}

    public TicketEntity(int code, TypeTicketEntity type) {
        this.code = code;
        this.type = type;
    }
}
