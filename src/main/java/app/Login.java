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

    /**
     * Try to access to the system asking for valid users.
     * @param userImplementation The implementation of a user.
     */

    public void logIn(UserImplementation userImplementation) {
        try {
            while (!isValidUser(userImplementation)) {
                System.out.println("User not valid asshole");
                userImplementation = InputHelper.getUser();
            }
            this.handleUsers(userImplementation);
        } catch (UserNotValidException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method implements a lambda expression to validate if the user is valid.
     *
     * @param userImpl The implementation of the user.
     * @return false if the user isn't valid or true if it is.
     */
    public boolean isValidUser(UserImplementation userImpl) {
        UserPredicate isLoginSuccess = (UserImplementation p) -> p.signIn(p);
        return isLoginSuccess.test(userImpl);
    }

    /**
     * Handle the users just before the login function, call the signIn method of each specific user.
     * @param userImpl The implementation of the user.
     */
    public void handleUsers(UserImplementation userImpl) {
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
    }

}
