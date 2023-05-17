package viewPackage;

import controllerPackage.ApplicationController;
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
    private ApplicationController controller;
    private JMenu applicationMenu, inscriptionMenu, listing, search, businessTask;
    private JMenuItem exit, formulaire, spectateurs, spectateurDate, locality, seats, menu;
    public MainWindow () {
    // Appel au constructeur hérité en donnant un titre à la fenêtre //
        super("Chill and Movies");
        // Positionnement de la fenêtre à l’écran :
        setBounds(100, 20, 1200, 800);
    // Gestion de la fermeture de la fenêtre si clic sur icône X : //
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                try {
                    controller = new ApplicationController();
                    controller.closeConnection();
                    System.exit(0);
                } catch (ConnectionException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }

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
        applicationMenu.setMnemonic('f');
        menuBar.add(applicationMenu);

        menu = new JMenuItem("Menu"); // crée une option de menu
        applicationMenu.add(menu);
        menu.addActionListener(new MenuListener());

        exit = new JMenuItem("Exit");
        applicationMenu.add(exit);
        exit.addActionListener(new ClosingListener());


        inscriptionMenu = new JMenu("Inscription");
        inscriptionMenu.setMnemonic('i');
        menuBar.add(inscriptionMenu);

        formulaire = new JMenuItem("Formulaire");
        formulaire.addActionListener(new FormListener());
        inscriptionMenu.add(formulaire);


        listing = new JMenu("Listing");
        listing.setMnemonic('l');
        menuBar.add(listing);


        spectateurs = new JMenuItem("Liste des spectateurs");
        listing.add(spectateurs);
        spectateurs.addActionListener(new ListingListener());


        search = new JMenu("Recherches");
        search.setMnemonic('r');
        menuBar.add(search);

        spectateurDate = new JMenuItem("Spectateurs par date");
        search.add(spectateurDate);
        spectateurDate.addActionListener(new SearchListenerDate());

        locality = new JMenuItem("Spectateurs par localité");
        search.add(locality);
        locality.addActionListener(new SearchListenerLocality());

        businessTask = new JMenu("Tache métier");
        menuBar.add(businessTask);

        seats = new JMenuItem("Places disponibles");
        businessTask.add(seats);
        seats.addActionListener(new BusinessListener());





    // Affichage de la fenêtre : //
        setVisible(true);


    }
    public class ClosingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controller = new ApplicationController();
                controller.closeConnection();
                System.exit(0);
            } catch (ConnectionException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }

    }

    public class FormListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainContainer.removeAll();
            mainContainer.add(new PanelRegister(mainContainer), BorderLayout.CENTER);

            setVisible(true);
        }

    }

    private class ListingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainContainer.removeAll();
            mainContainer.add(new ListingPanel(mainContainer), BorderLayout.CENTER);

            setVisible(true);
        }
    }

    private class SearchListenerDate implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainContainer.removeAll();
            mainContainer.add(new SearchingDatePanel(mainContainer), BorderLayout.CENTER);

            setVisible(true);
        }
    }

    private class SearchListenerLocality implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainContainer.removeAll();
            mainContainer.add(new SearchingLocalityPanel(mainContainer), BorderLayout.CENTER);

            setVisible(true);
        }
    }
    private class BusinessListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            mainContainer.removeAll();
            mainContainer.add(new SelectMoviePanel(mainContainer), BorderLayout.CENTER);

            setVisible(true);
        }
    }
    private class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainContainer.removeAll();
            mainContainer.add(new WelcomeMessage(), BorderLayout.CENTER);

        }
    }


    }




