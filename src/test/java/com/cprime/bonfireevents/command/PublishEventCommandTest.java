package com.cprime.bonfireevents.command;

import com.cprime.bonfireevents.adapter.EventListingAdapter;
import com.cprime.bonfireevents.command.impl.PublishEventCommandImpl;
import com.cprime.bonfireevents.domain.Event;
import com.cprime.bonfireevents.domain.EventState;
import com.cprime.bonfireevents.domain.Organizer;
import com.cprime.bonfireevents.domain.TicketType;
import com.cprime.bonfireevents.utility.TestUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PublishEventCommandTest {

    @Mock
    EventListingAdapter eventListingAdapter;

    @InjectMocks
    PublishEventCommand publishEventCommand = new PublishEventCommandImpl();


    private Event event;
    private Organizer host;
    TicketType ticketType;


    @BeforeEach
    void setUp() {


        event = new Event ("A title", "A description");
        event.setStart(TestUtility.NEXT_DAY);
        event.setEnd(TestUtility.THIRD_DAY);
        event.setCapacity(30);
        host = new Organizer(1234, "Bob");
        event.addOrganizer(host);
        ticketType = new TicketType(20, 3.50, TestUtility.TOMORROW);
        event.addTicketType(ticketType);

        doNothing().when(eventListingAdapter).notify(any());
    }


    @AfterEach
    void tearDown() {
        reset(eventListingAdapter);
    }


    @Test
    public void testThatExecutePublishesEvent() {
        publishEventCommand.execute(event);

        assertEquals(EventState.PUBLISHED.toString(), event.getState());
    }

    @Test
    public void testThatExecuteNotifiesEventListingAdapter() {
        publishEventCommand.execute(event);
        verify(eventListingAdapter).notify(any());
    }
}
