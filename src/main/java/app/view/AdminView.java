package app.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdminView {
    static Scene scene;
    static List<Button> buttons;
    public static Scene display(Stage window) {

        buttons = new ArrayList<>();
        for (int i = 0; i< 5; i++) {
            buttons.add(new Button("Button " + i));
        }

        SplitPane pane = new SplitPane();

        GridPane listPane = new GridPane();

        listPane.setPadding(new Insets(10, 10, 10, 10));
        listPane.setVgap(8);
        listPane.setHgap(10);
        Integer i = 0;
        for (Button button : buttons) {
            if (buttons.get(4).equals(button)) {
                button.setText("Cancel ");
            }
            button.setStyle("-fx-background-color: transparent;");
            GridPane.setConstraints(button, 0 ,i);

        i++;
        }
        listPane.setAlignment(Pos.TOP_LEFT);
        listPane.getChildren().addAll(buttons);
        pane.getItems().add(listPane);
        scene = new Scene(pane, 800, 600);
        window.setScene(scene);

        buttons.get(4).setOnAction(e -> {
            window.setScene(LoginView.display(window));
        });
        return scene;
    }
}
