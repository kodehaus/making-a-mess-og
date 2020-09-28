package com.cprime.bonfireevents.domain;

import com.cprime.bonfireevents.exception.TicketTypeException;

import java.util.Date;

public class TicketType {
    private int maximumQuantity;
    private Date expiration;
    private double price;

    public TicketType() {

    }

    public TicketType(int maximumQuantity, double price, Date expiration) {
        this.maximumQuantity = maximumQuantity;
        this.expiration = expiration;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public void validate() throws TicketTypeException {
        if (price < 0) {
            throw new TicketTypeException();
        }
    }
}
