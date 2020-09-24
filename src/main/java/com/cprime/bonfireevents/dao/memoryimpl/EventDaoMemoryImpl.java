package com.cprime.bonfireevents.dao.memoryimpl;

import com.cprime.bonfireevents.dao.EventDao;
import com.cprime.bonfireevents.domain.Event;

import java.util.HashMap;
import java.util.Map;

public class EventDaoMemoryImpl implements EventDao {
    Map<Integer, Event> events = new HashMap<>();

    public EventDaoMemoryImpl() {
        events.put(0, Event.TEST_EVENT);
    }

    @Override
    public Event findById(int id) {
        return events.get(id);
    }
}
