package app;

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
        return access;
    }

}
