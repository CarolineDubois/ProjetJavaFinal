package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private Container mainContainer;
    private Container helpContainer;
    private WelcomeMessage panelWelcome;
    private BuyRegister panelRegister;
    private JMenuBar menuBar;
    private JMenu applicationMenu, studentMenu, infosMenu;
    private JMenuItem exit, inscription, iesn, help;
    public MainWindow () {
    // Appel au constructeur hérité en donnant un titre à la fenêtre
        super("Cinéma");
        // Positionnement de la fenêtre à l’écran :
        setBounds(100, 100, 500, 500);
    // Gestion de la fermeture de la fenêtre si clic sur icône X :
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        } );

// Récupération de la référence du conteneur de la fenêtre :
        mainContainer = this.getContentPane();


        panelWelcome = new WelcomeMessage();
        mainContainer.setLayout((new BorderLayout()));
        mainContainer.add(panelWelcome, BorderLayout.CENTER);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar); // pour ajouter barre de menus à la fenêtre

        applicationMenu = new JMenu("Application"); // crée un menu
        applicationMenu.setMnemonic('F'); // raccourci mnémonique : alt +F
        menuBar.add(applicationMenu); // ajoute le menu Fichier à la barre de menus

        exit = new JMenuItem("Exit"); // crée une option de menu
        //exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        applicationMenu.add(exit); // ajoute l'option de menu SOrtie au menu fichier
        //exit.addActionListener(new ClosingListener());


        studentMenu = new JMenu("Student");
        studentMenu.setMnemonic('m');
        menuBar.add(studentMenu);

        inscription = new JMenuItem("Inscription"); // crée une option de menu
        //inscription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        studentMenu.add(inscription); // ajoute l'option de menu SOrtie au menu fichier
        //inscription.addActionListener(new InscriptionListener());


        infosMenu = new JMenu("Infos");
        infosMenu.setMnemonic('m');
        menuBar.add(infosMenu);

        iesn = new JMenuItem("IESN"); // crée une option de menu
        //iesn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        iesn.addActionListener(new BuyListener());
        infosMenu.add(iesn); // ajoute l'option de menu SOrtie au menu fichier


        help = new JMenuItem("Help"); // crée une option de menu
        //help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        infosMenu.add(help); // ajoute l'option de menu SOrtie au menu fichier
        //help.addActionListener(new HelpListener());


// Affichage de la fenêtre :
        setVisible(true);


    }
    public class ClosingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class BuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContainer.removeAll();
            BuyRegister panelRegister = new BuyRegister();
            mainContainer.add(panelRegister);
            setVisible(true);

        }
    }


}
