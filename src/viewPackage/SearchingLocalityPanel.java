package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Locality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchingLocalityPanel extends JPanel {
    private JComboBox<Locality> localitySpinner;
    private ApplicationController controller;
    private JLabel locality;
    private JPanel selectionPanel;
    private JPanel buttonPanel;
    private JButton okButton, backButton;
    private Container frameContainer;
    private String selectedLocality;

    public SearchingLocalityPanel (Container frameContainer){
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        // ------------------- selectionPanel -------------------------

        selectionPanel = new JPanel();
        locality = new JLabel("Choisissez une localité : ");
        selectionPanel.add(locality);

        try {
            ArrayList<Locality> localityList = controller.getAllLocality();

            localitySpinner = new JComboBox(localityList.toArray());
            localitySpinner.setMaximumRowCount(3);
            localitySpinner.setSelectedItem(0);
            selectionPanel.add(localitySpinner);
        }
        catch (GetDataException | ConnectionException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();

        okButton = new JButton("Ok");
        okButton.addActionListener(new SearchingLocalityPanel.ValidateListener());
        buttonPanel.add(okButton);
        backButton = new JButton("Retour");
        backButton.addActionListener(new SearchingLocalityPanel.BackListener());
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
            selectedLocality = localitySpinner.getItemAt(localitySpinner.getSelectedIndex()).getLabel();

            frameContainer.add(new ResultsLocalityPanel(selectedLocality, frameContainer));

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
