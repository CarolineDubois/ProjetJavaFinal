package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectMoviePanel extends JPanel {
    private Container frameContainer;
    private ApplicationController controller;
    private JPanel selectionPanel;
    private JLabel movie;
    private JComboBox<Movie> movieSpinner;
    private JPanel buttonPanel;
    private JButton okButton, backButton;
    private String selectedMovie;

    public SelectMoviePanel(Container frameContainer)  {

        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        selectionPanel = new JPanel();
        movie = new JLabel("Sélectionnez un film : ");
        selectionPanel.add(movie);

        try {
            ArrayList<Movie> movieList = controller.getAllMovie();

            movieSpinner = new JComboBox(movieList.toArray());
            movieSpinner.setMaximumRowCount(3);
            movieSpinner.setSelectedItem(0);
            selectionPanel.add(movieSpinner);

        }
        catch (ConnectionException | GetDataException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();

        okButton = new JButton("Ok");
        okButton.addActionListener(new SelectMoviePanel.ValidateListener());
        buttonPanel.add(okButton);

        backButton = new JButton("Retour");
        backButton.addActionListener(new SelectMoviePanel.BackListener());
        buttonPanel.add(backButton);


        this.add(selectionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    private class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            selectedMovie = movieSpinner.getItemAt(movieSpinner.getSelectedIndex()).toString();

            frameContainer.add(new SelectSessionPanel(frameContainer,selectedMovie));

        }
    }
    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            frameContainer.add(new WelcomeMessage(), BorderLayout.CENTER);

        }
    }
}
