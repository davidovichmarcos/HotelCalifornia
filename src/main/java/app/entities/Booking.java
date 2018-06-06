package app.entities;


import java.time.LocalDate;
import java.util.UUID;

/**
 * The class Booking.
 */
public class Booking implements Comparable {
    private UUID uuid;
    private Integer room;
    private Passenger passenger;
    private LocalDate initDate;
    private LocalDate finishDate;

    public Booking(LocalDate initDate, Integer days, Passenger passenger, Integer room) {
        this.uuid = UUID.randomUUID();
        this.room = room;
        this.passenger = passenger;
        this.initDate = initDate;
        this.finishDate = this.initDate.plusDays(days);
    }


    public Integer getRoom() {
        return room;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public int compareTo(Object o) {
        Booking comparator = (Booking) o;
        if (this.initDate.isBefore(comparator.initDate)) {
            return -1;
        } else if (this.initDate.isAfter(comparator.initDate)) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass()) {
            return false;
        } else {
            Booking b = (Booking) o;
            if (this.getRoom() == b.getRoom() && this.initDate == b.initDate && this.finishDate == b.finishDate) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int r = Integer.hashCode(this.room);
        r = 31 * r;
        return r;
    }


    @Override
    public String toString() {
        return "ID " + this.uuid + " PASSENGER: " + this.passenger.getName() + " " + this.passenger.getLastName() + " ROOM: " + this.room + " From: " + this.initDate + " TO: " + this.finishDate;
    }
}
