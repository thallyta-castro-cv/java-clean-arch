package com.thallyta.user.clean.architecture.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String cep;
    private Integer number;
    private String complement;

    public Address(String cep, Integer number, String complement) {
        this.cep = cep;
        this.number = number;
        this.complement = complement;
    }
}
