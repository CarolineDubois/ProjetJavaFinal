package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.*;
import modelPackage.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListingPanel extends JPanel{

    private JTable list;
    private JScrollPane scrollPane;
    private ApplicationController controller;
    private JPanel buttonPanel;
    private JButton updateButton, deleteButton, backButton;
    private Container frameContainer;
    private ListSelectionModel listSelect;
    private ArrayList<Person> persons;

    public ListingPanel(Container frameContainer)  {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        controller = new ApplicationController();

        try {
            persons = controller.getAllPerson();
            AllPersonModel model = new AllPersonModel(persons);

            list = new JTable(model);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = list.getSelectionModel();
            scrollPane = new JScrollPane(list);

            this.add(scrollPane, BorderLayout.CENTER);
        }
        catch (GetDataException | ConnectionException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        // Button //

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        updateButton = new JButton("Mise à jour");
        updateButton.addActionListener(new UpdateListener());
        deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new DeleteListener());
        backButton = new JButton("Retour");
        backButton.addActionListener(new ListingPanel.BackListener());

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);


        this.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

        //  Methods //


    }
    private class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int indexSelectedLine = listSelect.getMinSelectionIndex();

            if (indexSelectedLine >= 0) {

                int response = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir modifier cette personne ?", "Modification", JOptionPane.YES_NO_OPTION);

                if (response == 0) {
                    Person person;
                    person = persons.get(indexSelectedLine);

                    frameContainer.removeAll();
                    frameContainer.revalidate();
                    frameContainer.repaint();
                    frameContainer.add(new UpdateFormPanel(frameContainer, person), BorderLayout.CENTER);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Sélectionnez une ligne à modifier");
            }
        }
    }

        private class DeleteListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                int indexSelectedLine = listSelect.getMinSelectionIndex();

                if (indexSelectedLine >= 0) {

                    int response = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer cette personne ?", "Suppression", JOptionPane.YES_NO_OPTION);

                    if (response == 0) {

                        Person person;
                        person = persons.get(indexSelectedLine);

                        try {
                            controller.deletePerson(person);
                            frameContainer.removeAll();
                            frameContainer.revalidate();
                            frameContainer.repaint();
                            frameContainer.add(new ListingPanel(frameContainer), BorderLayout.CENTER);

                        } catch (DeleteDataException | ConnectionException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Sélectionnez une ligne à supprimer");
                }
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


