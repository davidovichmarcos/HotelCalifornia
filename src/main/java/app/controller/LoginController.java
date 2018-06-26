package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

import app.Main;
import app.user.Login;
import app.user.UserImplementation;
import app.user.UserType;
import com.sun.javafx.css.StyleCacheEntry;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *  The LoginController view.
 */
public class LoginController {
	@SuppressWarnings("unused")
    private Main mainApp;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    public Label lblWrongUser;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    // Add a public no-args constructor
    public LoginController() {
		// TODO Auto-generated constructor stub
	}
    @FXML
    private void initialize() {

    }

	/**
	 * Shows or the new view or the label wrong user.
	 * @param event the ActionEvent to the view.
	 * @throws IOException iOException.
	 */
    @FXML
    public void btnLoginPressed(ActionEvent event) throws IOException {
    	System.out.println("btn login pressed");
    	Stage window = (Stage) btnLogin.getScene().getWindow();
    	Login login = new Login();
    	UserImplementation user = new UserImplementation(txtUserName.getText(), txtPassword.getText());
    	if (login.isValidUser(user)) {
			System.out.println("Valid User");
			if(user.getUserType().equals(UserType.ADMIN)) {
				FXMLLoader adminLoader = new FXMLLoader();
		 	   	adminLoader.setLocation(Main.class.getResource("/fxml/AdminView.fxml"));
		        AnchorPane loginPane = (AnchorPane) adminLoader.load();
		        Scene scene = new Scene(loginPane);
		        window.setTitle("Admin");
		        window.setScene(scene);
		 	   	window.show();	
			} else if (user.getUserType().equals(UserType.EMPLOYEE)) {
				FXMLLoader adminLoader = new FXMLLoader();
		 	   	adminLoader.setLocation(Main.class.getResource("/fxml/EmployeeView.fxml"));
		        AnchorPane loginPane = (AnchorPane) adminLoader.load();
		        Scene scene = new Scene(loginPane);
		        window.setTitle("Employee");
		        window.setScene(scene);
		 	   	window.show();
			}	else if(user.getUserType().equals(UserType.PASSENGER)) {
				FXMLLoader adminLoader = new FXMLLoader();
		 	   	adminLoader.setLocation(Main.class.getResource("/fxml/PassengerView.fxml"));
		        AnchorPane loginPane = (AnchorPane) adminLoader.load();
		        Scene scene = new Scene(loginPane);
		        window.setTitle("Passenger");
		        window.setScene(scene);
		 	   	window.show();
			}
			
		} else {
			lblWrongUser.setVisible(true);
			txtUserName.clear();
			txtPassword.clear();
		}
    	
    	
    }

	/**
	 * Go back to the main view
	 * @param event the ActionEvent to the view.
	 * @throws IOException iOException.
	 */
    @FXML
    public void btnCancelPressed(ActionEvent event) throws IOException {
    	System.out.println("btn cancel pressed");
    	Stage window = (Stage) btnLogin.getScene().getWindow();
    	FXMLLoader loginLoader = new FXMLLoader();
 	   	loginLoader.setLocation(Main.class.getResource("/fxml/main.fxml"));
        AnchorPane loginPane = (AnchorPane) loginLoader.load();
        Scene scene = new Scene(loginPane);
        window.setTitle("Welcome");
        window.setScene(scene);
 	   	window.show();
    }

}
