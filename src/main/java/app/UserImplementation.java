package app;

import app.helpers.FileHelper;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The class UserImplementation it handle all the common user methods.
 */
public class UserImplementation implements User, Comparable {
    private String userName;
    private String password;
    private UserType userType;

    public UserImplementation(String userName, String password) {
        this.userName = userName;
        this.password = password;
        if (this.getUserTypeFromJson() != null) {
            this.userType = this.getUserTypeFromJson();
        }

    }

    public UserImplementation(String userName, String password, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Get the userType from the Json File when the username and password are right.
     *
     * @return the UserType of the User.
     */
    public UserType getUserTypeFromJson() {
        Set<UserImplementation> users = FileHelper.getUsersFromJson();
        for (UserImplementation user : users) {
            if (user.getUserName().equals(this.getUserName())) {
                if (user.getPassword().equals(this.getPassword())) {
                    return user.getUserType();
                }
            }
        }
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * SignIn the system as a valid user each other implementation of this interface must use this method.
     *
     * @param userImplementation A userImplementation.
     * @return false if it's unauthorized, true if it's authorized.
     */
    @Override
    public boolean signIn(UserImplementation userImplementation) throws UserNotValidException {
        try {
            Set<UserImplementation> users = FileHelper.getUsersFromJson();
            for (User userCompare : users) {
                if (userImplementation.equals(userCompare)) {
                    return true;
                }
            }
        } catch (UserNotValidException e) {
            throw e;
        }
        return false;
    }

    @Override
    public boolean signOut() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        UserImplementation comparator = (UserImplementation) o;
        if (this.hashCode() < comparator.hashCode()) {
            return -1;
        } else if (this.hashCode() > comparator.hashCode()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UserImplementation)) {
            return false;
        }
        UserImplementation compareUser = (UserImplementation) obj;

        if (this.getUserName().equals(compareUser.getUserName())) {
            if (this.getPassword().equals(compareUser.getPassword())) {
                if (this.getUserType().equals(compareUser.getUserType())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = String.valueOf(userName).hashCode();
        result = 31 * result + String.valueOf(password).hashCode();
        result = 31 * result + userType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String userImplString = new String();
        userImplString = ("UserName: " + userName + "\t");
        userImplString = userImplString + ("Password: " + password + "\t");
        userImplString = userImplString + ("User Type: " + userType + "\t");
        return userImplString;
    }
}
