package com.thallyta.user.clean.architecture.user.infra.controller.sale;

import com.thallyta.user.clean.architecture.user.application.usecase.sale.CreateSaleUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.sale.ListSaleUseCase;
import com.thallyta.user.clean.architecture.user.domain.sale.Sale;
import com.thallyta.user.clean.architecture.user.domain.ticket.Ticket;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import com.thallyta.user.clean.architecture.user.infra.controller.ticket.TicketDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final CreateSaleUseCase createSaleUseCase;
    private final ListSaleUseCase listSaleUseCase;

    public SaleController(CreateSaleUseCase createSaleUseCase, ListSaleUseCase listSaleUseCase) {
        this.createSaleUseCase = createSaleUseCase;
        this.listSaleUseCase = listSaleUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> listAll() {
        List<SaleDTO> sales = listSaleUseCase.getAll().stream()
                .map(sale -> new SaleDTO(
                        sale.getId(),
                        sale.getUserId(),
                        sale.getTickets().stream()
                                .map(ticket -> new TicketDTO(
                                        ticket.getCode(),
                                        ticket.getTypeTicket().getId()
                                ))
                                .toList()
                ))
                .toList();

        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody SaleDTO saleDTO) {
        Sale saleToSave = new Sale(
                saleDTO.id(),
                saleDTO.userId(),
                saleDTO.tickets().stream()
                        .map(ticket -> new Ticket(
                                ticket.code(),
                                new TypeTicket(ticket.typeTicketId())
                        ))
                        .toList()
        );

        createSaleUseCase.createSale(saleToSave);

        SaleDTO responseDTO = new SaleDTO(
                saleToSave.getId(),
                saleToSave.getUserId(),
                saleToSave.getTickets().stream().map(
                        ticketDTO -> new TicketDTO(
                            ticketDTO.getCode(),
                            ticketDTO.getTypeTicket().getId()
                        )).toList());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
