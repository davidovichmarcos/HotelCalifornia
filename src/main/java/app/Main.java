package app;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Hotel h = new Hotel();
        Passenger p1 = new Passenger("Juan", "Adolfo", 35111333, "pepe@javie.com", "Micalle 2344, Mar del Plata.");
        Booking book1= new Booking(LocalDate.of(2018, 06, 23), 4, p1, 1, true);
        System.out.println(book1);


        h.rooms.add(new Room(1,4));
        h.checkIn( p1 , 1, 4);
        System.out.println(h.rooms.get(0));
        h.rooms.get(0).addIntake(120);
        System.out.println("Habitacion cerrada. Su Cuenta es $ "+ h.checkOut(1));
        System.out.println(h.rooms.get(0));

        //h.bookings.add(book1);

    }
}
