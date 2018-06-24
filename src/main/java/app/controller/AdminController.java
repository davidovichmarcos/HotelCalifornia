package app.controller;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import app.Main;
import app.helpers.FileHelper;
import app.user.UserImplementation;
import app.user.UserType;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminController {
    @FXML
    private Label lblUserCreated;
    @FXML
    private ComboBox cmbUserType;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnCancel;
    @FXML
    private AnchorPane paneCreateUser;
    @FXML
    private GridPane gridRoomsPane;
    @FXML
    private Label lblRoom1, lblRoom2, lblRoom3, lblRoom4, lblRoom5, lblRoom6,
            lblRoom7, lblRoom8, lblRoom9, lblRoom10,lblRoom11,lblRoom12,lblRoom13,
            lblRoom14,lblRoom15,lblRoom16,lblRoom17,lblRoom18,lblRoom19,lblRoom20;


    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public AdminController() {
        // TODO Auto-generated constructor stub
    }

    @FXML
    private void initialize() {

    }

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

    @FXML
    private void btnShowRoomsPressed(ActionEvent event) {
        System.out.println("btn Showrooms pressed");
        gridRoomsPane.setVisible(true);
        lblRoom1.setText(RoomController.settLblRoomsStatus());
        paneCreateUser.setVisible(false);

    }

    @FXML
    private void btnCreateUserPressed(ActionEvent event) {
        System.out.println("btn create user pressed");
        gridRoomsPane.setVisible(false);
        paneCreateUser.setVisible(true);
        lblUserCreated.setVisible(false);

    }

    @FXML
    private void btnCreatePressed(ActionEvent event) {
        UserImplementation user = null;
        System.out.println("btn create pressed");
        if (!txtUserName.getText().isEmpty()) {
            if (!txtPassword.getText().isEmpty()) {
                if (cmbUserType.getValue() != null) {
                    if (cmbUserType.getValue().equals(new String("Admin"))) {
                        user = new UserImplementation(txtUserName.getText(), txtPassword.getText(), UserType.ADMIN);
                    } else if (cmbUserType.getValue().equals(new String("Employee"))) {
                        user = new UserImplementation(txtUserName.getText(), txtPassword.getText(), UserType.EMPLOYEE);
                    } else if (cmbUserType.getValue().equals(new String("Passenger"))) {
                        user = new UserImplementation(txtUserName.getText(), txtPassword.getText(), UserType.PASSENGER);
                    }
                    if (user != null) {
                        txtUserName.clear();
                        txtPassword.clear();
                        lblUserCreated.setText("User Created!");
                        lblUserCreated.setTextFill(Color.LIGHTBLUE);
                        lblUserCreated.setVisible(true);
                        TreeSet<UserImplementation> users = new TreeSet<>();
                        users.addAll(FileHelper.getUsersFromJson());
                        users.add(user);
                        FileHelper.usersToJsonFile(users);
                    }
                } else {
                    lblUserCreated.setText("Void UserType");
                    lblUserCreated.setTextFill(Color.ORANGE);
                    lblUserCreated.setVisible(true);
                }
            } else {
                lblUserCreated.setText("Void Password");
                lblUserCreated.setTextFill(Color.ORANGE);
                lblUserCreated.setVisible(true);
            }
        } else {
            lblUserCreated.setText("Void UserName");
            lblUserCreated.setTextFill(Color.ORANGE);
            lblUserCreated.setVisible(true);
        }

    }
}
