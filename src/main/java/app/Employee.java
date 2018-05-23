package app;

import java.util.ArrayList;
import java.util.UUID;

public class Employee extends Person implements User {
    ArrayList<Room> rooms = new ArrayList<Room>();

    public Employee(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }

    public void checkIn() {
        //ToDo
    }

    public void checkOut() {
        //ToDo
    }

    public boolean signIn() {
        //ToDo
        return false;
    }
}
