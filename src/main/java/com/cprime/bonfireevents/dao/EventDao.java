package com.cprime.bonfireevents.dao;

import com.cprime.bonfireevents.domain.Event;

public interface EventDao {
    Event findById(long id);

    void add(Event event);
}
