package viewPackage;

import javax.swing.*;
import java.awt.*;

public class WelcomeMessage extends JPanel {
    private JLabel welcome;

    public WelcomeMessage(){
        welcome = new JLabel("<html><h1><strong>Bienvenue dans votre cinéma 'Chill and Movies'</strong></h1></br><p>Toute notre équipe vous souhaite de passer un agréable moment en notre compagnie<p></html>", SwingConstants.CENTER);
        this.add(new ThreadPanel(), BorderLayout.EAST);

        this.setLayout(new FlowLayout());
        this.add(welcome);


    }
}