package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class EventTest {

    static final Date tomorrow = GET_NOW_PLUS_DAYS(1);
    static final Date nextNextDay = GET_NOW_PLUS_DAYS(2);
    static final Date thirdDay = GET_NOW_PLUS_DAYS(3);

    public static Date GET_NOW_PLUS_DAYS(int howManyDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, howManyDays); // number represents number of days
        Date yesterday = cal.getTime();
        return yesterday;
    }

    private Organizer otherHost;
    private Event event;
    private Organizer host;
    TicketType ticketType;

    @BeforeEach
    void setUp() {
        otherHost = new Organizer(5678, "Stephen");
        event = new Event ("A title", "A description");
        host = new Organizer(1234, "John");
        ticketType = new TicketType(20, 3.50, tomorrow);
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
        EventState expectedState = EventState.DRAFT;
        assertEquals(expectedState.toString(), event.getState() );
    }




    // S1-3 Event can have starting and ending dates and times.
    @Test
    public void testThatCanSetStartandEndDate() {
        //ARRANGE
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
            Date yesterday= GET_NOW_PLUS_DAYS(-1);
            event.setStart(yesterday);
            event.validate();
        });

    }


    // S1-4 Start date must be earlier than the end date.
    @Test
    public void testThatEndDateBeforeStartDateThrowsException() {

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
        assertEquals(EventState.DRAFT.toString(), event.getState());
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

    @Test
    public void testThatEventStartsWithCapacityZero() {
        //Arrange

        //Act

        //Assert
        assertEquals(0, event.getCapacity());

    }

    @Test
    public void testThatCapacityPersistsWhenSet() {
        //Arrange

        //Act
        event.setCapacity(20);
        //Assert
        assertEquals(20, event.getCapacity());

    }

    @Test
    public void testThatCantSetNegativeCapacity() {
        //Arrange
        //Act
        //Assert
        assertThrows(EventException.class, () -> {
            event.setCapacity(-2);
        });
    }

    @Test
    public void testThatGetTicketTypesIsEmptyToBeginWith() {
        List<TicketType> ticketTypeList = event.getTicketTypes();
        assertEquals(0, ticketTypeList.size());
    }



    @Test
    public void testThatAddTicketTypeWorks() {
        event.setStart(nextNextDay);
        event.setCapacity(30);
        event.addTicketType(ticketType);
        assertEquals(1, event.getTicketTypes().size());
        assertEquals(ticketType, event.getTicketTypes().get(0));
    }

    @Test
    public void testThatGetTicketTypeReturnsImmutable() {
        assertThrows(Exception.class, () -> {
            event.getTicketTypes().add(new TicketType());
        });
    }

    @Test
    public void testThatGetOrganizersReturnsImmutable() {
        assertThrows(Exception.class, () -> {
            event.getOrganizers().add(host);
        });
    }

    @Test
    public void testThatAddTicketTypeFailsIfExpirationIsAfterEventStartDate() {
        //Arrange
        event.setStart(tomorrow);
        event.setEnd(nextNextDay);
        TicketType type2 = new TicketType(20, 3.50, thirdDay);

        //Act+Assert
        assertThrows(Exception.class, () -> {
            event.addTicketType(type2);
        });
    }

    @Test
    public void testThatAddTicketTypeFailsIfTicketAmountMoreThanCapacity() {
        //Arrange
        event.setCapacity(10);
        event.setStart(nextNextDay);
        event.setEnd(thirdDay);
        TicketType type2 = new TicketType(20, 3.50, tomorrow);

        //Act+Assert
        assertThrows(Exception.class, () -> {
            event.addTicketType(type2);
        });
    }

    @Test
    public void testThatTicketsArentAvailableAfterExpiration() {
        //Arrange
        event.setCapacity(30);
        event.setStart(nextNextDay);
        event.setEnd(thirdDay);
        TicketType type2 = new TicketType(20, 3.50, GET_NOW_PLUS_DAYS(-1));
        event.addTicketType(type2);
        //Act+Assert
        assertEquals(0, event.getTicketTypes().size());
    }

}
