package com.thallyta.user.clean.architecture.user.domain.entities.user;

import com.thallyta.user.clean.architecture.user.domain.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldNotCreateUserWithWrongCpf() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Thallyta", "123456789-99", LocalDate.parse("1990-09-08"), "email@email.com"));

        assertThrows(IllegalArgumentException.class,
                () -> new User("Thallyta", "12345678999", LocalDate.parse("1990-09-08"), "email@email.com"));

        assertThrows(IllegalArgumentException.class,
                () -> new User("Thallyta", "", LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    void shouldCreateUserWithCorrectOrder() {
        User user = new User("123.456.789-99", "Thallyta", LocalDate.parse("1990-09-08"), "email@email.com");
        assertNotNull(user);
        assertEquals("123.456.789-99", user.getCpf());
        assertEquals("Thallyta", user.getName());
    }

    @Test
    void shouldCreateUserWithValidNameCpfBorn() {
        User user = new User("654.123.897-88", "Thallyta", LocalDate.parse("1990-09-08"), "email@email.com");

        assertEquals("Thallyta", user.getName());
        assertEquals("654.123.897-88", user.getCpf());
        assertEquals(LocalDate.parse("1990-09-08"), user.getBornDate());
    }

    @Test
    void shouldCreateUserWithAddress() {
        UserBuilder builder = new UserBuilder();

        User user = builder
                .withNameCpfBorn( "654.123.897-88", "Emily", LocalDate.parse("2000-10-01"))
                .includeAddress("12345-999", 40, "apto 201")
                .build();

        assertEquals("Emily", user.getName());
        assertEquals("654.123.897-88", user.getCpf());
        assertEquals(LocalDate.parse("2000-10-01"), user.getBornDate());

        Address address = user.getAddress();
        assertNotNull(address);
        assertEquals("12345-999", address.getCep());
        assertEquals(40, address.getNumber());
        assertEquals("apto 201", address.getComplement());
    }
}
