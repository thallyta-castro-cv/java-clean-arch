package com.thallyta.user.clean.architecture.user.infra.controller.sale;

import com.thallyta.user.clean.architecture.user.infra.controller.ticket.TicketDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SaleDTO(
        Long id,

        @NotNull(message = "O id do usuário é obrigatório!")
        Long userId,

        @NotNull(message = "Os dados do ingresso devem ser informados")
        @Valid
        List<TicketDTO> tickets
) {
}
