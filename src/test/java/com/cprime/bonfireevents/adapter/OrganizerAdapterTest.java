package com.cprime.bonfireevents.adapter;

import com.cprime.bonfireevents.adapter.testdouble.OrganizerAdapterStub;
import com.cprime.bonfireevents.domain.Organizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrganizerAdapterTest {

    @Autowired
    @Qualifier("organizerAdapterStub")
    private OrganizerAdapter organizerAdapter;

    @BeforeEach
    public void setUp() {
        organizerAdapter = new OrganizerAdapterStub();
    }

    @Test
    public void testThatAdapterExists() {
        OrganizerAdapter adapter;
    }

    @Test
    public void testThatGetOrganizerReturnsOrganizerWhenGivenUserId() {
        Organizer o = organizerAdapter.getOrganizer(2);
        assertNotNull(o);
    }

    @Test
    public void testThatGetOrganizerWorksWithStub() {
        Organizer o = organizerAdapter.getOrganizer(2);
        assertEquals(1234, o.getId());
        assertEquals("Bob", o.getName());
    }

}
