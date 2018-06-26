package app.controller;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The EmployeeController class.
 */
public class EmployeeController {
    @FXML
    private Button btnCancel;
    @FXML
    private GridPane gridRoomsPane;
    @FXML
    private Label lblRoom1, lblRoom2, lblRoom3, lblRoom4, lblRoom5, lblRoom6,
            lblRoom7, lblRoom8, lblRoom9, lblRoom10, lblRoom11, lblRoom12, lblRoom13,
            lblRoom14, lblRoom15, lblRoom16, lblRoom17, lblRoom18, lblRoom19, lblRoom20;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    // Add a public no-args constructor
    public EmployeeController() {
        // TODO Auto-generated constructor stub
    }

    @FXML
    private void initialize() {

    }

    /**
     * Go back to the login view.
     *
     * @param event the ActionEvent to the view.
     */
    @FXML
    private void btnCancelPressed(ActionEvent event) {
        try {
            System.out.println("btn Cancel Pressed");
            Stage window = (Stage) btnCancel.getScene().getWindow();
            FXMLLoader loginLoader = new FXMLLoader();
            loginLoader.setLocation(Main.class.getResource("/fxml/LoginView.fxml"));
            AnchorPane loginPane = (AnchorPane) loginLoader.load();
            Scene scene = new Scene(loginPane);
            window.setTitle("Login");
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            new Exception("Cannot load the LoginView.fxml");
        }
    }

    /**
     * Shows the Rooms and the status of each one.
     *
     * @param event the ActionEvent to the view.
     */
    @FXML
    private void btnShowRoomsPressed(ActionEvent event) {
        System.out.println("btn Showrooms pressed");
        setAllPanesNotVisible();
        gridRoomsPane.setVisible(true);
        ArrayList<Label> lblrooms = new ArrayList<>();
        lblrooms.add(lblRoom1);
        lblrooms.add(lblRoom2);
        lblrooms.add(lblRoom3);
        lblrooms.add(lblRoom4);
        lblrooms.add(lblRoom5);
        lblrooms.add(lblRoom6);
        lblrooms.add(lblRoom7);
        lblrooms.add(lblRoom8);
        lblrooms.add(lblRoom9);
        lblrooms.add(lblRoom10);
        lblrooms.add(lblRoom11);
        lblrooms.add(lblRoom12);
        lblrooms.add(lblRoom13);
        lblrooms.add(lblRoom14);
        lblrooms.add(lblRoom15);
        lblrooms.add(lblRoom16);
        lblrooms.add(lblRoom17);
        lblrooms.add(lblRoom18);
        lblrooms.add(lblRoom19);
        lblrooms.add(lblRoom20);
        RoomController.settLblRoomsStatus(lblrooms);

    }

    public void setAllPanesNotVisible() {
        gridRoomsPane.setVisible(false);
    }

}