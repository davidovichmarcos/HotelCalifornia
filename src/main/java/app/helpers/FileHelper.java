package app.helpers;

import app.*;
import app.entities.Employee;
import app.entities.Passenger;
import app.entities.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileHelper {
    File employeesFile = new File(".\\src\\main\\java\\app\\files\\EmployeesFile");
    File adminsFile = new File(".\\src\\main\\java\\app\\files\\AdminsFile");
    File bookingsFile = new File(".\\src\\main\\java\\app\\files\\BookingsFile");
    File passengersFile = new File(".\\src\\main\\java\\app\\files\\PassengersFile");
    File roomsFile = new File(".\\src\\main\\java\\app\\files\\RoomsFile");


    /**
     * Saves the treeset of Admins in the adminsFile.
     *
     * @param admins The treseet of admins.
     */
    public void adminsToJsonFile(TreeSet<Admin> admins) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(adminsFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(admins, TreeSet.class, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the admins from the Json.
     *
     * @return The treeSet of admins.
     */
    public TreeSet<Admin> getAdminsFromJson() {
        TreeSet<Admin> admins = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(adminsFile));
            Gson gson = new Gson();
            admins = gson.fromJson(reader, TreeSet.class);
        } catch (IOException e) {

        }
        return admins;
    }

    /**
     * Saves the treeset of employees in the employeesFile.
     *
     * @param employees The treeset of employees.
     */
    public void employeesToJsonFile(TreeSet<Employee> employees) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(employeesFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(employees, TreeSet.class, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the employees from the Json file.
     *
     * @return TreeSet of employees.
     */
    public TreeSet<Employee> getEmployeesfromJson() {
        TreeSet<Employee> employees = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(employeesFile));
            Gson gson = new Gson();
            employees = gson.fromJson(reader, TreeSet.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Saves the Arraylist of rooms in the roomsFile.
     *
     * @param rooms The arrayList of rooms.
     */
    public void roomsToJsonFile(ArrayList<Room> rooms) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(roomsFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(rooms, ArrayList.class, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the rooms from the Json file.
     *
     * @return The ArrayList of rooms.
     */
    public ArrayList<Room> getRoomsFromJson() {
        ArrayList<Room> rooms = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(roomsFile));
            Gson gson = new Gson();
            rooms = gson.fromJson(reader, ArrayList.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    /**
     * Saves the treeset of passengers in the passengersFile.
     *
     * @param passengers The treeset of passengers.
     */
    public void passengersToJsonFile(TreeSet<Passenger> passengers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(passengersFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(passengers, TreeSet.class, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the passengers from the Json file.
     *
     * @return TreeSet of employees.
     */
    public TreeSet<Passenger> getPassengersfromJson() {
        TreeSet<Passenger> passengers = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(passengersFile));
            Gson gson = new Gson();
            passengers = gson.fromJson(reader, TreeSet.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }

}
