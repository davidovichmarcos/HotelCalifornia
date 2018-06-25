package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;


public class MainController {
	@SuppressWarnings("unused")
    private Main mainApp;
    @FXML
    private Button btnAccess;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    // Add a public no-args constructor
    public MainController() {
    }

    @FXML
    private void initialize() {
    	
    	
    }
    @FXML
    public void btnAccessPressed(ActionEvent event) throws IOException {
        System.out.println("btn access pressed");

        // Swap screen
        Stage window = (Stage) btnAccess.getScene().getWindow();
        FXMLLoader loginLoader = new FXMLLoader();
        loginLoader.setLocation(Main.class.getResource("/fxml/LoginView.fxml"));
        AnchorPane login = (AnchorPane) loginLoader.load();
        Scene scene = new Scene(login);
        window.setTitle("Login");
        window.setScene(scene);
        window.show();

    }
 
}

