package app.entities;

import app.helpers.FileHelper;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 * The class Hotel.
 */
public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private TreeMap<Integer, TreeSet<Booking>> bookings = new TreeMap<Integer, TreeSet<Booking>>();
    private TreeSet<Passenger> passengers = new TreeSet<>();
    private TreeSet<Employee> employees = new TreeSet<>();
    private TreeSet<Admin> admins = new TreeSet<>();


    public Hotel () {
        this.admins.addAll(FileHelper.getAdminsFromJson());
        this.employees.addAll(FileHelper.getEmployeesfromJson());
        this.rooms.addAll(FileHelper.getRoomsFromJson());
        this.passengers.addAll(FileHelper.getPassengersfromJson());
        this.bookings.putAll(FileHelper.getBookingsfromJson());
    }


    /**
     *  Returns the amount of rooms the hotel has.
     * @return    (Integer) Amount of rooms.
     */
    public Integer getHotelSize (){ return this.rooms.size();}

    /**
     * Returns if an integer is a valid Room Id.
     * @param i
     * @return
     */
    public boolean isValidRoomId(Integer i) {
        return i>0&&i<=getHotelSize();
    }
    /**
     *  Returns the amount of Passengers in the collection.
     * @return    (Integer) Amount of passengers.
     */
    public  Integer getPassengersSize () {return this.passengers.size();}

    /**
     * Inserts a new room into the ArrayList
     *
     * @param r Room element
     * @return Indicates if it was able to create the room or not.
     */
    public boolean addRoom(Room r) {

        if (this.rooms.add(r)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the selected room
     *
     * @param id Room id you want to get.
     * @return Selected room object or null if it doesn't exist.
     */
    public Room getRoom(Integer id) {
        Room r = null;
        id--;
        try {
            r = this.rooms.get(id);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     *  Checks if there are rooms available within 2 given dates, for a requiered amount of people.
     * @param people    (Integer) Amount of people to fit.
     * @param startDate   (LocalDate) Start date.
     * @param endDate     (LocalDate) End Date.
     * @return  ArrayList of available rooms.
     */
    public List<Room> checkAvailability (Integer people, LocalDate startDate, LocalDate endDate) {
        List<Room> rooms = new ArrayList<Room>();
        for (Room r : this.rooms){
            if (r.getCapacity()>= people && isBookeable(r.getId(), startDate, endDate)) {
                rooms.add(r);
            }
        }
        return rooms;
    }


    /**
     * Inserts a new book into the Bookings treemap.
     *
     * @param b Booking element
     * @return Indicates if it was able to create the booking or not.
     */
    public boolean addBooking(Booking b) {
        if (this.bookings.containsKey(b.getRoom())) {
            if (isBookeable(b.getRoom(), b.getInitDate(), b.getFinishDate())) {
                this.bookings.get(b.getRoom()).add(b);
                return true;
            } else {
                return false;
            }
        } else {
            TreeSet<Booking> books = new TreeSet<Booking>();
            books.add(b);
            this.bookings.put(b.getRoom(), books);
            return true;
        }
    }

    /**
     * Confirms if the selected room has bookings or not.
     *
     * @param id Room id
     * @return Indicates if the room has bookings or not.
     */
    public boolean hasBookings(Integer id) {
        if (this.bookings.containsKey(id) && !(this.bookings.get(id).isEmpty()) ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the selected room can be bookeable between 2 given dates.
     *
     * @param id        Room id
     * @param startDate Booking Start date.
     * @param endDate   Booking End date.
     * @return Indicates if the room is bookeable or not.
     */
    public boolean isBookeable(Integer id, LocalDate startDate, LocalDate endDate) {
        if (hasBookings(id)) {
            TreeSet<Booking> bAux = this.bookings.get(id);
            Iterator<Booking> it = bAux.iterator();
            while (it.hasNext()) {
                Booking b = it.next();
                if (startDate.isBefore(b.getInitDate())) {
                    if (endDate.isBefore(b.getInitDate()) || endDate.isEqual(b.getInitDate())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (startDate.isBefore(b.getFinishDate())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Returns an ArrayList with all the booking from the requested room.
     *
     * @param id Room id.
     * @return ArrayList of booking from requested room.
     */
    public List<Booking> getBookings(Integer id) {
        List<Booking> bAux = new ArrayList<Booking>();
        if (this.bookings.containsKey(id)) {
            bAux.addAll(this.bookings.get(id));
        }
        return bAux;
    }

    /**
     * Searchs all the bookings made by a requested Passenger.
     *
     * @param p requested Passenger.
     * @return Arraylist with all the bookings found
     */
    public List<Booking> findBooking(Passenger p) {
        List<Booking> books = new ArrayList<>();
        Set<Integer> k = this.bookings.keySet();
        for (Integer i : k) {
            Iterator<Booking> iterator = this.bookings.get(i).iterator();
            Booking bAux;
            while (iterator.hasNext()) {
                bAux = iterator.next();
                if (bAux.getPassenger().getDni().equals(p.getDni())) {
                    books.add(bAux);
                }
            }
        }
        return books;
    }

    /**
     * Deletes a specified booking from the bookings treemap.
     *
     * @param booking Booking to delete.
     * @return Indicates if the booking was deleted or not.
     */
    public boolean cancelBooking(Booking booking) {
        return this.bookings.get(booking.getRoom()).remove(booking);
    }


    /**
     *  Ads a Passenger to the Passengers ArrayList.
     * @param p   New Passenger to add
     * @return    Wheather the passenger was added succesfully or not.
     */
    public boolean addPassenger (Passenger p) {return this.passengers.add(p);}
    /**
     *   Searches for a specific passenger.
     * @param dni   (Integer) Passeger Dni to search.
     * @return     Passenger or null.
     */
    public Passenger getPassenger (Integer dni) {
        for (Passenger p : this.passengers){
            if (dni.equals(p.getDni()))
                return p;
        }
        return null;
    }
    /**
     *  Returns a TreeSet of all the passengers.
     * @return  TreeSet of passengers
     */
    public TreeSet<Passenger> getAllPassengers(){ return this.passengers;}

    /** Deletes a specified Passenger from the Collection.
     *
     * @param p   Passenger to delete.
     * @return   Indicates if the passenger was removed or not.
     */
    public boolean deletePassenger (Passenger p) {return this.passengers.remove(p);}

    /**
     * Do a checkIn.
     *
     * @param p    Passenger who takes the room.
     * @param room Number (id) of the room to do the check in to.
     * @param days Amount of days the passenger will stay in.
     * @return boolean
     *
     */
    public boolean checkIn(Passenger p, Integer room, Integer days) {
        room--;
        if (!(rooms.get(room).isOcupated())) {
            Room roomAux = rooms.get(room);
            roomAux.setOcupated(true);
            roomAux.setGuest(p);
            roomAux.setInitDate(LocalDate.now());
            roomAux.setFinishDate(LocalDate.now().plusDays(days));
            rooms.set(room, roomAux);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Do a checkOut.
     *
     * @param roomId Number (id) of room to checkout
     * @return double Returns the amount of intakes made by passenger
     */
    public double checkOut(Integer roomId) {
        Room roomAux = getRoom(roomId);
        getPassenger(roomAux.getGuest().getDni()).addHistory("From: "+roomAux.getInitDate()+ " TO: "+ LocalDate.now() +" ROOM: "+roomAux.getId() + " CONSUMED: $"+roomAux.getIntakes());
        double r = roomAux.getIntakes();
        roomAux.setOcupated(false);
        roomAux.setInitDate(null);
        roomAux.setFinishDate(null);
        roomAux.setGuest(null);
        roomAux.setIntakes(0);
        rooms.set(roomId, roomAux);
        return r;
    }

    public void save() {
        FileHelper.roomsToJsonFile(this.rooms);
        FileHelper.passengersToJsonFile(this.passengers);
        FileHelper.bookingsToJsonFile(this.bookings);
        FileHelper.employeesToJsonFile(this.employees);
        FileHelper.adminsToJsonFile(this.admins);
    }



}
