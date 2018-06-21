package app.entities;

import app.user.User;
import app.user.UserImplementation;
import app.user.UserType;

/**
 * The class Employee.
 */
public class Employee extends Person implements User, Comparable {

    public Employee() {
    }

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
     * Get the hotel rooms.
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
        if (userImplementation.getUserType().equals(UserType.EMPLOYEE)) {
            //ToDo Employee menu
        }
        return false;
    }

    @Override
    public boolean signOut() {
        return false;
    }
}
