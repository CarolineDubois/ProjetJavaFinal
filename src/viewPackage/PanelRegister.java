package viewPackage;
import exceptionPackage.AddDataException;
import exceptionPackage.ConnectionException;
import exceptionPackage.GetDataException;
import modelPackage.Locality;
import modelPackage.Person;
import controllerPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class PanelRegister extends JPanel {

    private Container frameContainer;
    private JLabel lastName, firstName, middleName, street, streetNumber, birthdate, phoneNumber, identifierLocality;
    private JTextField lastNameField, firstNamefield, middleNameField, streetField, phoneNumberField;
    private JCheckBox isDisabledBox;
    private JSpinner DBAddingDateField, streetNumberField;
    private JComboBox<Locality> identifierLocalityList;
    private Date today;
    private JButton validateButton, reinitialisationButton, backButton;
    private JPanel formPanel;
    private JPanel buttonsPanel;
    private ApplicationController controller;
    public PanelRegister(Container frameContainer) {

        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());
        this.controller = new ApplicationController();


        lastName = new JLabel("Nom : *");
        lastNameField = new JTextField();
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);
        lastName.setLocation(150, 100);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(150, 20);
        lastNameField.setLocation(300, 100);


        firstName = new JLabel("Prénom : *");
        firstNamefield = new JTextField();
        firstNamefield.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNamefield.setSize(150, 20);
        firstNamefield.setLocation(300, 150);
        firstName.setFont(new Font("Arial", Font.PLAIN, 20));
        firstName.setSize(150, 20);
        firstName.setLocation(150, 150);


        middleName = new JLabel("Second prénom");
        middleNameField = new JTextField();
        middleName.setFont(new Font("Arial", Font.PLAIN, 20));


        street = new JLabel("Rue : *");
        streetField = new JTextField();
        street.setFont(new Font("Arial", Font.PLAIN, 20));



        streetNumber = new JLabel("Numéro de rue : *");
        streetNumber.setFont(new Font("Arial", Font.PLAIN, 20));

        streetNumberField = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));


        birthdate = new JLabel("Date de naissance : *");
        birthdate.setFont(new Font("Arial", Font.PLAIN, 20));

        today = new Date();


        DBAddingDateField = new JSpinner(new SpinnerDateModel(today, null, today, Calendar.MONTH));
        DBAddingDateField.setFont(new Font("Arial", Font.PLAIN, 20));

        JSpinner.DateEditor editor = new JSpinner.DateEditor(DBAddingDateField, "dd-MM-yyyy");
        DBAddingDateField.setEditor(editor);


        isDisabledBox = new JCheckBox("Handicape *");
        isDisabledBox.setFont(new Font("Arial", Font.PLAIN, 20));


        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberField = new JTextField();
        //phoneNumberField = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));

        identifierLocality = new JLabel("Localité *");
        identifierLocality.setFont(new Font("Arial", Font.PLAIN, 20));

        try {
            ArrayList<Locality> localityList = controller.getAllLocality();

            identifierLocalityList = new JComboBox(localityList.toArray());
            identifierLocalityList.setMaximumRowCount(3);
            identifierLocalityList.setSelectedItem(0);
        }
        catch (GetDataException | ConnectionException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

        // ------------------------------ FormPanel --------------------------------------

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 20, 20));

        formPanel.add(lastName);
        formPanel.add(lastNameField);
        formPanel.add(firstName);
        formPanel.add(firstNamefield);
        formPanel.add(middleName);
        formPanel.add(middleNameField);
        formPanel.add(street);
        formPanel.add(streetField);
        formPanel.add(streetNumber);
        formPanel.add(streetNumberField);
        formPanel.add(isDisabledBox);
        formPanel.add(new JPanel());
        formPanel.add(birthdate);
        formPanel.add(DBAddingDateField);
        formPanel.add(phoneNumber);
        formPanel.add(phoneNumberField);
        formPanel.add(identifierLocality);
        formPanel.add(identifierLocalityList);


        this.add(formPanel, BorderLayout.CENTER);

        // ----------------------- ButtonPanel ----------------------------

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        validateButton = new JButton("Soumettre");
        validateButton.addActionListener(new ValidateListener());
        reinitialisationButton = new JButton("Réinisialiser");
        reinitialisationButton.addActionListener(new resetListener());
        backButton = new JButton("Retour");
        backButton.addActionListener(new BackListener());

        buttonsPanel.add(validateButton);
        buttonsPanel.add(reinitialisationButton);
        buttonsPanel.add(backButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

                private class ValidateListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        if (lastNameField.getText().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Entrez un nom");
                        } else {
                            if (firstNamefield.getText().isBlank()) {
                                JOptionPane.showMessageDialog(null, "Entrez un prénom");
                            } else {
                            if (streetField.getText().isBlank()) {
                                JOptionPane.showMessageDialog(null, "Entrez une rue");
                            } else {
                                if (streetNumberField.getValue().toString().equals("0")) {
                                    JOptionPane.showMessageDialog(null, "Entrez un numéro de rue");
                                } else {

                                    Person person;
                                    Date date = (Date) DBAddingDateField.getValue();
                                    LocalDate birthDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                                    String middleName;
                                    String phoneNumber;
                                    middleName = (middleNameField.getText().isBlank() ? null : middleNameField.getText());
                                    phoneNumber = (phoneNumberField.getText().isBlank() ? null : phoneNumberField.getText());

                                    person = new Person(firstNamefield.getText(), middleName,lastNameField.getText(), streetField.getText(), Integer.parseInt(streetNumberField.getValue().toString()), birthDate, isDisabledBox.isSelected(), phoneNumber ,((Locality) identifierLocalityList.getItemAt(identifierLocalityList.getSelectedIndex())).getIdentifier());
                                    System.out.println(person.toString());
                                    try {
                                        controller.addPerson(person);
                                        JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
                                        frameContainer.removeAll();
                                        frameContainer.revalidate();
                                        frameContainer.repaint();
                                        frameContainer.add(new PanelRegister(frameContainer));
                                    } catch (AddDataException | ConnectionException exception) {
                                        JOptionPane.showMessageDialog(null, exception.getMessage());
                                    }
                                }
                            }
                        }
                    }
                }
            }

    private class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frameContainer.removeAll();
            frameContainer.revalidate();
            frameContainer.repaint();
            frameContainer.add(new PanelRegister(frameContainer));

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

