package app;

import java.util.UUID;

/**
 * The class room.
 */
public class Room {
    private UUID uuid;
    private boolean isAvailable;
    private boolean isOcupated;

    /**
     * Consturct a room
     *
     * @param uuid        The uuid must be unique.
     * @param isAvailable Shows if the room is available.
     * @param isOcupated  Shows if the room is ocupated.
     */
    public Room(UUID uuid, boolean isAvailable, boolean isOcupated) {
        this.uuid = uuid;
        this.isAvailable = isAvailable;
        this.isOcupated = isOcupated;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isOcupated() {
        return isOcupated;
    }

    public void setOcupated(boolean ocupated) {
        isOcupated = ocupated;
    }

}
