package com.cprime.bonfireevents.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganizerTest {

    @Test
    public void testThatOrganizerExists() {
        Organizer organizer;

    }
    @Test
    public void testThatOrganizerTakesIdAndName() {
        Organizer organizer = new Organizer(1234, "John");
        assertEquals(1234, organizer.getId());
        assertEquals("John", organizer.getName());

    }
}
