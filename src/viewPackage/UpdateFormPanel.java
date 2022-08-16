package View;

import controllerPackage.ApplicationController;
import exceptionPackage.*;
import modelPackage.Person;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateFormPanel extends JPanel {
    private static int NB_PEOPLE = 5;
    private static int NB_CATEGORIES = 4;
    private Container frameContainer;
    private JLabel identifier, lastName, firstName, middleName, street, streetNumber, birthdate, phoneNumber;
    private JTextField lastNameField, firstNamefield, middleNameField, streetField;
    private JCheckBox isDisabledBox, storageBox;
    private JSpinner DBAddingDateField, streetNumberField, phoneNumberField, identifierField;
    private JComboBox categoryList, personList;
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

        DBAddingDateField = new JSpinner(new SpinnerDateModel(dateField, null, today, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(DBAddingDateField, "dd-MM-yyyy");
        DBAddingDateField.setEditor(editor);
        birthdate.setHorizontalAlignment(SwingConstants.RIGHT);

        isDisabledBox = new JCheckBox("Handicape");
        isDisabledBox.setSelected(person.getIsDisable());
        isDisabledBox.addItemListener(new isBoundedListener());

        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumberField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));
        if (person.getPhoneNumber() == null) {
            phoneNumberField.setValue(person.getPhoneNumber());
        } else {
            phoneNumberField.setEnabled(false);
        }
        phoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);


        // ------------------------------ FormPanel --------------------------------------

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

        // ----------------------- ButtonPanel ----------------------------

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        validateButton = new JButton("Mettre à jour");
        //validateButton.addActionListener(new ValidateListener());

        buttonsPanel.add(validateButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
/*

    private class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Date date = (Date) DBAddingDateField.getValue();
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            person person;
            Integer storageTemperature;
            Double depositPrice;

            if(storageBox.isSelected())
                storageTemperature = Integer.parseInt(storageTemperatureField.getValue().toString());
            else
                storageTemperature = null;

            if(isBoundedBox.isSelected())
                depositPrice = Double.parseDouble(priceField.getValue().toString());
            else
                depositPrice = null;



            Pattern patternPerson = Pattern.compile("\\(.*\\)", Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = patternPerson.matcher(personList.getSelectedItem().toString());

            Pattern patternCategory = Pattern.compile("\\(.*\\)", Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = patternCategory.matcher(categoryList.getSelectedItem().toString());


            if(matcher1.find() && matcher2.find()) {
                try {
                    person = new person(
                            articleField.getText(),
                            Double.parseDouble(priceField.getValue().toString()),
                            isBoundedBox.isSelected(),
                            depositPrice,
                            storageTemperature,
                            calendar,
                            Integer.parseInt(matcher2.group(0).substring(1, 5)),
                            matcher1.group(0).substring(1, 7)
                    );
                    try {
                        controller.updateType(person);
                        JOptionPane.showMessageDialog(null, "Mise à jour effectuée avec succès");
                        frameContainer.removeAll();
                        frameContainer.revalidate();
                        frameContainer.repaint();
                        frameContainer.add(new ListingPanel(frameContainer));
                    }
                    catch (UpdateException | ConnectionException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                } catch (LabelException | PriceException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }


            } else {
                JOptionPane.showMessageDialog(null, new UpdateException().getMessage());
            }
        }
    }

}

