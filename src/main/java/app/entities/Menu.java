package app.entities;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    public static void menuPrincipal (Hotel hotel){
        System.out.println();
        System.out.println(":::::: HOTEL CALIFORNIA ::::::");
        System.out.println("\n1. Habitaciones");
        System.out.println("2. Reservas");
        System.out.println("3. Pasajeros");
        System.out.println("4. Check In");
        System.out.println("5. Check Out");
        System.out.println("6. Salir");
        System.out.print("Ingrese opcion: ");

        int s = integerReader();
        switch (s) {
            case 1:
                menuHabitacion(hotel);
                menuPrincipal(hotel);
                break;
            case 2:
                menuReservas(hotel);
                menuPrincipal(hotel);
                break;
            case 3:
                menuPasajeros(hotel);
                menuPrincipal(hotel);
                break;
            case 4:
                checkIn(hotel);
                menuPrincipal(hotel);
                break;
            case 5:
                checkOut(hotel);
                menuPrincipal(hotel);
                break;
            case 6:
                break;
        }

    }

    private static void menuHabitacion (Hotel hotel){
        int room;

        System.out.println("\n:::::: HABITACIONES ::::::");
        System.out.println("\n1. Estado General");
        System.out.println("2. Listar Habitaciones");
        System.out.println("3. Estado de Habitacion");
        System.out.println("4. Modificar Estado de una habitacion");
        System.out.println("5. Agregar consumos a una habitacion");
        System.out.println("6. Salir");
        System.out.print("Ingrese opcion: ");

        int s = integerReader();
        switch (s) {
            case 1:
                estadoGeneral(hotel);
                break;
            case 2:
                System.out.println("---- HABITACIONES ----");
                for(int i=1; i<=hotel.getHotelSize(); i++){
                    System.out.println(hotel.getRoom(i));
                }
                menuHabitacion(hotel);
                break;
            case 3:
                System.out.println(hotel.getRoom(roomReader(hotel)));
                menuHabitacion(hotel);
                break;
            case 4:
                modificarEstado(hotel);
                menuHabitacion(hotel);
                break;
            case 5:
                addIntakes(hotel);
                menuHabitacion(hotel);
                break;
            case 6:
                break;

        }

    }

    private static void estadoGeneral(Hotel hotel){
        int rooms = hotel.getHotelSize();
        int ocupated =0;
        System.out.println("=== ESTADO GENERAL ===");
        System.out.println("\nHabitaciones: " +rooms);
        for (int i=1; i<rooms; i++){
            if(hotel.getRoom(i).isOcupated()) ocupated++;
        }
        System.out.println("Ocupadas: "+ ocupated );
        System.out.println("Libres: " +(rooms-ocupated));
        menuHabitacion(hotel);
    }

    private static void addIntakes(Hotel hotel){
        int room=roomReader(hotel);
            if (hotel.getRoom(room).isOcupated()) {
                System.out.printf("\nValor consumido: $");
                hotel.getRoom(room).addIntake(sc.nextDouble());
            }else {
                System.out.println("La habitacion esta desocupada.");
            }
    }

    private static void modificarEstado(Hotel hotel){
        int room=0;
        int state=0;
        System.out.printf("\nHabitacion: ");
        room=roomReader(hotel);
        System.out.printf("\n\nSeleccione estado: ");
        System.out.println("\n1.- Disponible");
        System.out.println("2.- Limpieza");
        System.out.println("3.- Reparacion");
        System.out.println("4.- Desinfeccion");
        state=integerReader();
        switch (state){
            case 1:
                hotel.getRoom(room).setAvailable(IsAvailable.AVAILABLE);
                break;
            case 2:
                hotel.getRoom(room).setAvailable(IsAvailable.CLEANING);
                break;
            case 3:
                hotel.getRoom(room).setAvailable(IsAvailable.REPARATION);
                break;
             case 4:
                 hotel.getRoom(room).setAvailable(IsAvailable.DISINFECTION);
                break;
        }
    }

   ///// BOOKING MENU /////

    private static void menuReservas (Hotel hotel){
        System.out.println();
        System.out.println(":::::: RESERVAS ::::::");
        System.out.println("\n1. Hacer una Reserva");
        System.out.println("2. Cancelar Existente");
        System.out.println("3. Ver TODAS las reservas");
        System.out.println("4. Ver reservas de UNA HABITACION");
        System.out.println("5. Salir");
        System.out.print("Ingrese opcion: ");

        int s = integerReader();
        switch (s) {
            case 1:
                makeReservation(hotel);
                menuReservas(hotel);
                break;
            case 2:
                cancelBooking(hotel);
                menuReservas(hotel);
                break;
            case 3:
                showAllBookings(hotel);
                menuReservas(hotel);
                break;
            case 4:
                showBookingsFromRoom(hotel);
                menuReservas(hotel);
                break;
            case 5:
                break;
        }

    }

    /**
     * This complex method interacts with keyboard inputs to check for bookeable rooms in the hotel, after that if a selection is made creates a booking and inserts it into the hotel booking array.
     * @param hotel
     */
    private static void makeReservation(Hotel hotel){
        int people, duration,room;
        boolean k=false;
        char control;
        LocalDate date;
        Passenger passenger;
        Booking booking;

        System.out.printf("\n\nCantidad de personas?: ");
        people=integerReader();
        while (people<1) {
            System.out.println("Cantidad invalida, intente nuevamente.");
            people=integerReader();
        }

        System.out.println("\n ·· Fecha de Arrivo ·· ");
        date=createDate();

        System.out.println("Dias de hospedaje: ");
        duration=integerReader();
        while (duration<1) {
            System.out.println("Cantidad invalida, intente nuevamente.");
            duration=integerReader();
        }

        List<Room> rta= hotel.checkAvailability(people, date, date.plusDays(duration));

        if(rta.isEmpty()) {
            System.out.println("\nNo hay Habitaciones disponibles.");
        } else {
            System.out.println("\n ···· Habitaciones Disponibles ····");
            rta.forEach(System.out::println);
            System.out.printf("\n\nSeleccione una habitacion para reservar o 0 para salir:");
            do {
                room = integerReader();
                if (hotel.isValidRoomId(room) && rta.contains(hotel.getRoom(room)) ) {

                    passenger = findPassenger(hotel);
                    if (passenger==null) passenger=createAndAddPassenger(hotel);

                    booking = new Booking(date, duration, passenger, room);
                    System.out.println("===== Su Reserva =====");
                    System.out.println(booking);
                    System.out.println("Confirma reserva? s/n");
                    control=controlReader();
                    if (control == 's') {
                        k=hotel.addBooking(booking);
                        if (k) {
                            System.out.println("Reserva creada con exito.");
                        }else {
                            System.out.println("Error en reserva.");
                        }

                    }
                } else if(room !=0 && !(rta.contains(hotel.getRoom(room)))) {
                    System.out.println("Numero invalido, Ingrese nuevamente o 0 para salir.");
                }
            }while (room!=0 && !k);
        }
    }

    /**
     *  Searches all bookings from a Passenger and cancels a selected one.
     * @param hotel
     */
    private static void cancelBooking(Hotel hotel){
        int select;
        char control;
        Passenger aux;
        List <Booking> results;

        System.out.printf("Ingrese DNI de Pasajero: ");
        aux= hotel.getPassenger(integerReader());
        results=hotel.findBooking(aux);
        if(results.isEmpty()){
            System.out.println("No se encontraron resultados.");
        } else {
            for(int i=0; i<results.size(); i++){
                System.out.println((i+1)+ "|  "+results.get(i) );
            }
            do {
                System.out.println("Seleccione un elemento de la lista para cancelar o 0 para salir: ");
                select = integerReader();
                if (select !=0 && select<results.size()+1) {
                    select--;
                    System.out.printf("\n=== Reserva ===\n" + results.get(select)+"\n");
                    System.out.printf("\nConfirma seleccion? s/n");
                    control=controlReader();
                    if (control=='s'){
                        hotel.cancelBooking(results.get(select));
                        System.out.println("Reserva Cancelada");
                    }
                }
            } while (select!=0 && select>results.size()+1);

        }
    }

    /** Reads a Keyboard input and shows on console if the selected room has bookings.
     *
     * @param hotel
     */
    private static void showBookingsFromRoom(Hotel hotel){
        int room;
        List<Booking> result;

        System.out.printf("\nIngrese numero de habitacion: ");
        do {
            room = integerReader();
            if (room ==0 || room> hotel.getHotelSize()) System.out.println("La habitacion no existe, intente nuevamente.");
        }while (room==0 || room> hotel.getHotelSize());
        result=hotel.getBookings(room);
        if(result.isEmpty()){
            System.out.println("La habitacion no tiene reservas");
        } else {
            System.out.println("=== RESERVAS ===");
            result.forEach(System.out::println);
        }
    }

    /**
     *  Shows on console all the bokings in the booking map of the hotel.
     * @param hotel
     */
    public static void showAllBookings(Hotel hotel){
        System.out.println("\n··· BOOKINGS ···");
        for(int i =1 ; i< hotel.getHotelSize(); i++){
            if(!(hotel.getBookings(i).isEmpty())){
                System.out.println("\n=== ROOM ===  #"+i);
                hotel.getBookings(i).forEach(System.out::println);
            }
        }
    }



