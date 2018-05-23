package app;

import java.util.UUID;

public abstract class Person {
    private String name;
    private String lastName;
    private String email;
    private Integer dni;
    private UUID uuid;

    public Person(String name, String lastName, Integer dni, UUID uuid, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
