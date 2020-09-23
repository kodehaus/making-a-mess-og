package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;

import java.util.Date;

public class Event {

    private String title;
    private String description;
    private String state;
    private Date start;
    private Date end;

    public Event() {

    }


    public Event(String title, String description) {
        this.title = title;
        this.description = description;
        state = "draft";
        validate();
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

            return state;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
        validate();
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
        validate();
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

    }

}
