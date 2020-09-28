package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Event {


    private int id;
    private String title;
    private String description;
    private EventState state;
    private Date start;
    private Date end;
    private List<Organizer> organizers;
    private int capacity;

    public static final Event TEST_EVENT = new Event(0,"TEST", "Test");

    public Event() {
        state = EventState.DRAFT;
        generateId();
        organizers = new ArrayList<>();
    }

    public Event(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }

    private Event(int id, String title, String description) {
        this.id=id;
        this.title = title;
        this.description = description;
        state = EventState.DRAFT;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState (){
        return state.toString();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public void addOrganizer(Organizer organizer) {
        if (organizers.contains(organizer)) {
            throw new EventException();
        }
        organizers.add(organizer);
    }

    public void removeOrganizer(Organizer organizer) {
        if (organizers.size() == 1 && organizers.contains(organizer)) {
            throw new EventException();
        }
        organizers.remove(organizer);
    }


    public void validate() throws EventException {
        if( title == null || title.equals("") || description == null || description.equals("") ) {
            throw new EventException();
        }
        Date now = new Date();
        if (start != null) {
            if(start.before(now)) {
                throw new EventException();
            }
            if (end != null && end.before(start)) {
                throw new EventException();
            }

        }
        if(organizers==null || organizers.size()==0){
            throw new EventException();
        }
    }

    private void generateId() {
        Random random = new Random();
        id = random.nextInt(Integer.MAX_VALUE) ;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) {
        if (cap > 0) {
            capacity = cap;
        } else {
            throw new EventException();
        }
    }
}
