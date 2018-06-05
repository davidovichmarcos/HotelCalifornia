package app.entities;

import java.time.LocalDate;
import java.util.*;

/**
 * The class Hotel.
 */
public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private TreeMap < Integer, TreeSet<Booking> > bookings = new TreeMap< Integer, TreeSet<Booking>>();
    private TreeSet<Employee> employees = new TreeSet<>();
    private TreeSet<Passenger> passengers = new TreeSet<>();


    /**
     * Inserts a new room into the ArrayList
     * @param r Room element
     * @return  Indicates if it was able to create the room or not.
     */
    public boolean createRoom (Room r) {

            if(this.rooms.add(r)){
                return true;
            }else  {
                return false;
            }
    }

    /**
     * Returns the selected room
     * @param id Room id you want to get.
     * @return Selected room object or null if it doesn't exist.
     */
    public Room getRoom(Integer id) {
        Room r = null;
        id--;
        try {
            r = this.rooms.get(id);
        }catch (IndexOutOfBoundsException e){
        }
        return r;
    }

    /**
     * Inserts a new book into the Bookings treemap.
     * @param b Booking element
     * @return   Indicates if it was able to create the booking or not.
     */
    public boolean createBooking (Booking b){
        if(this.bookings.containsKey(b.getRoom())){
            if (isBookeable(b.getRoom(), b.getInitDate(), b.getFinishDate())) {
                this.bookings.get(b.getRoom()).add(b);
            }

        } else {
            TreeSet<Booking> books = new TreeSet<Booking>();
            books.add(b);
            this.bookings.put(b.getRoom(), books);
        }
        return this.bookings.get(b.getRoom()).contains(b);
    }

    /**
     *  Confirms if the selected room has bookings or not.
     * @param id  Room id
     * @return  Indicates if the room has bookings or not.
     */
    public boolean  hasBookings (Integer id){
        if (this.bookings.containsKey(id)) {
            if (!(this.bookings.get(id).isEmpty())) {
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     *  Checks if the selected room can be bookeable between 2 given dates.
     *
     * @param id  Room id
     * @param startDate  Booking Start date.
     * @param endDate    Booking End date.
     * @return           Indicates if the room is bookeable or not.
     */
    public boolean isBookeable (Integer id, LocalDate startDate, LocalDate endDate){
        if (hasBookings(id)) {
            TreeSet <Booking> bAux = this.bookings.get(id);
            Iterator<Booking> it = bAux.iterator();
            while(it.hasNext()) {
                Booking b = it.next();
                if (startDate.isBefore(b.getInitDate())) {
                    if (endDate.isBefore(b.getInitDate()) || endDate.isEqual(b.getInitDate())){
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if(startDate.isBefore(b.getFinishDate())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Returns an ArrayList with all the booking from the requested room.
     * @param id    Room id.
     * @return      ArrayList of booking from requested room.
     */
    public ArrayList<Booking> getBookings(Integer id){
        ArrayList<Booking> bAux= new ArrayList<Booking>();
        if(this.bookings.containsKey(id)){
            bAux.addAll(this.bookings.get(id));
        }
        return bAux;
    }

    /**
     *  Searchs all the bookings made by a requested Passenger.
     * @param p   requested Passenger.
     * @return    Arraylist with all the bookings found
     */
    public ArrayList<Booking> findBooking (Passenger p) {
        ArrayList<Booking> books = new ArrayList<>();
        Set<Integer> k = this.bookings.keySet();
        for (Integer i : k) {
            Iterator<Booking> iterator = this.bookings.get(i).iterator();
            Booking bAux;
            while (iterator.hasNext()){
                bAux= iterator.next();
                if (bAux.getPassenger().equals(p)) {
                    books.add(bAux);
                }
            }
        }
        return books;
    }


    /**
     *  Deletes a specified booking from the bookings treemap.
     * @param booking   Booking to delete.
     * @return          Indicates if the booking was deleted or not.
     */
    public boolean cancelBooking(Booking booking){
        return this.bookings.get(booking.getRoom()).remove(booking);
    }




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
