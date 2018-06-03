package app.entities;

import app.User;
import app.UserImplementation;

import java.time.LocalDate;

/**
 * The class Passenger.
 * Add visit history.
 */
public class Passenger extends Person implements User, Comparable {
    private String originAddress;


    public Passenger(String name, String lastName, Integer dni, String email, String address) {
        super(name, lastName, dni, email);
        this.originAddress = address;
    }

    public String getOriginAdress() {
        return originAddress;
    }

    /**
     * Saves a booking in the hotel.
     */
    public void makeABooking(LocalDate initDate, LocalDate finishDate, Integer roomId) {
        boolean available = Hotel.isRoomAvailable(initDate, finishDate, roomId);
        //if its available makes a booking ,if not show a message.
        //ToDo
    }

    /**
     * Charges an extra for the receipt.
     */
    public void consumeSomething() {
        //ToDo
    }

    @Override
    public boolean signIn(UserImplementation userImplementation) {
        return false;
    }

    @Override
    public boolean signOut() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Passenger comparator = (Passenger) o;
        if (this.getDni() < comparator.getDni()) {
            return -1;
        } else if (this.getDni() > comparator.getDni()) {
            return 1;
        } else {
            return 0;
        }
    }
}
