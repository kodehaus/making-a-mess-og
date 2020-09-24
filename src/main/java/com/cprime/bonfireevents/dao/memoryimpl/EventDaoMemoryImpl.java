package com.cprime.bonfireevents.dao.memoryimpl;

import com.cprime.bonfireevents.dao.EventDao;
import com.cprime.bonfireevents.domain.Event;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class EventDaoMemoryImpl implements EventDao {
    Map<Long, Event> events = new HashMap<>();

    public EventDaoMemoryImpl() {
        events.put(0L, Event.TEST_EVENT);
    }

    @Override
    public Event findById(long id) {
        return events.get(id);
    }

    @Override
    public void add(Event event) {
        events.put(event.getId(), event);
    }


}
