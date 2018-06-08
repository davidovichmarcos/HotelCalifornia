package app;


/**
 * The interface User has two methods.
 * signIn() is for every implementation of each user,
 * which means that different kind of Users will signIn
 * by different ways.
 * And the method signOut
 */
public interface User {

    /**
     * @return false if it's unauthorized, true if it's authorized.
     */
    boolean signIn(UserImplementation userImplementation);

    boolean signOut();
}
