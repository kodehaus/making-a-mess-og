package com.cprime.bonfireevents.adapter;

import com.cprime.bonfireevents.command.PublishEventCommand;
import com.cprime.bonfireevents.dto.PublishedEventMessage;

public interface EventListingAdapter {
    void notify(PublishedEventMessage message);
}
