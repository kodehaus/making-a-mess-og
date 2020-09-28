package com.cprime.bonfireevents.dto;

import java.util.Date;

public class PublishedEventMessage {

    int id;
    String title;
    String description;
    Date starts;
    Date ends;

    public PublishedEventMessage(int id, String title, String description, Date starts, Date ends) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.starts = starts;
        this.ends = ends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getStarts() {
        return starts;
    }

    public void setStarts(Date starts) {
        this.starts = starts;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }
}
