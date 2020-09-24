package com.cprime.bonfireevents.controller;

import com.cprime.bonfireevents.dao.EventDao;
import com.cprime.bonfireevents.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class EventController {
@Autowired
    EventDao dao;

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable("id") int id) {
        Event event = dao.findById(id);

        return event;
    }

    @PostMapping("/event")
    public ResponseEntity<Event> postEvent(@RequestBody Event event) {
        event.validate();
        dao.add(event);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/event/"+event.getId());
        return new ResponseEntity<Event>(event, headers, HttpStatus.CREATED);
    }
}