////////////    PASSENGERS MENU      ////////////

    private static void menuPasajeros (Hotel hotel){
        System.out.println("\n:::::: PASAJEROS ::::::");
        System.out.println("\n1. Listar Pasajeros");
        System.out.println("2. Agregar Pasajero");
        System.out.println("3. Eliminar Pasajero");
        System.out.println("4. Buscar Pasajero");
        System.out.println("5. Ver Historial de un Pasajero");
        System.out.println("6. Salir");
        System.out.print("Ingrese opcion: ");

        int s = integerReader();
        switch (s) {
            case 1:
                System.out.println("=== LISTADO DE PASAJEROS === ");
                hotel.getAllPassengers().forEach(System.out::println);
                menuPasajeros(hotel);
                break;
            case 2:
                createAndAddPassenger(hotel);
                menuPasajeros(hotel);
                break;
            case 3:
                erasePassenger(hotel);
                menuPasajeros(hotel);
                break;
            case 4:
                findPassenger(hotel);
                menuPasajeros(hotel);
                break;
            case 5:
                showHistory(hotel);
                menuPasajeros(hotel);
                break;
            case 6:
                break;
        }

    }

    /**
     *  Creates a Passenger element via keyboard input, adds it to the hotel and returns it.
     * @return new Passenger Element
     */
    private static Passenger createAndAddPassenger(Hotel hotel){
        String name, lastName, email,address;
        char control = 'p';
        int dni;
        Passenger aux;
        System.out.println("=== Crear Pasajero ===");
        do {
            sc.nextLine();
            System.out.printf("\nNombre: ");
            name = sc.nextLine();
            System.out.printf("Apellido: ");
            lastName = sc.nextLine();
            System.out.printf("DNI: ");
            dni = integerReader();
            sc.nextLine();
            System.out.printf("Email: ");
            email = sc.nextLine();
            System.out.printf("Direccion: ");
            address = sc.nextLine();
            aux = new Passenger(name, lastName, dni, email, address);
            System.out.println("DATOS INGRESADOS:");
            System.out.println(aux);
            do {
                System.out.println("Los datos son correctos? s/n");
                control = sc.next().charAt(0);
                if (control=='n'){
                    System.out.println("** Reingrese datos **");
                } else {
                    if (hotel.addPassenger(aux)) {
                        System.out.println("Pasajero creado con exito.");
                    }else {
                        System.out.println("El Pasajero ya existe o hubo algun error en creacion.");
                    }
                }
            }while (control!='s'&&control!='n');
        }while (control == 'n');
        return aux;
    }
    /**
     *  Reads a keyboard input and seaches if the passenger exixst.
     * @param hotel
     * @return Passanger or null
     */
    private static Passenger findPassenger(Hotel hotel) {
        Passenger aux;
        System.out.printf("Ingrese DNI de Pasajero: ");
        aux= hotel.getPassenger(integerReader());
        if (aux!=null){
            System.out.printf("\nDATOS DE PASAJERO: \n" + aux+ "\n\n");
        }else {
            System.out.println("El Pasajero NO EXISTE\n");
        }
        return aux;
    }
    /**
     *  Finds a Passenger via keyboard input and erases it from the hotel list. Also erases all of his bookings.
     * @param hotel
     */
    private static void erasePassenger(Hotel hotel){
        Passenger aux = findPassenger(hotel);
        char control;
        if (aux!=null){
            List<Booking> books = hotel.findBooking(aux);
            if (!(books.isEmpty())) {
                System.out.printf("\nEl Pasajero tiene reservas pendientes. Desea eliminarlas? s/n : ");
                control=controlReader();
                if (control=='s'){
                    for (int i=0;i<books.size(); i++){
                        hotel.cancelBooking(books.get(i));
                    }
                }
            }
            System.out.println("Esta a punto de eliminar el pasajero: " + aux + "\n\nDesea confirmar la eliminacion?");
            control=controlReader();
            if (control=='s') {
                hotel.deletePassenger(aux);
                System.out.println("Pasajero eliminado con EXITO.");
            }
        }
    }

    /**
     *  Shows the Visit History of a Passenger entered by keyboard.
     * @param hotel
     */
    private static void showHistory(Hotel hotel){
        Passenger p = findPassenger(hotel);
        if(p!=null){
            if(!(p.getHistory().isEmpty())){
                System.out.println("··· HISTORIAL DE VISITAS ··· ");
                p.getHistory().forEach(System.out::println);
            }else {
                System.out.println("El historial de "+p.getName()+" " +p.getLastName()+" esta vacio.");
            }
        }else {
            System.out.println("El Pasajero no existe.");
        }
    }

