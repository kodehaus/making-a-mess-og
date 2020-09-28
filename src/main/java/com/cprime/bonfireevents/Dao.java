package com.cprime.bonfireevents;

public class Dao {
    public void save(Event e) {
        throw new DbTimeoutException();
    }

    public static class DbTimeoutException extends RuntimeException{

    }
}
