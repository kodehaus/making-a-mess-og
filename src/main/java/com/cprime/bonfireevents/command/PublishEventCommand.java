package com.cprime.bonfireevents.command;

import com.cprime.bonfireevents.domain.Event;

public interface PublishEventCommand {
    void execute(Event event);
}
