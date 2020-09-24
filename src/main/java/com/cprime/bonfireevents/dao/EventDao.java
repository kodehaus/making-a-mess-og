package com.cprime.bonfireevents.dao;

import com.cprime.bonfireevents.domain.Event;

public interface EventDao {
    Event findById(int id);

    void add(Event event);
}
