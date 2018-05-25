package app;

/**
 * The class room.
 */
public class Room {
    private Integer id;
    private IsAvailable isAvailable;
    private boolean isOcupated;

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

    public Integer getUuid() {
        return id;
    }

    public void setUuid(Integer uuid) {
        this.id = uuid;
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

}
