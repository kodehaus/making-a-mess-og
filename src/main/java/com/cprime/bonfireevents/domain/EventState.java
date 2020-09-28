package com.cprime.bonfireevents.domain;

public enum EventState {
    DRAFT, PUBLISHED;

    public String toString() {
        return name().toLowerCase();
    }
}
