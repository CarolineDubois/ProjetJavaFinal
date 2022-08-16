package viewPackage;

import exceptionPackage.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private Container mainContainer;
    private WelcomeMessage panelWelcome;
    private JMenuBar menuBar;
    private JMenu applicationMenu, inscriptionMenu, listing, recherche;
    private JMenuItem exit, formulaire, spectateurs, spectateurDate;
    public MainWindow () {
    // Appel au constructeur hérité en donnant un titre à la fenêtre //
        super("Cinéma");
        // Positionnement de la fenêtre à l’écran :
        setBounds(100, 100, 1200, 800);
    // Gestion de la fermeture de la fenêtre si clic sur icône X : //
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        } );


    // Récupération de la référence du conteneur de la fenêtre : //
        mainContainer = this.getContentPane();

    // ajout des panels //
        panelWelcome = new WelcomeMessage();
        mainContainer.setLayout((new BorderLayout()));
        mainContainer.add(panelWelcome, BorderLayout.CENTER);


    // menu //
        menuBar = new JMenuBar();
        setJMenuBar(menuBar); // pour ajouter barre de menus à la fenêtre

        applicationMenu = new JMenu("Application"); // crée un menu
        applicationMenu.setMnemonic('f'); // raccourci mnémonique : alt +F
        menuBar.add(applicationMenu); // ajoute le menu Fichier à la barre de menus

        exit = new JMenuItem("Exit"); // crée une option de menu
        //exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        applicationMenu.add(exit); // ajoute l'option de menu SOrtie au menu fichier
        exit.addActionListener(new ClosingListener());


        inscriptionMenu = new JMenu("Inscription");
        inscriptionMenu.setMnemonic('i');
        menuBar.add(inscriptionMenu);

        formulaire = new JMenuItem("Formulaire"); // crée une option de menu
        formulaire.addActionListener(new BuyListener());
        inscriptionMenu.add(formulaire); // ajoute l'option de menu SOrtie au menu fichier
        //inscription.addActionListener(new InscriptionListener());


        listing = new JMenu("Listing");
        listing.setMnemonic('l');
        menuBar.add(listing);


        spectateurs = new JMenuItem("Liste des spectateurs"); // crée une option de menu
        listing.add(spectateurs); // ajoute l'option de menu SOrtie au menu fichier
        spectateurs.addActionListener(new ListingListener());


        recherche = new JMenu("Recherche");
        recherche.setMnemonic('r');
        menuBar.add(recherche);

        spectateurDate = new JMenuItem("Spectateurs par date"); // crée une option de menu
        recherche.add(spectateurDate); // ajoute l'option de menu SOrtie au menu fichier
        //help.addActionListener(new HelpListener());
        recherche.addActionListener(new SearchListener());


        mainContainer.add(new ThreadPanel(), BorderLayout.EAST);

    // Affichage de la fenêtre : //
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
            mainContainer.add(new PanelRegister(mainContainer), BorderLayout.CENTER);
            setVisible(true);
        }

    }

    private class ListingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                mainContainer.removeAll();
                mainContainer.add(new ListingPanel(mainContainer), BorderLayout.CENTER);
            } catch (ConnectionException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            setVisible(true);
        }
    }

    private class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainContainer.removeAll();
            mainContainer.add(new SearchingPanel(mainContainer), BorderLayout.CENTER);
            setVisible(true);
        }
    }



}
