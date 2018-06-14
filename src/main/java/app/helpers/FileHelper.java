package app.helpers;


import app.UserImplementation;
import app.entities.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.util.*;

public class FileHelper {


    private static final String s = File.separator;

    File bookingsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"BookingsFile");

    /**
     * Saves the Treeset of Users in the usersFile.
     *
     * @param users The TreeSet of users.
     */
    public static void usersToJsonFile(TreeSet<UserImplementation> users) {
        try {
            File usersFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"UsersFile");
            BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(users, TreeSet.class, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the users from the Json.
     *
     * @return The TreeSet of users.
     */
    public static Set<UserImplementation> getUsersFromJson() {
        Set<UserImplementation> users = new TreeSet<>();
        try {
            File usersFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"UsersFile");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            Gson gson = new Gson();
            users = gson.fromJson(reader, new TypeToken<Set<UserImplementation>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Saves the treeset of Admins in the adminsFile.
     *
     * @param admins The treseet of admins.
     */
    public static void adminsToJsonFile(TreeSet<Admin> admins) {
        try {
            File adminsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"AdminsFile");
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
    public static Set<Admin> getAdminsFromJson() {
        Set<Admin> admins = new TreeSet<>();
        try {
            File adminsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"AdminsFile");
            BufferedReader reader = new BufferedReader(new FileReader(adminsFile));
            Gson gson = new Gson();
            admins = gson.fromJson(reader, new TypeToken<TreeSet<Admin>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

    /**
     * Saves the treeset of employees in the employeesFile.
     *
     * @param employees The treeset of employees.
     */
    public static void employeesToJsonFile(TreeSet<Employee> employees) {
        try {
            File employeesFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"EmployeesFile");
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
    public static Set<Employee> getEmployeesfromJson() {
        Set employees = new TreeSet<>();
        try {
            File employeesFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"EmployeesFile");
            BufferedReader reader = new BufferedReader(new FileReader(employeesFile));
            Gson gson = new Gson();
            employees = gson.fromJson(reader, new TypeToken<TreeSet<Employee>>() {
            }.getType());
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
    public static void roomsToJsonFile(ArrayList<Room> rooms) {
        try {
            File roomsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"RoomsFile");
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
    public static List<Room> getRoomsFromJson() {
        List<Room> rooms = new ArrayList<>();
        try {
            File roomsFile = new File("."+ s +"src"+ s +"main"+ s +"java"+s+"app"+s+"files"+s+"RoomsFile");
            BufferedReader reader = new BufferedReader(new FileReader(roomsFile));
            Gson gson = new Gson();
            rooms = gson.fromJson(reader, new TypeToken<ArrayList<Room>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    /**
     * Saves the TreeSet of passengers in the passengersFile.
     *
     * @param passengers The TreeSet of passengers.
     */
    public static void passengersToJsonFile(TreeSet<Passenger> passengers) {
        try {
            File passengersFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"PassengersFile");
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
    public static Set<Passenger> getPassengersfromJson() {
        Set<Passenger> passengers = null;
        try {
            File passengersFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"PassengersFile");
            BufferedReader reader = new BufferedReader(new FileReader(passengersFile));
            Gson gson = new Gson();
            passengers = gson.fromJson(reader, new TypeToken<TreeSet<Passenger>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    /**
     * Saves the TreeMap of bookings in the bookingsFile.
     *
     * @param bookings
     */
    public static void bookingsToJsonFile(TreeMap <Integer, TreeSet<Booking>> bookings) {
        try {
            File bookingsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"BookingsFile");
            BufferedWriter writer = new BufferedWriter(new FileWriter(bookingsFile));
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            gson.toJson(bookings, TreeMap.class, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the bookings from the Json file.
     *
     * @return The TreeMap of Bookings.
     */
    public static Map<Integer, TreeSet<Booking>> getBookingsfromJson() {
        Map<Integer, TreeSet<Booking>> bookings = null;
        try {
            File bookingsFile = new File("."+s+"src"+s+"main"+s+"java"+s+"app"+s+"files"+s+"BookingsFile");
            BufferedReader reader = new BufferedReader(new FileReader(bookingsFile));
            Gson gson = new Gson();
            bookings = gson.fromJson(reader, new TypeToken<TreeMap<Integer, TreeSet<Booking>>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bookings;
    }

}
