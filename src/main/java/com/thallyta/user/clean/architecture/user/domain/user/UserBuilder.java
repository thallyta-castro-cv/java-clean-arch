package com.thallyta.user.clean.architecture.user.domain.user;

import com.thallyta.user.clean.architecture.user.domain.address.Address;

import java.time.LocalDate;

public class UserBuilder {

    private String cpf;
    private String name;
    private LocalDate born;
    private Address address;


    public UserBuilder withNameCpfBorn(String cpf, String name, LocalDate born) {
        this.cpf = cpf;
        this.name = name;
        this.born = born;
        return this;
    }

    public UserBuilder includeAddress(String cep, Integer number, String complement) {
        this.address = new Address(cep, number, complement);
        return this;
    }

    public User build() {
        User user = new User(cpf, name, born, "");
        user.setAddress(address);
        return user;
    }
}
