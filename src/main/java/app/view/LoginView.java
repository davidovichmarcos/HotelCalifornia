package app.view;


import app.Login;
import app.UserImplementation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;


public class LoginView {
    static TextField txtUserName;
    static TextField txtPassword;
    static Button btnLogin;
    static Button btnCancel;
    static boolean access;
    public static Scene display() {
        Scene scene;
        txtUserName = new TextField("User Name");
        txtPassword = new PasswordField();
        txtPassword.setPromptText("Password");
        btnLogin = new Button("Login");
        btnCancel = new Button("Go Back!");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(8);
        pane.setHgap(10);

        GridPane.setConstraints(txtUserName, 3, 1);
        GridPane.setConstraints(txtPassword, 3, 2);
        GridPane.setConstraints(btnLogin, 3, 6);
        GridPane.setConstraints(btnCancel, 4, 6);
        pane.getChildren().addAll(txtUserName, txtPassword, btnLogin, btnCancel);
        pane.setAlignment(Pos.CENTER);
        scene = new Scene(pane, 800, 600);
        btnLogin.setOnAction(e -> {

            Login login = new Login();
            UserImplementation user = new UserImplementation(txtUserName.getText(), txtPassword.getText());
            if (login.isValidUser(user)) {
                access = true;
                System.out.println("valid user");
                login.handleUsers(user);

            } else {
                System.out.println("User Not Valid");
            }
            txtUserName.clear();
            txtUserName.setPromptText("User Name");
            txtPassword.clear();
        });
        return scene;
    }
}
