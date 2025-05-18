package com.thallyta.user.clean.architecture.user.infra.persistence.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private LocalDate bornDate;
    private String email;

    public UserEntity() {}

    public UserEntity(Long id, String cpf, String name, LocalDate bornDate, String email) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
    }
}
