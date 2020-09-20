package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;
import org.junit.jupiter.api.Test;

import java.util.Date;

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

    // S1-7: When initially created, the event state is "draft" and is not "publicized."

    @Test
    public void testThatWhenEventCreatedStateIsDraft() {
        Event event = new Event("A title", "A description");
        String expectedState = "draft";
        assertEquals(expectedState, event.getState() );
    }

    // S1-3 Event can have starting and ending dates and times.
    @Test
    public void testThatCanSetStartandEndonDate() {
        Event event = new Event("A title", "A description");
        Date expectedDate = new Date();
        event.setStart(expectedDate);
        assertEquals( expectedDate, event.getStart());
    }


}
