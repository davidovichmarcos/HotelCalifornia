package app.user;

/**
 * The class UserNotValidException.
 */
public class UserNotValidException extends InstantiationError {
    /**
     * When the user set wrong values like UserType is 0 or 4.
     *
     * @param message The user is trying to joke with you.
     */
    public UserNotValidException(String message) {
        super(message);
    }
}
