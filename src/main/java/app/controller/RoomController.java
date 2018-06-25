package app.controller;

import app.entities.Room;
import app.helpers.FileHelper;
import javafx.scene.control.Label;


import java.util.ArrayList;

public class RoomController {


    public static void settLblRoomsStatus(ArrayList<Label> rooms) {
        ArrayList<Room> roomsFromFile = new ArrayList<>();
        roomsFromFile.addAll(FileHelper.getRoomsFromJson());
        for (int i = 0 ; i < 20;i++) {
            rooms.get(i).setText(roomsFromFile.get(i).toString());
        }
    }

}
