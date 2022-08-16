package viewPackage;

import javax.swing.*;
import java.awt.*;

public class WelcomeMessage extends JPanel {
    private JLabel welcome;

    public WelcomeMessage(){
        welcome = new JLabel("<html><h1><strong>Bienvenue dans votre cinéma</strong></h1></html>", SwingConstants.CENTER);

        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(330, 120, 100, 300));
        this.add(welcome);
    }
}