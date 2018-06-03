package app;

import app.entities.Admin;
import app.helpers.InputHelper;

/**
 * The Class Login.
 */
public class Login {
    private boolean access;

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    public boolean logIn() {
        InputHelper inputHelper = new InputHelper();
        UserImplementation userImpl = inputHelper.getUser();
        access = userImpl.signIn(userImpl);
        if (userImpl.getUserType().equals(UserType.ADMIN)) {
            Admin admin= new Admin("newadmin","asd",684654,"emailfake");
            admin.signIn(userImpl);
        } else if ( userImpl.getUserType().equals(UserType.EMPLOYEE)) {

        }else if (userImpl.getUserType().equals(UserType.PASSENGER)) {

        }

        return access;
    }

}
