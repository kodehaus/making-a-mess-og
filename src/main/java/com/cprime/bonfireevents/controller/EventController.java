package com.cprime.bonfireevents.controller;

import com.cprime.bonfireevents.domain.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

@RestController
public class EventController {

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable("id") int id) {
        Event event = new Event("T1", "D1");
        return event;
    }

    @PostMapping("/event")
    public ResponseEntity<Event> postEvent(@RequestBody Event event) {
        event.validate();
        return new ResponseEntity<Event>(null, null, HttpStatus.CREATED);
    }
}
