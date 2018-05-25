package app;


import java.time.LocalDate;
import java.util.UUID;

/**
 *  The class Booking.
 */
public class Booking {
    private UUID uuid;
    private LocalDate initDate;
    private LocalDate finishDate;
    private Person person;
    private Room room;
    private boolean bookingState;

    public Booking(LocalDate initDate, LocalDate finishDate, Person person, Room room, boolean bookingState,UUID uuid) {
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.person = person;
        this.room = room;
        this.bookingState = bookingState;
        this.uuid = uuid;
    }

    /**
     *  Set the bookingState.
     */
    public boolean cancelBooking() {
        this.bookingState = false;
        return this.bookingState;
    }

}
