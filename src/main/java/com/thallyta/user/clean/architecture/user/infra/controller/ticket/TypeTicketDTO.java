package com.thallyta.user.clean.architecture.user.infra.controller.ticket;

import com.thallyta.user.clean.architecture.user.domain.ticket.Definition;
import com.thallyta.user.clean.architecture.user.domain.ticket.Sector;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TypeTicketDTO(
        @NotNull(message = "O setor do ingresso é obrigatório!")
        Sector sector,

        @NotNull(message = "A definição do tipo de ingresso é obrigatória!")
        Definition definition,

        @NotNull
        Double value,

        Long eventId,

        @Positive
        int totalAvailable
) {
}
