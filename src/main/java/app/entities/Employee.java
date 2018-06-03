package app.entities;

import app.User;
import app.UserImplementation;

/**
 * The class Employee.
 */
public class Employee extends Person implements User, Comparable {

    /**
     * @param name
     * @param lastName
     * @param dni
     * @param email
     */
    public Employee(String name, String lastName, Integer dni, String email) {
        super(name, lastName, dni, email);
    }

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    public boolean signIn() {
        //ToDo
        return false;
    }

    /**
     * Get the hotel rooms must call it in a bucle.
     */
    public void getRooms() {
        //ToDo
    }

    public void createPassenger() {

    }

    @Override
    public int compareTo(Object o) {
        Employee comparator = (Employee) o;
        if (this.getDni() < comparator.getDni()) {
            return -1;
        } else if (this.getDni() > comparator.getDni()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean signIn(UserImplementation userImplementation) {
        return false;
    }

    @Override
    public boolean signOut() {
        return false;
    }
}