//// CHECK IN & OUT ////

    private static void checkIn (Hotel hotel){
        int room,days;
        char control;
        Passenger passenger = findPassenger(hotel);
        if (passenger==null){
            System.out.println("El pasajero no existe. Ingrese datos para crearlo...");
            passenger=createAndAddPassenger(hotel);
        }
        room=roomReader(hotel);
        System.out.println("Cantidad de dias de hospedaje?: ");
        days=integerReader();

        System.out.printf("\nPasajero: "+passenger+ "\nHabitacion: "+hotel.getRoom(room)+ "\nDías de hospedaje: "+days+"\n\nConfirma Check In? s/n: ");
        control=controlReader();
        if(control=='s'){
            if(hotel.checkIn(passenger,room,days)){
                System.out.println("\nCheck In realizado CON EXITO.");
            } else {
                System.out.println("\nERROR.\nLa habitacion esta OCUPADA o tiene RESERVAS previstas para la fecha seleccionada.");
            }
        }



    }

    private static void checkOut(Hotel hotel){
        int room=roomReader(hotel);
        if (hotel.getRoom(room).isOcupated()){
            double check = hotel.checkOut(room);
        System.out.println("Habitacion liberada.\nEl total en consumos es $"+check);
        }else{
            System.out.println("La habitacion NO ESTA OCUPADA");
        }
    }



   ///// HELPERS /////
    /**
     * Reads a keyboard input and returns it as a LocalDate element.
     * @return
     */
    private static LocalDate createDate (){
        int year, month, day;
        LocalDate date=null;
        System.out.printf("Año: ");
        year=integerReader();
        if (year < LocalDate.now().getYear() || year>2030) {
            do {
                System.out.println("\nAño Invalido, intente nuevamente.");
                year = integerReader();
            } while (year<2018 || year>2027 );
        }

        System.out.printf("Mes: ");
        month = integerReader();
        if (month >12 || month < 1 || month<LocalDate.now().getMonthValue())
            do {
                System.out.println("\nMes invalido, intente nuevamente");
                month = integerReader();
            } while (month>12 || month<1 || month<LocalDate.now().getMonthValue() );

        System.out.printf("Dia: ");
        day=integerReader();
        if (day<1 || day>31) {
            do {
                System.out.println("Dia invalido, intente nuevamente");
                day=integerReader();
            }while (day<1 || day>31);
        }
        try {
            date = LocalDate.of(year, month, day);
        } catch(DateTimeException e){
            System.out.println("Fecha Invalida, Intente nuevamente.");
            createDate();
        }
        return date;
    }

    /**
     * Returns if chars of a string are digits or not
     * @param s string
     * @return   boolean
     */
    private static boolean areDigits (String s) {
        boolean k=true;
        int i=0;
        while (k && i<s.length()){
            if (Character.isDigit(s.charAt(i))) {
                k= true;
            } else {
                k=false;
            }
            i++;
        }
        return k;
    }
    /**
     *  Reads a keyboard input and restrings it to only typing numbers.
     * @return
     */
    private static int integerReader(){
        String aux;
        boolean k=false;
        int rta;
        do {
            aux = sc.next();
            k= areDigits(aux);
            if (!k) { System.out.println("Ingrese solo digitos."); }
        }while (!k);
        rta =Integer.parseInt(aux);
        return rta;
    }

    private static int roomReader(Hotel hotel){
        int room;
        System.out.println("\nIngrese Numero de Habitacion: ");
        do{
            room = integerReader();
            if (!(hotel.isValidRoomId(room))) System.out.println("Numero de habitacion no valido. Intente nuevamente.");
        }while (!(hotel.isValidRoomId(room)));
        return room;
    }
    /**
     *  Reads a keyboard input and restrings it to only confirmation characters. Default are S for yes and N for no.
     * @return
     */
    private static char controlReader (){
        char c;
        do {
            c = sc.next().charAt(0);
            if (c !='s' && c!='n') System.out.println("Ingrese S por si o N por no.");
        } while (c !='s' && c!='n' );
        return c;
    }

    /// END HELPERS ////

}
