package app;

import java.util.UUID;

public class Passenger extends Person {
    private String originAdress;

    public Passenger(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }

    public String getOriginAdress() {
        return originAdress;
    }

    public void makeABooking() {
        //ToDo
    }

    public void consumeSomething() {
        //ToDo
    }

}
