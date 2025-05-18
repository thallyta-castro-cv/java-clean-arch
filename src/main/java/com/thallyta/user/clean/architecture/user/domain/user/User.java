package com.thallyta.user.clean.architecture.user.domain.user;

import com.thallyta.user.clean.architecture.user.domain.address.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private Long id;
    private String cpf;
    private String name;
    private LocalDate bornDate;
    private String email;
    private Address address;

    public User(Long id, String cpf, String name, LocalDate bornDate, String email) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
    }

    public User(Long id){
        this.id = id;
    }

    public User(String name, String cpf, LocalDate bornDate, String email) {
        this.name = name;
        this.cpf = cpf;
        this.bornDate = bornDate;
        this.email = email;
    }
}
