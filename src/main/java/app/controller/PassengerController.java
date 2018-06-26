package app.controller;
import javafx.event.ActionEvent;
import java.net.URL;
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
 *  The PassengerController class.
 */
public class PassengerController {
	@FXML
	private Button btnCancel;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    // Add a public no-args constructor
    public PassengerController() {
		// TODO Auto-generated constructor stub
	}
    @FXML
    private void initialize() {

    }

    /**
     * Go back to the login view.
     * @param event the ActionEvent to the view.
     */
    @FXML
    private void btnCancelPressed(ActionEvent event) {
    	try
    	{
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
   
}