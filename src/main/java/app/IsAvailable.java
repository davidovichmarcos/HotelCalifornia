package app;

public enum IsAvailable {
    CLEANING("Cleaning reason"),
    REPARATION("Reparation reason"),
    DISINFECTION("disinfection reason"),
    AVAILABLE ("Room is available");   /// agregue la base


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
