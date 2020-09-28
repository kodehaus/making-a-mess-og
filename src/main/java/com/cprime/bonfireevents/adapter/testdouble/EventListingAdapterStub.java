package com.cprime.bonfireevents.adapter.testdouble;

import com.cprime.bonfireevents.adapter.EventListingAdapter;
import com.cprime.bonfireevents.dto.PublishedEventMessage;
import org.springframework.stereotype.Component;

@Component
public class EventListingAdapterStub implements EventListingAdapter {

    @Override
    public void notify(PublishedEventMessage message) {
        //nuthin
    }
}
