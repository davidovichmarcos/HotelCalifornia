package app;

import java.util.UUID;


/**
 *  The class Employee.
 */
public class Employee extends Person implements User {

    /**
     * @param name
     * @param lastName
     * @param dni
     * @param uuid
     * @param email
     */
    public Employee(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }

    /**
     *  Do a checkIn.
     */
    public void checkIn() {
        //ToDo
    }

    /**
     *  Do a checkOut.
     */
    public void checkOut() {
        //ToDo
    }

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    public boolean signIn() {
        //ToDo
        return false;
    }

    /**
     *  Get the hotel rooms must call it in a bucle.
     */
    public void getRooms() {
        //ToDo
    }

}
