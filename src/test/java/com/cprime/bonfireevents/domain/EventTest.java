package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EventTest {

    // S1-1: New events require a title and description.
    @Test
    public void testThatNewEventsCanBeCreatedWithTitleAndDescription() {
        Event event = new Event("A title", "A description");
        assertEquals("A title", event.getTitle());
        assertEquals("A description", event.getDescription());
    }

    @Test
    public void testThatNewEventTitleAndDescriptionNotBlank() {
        assertThrows(EventException.class, () -> {
            new Event("", "");
        });
    }
    @Test
    public void testThatNewEventTitleAndDescriptionNotNull() {
        assertThrows(EventException.class, () -> {
            new Event( null, null);
        });
    }
}
