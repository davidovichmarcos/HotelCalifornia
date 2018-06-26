package app.controller;

import app.entities.Room;
import app.helpers.FileHelper;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * The class room controller.
 */
public class RoomController {


    /**
     * Set The text to the lblRooms
     *
     * @param rooms the List of Rooms.
     */
    public static void settLblRoomsStatus(ArrayList<Label> rooms) {
        ArrayList<Room> roomsFromFile = new ArrayList<>();
        roomsFromFile.addAll(FileHelper.getRoomsFromJson());
        for (int i = 0; i < 20; i++) {
            rooms.get(i).setText(roomsFromFile.get(i).toString());
            rooms.get(i).setTextFill(Color.ANTIQUEWHITE);
        }
    }

}
