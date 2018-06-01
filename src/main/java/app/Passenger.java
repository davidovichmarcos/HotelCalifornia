package app;

import java.time.LocalDate;
import java.util.UUID;

/**
 * The class Passenger.
 * Add visit history.
 */
public class Passenger extends Person {
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

}
