package app;

import sun.security.util.Password;

import java.util.UUID;

public class Admin extends Person implements User {

    private Password password;

    public Admin(String name, String lastName, Integer dni, UUID uuid, String email) {
        super(name, lastName, dni, uuid, email);
    }

    public boolean signIn() {
        //ToDo
        return false;
    }
}
