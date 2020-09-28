package com.cprime.bonfireevents;

import java.util.Date;

public class Event {

    public String title;
    public String description;
    public Date starts;
    public Date ends;
    public String state;
    public int capacity;
    public Tickets tickets;
    public double potentialRevenue;
    public String Organizer;


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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public double getPotentialRevenue() {
        return potentialRevenue;
    }

    public void setPotentialRevenue(double potentialRevenue) {
        this.potentialRevenue = potentialRevenue;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
    }
}
