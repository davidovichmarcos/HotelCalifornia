package app;

import java.io.IOException;

import app.controller.LoginController;
import app.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	
    private Stage window;
   
    Parent root;
    AnchorPane pane;

    static MainController myControllerHandle;

    public static void main(String[] args) {
        Application.launch(args);
    }
    
	@Override
    public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/main.fxml"));
        AnchorPane login = (AnchorPane) loader.load();
        window.setTitle("Welcome");
        window.setScene(new Scene(login));
        window.sizeToScene();
        window.setResizable(false); 
        
        window.show();
	}
}
