package com.thallyta.user.clean.architecture.user.infra.persistence.sale;

import com.thallyta.user.clean.architecture.user.infra.persistence.ticket.TicketEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TicketEntity> tickets = new ArrayList<>();

    public SaleEntity() {}

    public SaleEntity(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }
}
