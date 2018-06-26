package app.controller;

import app.entities.Room;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import app.Main;
import app.helpers.FileHelper;
import app.user.UserImplementation;
import app.user.UserType;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * The Admin Controller class.
 */
public class AdminController {
    /**
     * All the component from the view.
     */
    @FXML
    private Label lblUserCreated;
    @FXML
    private Label lblWrongUserModified;
    @FXML
    private ComboBox cmbUserType;
    @FXML
    private ComboBox cmbUserTypeModified;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserNameModified;
    @FXML
    private PasswordField txtPasswordModified;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnModifyUser;
    @FXML
    private AnchorPane paneCreateUser;
    @FXML
    private GridPane gridRoomsPane;
    @FXML
    private AnchorPane presentationPane;
    @FXML
    private AnchorPane modifyPermissionsPane;
    @FXML
    private Label lblRoom1, lblRoom2, lblRoom3, lblRoom4, lblRoom5, lblRoom6,
            lblRoom7, lblRoom8, lblRoom9, lblRoom10, lblRoom11, lblRoom12, lblRoom13,
            lblRoom14, lblRoom15, lblRoom16, lblRoom17, lblRoom18, lblRoom19, lblRoom20;


    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    /**
     * Add a public no-args constructor
     */

    public AdminController() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Required method by JavaFX.
     */
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

    /**
     * Shows the Create users view.
     *
     * @param event the ActionEvent to the view.
     */
    @FXML
    private void btnCreateUserPressed(ActionEvent event) {
        System.out.println("btn create user pressed");
        setAllPanesNotVisible();
        lblUserCreated.setVisible(false);
        paneCreateUser.setVisible(true);

    }

    @FXML
    private void btnModifyPermissionsPressed() {
        System.out.println("btn modify permissions pressed");
        setAllPanesNotVisible();
        lblWrongUserModified.setVisible(false);
        modifyPermissionsPane.setVisible(true);
    }

    @FXML
    private void btnModifyUserPressed() {
        System.out.println("btn modify user pressed");
        TreeSet<UserImplementation> users = new TreeSet<>();
        UserImplementation userModified = null;
        users.addAll(FileHelper.getUsersFromJson());
        TreeSet<UserImplementation> usersModify = new TreeSet<>();
        boolean validUser = false;
        for (UserImplementation user : users) {
            if (user.getUserName().equals(txtUserNameModified.getText())) {
                System.out.println(cmbUserTypeModified.getValue());
                if (user.getPassword().equals(txtPasswordModified.getText())) {
                    validUser = true;

                    if (cmbUserTypeModified.getValue().equals("Admin")) {
                        userModified = new UserImplementation(txtUserNameModified.getText(), txtPasswordModified.getText(), UserType.ADMIN);
                    } else if (cmbUserTypeModified.getValue().equals("Passenger")) {
                        userModified = new UserImplementation(txtUserNameModified.getText(), txtPasswordModified.getText(), UserType.PASSENGER);
                    } else if (cmbUserTypeModified.getValue().equals("Employee")) {
                        userModified = new UserImplementation(txtUserNameModified.getText(), txtPasswordModified.getText(), UserType.EMPLOYEE);
                    }
                    usersModify.add(userModified);

                }
            }
            if (!user.getUserName().equals(txtUserNameModified.getText())) {
                usersModify.add(user);
            }
            FileHelper.usersToJsonFile(usersModify);
        }
        txtUserNameModified.clear();
        txtPasswordModified.clear();
        if (validUser) {
            lblWrongUserModified.setTextFill(Color.LIGHTGREEN);
            lblWrongUserModified.setText("User Modified");
            lblWrongUserModified.setVisible(true);
        } else {
            lblWrongUserModified.setTextFill(Color.ORANGE);
            lblWrongUserModified.setText("User Not Valid");
            lblWrongUserModified.setVisible(true);
        }
    }


    /**
     * Shows the label wich says if the users ir wrong or not.
     *
     * @param event the ActionEvent to the view.
     */
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

    /**
     * Set all the panes not visible at first, all the panes must be added.
     */
    private void setAllPanesNotVisible() {
        paneCreateUser.setVisible(false);
        gridRoomsPane.setVisible(false);
        presentationPane.setVisible(false);
        modifyPermissionsPane.setVisible(false);
    }
}
