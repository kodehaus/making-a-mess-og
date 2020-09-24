package com.cprime.bonfireevents.dao.memoryimpl;

import com.cprime.bonfireevents.dao.EventDao;

import com.cprime.bonfireevents.domain.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventDaoMemoryImplTest {

    @Test
    public void testThatEventDaoMemoryImplExists() {
        EventDao dao = new EventDaoMemoryImpl();
    }

    @Test
    public void testThatEventDaoFindZeroFindsDefaultEvent() {
        EventDao eventDao = new EventDaoMemoryImpl();
        Event e = eventDao.findById(0);
        assertEquals(Event.TEST_EVENT, e);
    }

    @Test
    public void testThatEventsPutIntoDaoCanBeRetrieved() {
        EventDao eventDao = new EventDaoMemoryImpl();
        Event event = new Event("ABC", "def");
        eventDao.add(event);
        Event event2 = eventDao.findById(event.getId());
    }

}
