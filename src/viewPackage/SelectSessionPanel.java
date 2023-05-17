package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectSessionPanel extends JPanel {
    private Container frameContainer;
    private ApplicationController controller;
    private JPanel selectionPanel;
    private JLabel session;
    private JComboBox<Session> sessionSpinner;
    private JPanel buttonPanel;
    private JButton okButton, backButton;
    private String selectedSession, selectedMovie;
    private Integer selectedSessionId;

    public SelectSessionPanel(Container frameContainer, String movie) {

        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());

        selectedMovie = movie;
        controller = new ApplicationController();
        selectionPanel = new JPanel();
        session = new JLabel("Sélectionnez une séance : ");
        selectionPanel.add(session);

        try {
            ArrayList<Session> sessionList = controller.getSessionByMovie(selectedMovie);

            sessionSpinner = new JComboBox(sessionList.toArray());
            sessionSpinner.setMaximumRowCount(3);
            sessionSpinner.setSelectedItem(0);
            selectionPanel.add(sessionSpinner);

        }
        catch (ConnectionException | GetDataException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();

        okButton = new JButton("Ok");
        okButton.addActionListener(new SelectSessionPanel.ValidateListener());
        buttonPanel.add(okButton);

        backButton = new JButton("Retour");
        backButton.addActionListener(new SelectSessionPanel.BackListener());
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
            selectedSession = sessionSpinner.getItemAt(sessionSpinner.getSelectedIndex()).toString();
            selectedSessionId = sessionSpinner.getItemAt(sessionSpinner.getSelectedIndex()).getNumber();

            frameContainer.add(new SelectSeatPanel(frameContainer,selectedSession, selectedMovie, selectedSessionId));

        }


    }
    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            frameContainer.add(new SelectMoviePanel(frameContainer), BorderLayout.CENTER);
        }
    }
}
