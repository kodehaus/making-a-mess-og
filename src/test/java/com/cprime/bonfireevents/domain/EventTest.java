package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class EventTest {

    private Organizer otherHost;
    private Event event;
    private Organizer host;

    @BeforeEach
    void setUp() {
        otherHost = new Organizer(5678, "Stephen");
        event = new Event ("A title", "A description");
        host = new Organizer(1234, "John");
    }

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
            new Event("", "").validate();
        });
    }
    @Test
    public void testThatNewEventTitleAndDescriptionNotNull() {
        assertThrows(EventException.class, () -> {
            new Event( null, null).validate();
        });
    }

    // S1-7: When initially created, the event state is "draft" and is not "publicized."

    @Test
    public void testThatWhenEventCreatedStateIsDraft() {
        String expectedState = "draft";
        assertEquals(expectedState, event.getState() );
    }


    public Date UTILITY_METHOD_getNowPlusSomeDays(int howManyDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, howManyDays); // number represents number of days
        Date yesterday = cal.getTime();
        return yesterday;
    }

    // S1-3 Event can have starting and ending dates and times.
    @Test
    public void testThatCanSetStartandEndDate() {
        //ARRANGE
        Date tomorrow= UTILITY_METHOD_getNowPlusSomeDays(1);
        //ACT
        event.setStart(tomorrow);
        event.setEnd(tomorrow);
        //ASSERT
        assertEquals( tomorrow, event.getStart());
        assertEquals( tomorrow, event.getEnd());
    }
// S1-5 The event start date must be in the future.
    @Test
    public void testThatStartDateIsInTheFuture(){
        assertThrows(EventException.class, () -> {
            Date yesterday= UTILITY_METHOD_getNowPlusSomeDays(-1);
            event.setStart(yesterday);
            event.validate();
        });

    }


    // S1-4 Start date must be earlier than the end date.
    @Test
    public void testThatEndDateBeforeStartDateThrowsException() {

        Date tomorrow = UTILITY_METHOD_getNowPlusSomeDays(1);
        Date nextNextDay = UTILITY_METHOD_getNowPlusSomeDays(2);
        assertThrows(EventException.class, () -> {
            event.setStart(nextNextDay);
            event.setEnd(tomorrow);
            event.validate();
        });

    }

    @Test
    public void testThatEventIdExists() {
        assertTrue (event.getId() > 0);
    }

    @Test
    public void testThatDefaultEventExists() {
        Event event = Event.TEST_EVENT;
        assertEquals(0L, event.getId());
        assertEquals("TEST", event.getTitle());
        assertEquals("Test", event.getDescription());
        assertEquals("draft", event.getState());
    }
    @Test
    public void testThatEventCanHaveOrganizer(){
     //Arrange

     //Act
        event.addOrganizer(host);
     //Assert
        Assertions.assertTrue(event.getOrganizers().contains(host));

    }

    @Test
    public void testThatEventCanHaveMultipleOrganizers(){
        //Arrange


        //Act
        event.addOrganizer(host);
        event.addOrganizer(otherHost);

        //Assert
        Assertions.assertTrue(event.getOrganizers().contains(host));
        Assertions.assertTrue(event.getOrganizers().contains(otherHost));



    }
    @Test
    public void testThatEventMustHaveOneOrganizerThrowsException() {

        assertThrows(EventException.class, () -> {
            event.validate();
        });

    }

    @Test
    public void testThatEventMustNotHaveDuplicateOrganizers() {
        //Arrange

        //Act
        event.addOrganizer(host);

        //Assert
        assertThrows(EventException.class, () -> {
            event.addOrganizer(host);
        });

    }

    @Test
    public void testThatRemoveTakesOrganizersOffEvent() {
        //Arrange
        event.addOrganizer(host);
        event.addOrganizer(otherHost);
        //Act
        event.removeOrganizer(otherHost);
        //Assert
        Assertions.assertTrue(event.getOrganizers().contains(host));
        Assertions.assertFalse(event.getOrganizers().contains(otherHost));
    }

    @Test
    public void testThatRemoveCannotRemoveLastOrganizer() {
        //Arrange

        //Act
        event.addOrganizer(host);

        //Assert
        assertThrows(EventException.class, () -> {
            event.removeOrganizer(host);
        });

    }
}
