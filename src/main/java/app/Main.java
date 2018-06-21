package app;

import app.view.LoginView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private Stage window;
    Button btnAccess;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Presentation");
        btnAccess = new Button("Access");
        VBox layout = new VBox(10);
        layout.getChildren().add(btnAccess);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 800, 600);
        btnAccess.setOnAction(e -> {
            System.out.println("Access button");
            window.setScene(LoginView.display(window));

        });
        window.setScene(scene);
        window.show();
    }
}
