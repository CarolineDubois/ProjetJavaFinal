package viewPackage;

import exceptionPackage.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class SearchingPanel extends JPanel {
    private JSpinner dateSpinner;
    private JLabel labelStart;
    private JLabel labelEnd;
    private Date today;
    private JPanel selectionPanel;
    private JPanel buttonPanel;
    private JButton okButton;
    private Container frameContainer;
    private GregorianCalendar selectedDate;

    public SearchingPanel(Container frameContainer) {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());

    // ------------------- selectionPanel -------------------------

    selectionPanel = new JPanel();

    today = new Date();
    dateSpinner = new JSpinner(new SpinnerDateModel(today, null, today, Calendar.MONTH));
    JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(editor);

    labelStart = new JLabel("Entrez une date de début : ");
        selectionPanel.add(labelStart);

        selectionPanel.add(dateSpinner);

    labelStart = new JLabel("Entrez une date de fin : ");
        selectionPanel.add(labelStart);

        selectionPanel.add(dateSpinner);


        // ------------------ buttonPanel ------------------------------

        buttonPanel = new JPanel();

        okButton = new JButton("Ok");
        okButton.addActionListener(new ValidateListener());
        buttonPanel.add(okButton);

        this.add(selectionPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);


    }
    private class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selectedDate = new GregorianCalendar(
                    Integer.parseInt(new SimpleDateFormat("yyyy").format(dateSpinner.getValue())),
                    Integer.parseInt(new SimpleDateFormat("MM").format(dateSpinner.getValue())) - 1,
                    Integer.parseInt(new SimpleDateFormat("dd").format(dateSpinner.getValue()))
            );

            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            try {
                frameContainer.add(new ResultsPanel(selectedDate));
            } catch (ConnectionException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
    }

}
