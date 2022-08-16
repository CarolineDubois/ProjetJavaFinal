package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.ConnectionException;
import exceptionPackage.PersonException;
import modelPackage.Dates;
import modelPackage.ResultsSearchDate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResultsPanel extends JPanel {
    private JTable results;
    private JScrollPane scrollPane;
    private ApplicationController controller;
    private ArrayList<ResultsSearchDate> resultsByDate;
    private ListSelectionModel listSelect;

    public ResultsPanel(GregorianCalendar selectedDate) throws ConnectionException {
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        try {
            resultsByDate = new ArrayList<>(controller.getPersonDate(selectedDate));

            Dates model = new Dates(resultsByDate);

            results = new JTable(model);
            results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = results.getSelectionModel();
            scrollPane = new JScrollPane(results);

            this.add(scrollPane, BorderLayout.CENTER);
        } catch(PersonException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
