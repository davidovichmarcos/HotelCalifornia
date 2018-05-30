package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * The class Hotel.
 */
public class Hotel {
    ArrayList<Room> rooms = new ArrayList<Room>();
    TreeSet<Booking> bookings = new TreeSet<>();
    TreeSet<Employee> employees = new TreeSet<>();
    TreeSet<Passenger> passengers = new TreeSet<>();


    /**
     * Get Roooms from the file.
     */
    public void getRooms() {

    }

    /**
     * Get the treeset of Passengers from the file.
     */
    public void getPassengers() {

    }

    /**
     * Get the treeset of epmloyees from the file.
     */
    public void getEmployees() {

    }

    /**
     * @param initDate
     * @param finishDate
     * @param roomId
     * @return
     */
    public static boolean isRoomAvailable(LocalDate initDate, LocalDate finishDate, Integer roomId) {
        return false;
    }

    /**
     * Do a checkIn.
     */
    public void checkIn(Passenger passenger, Room room, Integer days) {
        // check if the room is reservated.
        // check if the room is ocupated.
        //ToDo
    }

    /**
     * Do a checkOut.
     */
    public void checkOut(Room room) {
        Room roomAux = rooms.get(room.getId() - 1);
        roomAux.setOcupated(false);
        roomAux.setInitDate(null);
        roomAux.setFinishDate(null);
        rooms.set(room.getId() - 1, roomAux);
    }

}
