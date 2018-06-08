package app;

/**
 * This functional interface is used to implement a lambda expression at the moment of validating
 * the users.
 */
@FunctionalInterface
public interface UserPredicate {
    /**
     * Test if the user is valid.
     *
     * @param p Must be an implementation of a user.
     * @return false if the user isn't valid or true if it is.
     */
    boolean test(UserImplementation p);
}
