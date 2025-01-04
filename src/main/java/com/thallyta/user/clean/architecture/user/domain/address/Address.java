package com.thallyta.user.clean.architecture.user.domain.address;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    private String cep;
    private Integer number;
    private String complement;

    public Address(){}

    public Address(String cep, Integer number, String complement) {
        this.cep = cep;
        this.number = number;
        this.complement = complement;
    }
}
