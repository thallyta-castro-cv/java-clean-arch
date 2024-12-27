package com.thallyta.user.clean.architecture.user.infra.controller.user;

import java.time.LocalDate;

public record UserDTO(
        String cpf,
        String name,
        LocalDate bornDate,
        String email
) {
}
