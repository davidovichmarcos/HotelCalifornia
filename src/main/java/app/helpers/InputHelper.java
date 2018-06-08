package app.helpers;

import app.User;
import app.UserImplementation;
import app.UserNotValidException;
import app.UserType;

import java.util.Scanner;

/**
 * The class InputHelper.
 */
public class InputHelper {

    private UserImplementation userImplementation;

    /**
     * Get the users from teh console.
     *
     * @return A UserImplementation if its valid or a null if its invalid.
     */
    public static UserImplementation getUser() {
        try {
            System.out.println("Enter User Name: \n");
            Scanner userNameScanner = new Scanner(System.in);
            String userName = userNameScanner.nextLine();
            System.out.println("Enter Password: \n");
            Scanner passwordScanner = new Scanner(System.in);
            String pass = passwordScanner.nextLine();
            System.out.println("Enter User Tye: 1 for Admin, 2 for Empoyee and 3 for Passenger");
            Scanner userTypeScanner = new Scanner(System.in);
            int userTypeInt = userTypeScanner.nextInt();
            UserType userType = null;
            if (userTypeInt == 1) {
                userType = UserType.ADMIN;
            } else if (userTypeInt == 2) {
                userType = UserType.EMPLOYEE;
            } else if (userTypeInt == 3) {
                userType = UserType.PASSENGER;
            }
            UserImplementation user = new UserImplementation(userName, pass, userType);
            return user;
        } catch (UserNotValidException e) {
            e.printStackTrace();
        }
        return null;
    }
}
