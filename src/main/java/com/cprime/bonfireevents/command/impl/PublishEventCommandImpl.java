package com.cprime.bonfireevents.command.impl;

import com.cprime.bonfireevents.adapter.EventListingAdapter;
import com.cprime.bonfireevents.command.PublishEventCommand;
import com.cprime.bonfireevents.domain.Event;
import com.cprime.bonfireevents.dto.PublishedEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PublishEventCommandImpl implements PublishEventCommand {

    @Autowired
    EventListingAdapter eventListingAdapter;

    @Override
    public void execute(Event event) {
        event.publish(new Date());

        eventListingAdapter.notify(
                new PublishedEventMessage(event.getId(), event.getTitle(), event.getDescription(),
                        event.getStart(), event.getEnd()));
    }
}
