package app;

public enum UserType {
    ADMIN("Administrator"),
    EMPLOYEE("Employee"),
    PASSENGER("Passenger");

    private String description;

    UserType(String description) {
        this.description = description;
    }
}
