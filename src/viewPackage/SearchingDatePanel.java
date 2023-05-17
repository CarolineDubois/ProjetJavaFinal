package viewPackage;

import controllerPackage.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class SearchingDatePanel extends JPanel {
    private JSpinner dateSpinnerStart, dateSpinnerEnd;
    private ApplicationController controller;
    private JLabel startDate;
    private JLabel endDate;
    private Date today;
    private JPanel selectionPanel;
    private JPanel buttonPanel;
    private JButton okButton, backButton;
    private Container frameContainer;
    private LocalDate selectedDateStart, selectedDateEnd;

    public SearchingDatePanel(Container frameContainer)  {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();


        // ------------------- selectionPanel -------------------------

        selectionPanel = new JPanel();

        today = new Date();


        dateSpinnerStart = new JSpinner(new SpinnerDateModel(today, null, today, Calendar.MONTH));
        dateSpinnerStart.setFont(new Font("Arial", Font.PLAIN, 20));

        JSpinner.DateEditor editorStart = new JSpinner.DateEditor(dateSpinnerStart, "dd-MM-yyyy");
        dateSpinnerStart.setEditor(editorStart);

        dateSpinnerEnd = new JSpinner(new SpinnerDateModel(today, null, today, Calendar.MONTH));
        dateSpinnerEnd.setFont(new Font("Arial", Font.PLAIN, 20));

        JSpinner.DateEditor editorEnd = new JSpinner.DateEditor(dateSpinnerEnd, "dd-MM-yyyy");
        dateSpinnerEnd.setEditor(editorEnd);

        startDate = new JLabel("Entrez une date de début : ");
        selectionPanel.add(startDate);
        selectionPanel.add(dateSpinnerStart);

        endDate = new JLabel("Entrez une date de fin : ");
        selectionPanel.add(endDate);
        selectionPanel.add(dateSpinnerEnd);


        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();

        okButton = new JButton("Ok");
        okButton.addActionListener(new ValidateListener());
        buttonPanel.add(okButton);
        backButton = new JButton("Retour");
        backButton.addActionListener(new BackListener());
        buttonPanel.add(backButton);


        this.add(selectionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);


    }
    private class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selectedDateStart = ((java.util.Date) dateSpinnerStart.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            selectedDateEnd = ((java.util.Date) dateSpinnerEnd.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();

            frameContainer.add(new ResultsDatePanel(selectedDateStart, selectedDateEnd, frameContainer));

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
