package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectSeatPanel extends JPanel {
    private Container frameContainer;
    private ApplicationController controller;
    private JPanel selectionPanel;
    private JLabel seatTable, seatFree, seatBusy;
    private JTable seatSpinner;
    private JPanel buttonPanel;
    private JButton backButton;
    private String selectedSeat, selectedSession, selectedMovie;
    private Integer selectedSessionId;
    private ListSelectionModel listSelect;
    private JScrollPane scrollPane;
    private ArrayList<Seat> seatFreeList;
    private Integer seatBusyList;


    public SelectSeatPanel(Container frameContainer,String session, String movie, Integer sessionId){
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        selectionPanel = new JPanel();
        selectedSession = session;
        selectedMovie = movie;
        selectedSessionId = sessionId;
        try {
            seatFreeList = controller.getFreeSeat(sessionId);

            SeatModel model = new SeatModel(seatFreeList);

            seatSpinner = new JTable(model);
            seatSpinner.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = seatSpinner.getSelectionModel();
            scrollPane = new JScrollPane(seatSpinner);

            selectionPanel.add(scrollPane, BorderLayout.CENTER);

            seatBusyList = controller.getBusySeat(selectedSessionId);


        } catch (ConnectionException | GetDataException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }


        seatBusy = new JLabel("Nombre de places occupés : " + seatBusyList + "\n");
        selectionPanel.add(seatBusy);



        seatFree = new JLabel("Nombre de places disponibles : "  + seatFreeList.size() + "\n" );
        selectionPanel.add(seatFree);



        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();
        backButton = new JButton("Retour");
        backButton.addActionListener(new SelectSeatPanel.BackListener());
        buttonPanel.add(backButton);

        this.add(selectionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

    }
    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            frameContainer.add(new SelectSessionPanel(frameContainer, selectedMovie), BorderLayout.CENTER);
        }
    }


}
