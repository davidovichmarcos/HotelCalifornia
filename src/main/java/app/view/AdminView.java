package app.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;

public class AdminView {

    public static Scene display() {
        Scene scene;
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        SplitPane pane = new SplitPane();
        GridPane listPane = new GridPane();

        listPane.setPadding(new Insets(10, 10, 10, 10));
        listPane.setVgap(8);
        listPane.setHgap(10);

        GridPane.setConstraints(button1, 0, 0);
        GridPane.setConstraints(button2, 0, 0);
        listPane.getChildren().addAll(button1,button2);
        listPane.setAlignment(Pos.TOP_LEFT);
        pane.getItems().add(listPane);
        scene = new Scene(pane, 800, 600);
        return scene;
    }
}
