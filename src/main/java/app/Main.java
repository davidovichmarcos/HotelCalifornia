package app;

import app.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
