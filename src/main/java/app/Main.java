package app;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Hotel h = new Hotel();
        h.rooms.add(new Room(1,4));
        h.checkIn(new Passenger("Juan", "Adolfo", 35111333, "pepe@javie.com", "Micalle 2344, Mar del Plata."), 1, 4);
        System.out.println(h.rooms.get(0));
        h.rooms.get(0).addIntake(120);
        System.out.println("Habitacion cerrada. Su Cuenta es $ "+ h.checkOut(1));
        System.out.println(h.rooms.get(0));


    }
}
