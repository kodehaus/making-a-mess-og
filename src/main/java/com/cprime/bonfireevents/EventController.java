package com.cprime.bonfireevents;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class EventController {

    @PostMapping("/event")
    public ResponseEntity<String> postEvent(@RequestBody Event e) {

        OrganizerService.Organizer o = new OrganizerService().getOrganizer( new UserService().getUserId());

        if (e.title == null) { throw new EventException(); }
        if (e.description == null) { throw new EventException(); }

        e.setOrganizer( o.getName() );

        if (e.starts.after(e.ends)) { throw new EventException(); }

        if (e.state.equals("published")) {
            if (e.starts.before(new Date())) { throw new EventException(); }
            if (e.capacity <= 0){ throw new EventException(); }
            if (e.tickets.capacity != e.capacity ) { throw new EventException(); }

            double r = calc(e);
            e.potentialRevenue= r;

            new EventListingManager().notify(e);
        }

        new Dao().save(e);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private double calc(Event e) {
        return e.tickets.capacity * e.tickets.cost;
    }



}
