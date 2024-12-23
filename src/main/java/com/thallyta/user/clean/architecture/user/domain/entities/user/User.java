package com.thallyta.user.clean.architecture.user.domain.entities.user;

import com.thallyta.user.clean.architecture.user.domain.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private String cpf;
    private String name;
    private LocalDate bornDate;
    private String email;
    private Address address;

    public User(String cpf, String name, LocalDate bornDate, String email) {



        this.cpf = cpf;
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
    }
}
