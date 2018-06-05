package app;

import app.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Hotel h = new Hotel();
        Passenger p1 = new Passenger("Juan", "Adolfo", 35111333, "pepe@javie.com", "Micalle 2344, Mar del Plata.");
        Booking book1= new Booking(LocalDate.of(2018, 06, 4), 4, p1, 7);
        System.out.println(book1);
        Booking book2= new Booking(LocalDate.of(2018, 06, 29), 6, p1, 1);
        Booking book3= new Booking(LocalDate.of(2018, 06, 27), 2, p1, 15);

        System.out.println(h.createRoom(new Room(1, 4)));
        System.out.println(h.createRoom(new Room(2, 4)));
        System.out.println(h.createRoom(new Room(3, 4)));
       h.createRoom(new Room(2, 2));
        h.createRoom(new Room(3, 6));
         System.out.println(h.getRoom(1));
        System.out.println("BOOKING :"+ h.createBooking(book1));
        System.out.println("has bookings" + h.hasBookings(1));
     System.out.println("is bookeable: "+ h.isBookeable(1, LocalDate.of(2018, 04, 29), LocalDate.of(2018, 06, 30)) );
        System.out.println("BOOKING 2 : "+ h.createBooking(book2));
        System.out.println("BOOKING 3 : "+ h.createBooking(book3));

        ArrayList<Booking> b = h.getBookings(1);
        for (Booking bx : b){
            System.out.println(bx);
        }


        System.out.println("·····  FIND BOOKINGS ·····");

        ArrayList<Booking> f = h.findBooking(p1);
        for( Booking xx : f){
            System.out.println(xx);
        }

        System.out.println("·····  DELETE BOOKINGS ·····");

        System.out.println(h.cancelBooking(f.get(1)));

        f = h.findBooking(p1);
        for( Booking xy : f){
            System.out.println(xy);
        }


    }
}
