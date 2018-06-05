package app;

import app.entities.Admin;
import app.entities.Employee;
import app.entities.Passenger;
import app.helpers.InputHelper;

import java.awt.*;

/**
 * The Class Login.
 */
public class Login {
    private boolean access;

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    public boolean logIn() {
        UserImplementation userImpl = InputHelper.getUser();
        access = userImpl.signIn(userImpl);
        if (userImpl.getUserType().equals(UserType.ADMIN)) {
            Admin admin = new Admin();
            admin.signIn(userImpl);
        } else if (userImpl.getUserType().equals(UserType.EMPLOYEE)) {
            Employee employee = new Employee();
            employee.signIn(userImpl);
        } else if (userImpl.getUserType().equals(UserType.PASSENGER)) {
            Passenger passenger = new Passenger();
            passenger.signIn(userImpl);
        }

        return access;
    }

}
