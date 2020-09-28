package com.cprime.bonfireevents.command;

import com.cprime.bonfireevents.domain.Event;

public interface CreateEventCommand {
    Event execute(String title, String description);
}
