package com.thallyta.user.clean.architecture.user.infra.controller.event;

import com.thallyta.user.clean.architecture.user.domain.address.Address;
import com.thallyta.user.clean.architecture.user.domain.event.Category;
import com.thallyta.user.clean.architecture.user.domain.ticket.TypeTicket;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record EventDTO(
        Long id,

       @NotNull(message = "A categoria do evento é obrigatória!")
       Category category,

       @NotBlank(message = "A descrição do evento é obrigatória!")
       String description,

       @NotNull(message = "Data do evento é obrigatória!")
       @Future(message = "Data do evento deve ser uma data futura!")
       LocalDateTime date,

       @NotNull(message = "O endereço do evento é obrigatório!")
       @Valid
       Address address,

       List<TypeTicket> typeTickets
) {
}