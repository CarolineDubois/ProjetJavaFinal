package viewPackage;
import exceptionPackage.AddPersonException;
import modelPackage.Person;
import controllerPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class PanelRegister
        extends JFrame {

    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"1955", "1956", "1957", "1958",
            "1959", "1960", "1961", "1962", "1963",
            "1964", "1965", "1966", "1967", "1968",
            "1969", "1970", "1971", "1972", "1973",
            "1974", "1975", "1976", "1977", "1978",
            "1979", "1980", "1981", "1982", "1983",
            "1984", "1985", "1986", "1987", "1988",
            "1989", "1990", "1991", "1992", "1993",
            "1994", "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019"};

    // constructor, to initialize the components
    // with default values.
    private Container frameContainer;
    private JLabel title,identifier, lastName, firstName, middleName, street, streetNumber, birthdate, phoneNumber;
    private JTextField lastNameField, firstNamefield, middleNameField, streetField;
    private JCheckBox isDisabledBox, storageBox;
    private JSpinner DBAddingDateField, streetNumberField, identifierField, phoneNumberField;
    private JComboBox categoryList, personList;
    private Date today;
    private JButton validateButton, reinitialisationButton;
    private JPanel formPanel;
    private JPanel buttonsPanel;
    private ApplicationController controller;
    public PanelRegister(Container frameContainer) {
        setTitle("Inscription");
        setBounds(300, 90, 625, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        Person person;


        this.frameContainer = this.frameContainer;
        this.setLayout(new BorderLayout());

        this.controller = new ApplicationController();


        identifier = new JLabel("Identifiant :");
        identifierField = new JSpinner(new SpinnerNumberModel(0.0, 0.0, null, 0.1));



        lastName = new JLabel("Nom :");
        lastNameField = new JTextField();
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);
        lastName.setLocation(150, 100);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(150, 20);
        lastNameField.setLocation(300, 100);


        firstName = new JLabel("Prénom :");
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


        street = new JLabel("Rue :");
        streetField = new JTextField();
        street.setFont(new Font("Arial", Font.PLAIN, 20));



        streetNumber = new JLabel("Numéro de rue :");
        streetNumber.setFont(new Font("Arial", Font.PLAIN, 20));

        streetNumberField = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));


        birthdate = new JLabel("Date de naissance :");
        birthdate.setFont(new Font("Arial", Font.PLAIN, 20));

        today = new Date();


        DBAddingDateField = new JSpinner(new SpinnerDateModel(today, null, today, Calendar.MONTH));
        DBAddingDateField.setFont(new Font("Arial", Font.PLAIN, 20));

        JSpinner.DateEditor editor = new JSpinner.DateEditor(DBAddingDateField, "dd-MM-yyyy");
        DBAddingDateField.setEditor(editor);


        isDisabledBox = new JCheckBox("Handicape");
        isDisabledBox.setFont(new Font("Arial", Font.PLAIN, 20));


        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberField = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));



        // ------------------------------ FormPanel --------------------------------------

        this.formPanel = new JPanel();
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


        this.add(formPanel, BorderLayout.CENTER);

        // ----------------------- ButtonPanel ----------------------------

        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        validateButton = new JButton("Soumettre");
        validateButton.addActionListener(new ValidateListener());
        reinitialisationButton = new JButton("Reset");
        reinitialisationButton.addActionListener(new reListener());

        buttonsPanel.add(validateButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

                private class ValidateListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        if (lastNameField.getText().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Entrez un nom");
                        } else {
                            Person person;
                            Date date = (Date) DBAddingDateField.getValue();
                            GregorianCalendar calendar = new GregorianCalendar();
                            calendar.setTime(date);

                            try {
                                person = new Person(1, firstNamefield.getText(), lastNameField.getText(), middleNameField.getText(), street.getText(), Integer.parseInt(streetNumberField.getValue().toString()), calendar, Integer.parseInt(phoneNumberField.getValue().toString()), isDisabledBox.isSelected(), 6060);
                                try {
                                    controller.addPerson(person);
                                    JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
                                    frameContainer.removeAll();
                                    frameContainer.revalidate();
                                    frameContainer.repaint();
                                    frameContainer.add(new PanelRegister(frameContainer));
                                } catch (AddPersonException exception) {
                                    JOptionPane.showMessageDialog(null, exception.getMessage());
                                }


                            } catch (NumberFormatException numberFormatException) {
                                numberFormatException.printStackTrace();
                            } catch (HeadlessException headlessException) {
                                headlessException.printStackTrace();
                            }
                        }
                    }
                }

            private class reListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    frameContainer.removeAll();
                    frameContainer.revalidate();
                    frameContainer.repaint();
                    frameContainer.add(new PanelRegister(frameContainer));
                }
            }
}

