package app.entities;


import app.User;
import app.UserImplementation;
import app.UserType;

/**
 * The class admin.
 */
public class Admin extends Person implements User, Comparable {

    public Admin() {
    }

    public Admin(String name, String lastName, Integer dni, String email) {
        super(name, lastName, dni, email);
    }

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    @Override
    public boolean signIn(UserImplementation userImplementation) {
        if (userImplementation.getUserType().equals(UserType.ADMIN)) {
            //ToDo Admin menu.
        }
        return false;
    }

    @Override
    public boolean signOut() {
        return false;
    }

    public void makeABackup() {
        //save in the files the entities.
    }

    public void createEmployee() {

    }

    @Override
    public int compareTo(Object o) {
        Admin comparator = (Admin) o;
        if (this.getDni() < comparator.getDni()) {
            return -1;
        } else if (this.getDni() > comparator.getDni()) {
            return 1;
        } else {
            return 0;
        }
    }
}
