package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.*;
import modelPackage.AllPersonModel;
import modelPackage.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListingPanel extends JPanel{

    private JTable list;
    private JScrollPane scrollPane;
    private ApplicationController controller;
    private JPanel buttonPanel;
    private JButton updateButton, deleteButton;
    private Container frameContainer;
    private ListSelectionModel listSelect;

    public ListingPanel(Container frameContainer) throws ConnectionException {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        try {

            ArrayList<Person> person = controller.getAllPerson();
            AllPersonModel model = new AllPersonModel(person);

            list = new JTable(model);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = list.getSelectionModel();
            scrollPane = new JScrollPane(list);


            this.add(scrollPane, BorderLayout.CENTER);
        }
        catch (PersonException | AllPersonException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        // Button //

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        updateButton = new JButton("Mise à jour");
        updateButton.addActionListener(new UpdateListener());
        deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new DeleteListener());

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

        //  Methods //


    }

    public Person recovery(int indexSelectedLine)  {
        Date date = (Date) list.getValueAt(indexSelectedLine, 5);
        GregorianCalendar birthdate = new GregorianCalendar();
        birthdate.setTime(date);
        Person person;
        String middleName;
        Integer phoneNumber;

        if(list.getValueAt(indexSelectedLine, 3) != null)
            middleName =  list.getValueAt(indexSelectedLine, 3).toString();
        else
            middleName = null;

        if(list.getValueAt(indexSelectedLine, 8) != null)
            phoneNumber = Integer.parseInt(list.getValueAt(indexSelectedLine, 8).toString());
        else
            phoneNumber = null;

        person = new Person(
                Integer.parseInt(list.getValueAt(indexSelectedLine, 0).toString()),
                list.getValueAt(indexSelectedLine, 1).toString(),
                list.getValueAt(indexSelectedLine, 2).toString(),
                middleName,
                list.getValueAt(indexSelectedLine, 4).toString(),
                Integer.parseInt(list.getValueAt(indexSelectedLine, 5).toString()),
                birthdate,
                phoneNumber,
                Boolean.parseBoolean(list.getValueAt(indexSelectedLine, 7).toString()),
                Integer.parseInt(list.getValueAt(indexSelectedLine, 9).toString())


        );

        return person;

    }

    private class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int indiceLigneSelect = listSelect.getMinSelectionIndex();

            if(indiceLigneSelect != -1) {

                int reponse = JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir modifier cette personne ?", "Modification", JOptionPane.YES_NO_OPTION);

                if(reponse == 0) {
                    Person person = null;
                    person = recovery(indiceLigneSelect);

                    try {
                        controller.updatePerson(person);
                        frameContainer.removeAll();
                        frameContainer.revalidate();
                        frameContainer.repaint();
                        frameContainer.add(new UpdateFormPanel(frameContainer, person), BorderLayout.CENTER);

                    } catch (UpdateException | ConnectionException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Sélectionnez une ligne à modifier");
            }
        }
    }

    private class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int indexSelectedLine = listSelect.getMinSelectionIndex();

            if(indexSelectedLine != -1) {

                int reponse = JOptionPane.showConfirmDialog(null,"Etes-vous sûr de vouloir supprimer cette personne ?", "Suppression", JOptionPane.YES_NO_OPTION);

                if(reponse == 0) {

                    Person person = null;
                    try {
                        person = recovery(indexSelectedLine);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    try {
                        controller.deletePerson(person);
                        frameContainer.removeAll();
                        frameContainer.revalidate();
                        frameContainer.repaint();
                        frameContainer.add(new ListingPanel(frameContainer), BorderLayout.CENTER);

                    } catch (DeleteException | ConnectionException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Sélectionnez une ligne à supprimer");
            }


        }
    }


}
