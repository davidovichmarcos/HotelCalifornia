package app.view;

import app.entities.Room;
import app.helpers.FileHelper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * The class AdminView.
 */
public class AdminView {
    static Scene scene;
    static List<Button> buttons;

    public static Scene display(Stage window) {
        buttons = getButtons();
        SplitPane pane = buildPane();
        /**
         * Setting the go back action to the last button.
         */
        buttons.get(0).setOnAction(event -> {

        });
        buttons.get(4).setOnAction(e -> {
            window.setScene(LoginView.display(window));
        });

        scene = new Scene(pane, 800, 600);
        window.setScene(scene);
        return scene;
    }

    /**
     * Build the buttons list.
     *
     * @return the List of Buttons.
     */
    public static List<Button> getButtons() {
        buttons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            buttons.add(new Button("Button " + i));
        }
        Integer i = 0;
        for (Button button : buttons) {
            if (buttons.get(0).equals(button)) {
                button.setText("Show Rooms");
            }
            if (buttons.get(4).equals(button)) {
                button.setText("Cancel ");
            }
            button.setStyle("-font-color: #fff;");
            button.setStyle("-fx-background-color: transparent;");
            GridPane.setConstraints(button, 0, i);

            i++;
        }
        return buttons;
    }

    /**
     * Build the SplitPane adding the buttons.
     *
     * @return the SplitPane to set in to the scene.
     */
    public static SplitPane buildPane() {
        SplitPane pane = new SplitPane();
        GridPane menu = new GridPane();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setVgap(8);
        menu.setHgap(10);
        menu.setAlignment(Pos.TOP_LEFT);
        menu.setMaxWidth(150);
        menu.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        menu.getChildren().addAll(buttons);
        SplitPane mainPane = getMainPane();
        pane.getItems().add(menu);
        pane.getItems().add(mainPane);
        return pane;
    }

    /**
     * Build the main SplitPane
     * @return the main Pane.
     */
    public static SplitPane getMainPane() {
        SplitPane mainPane = new SplitPane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        return mainPane;
    }

}
