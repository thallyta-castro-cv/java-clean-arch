package com.thallyta.user.clean.architecture.user.infra.controller.ticket;

import jakarta.validation.constraints.NotNull;

public record TicketDTO(
        @NotNull(message = "O código do ingresso é obrigatório!")
        Integer code,

        @NotNull(message = "O id do tipo do ingresso é obrigatório!")
        Long typeTicketId
) {
}
