package viewPackage;

import javax.swing.*;
import java.awt.*;

public class WelcomeMessage extends JPanel {
    private JLabel welcome;

    public WelcomeMessage(){
        welcome = new JLabel("Welcome");

        this.setLayout(new FlowLayout());

        this.add(welcome);
    }
}