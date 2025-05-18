package com.thallyta.user.clean.architecture.user.infra.gateway.sale;

import com.thallyta.user.clean.architecture.user.domain.sale.Sale;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.SaleEntity;

public class SaleEntityMapper {

    private final TicketEntityMapper ticketEntityMapper;

    public SaleEntityMapper(TicketEntityMapper ticketEntityMapper) {
        this.ticketEntityMapper = ticketEntityMapper;
    }

    public SaleEntity toEntity(Sale sale) {
        return new SaleEntity(
                ticketEntityMapper.toEntityList(sale.getTickets())
        );
    }

    public Sale toDomain(SaleEntity saleEntity){
        return new Sale(
                saleEntity.getId(),
                saleEntity.getUser().getId(),
                ticketEntityMapper.toDomainList(saleEntity.getTickets())
        );
    }
}
