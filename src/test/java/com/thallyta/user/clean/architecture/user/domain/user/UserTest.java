package com.thallyta.user.clean.architecture.user.domain.user;

import com.thallyta.user.clean.architecture.user.domain.address.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
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
