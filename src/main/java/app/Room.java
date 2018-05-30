package app;

import java.time.LocalDate;

/**
 * The class room.
 */
public class Room {
    private Integer id;
    private IsAvailable isAvailable;
    private boolean isOcupated;
    private LocalDate initDate;
    private LocalDate finishDate;


    /**
     * Consturct a room
     *
     * @param id          The uuid must be unique.
     * @param isAvailable Shows if the room is available.
     * @param isOcupated  Shows if the room is ocupated.
     */
    public Room(Integer id, IsAvailable isAvailable, boolean isOcupated) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.isOcupated = isOcupated;
    }

    /**
     * @param id          The uuid must be unique.
     * @param isAvailable Shows if the room is available.
     * @param isOcupated  Shows if the room is ocupated.
     * @param initDate    Init date of the ocupation.
     * @param finishDate  Finish date of the ocupation.
     */
    public Room(Integer id, IsAvailable isAvailable, boolean isOcupated, LocalDate initDate, LocalDate finishDate) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.isOcupated = isOcupated;
        this.initDate = initDate;
        this.finishDate = finishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

}
