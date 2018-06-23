package app.entities;

public enum IsAvailable {
    CLEANING("Cleaning"),
    REPARATION("Under Maintenance"),
    DISINFECTION("Under Desinfection"),
    AVAILABLE("Room is AVAILABLE");


    private String reason;

    /**
     * @param reason
     */
    IsAvailable(String reason) {
        this.reason = reason;
    }

    /**
     * @return Get the reason
     */
    public String getReason() {
        return this.reason;
    }
}
