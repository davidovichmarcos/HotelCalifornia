package app.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WindowBase extends JFrame {
    public WindowBase(int x, int y, String title, boolean isVisible, JPanel panel) {
        setTitle(title);
        setSize(x, y);
        setVisible(isVisible);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}