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
    Has
    TreeSet<Booking> bookings = new TreeSet<>();
    // booking no puede ser tree set. porque 1 room puede tener muchos bookings diferentes, hay que comprobar via metodo que esa room este disponible en el lapso de dias pedidos. Tendrian que estar ordenadas segun el id de la room y comprobado via codigo que no se pisen... seria un HASHMAP?
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
     * @param p Passenger who takes the room.
     * @param room Number (id) of the room to do the check in to.
     * @param days Amount of days the passenger will stay in.
     */
    public void checkIn(Passenger p, Integer room, Integer days) {
        // check if the room is reservated.
        room --;
        if (!(rooms.get(room).isOcupated())) {
            Room roomAux = rooms.get(room);
            roomAux.setOcupated(true);
            roomAux.setGuest(p);
            roomAux.setInitDate(LocalDate.now());
            roomAux.setFinishDate(LocalDate.now().plusDays(days));
            rooms.set(room, roomAux);
        } else {
            System.out.println("HABITACION OCUPADA.");
        }
    }

    /**
     * Do a checkOut.
     * @param room Number (id) of room to checkout
     * @return double Returns the amount of intakes made by passenger
     */
    public double checkOut(Integer room) {
        room --;
        Room roomAux = rooms.get(room);
        double r=roomAux.getIntakes();
        roomAux.setOcupated(false);
        roomAux.setInitDate(null);
        roomAux.setFinishDate(null);
        roomAux.setGuest(null);
        roomAux.setIntakes(0);
        rooms.set(room, roomAux);
        return r;
    }

}
