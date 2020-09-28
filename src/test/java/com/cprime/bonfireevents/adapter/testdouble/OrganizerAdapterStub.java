package com.cprime.bonfireevents.adapter.testdouble;

import com.cprime.bonfireevents.adapter.OrganizerAdapter;
import com.cprime.bonfireevents.domain.Organizer;
import org.springframework.stereotype.Service;


@Service("organizerAdapterStub")
public class OrganizerAdapterStub implements OrganizerAdapter {
    @Override
    public Organizer getOrganizer(int i) {
        return new Organizer(1234, "Bob");
    }
}
