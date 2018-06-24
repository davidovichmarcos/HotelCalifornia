package app.controller;

import app.entities.Room;
import app.helpers.FileHelper;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class RoomController {


    public static String settLblRoomsStatus() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.addAll(FileHelper.getRoomsFromJson());
        rooms.get(0).toString();
        rooms.get(1).getId();

        return rooms.get(0).toString();
    }

}
