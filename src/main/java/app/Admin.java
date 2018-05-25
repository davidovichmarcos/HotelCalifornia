package app;

import sun.security.util.Password;

import java.util.UUID;

/**
 *  The class admin.
 */
public class Admin extends Person implements User {

    private Password password;

    public Admin(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }
    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    public boolean signIn() {
        //ToDo
        return false;
    }
}
