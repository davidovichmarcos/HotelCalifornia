package app;

import app.controller.MainController;
import app.entities.Hotel;
import app.entities.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage window;

    Parent root;
    AnchorPane pane;

    static MainController myControllerHandle;

    public static void main(String[] args) {
        // 1  Console Application
        //Hotel hotel = new Hotel();
        //Menu.menuPrincipal(hotel);
        //hotel.save();
        // 2 Window
        Application.launch(args);
    }

    /**
     * Start The javaFX application.
     *
     * @param primaryStage the OS window.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/main.fxml"));
        AnchorPane login = (AnchorPane) loader.load();
        window.setTitle("Welcome");
        window.setScene(new Scene(login));
        window.sizeToScene();
        window.getIcons().add(new Image("/img/icon.png"));
        window.setResizable(false);
        window.show();
    }
}
