package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.TicketTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;


public class TicketTypeTest {

    TicketType ticketType;

    @BeforeEach
    public void setUp() {
        ticketType = new TicketType();
    }

    @Test
    public void testThatTicketTypeExists() {
        new TicketType();
    }

    @Test
    public void testThatTicketTypeHasPersistentMaximumQuantity() {
        ticketType.setMaximumQuantity(30);
        assertEquals(30, ticketType.getMaximumQuantity());
    }

    @Test
    public void testThatTicketTypeHasPersistentExpiryDate() {
        Date now = new Date();
        ticketType.setExpiration(now);
        assertEquals(now, ticketType.getExpiration());
    }

    @Test
    public void testThatTicketTypeHasPersistentPrice() {
        ticketType.setPrice(3.50);
        assertEquals(3.50, ticketType.getPrice());
    }

    @Test
    public void testThatTicketTypeFailsToValidateWithNegativePrice() {

        ticketType.setPrice(-3.50);

        assertThrows(TicketTypeException.class, () -> {
            ticketType.validate();
        });
    }

}
