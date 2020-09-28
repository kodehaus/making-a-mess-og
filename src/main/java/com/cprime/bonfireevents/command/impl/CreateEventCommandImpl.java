package com.cprime.bonfireevents.command.impl;

import com.cprime.bonfireevents.adapter.OrganizerAdapter;
import com.cprime.bonfireevents.adapter.UserAdapter;
import com.cprime.bonfireevents.command.CreateEventCommand;
import com.cprime.bonfireevents.domain.Event;
import com.cprime.bonfireevents.domain.Organizer;
import com.cprime.bonfireevents.dto.EventPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateEventCommandImpl implements CreateEventCommand {

    @Autowired
    UserAdapter userAdapter;

    @Autowired
    OrganizerAdapter organizerAdapter;

    @Override
    public Event execute(String title, String description) {
        Event event = new Event(title, description);
        int userId = userAdapter.getUserId();
        Organizer organizer = organizerAdapter.getOrganizer(userId);
        event.addOrganizer(organizer);
        event.validate();
        return event;
    }

}
