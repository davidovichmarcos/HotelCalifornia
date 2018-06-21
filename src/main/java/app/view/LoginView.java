package app.view;


import app.user.Login;
import app.Main;
import app.user.UserImplementation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginView {
    static TextField txtUserName;
    static TextField txtPassword;
    static Button btnLogin;
    static Button btnCancel;
    static boolean access;
    static Label lblWrongUser;

    public static Scene display(Stage window) {
        txtUserName = new TextField("User Name");
        txtPassword = new PasswordField();
        txtPassword.setPromptText("Password");
        btnLogin = new Button("Login");
        btnCancel = new Button("Go Back!");
        lblWrongUser = new Label("Wrong User!");
        lblWrongUser.setVisible(false);
        /** Building the Scene and his respective pane.
         */
        GridPane pane = buildPane();
        Scene scene = new Scene(pane, 800, 600);
        /**
         *  The login button functionality.
         */
        btnLogin.setOnAction(e -> {
            Login login = new Login();
            UserImplementation user = new UserImplementation(txtUserName.getText(), txtPassword.getText());
            if (login.isValidUser(user)) {
                access = true;
                System.out.println("valid user");
                AdminView.display(window);

            } else {
                System.out.println("User Not Valid");
                lblWrongUser.setVisible(true);
            }
            txtUserName.clear();
            txtUserName.setPromptText("User Name");
            txtPassword.clear();
        });
        /**
         *  The Go Back button functionality.
         */
        btnCancel.setOnAction(e -> {
            Main main = new Main();
            try {
                main.start(window);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        return scene;
    }

    /**
     * Buil the LoginView pane.
     *
     * @return The GridPane to the display method.
     */
    public static GridPane buildPane() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(8);
        pane.setHgap(10);

        GridPane.setConstraints(txtUserName, 3, 1);
        GridPane.setConstraints(txtPassword, 3, 2);
        GridPane.setConstraints(btnLogin, 3, 7);
        GridPane.setConstraints(btnCancel, 4, 7);
        GridPane.setConstraints(lblWrongUser, 3, 6);
        pane.getChildren().addAll(txtUserName, txtPassword, btnLogin, btnCancel, lblWrongUser);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }

}
