package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.ResultsSearchLocality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsLocalityPanel extends JPanel {
    private JTable results;
    private JScrollPane scrollPane;
    private ApplicationController controller;
    private ArrayList<ResultsSearchLocality> resultsByLocality;
    private ListSelectionModel listSelect;
    private Container frameContainer;
    private JPanel buttonPanel;
    private JButton backButton;

    public ResultsLocalityPanel(String locality, Container frameContainer) {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        try {
            resultsByLocality = new ArrayList<>(controller.getPersonLocality(locality));

            LocalitySearchModel model = new LocalitySearchModel(resultsByLocality);

            results = new JTable(model);
            results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = results.getSelectionModel();
            scrollPane = new JScrollPane(results);

            this.add(scrollPane, BorderLayout.CENTER);
        } catch(GetDataException | ConnectionException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        //buttons//

        buttonPanel = new JPanel();

        backButton = new JButton("Retour");
        backButton.addActionListener(new ResultsLocalityPanel.BackListener());
        buttonPanel.add(backButton);

        this.add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);

    }
    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            frameContainer.add(new SearchingDatePanel(frameContainer), BorderLayout.CENTER);


        }
    }

}
