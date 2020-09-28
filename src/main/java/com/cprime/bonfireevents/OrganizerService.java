package com.cprime.bonfireevents;


public class OrganizerService {
    public Organizer getOrganizer(int i) {
        throw new CustomServiceNotFoundException();
    }

    public static class CustomServiceNotFoundException extends RuntimeException {

    }

    public static class Organizer {
        String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
