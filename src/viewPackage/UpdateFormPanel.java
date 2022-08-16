package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.*;
import modelPackage.Person;


import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class UpdateFormPanel extends JPanel {
    private Container frameContainer;
    private JLabel identifier, lastName, firstName, middleName, street, streetNumber, birthdate, phoneNumber;
    private JTextField lastNameField, firstNamefield, middleNameField, streetField;
    private JCheckBox isDisabledBox;
    private JSpinner AddDateField, streetNumberField, phoneNumberField, identifierField;
    private Date today;
    private JButton validateButton;
    private JPanel formPanel;
    private JPanel buttonsPanel;
    private ApplicationController controller;

    public UpdateFormPanel(Container frameContainer, Person person) throws ConnectionException {
        this.frameContainer = frameContainer;
        this.setLayout(new BorderLayout());

        this.controller = new ApplicationController();


        identifier = new JLabel("Identifiant :");
        identifierField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));
        identifierField.setValue(person.getIdentifier());
        identifier.setHorizontalAlignment(SwingConstants.RIGHT);


        lastName = new JLabel("Nom :");
        lastNameField = new JTextField();
        lastNameField.setText(person.getLastName());
        lastNameField.setEnabled(false);
        lastName.setHorizontalAlignment(SwingConstants.RIGHT);


        firstName = new JLabel("Prénom :");
        firstNamefield = new JTextField();
        firstNamefield.setText(person.getFistName());
        firstNamefield.setEnabled(false);
        firstName.setHorizontalAlignment(SwingConstants.RIGHT);


        middleName = new JLabel("Second prénom");
        middleNameField = new JTextField();
        if (person.getMiddleName() == null) {
            middleNameField.setEnabled(false);
        } else {
            middleNameField.setText(person.getMiddleName());
        }
        middleName.setHorizontalAlignment(SwingConstants.RIGHT);

        street = new JLabel("Rue :");
        streetField = new JTextField();
        streetField.setText(person.getFistName());
        streetField.setEnabled(false);
        street.setHorizontalAlignment(SwingConstants.RIGHT);

        streetNumber = new JLabel("Numéro de rue :");
        streetNumberField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));
        identifierField.setValue(person.getStreetNumber());
        streetNumber.setHorizontalAlignment(SwingConstants.RIGHT);

        birthdate = new JLabel("Date de naissance :");
        today = new Date();

        Date dateField = person.getBirthDate().getTime();

        AddDateField = new JSpinner(new SpinnerDateModel(dateField, null, today, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(AddDateField, "dd-MM-yyyy");
        AddDateField.setEditor(editor);
        birthdate.setHorizontalAlignment(SwingConstants.RIGHT);

        isDisabledBox = new JCheckBox("Handicape");
        isDisabledBox.setSelected(person.getIsDisable());
       

        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumberField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));
        if (person.getPhoneNumber() == null) {
            phoneNumberField.setValue(person.getPhoneNumber());
        } else {
            phoneNumberField.setEnabled(false);
        }
        phoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);


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
        formPanel.add(birthdate);
        formPanel.add(phoneNumber);
        formPanel.add(phoneNumberField);


        this.add(formPanel, BorderLayout.CENTER);

        //  Button //

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        validateButton = new JButton("Mettre à jour");

        buttonsPanel.add(validateButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
