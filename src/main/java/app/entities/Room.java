package app.entities;

import java.time.LocalDate;

/**
 * The class room.
 */
public class Room {
    private Integer id;
    private Integer capacity;
    private RoomType roomType;
    private IsAvailable isAvailable;
    private boolean isOcupated;
    private LocalDate initDate;
    private LocalDate finishDate;
    private Passenger guest;
    private double intakes;


    /**
     * Room Constructor 001
     *
     * @param id       The uuid must be unique.
     * @param capacity Cuantity of passangers this room can fit.
     */
    public Room(Integer id, Integer capacity, RoomType roomType) {
        this.id = id;
        this.capacity = capacity;
        this.roomType = roomType;
        this.isAvailable = isAvailable.AVAILABLE;
        this.isOcupated = false;
        this.initDate = null;
        this.finishDate = null;
        this.guest = null;
        this.intakes = 0;
    }

    //// -----  GETTERS & SETTERS -------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomType getRoomType() { return roomType; }

    public void setRoomType(RoomType roomType) { this.roomType = roomType;}

    public IsAvailable isAvailable() {
        return isAvailable;
    }

    public void setAvailable(IsAvailable available) {
        isAvailable = available;
    }

    public boolean isOcupated() {
        return isOcupated;
    }

    public void setOcupated(boolean ocupated) {
        isOcupated = ocupated;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Passenger getGuest() {
        return guest;
    }

    public void setGuest(Passenger guest) {
        this.guest = guest;
    }

    public double getIntakes() {
        return intakes;
    }

    public void setIntakes(double intakes) {
        this.intakes = intakes;
    }

    //// -----  FINISH GETTERS & SETTERS -------


    ////  ----  METHODS -----

    public void addIntake(double value) {
        this.intakes += value;
    }

    @Override
    public String toString() {
        if (this.isOcupated) {
            return "Room: " + this.getId() + "\nCapacity: " + this.getCapacity() + "\n" + this.roomType + "\n"+this.isAvailable.getReason()+ "\nOcuppied: " + this.isOcupated() + "\nGuest: " + this.getGuest().getName() +this.getGuest().getLastName() + "\nFrom: " + this.getInitDate() + "\nTo : " + this.getFinishDate();
        } else {
            return "Room: " + this.getId() + "\nCapacity: " + this.getCapacity() + "\n"+this.roomType +"\n "+this.isAvailable.getReason()+  "\nOcuppied: " + this.isOcupated();
        }
    }
}
