package app;

public interface User {

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    boolean signIn();
}
