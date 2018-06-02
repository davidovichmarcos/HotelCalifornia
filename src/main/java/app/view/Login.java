package app.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login {


    private boolean success;

    public Login(int x, int y, String title, boolean isVisible) {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;
        final JLabel labelUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(labelUsername, cs);

        final JTextField textFieldUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(textFieldUsername, cs);

        JLabel labelPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(labelPassword, cs);

        final JTextField textFieldPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        panel.add(textFieldPassword, cs);

        JButton loginBtn = new JButton("Log in!");
        cs.gridx = 1;
        cs.gridy = 2;
        panel.add(loginBtn, cs);


        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Descomentar cuando este el metodo que valide los usuarios del archivo.
                /*if (){

                    success = true;
                }else {
                    textFieldPassword.setText("");
                    textFieldUsername.setText("");
                    success = false;
                }*/
            }
        });

        new WindowBase(x, y, title, isVisible, panel);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
