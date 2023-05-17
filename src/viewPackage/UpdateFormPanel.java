package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.*;
import modelPackage.Locality;
import modelPackage.Person;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UpdateFormPanel extends JPanel {
    private Container frameContainer;
    private JLabel identifier, lastName, firstName, middleName, street, streetNumber, birthdate, phoneNumber, identifierLocality;
    private JTextField lastNameField, firstNamefield, middleNameField, streetField, phoneNumberField, identifierField;
    private JCheckBox isDisabledBox;
    private JSpinner addDateField, streetNumberField;
    private JComboBox<Locality> identifierLocalityList;
    private SpinnerDateModel addDateFieldModel;
    private Date today;
    private JButton validateButton;
    private JPanel formPanel;
    private JPanel buttonsPanel;
    private ApplicationController controller;

    public UpdateFormPanel(Container frameContainer, Person person) {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());

        this.controller = new ApplicationController();


        identifier = new JLabel("Identifiant :");
        identifierField = new JTextField();
        identifierField.setText(person.getIdentifier().toString());
        identifierField.setEnabled(false);


        lastName = new JLabel("Nom :");
        lastNameField = new JTextField();
        lastNameField.setText(person.getLastName());


        firstName = new JLabel("Prénom :");
        firstNamefield = new JTextField();
        firstNamefield.setText(person.getFistName());


        middleName = new JLabel("Second prénom");
        middleNameField = new JTextField();
        if (person.getMiddleName() != null) {
            middleNameField.setText(person.getMiddleName());
        }

        street = new JLabel("Rue :");
        streetField = new JTextField();
        streetField.setText(person.getStreet());

        streetNumber = new JLabel("Numéro de rue :");
        streetNumberField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));
        streetNumberField.setValue(person.getStreetNumber());

        birthdate = new JLabel("Date de naissance :");
        today = new Date();

        addDateFieldModel = new SpinnerDateModel(today, null, null, Calendar.YEAR);
        addDateField = new JSpinner(addDateFieldModel);
        LocalDate localDate = person.getBirthDate();
        addDateField.setValue(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(addDateField, "dd/MM/yyyy");
        addDateField.setEditor(dateEditor);

        isDisabledBox = new JCheckBox("Handicape");
        isDisabledBox.setSelected(person.getIsDisable());
       

        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumberField = new JTextField();
        if (person.getPhoneNumber() != null) {
            phoneNumberField.setText(person.getPhoneNumber());
        }
        identifierLocality = new JLabel("Localité");
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


        // Panel //

        this.formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 5, 5));

        formPanel.add(identifier);
        formPanel.add(identifierField);
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
        formPanel.add(addDateField);
        formPanel.add(phoneNumber);
        formPanel.add(phoneNumberField);
        formPanel.add(identifierLocality);
        formPanel.add(identifierLocalityList);


        this.add(formPanel, BorderLayout.CENTER);

        //  Button //

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        validateButton = new JButton("Mettre à jour");
        validateButton.addActionListener(new ValidateListener());

        buttonsPanel.add(validateButton);

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
                        if (streetNumberField.getValue().toString().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Entrez un numéro de rue");
                        } else {

                            Person person;
                            Date date = (Date) addDateField.getValue();
                            LocalDate birthDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                            String middleName;
                            String phoneNumber;
                            middleName = (middleNameField.getText().isBlank() ? null : middleNameField.getText());
                            phoneNumber = (phoneNumberField.getText().isBlank() ? null : phoneNumberField.getText());
                            double streetNumber = Double.parseDouble(streetNumberField.getValue().toString());
                            int roundedStreetNumber = (int) Math.round(streetNumber);

                            person = new Person(Integer.parseInt(identifierField.getText()),firstNamefield.getText(), middleName,lastNameField.getText(), streetField.getText(), roundedStreetNumber, birthDate, isDisabledBox.isSelected(), phoneNumber ,((Locality) identifierLocalityList.getItemAt(identifierLocalityList.getSelectedIndex())).getIdentifier());
                            try {
                                controller.updatePerson(person);
                                JOptionPane.showMessageDialog(null, "Mise à jour effectuée avec succès");
                                frameContainer.removeAll();
                                frameContainer.revalidate();
                                frameContainer.repaint();
                                frameContainer.add(new ListingPanel(frameContainer));
                            } catch (UpdateDataException | ConnectionException exception) {
                                JOptionPane.showMessageDialog(null, exception.getMessage());
                            }

                        }
                    }
                }
            }
        }
    }


}
