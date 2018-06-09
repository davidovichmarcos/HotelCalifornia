package app.entities;

import app.User;
import app.UserImplementation;
import app.UserType;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The class Passenger.
 * Add visit history.
 */
public class Passenger extends Person implements User, Comparable {
    private String originAddress;
    private ArrayList<String> history = new ArrayList<String>();

    public Passenger() {}

    public Passenger(String name, String lastName, Integer dni, String email, String address) {
        super(name, lastName, dni, email);
        this.originAddress = address;
    }

    public String getOriginAdress() {
        return originAddress;
    }

    /**
     *  Add a visit log into passenger history.
     * @param log   String with visit details.
     * @return  boolean
     */
    public boolean addHistory (String log){
        return this.history.add(log);
    }

    /**
     *  Get passenger History Array
     * @return   ArrayList with History log.
     */
    public ArrayList<String> getHistory() {
        return history;
    }

    @Override
    public boolean signIn(UserImplementation userImplementation) {
        if (userImplementation.getUserType().equals(UserType.PASSENGER)) {
            //ToDo Passenger menu
        }
        return false;
    }

    @Override
    public String toString() {return super.toString()+ " Address: "+this.originAddress ; }


    @Override
    public boolean signOut() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Passenger comparator = (Passenger) o;
        if (this.getDni() < comparator.getDni()) {
            return -1;
        } else if (this.getDni() > comparator.getDni()) {
            return 1;
        } else {
            return 0;
        }
    }
}
