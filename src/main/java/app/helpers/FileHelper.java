package app.helpers;

import app.Employee;
import app.Room;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class FileHelper {
    File employeesFile = new File("C:\\Users\\Marcos\\IdeaProjects\\HotelCalifornia\\src\\main\\java\\app\\files\\EmployeesFile");
    File adminsFile = new File("C:\\Users\\Marcos\\IdeaProjects\\HotelCalifornia\\src\\main\\java\\app\\files\\AdminsFile");
    File bookingsFile = new File("C:\\Users\\Marcos\\IdeaProjects\\HotelCalifornia\\src\\main\\java\\app\\files\\BookingsFile");
    File passengersFile = new File("C:\\Users\\Marcos\\IdeaProjects\\HotelCalifornia\\src\\main\\java\\app\\files\\PassengersFile");
    File roomsFile = new File("C:\\Users\\Marcos\\IdeaProjects\\HotelCalifornia\\src\\main\\java\\app\\files\\RoomsFile");

    /**
     * Saves the treeset of employees in the employeesFile.
     *
     * @param employees The treeset of employees.
     */
    public void employeesToJsonFile(TreeSet<Employee> employees) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(employeesFile));
            Gson gson = new Gson();
            for (Employee employee : employees) {
                gson.toJson(employee, Employee.class, writer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the Arraylist of rooms in the roomsFile.
     *
     * @param rooms The treeset of rooms.
     */
    public void roomsToJsonFile(ArrayList<Room> rooms) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(roomsFile));
            Gson gson = new Gson();
            for (Room room : rooms) {
                gson.toJson(room, Room.class, writer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
