package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.EventException;

import java.util.Date;

public class Event {

    private String title;
    private String description;
    private String state;
    private Date start;

    public Event(String title, String description) {
        if( title == null || title.equals("") || description == null || description.equals("") ) {
            throw new EventException();
        }

        this.title = title;
        this.description = description;
        state = "draft";


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
    }


}
