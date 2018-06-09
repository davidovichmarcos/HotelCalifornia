package app;

import app.entities.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Hotel h = new Hotel();
        System.out.println(h.getHotelSize());
        System.out.println(h.getPassengersSize());
        System.out.println(h.getRoom(6));
        h.checkOut(6);
        System.out.println(h.getPassenger(66666666).getHistory());



        /*   h.checkIn(h.getPassenger(88999000),12, 7 );
        h.checkIn(h.getPassenger(99000111),5, 7 );
        h.checkIn(h.getPassenger(66777888),3, 10 );
        h.checkIn(h.getPassenger(66666666),6, 6 );




        for(int i = 0; i<h.getHotelSize(); i++){
            System.out.println(h.getRoom(i+1));
        }

        Set<Passenger> mySet = h.getAllPassengers();
        for  (Passenger p : mySet){
            System.out.println(p);
        }

     /*   System.out.println(h.addBooking( new Booking(LocalDate.of(2018,06,20), 4, h.getPassenger(10111222), 2)) );
        System.out.println(h.addBooking( new Booking(LocalDate.of(2018,06,26), 3, h.getPassenger(22333444), 2)) );
        System.out.println(h.addBooking( new Booking(LocalDate.of(2018,06,28), 4, h.getPassenger(10111222), 3)) );
        System.out.println(h.addBooking( new Booking(LocalDate.of(2018,06,29), 4, h.getPassenger(10111222), 4)) );
        System.out.println(h.addBooking( new Booking(LocalDate.of(2018,06,24), 4, h.getPassenger(10111222), 1)) );
       */

        /*   for(int i = 0; i<20; i++){
            h.createRoom(new Room((i+1), (random.nextInt(4)+1)*2, RoomType.MATRIMONIAL));
            h.createRoom(new Room((i+2), (random.nextInt(4)+1)*2, RoomType.SINGLE));
            i++;
        }

     /*   System.out.println("············  AVAILABILITY  ·············");
        List<Room> rhelper = h.checkAvailability(4, LocalDate.now(), LocalDate.of(2018, 06,23) );
        if (!(rhelper.isEmpty())) {
            for (Room r : rhelper){
                System.out.println(r);
            }
        }else {
            System.out.println("NO HAY");
        }
    */






        // h.save();
    }
}
