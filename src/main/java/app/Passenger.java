package app;

import java.util.UUID;

/**
 *  The class Passenger.
 */
public class Passenger extends Person {
    private String originAdress;

    public Passenger(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }

    public String getOriginAdress() {
        return originAdress;
    }

    /**
     *  Saves a booking in the hotel.
     */
    public void makeABooking() {
        //ToDo
    }

    /**
     *  Charges an extra for the receipt.
     */
    public void consumeSomething() {
        //ToDo
    }

}
