package com.thallyta.user.clean.architecture.user.application.usecase.sale;

import com.thallyta.user.clean.architecture.user.application.gateway.sale.SaleRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TicketRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.user.UserRepository;
import com.thallyta.user.clean.architecture.user.domain.sale.Sale;
import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.domain.user.User;
import com.thallyta.user.clean.architecture.user.infra.exceptions.ValidateMessageException;

import java.util.ArrayList;
import java.util.List;

public class CreateSaleUseCase {

    public final SaleRepository saleRepository;
    public final UserRepository userRepository;
    public final TypeTicketRepository typeTicketRepository;
    private final TicketRepository ticketRepository;

    public CreateSaleUseCase(SaleRepository saleRepository, UserRepository userRepository, TypeTicketRepository typeTicketRepository, TicketRepository ticketRepository) {
        this.saleRepository = saleRepository;
        this.userRepository = userRepository;
        this.typeTicketRepository = typeTicketRepository;
        this.ticketRepository = ticketRepository;
    }

    public void createSale(Sale sale){
        Sale newSale = prepareSaleToSaveTicket(sale);
        newSale.setTickets(sale.getTickets());
        setTickets(newSale);
    }

    private Sale prepareSaleToSaveTicket(Sale sale) {
        User user = userRepository.getById(sale.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Sale newSale = new Sale();
        newSale.setUserId(user.getId());
        return saleRepository.create(newSale);
    }

    private void setTickets(Sale sale) {
        List<Ticket> newTickets = new ArrayList<>();

        for (Ticket ticket : sale.getTickets()) {
            try {
                TypeTicket type = typeTicketRepository.getById(ticket.getTypeTicket().getId());
                Ticket newTicket = new Ticket(ticket.getId(), ticket.getCode(), sale.getId(), type);
                newTickets.add(newTicket);
            } catch (Exception e) {
                throw new ValidateMessageException("Erro ao configurar os ingressos da sua venda");
            }
        }

        newTickets.forEach(ticket -> ticketRepository.createTicket(ticket, sale.getId()));

    }

}
