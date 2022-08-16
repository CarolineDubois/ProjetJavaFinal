package viewPackage;
import exceptionPackage.AddPersonException;
import exceptionPackage.ConnectionException;
import modelPackage.Person;
import controllerPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class BuyRegister
        extends JFrame {

    // Components of the Form
   /*private Container c;
    private JLabel title, lastName, firstName, middleName, isDisable, street, phoneNumber, birthDate, numberStreet, res;;
    private JTextField tLastName, tFirstName, tMiddleName;
    private JRadioButton disable;
    private JRadioButton notDisable;
    private ButtonGroup gengp;
    private JComboBox date, month, year;
    private JTextArea tStreet, tNumberStreet, tPhoneNumber;
    private JCheckBox term;
    private JButton sub, reset;
    private JTextArea tout;

    private JTextArea resadd;

    */

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
    public BuyRegister(Container frameContainer) {
        setTitle("Inscription");
        setBounds(300, 90, 625, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        /*

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Formulaire d'inscription");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(400, 30);
        title.setLocation(150, 30);
        c.add(title);

        lastName = new JLabel("Nom*");
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);
        lastName.setLocation(150, 100);
        c.add(lastName);

        tLastName = new JTextField();
        tLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        tLastName.setSize(150, 20);
        tLastName.setLocation(300, 100);
        c.add(tLastName);

        firstName = new JLabel("Prénom*");
        firstName.setFont(new Font("Arial", Font.PLAIN, 20));
        firstName.setSize(150, 20);
        firstName.setLocation(150, 150);
        c.add(firstName);

        tFirstName = new JTextField();
        tFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        tFirstName.setSize(150, 20);
        tFirstName.setLocation(300, 150);
        c.add(tFirstName);

        middleName = new JLabel("Second Prénom");
        middleName.setFont(new Font("Arial", Font.PLAIN, 20));
        middleName.setSize(150, 20);
        middleName.setLocation(150, 200);
        c.add(middleName);

        tMiddleName = new JTextField();
        tMiddleName.setFont(new Font("Arial", Font.PLAIN, 15));
        tMiddleName.setSize(150, 20);
        tMiddleName.setLocation(300, 200);
        c.add(tMiddleName);

        isDisable = new JLabel("Est invalide ?*");
        isDisable.setFont(new Font("Arial", Font.PLAIN, 20));
        isDisable.setSize(150, 20);
        isDisable.setLocation(150, 250);
        c.add(isDisable);

        notDisable = new JRadioButton("Non");
        notDisable.setFont(new Font("Arial", Font.PLAIN, 15));
        notDisable.setSelected(true);
        notDisable.setSize(75, 20);
        notDisable.setLocation(300, 250);
        c.add(notDisable);

        disable = new JRadioButton("Oui");
        disable.setFont(new Font("Arial", Font.PLAIN, 15));
        disable.setSelected(false);
        disable.setSize(80, 20);
        disable.setLocation(375, 250);
        c.add(disable);

        gengp = new ButtonGroup();
        gengp.add(disable);
        gengp.add(notDisable);

        birthDate = new JLabel("Date of birth*");
        birthDate.setFont(new Font("Arial", Font.PLAIN, 20));
        birthDate.setSize(150, 20);
        birthDate.setLocation(150, 300);
        c.add(birthDate);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(300, 300);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(350, 300);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(420, 300);
        c.add(year);

        street = new JLabel("Adresse*");
        street.setFont(new Font("Arial", Font.PLAIN, 20));
        street.setSize(100, 20);
        street.setLocation(150, 350);
        c.add(street);

        tStreet = new JTextArea();
        tStreet.setFont(new Font("Arial", Font.PLAIN, 15));
        tStreet.setSize(200, 40);
        tStreet.setLocation(300, 350);
        tStreet.setLineWrap(true);
        c.add(tStreet);

        numberStreet = new JLabel("Numéro*");
        numberStreet.setFont(new Font("Arial", Font.PLAIN, 20));
        numberStreet.setSize(100, 20);
        numberStreet.setLocation(150, 400);
        c.add(numberStreet);

        tNumberStreet = new JTextArea();
        tNumberStreet.setFont(new Font("Arial", Font.PLAIN, 15));
        tNumberStreet.setSize(50, 30);
        tNumberStreet.setLocation(300, 400);
        tNumberStreet.setLineWrap(true);
        c.add(tNumberStreet);

        phoneNumber = new JLabel("Numéro de téléphone*");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumber.setSize(150, 20);
        phoneNumber.setLocation(150, 450);
        c.add(phoneNumber);

        tPhoneNumber = new JTextArea();
        tPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        tPhoneNumber.setSize(50, 30);
        tPhoneNumber.setLocation(300, 450);
        tPhoneNumber.setLineWrap(true);
        c.add(tPhoneNumber);


        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(200, 500);
        sub.addActionListener(new ValidateListener());
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(320, 500);
        c.add(reset);

        setVisible(true);
        */
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

        //isDisabledBox.addItemListener(new isBoundedListener());

        phoneNumber = new JLabel("Numéro de téléphone");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneNumberField = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));



        // ------------------------------ FormPanel --------------------------------------

        this.formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 20, 20));

        //formPanel.add(identifier);
        //formPanel.add(identifierField);
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
                                    frameContainer.add(new BuyRegister(frameContainer));
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
                    frameContainer.add(new BuyRegister(frameContainer));
                }
            }
}

/*

// Driver Code
class Registration {

    public static void main(String[] args) throws Exception
    {
        BuyRegister f = new BuyRegister(frameContainer);
    }
}

 tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);*/




// method actionPerformed()
// to get the action performed
// by the user and act accordingly
    /*
    private class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sub) {
                if (term.isSelected()) {
                    String data1;
                    String data
                            = "Prénom : "
                            + firstName.getText() + "\n"
                            + "Nom : "
                            + lastName.getText() + "\n";
                    if (disable.isSelected())
                        data1 = "Est invalide : non "
                                + "\n";
                    else
                        data1 = "Est invalide : oui"
                                + "\n";
                    String data2
                            = "DOB : "
                            + (String) date.getSelectedItem()
                            + "/" + (String) month.getSelectedItem()
                            + "/" + (String) year.getSelectedItem()
                            + "\n";

                    String data3 = "Address : " + tStreet.getText();
                    tout.setText(data + data1 + data2 + data3);
                    tout.setEditable(false);
                    res.setText("Registration Successfully..");
                } else {
                    tout.setText("");
                    resadd.setText("");
                    res.setText("Please accept the"
                            + " terms & conditions..");
                }
            } else if (e.getSource() == reset) {
                String def = "";
                tFirstName.setText(def);
                tLastName.setText(def);
                tStreet.setText(def);
                res.setText(def);
                tout.setText(def);
                term.setSelected(false);
                date.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);
                resadd.setText(def);
            }
            */