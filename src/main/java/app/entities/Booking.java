package app.entities;


import java.time.LocalDate;
import java.util.UUID;

/**
 * The class Booking.
 */
public class Booking implements Comparable {
    private UUID uuid;
    private LocalDate initDate;
    private LocalDate finishDate;
    private Passenger passenger;
    private Integer room;
    private boolean bookingState;   /// que funcion cumple???

    public Booking(LocalDate initDate, Integer days, Passenger passenger, Integer room, boolean bookingState) {
        /// no tendria que autogenerarse un UUID cuando se crea?
        this.initDate = initDate;
        this.finishDate = this.initDate.plusDays(days);
        this.passenger = passenger;
        this.room = room;
        this.bookingState = bookingState;
        this.uuid = UUID.randomUUID();  /// autogenera su  uuid
    }

    /**
     * Set the bookingState.
     */
    public boolean cancelBooking() {
        this.bookingState = false;
        return this.bookingState;
    }

    @Override
    public int compareTo(Object o) {
        Room comparator = (Room) o;
        if (this.room < comparator.getId()) {
            return -1;
        } else if (this.room > comparator.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "ID " + this.uuid + "PASSENGER: " + this.passenger.getName() + " " + this.passenger.getLastName() + " ROOM: " + this.room + " From: " + this.initDate + " TO: " + this.finishDate + " State: " + this.bookingState;
    }
}
