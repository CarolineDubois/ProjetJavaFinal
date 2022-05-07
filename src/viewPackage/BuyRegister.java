package viewPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BuyRegister
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel lastName;
    private JTextField tLastName;
    private JLabel firstName;
    private JTextField tFirstName;
    private JLabel isDisable;
    private JRadioButton disable;
    private JRadioButton notDisable;
    private ButtonGroup gengp;
    private JLabel birthDate;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel street;
    private JTextArea tStreet;
    private JLabel numberStreet;
    private JTextArea tNumberStreet;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1955", "1956", "1957", "1958",
            "1959","1960", "1961", "1962", "1963",
            "1964","1965", "1966", "1967", "1968",
            "1969", "1970", "1971", "1972", "1973",
            "1974","1975", "1976", "1977", "1978",
            "1979","1980", "1981", "1982", "1983",
            "1984","1985", "1986", "1987", "1988",
            "1989","1990", "1991", "1992", "1993",
            "1994", "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    // constructor, to initialize the components
    // with default values.
    public BuyRegister()
    {
        setTitle("Inscription");
        setBounds(300, 90, 500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Formulaire d'inscription");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        lastName = new JLabel("Nom");
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);
        lastName.setLocation(100, 100);
        c.add(lastName);

        tLastName = new JTextField();
        tLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        tLastName.setSize(190, 20);
        tLastName.setLocation(200, 100);
        c.add(tLastName);

        firstName = new JLabel("Prénom");
        firstName.setFont(new Font("Arial", Font.PLAIN, 20));
        firstName.setSize(100, 20);
        firstName.setLocation(100, 150);
        c.add(firstName);

        tFirstName = new JTextField();
        tFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        tFirstName.setSize(150, 20);
        tFirstName.setLocation(200, 150);
        c.add(tFirstName);

        isDisable = new JLabel("Est invalide ?");
        isDisable.setFont(new Font("Arial", Font.PLAIN, 20));
        isDisable.setSize(100, 20);
        isDisable.setLocation(100, 200);
        c.add(isDisable);

        notDisable = new JRadioButton("Non");
        notDisable.setFont(new Font("Arial", Font.PLAIN, 15));
        notDisable.setSelected(true);
        notDisable.setSize(75, 20);
        notDisable.setLocation(200, 200);
        c.add(notDisable);

        disable = new JRadioButton("Oui");
        disable.setFont(new Font("Arial", Font.PLAIN, 15));
        disable.setSelected(false);
        disable.setSize(80, 20);
        disable.setLocation(275, 200);
        c.add(disable);

        gengp = new ButtonGroup();
        gengp.add(disable);
        gengp.add(notDisable);

        birthDate = new JLabel("Date of birth");
        birthDate.setFont(new Font("Arial", Font.PLAIN, 20));
        birthDate.setSize(100, 20);
        birthDate.setLocation(100, 250);
        c.add(birthDate);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);

        street = new JLabel("Adresse");
        street.setFont(new Font("Arial", Font.PLAIN, 20));
        street.setSize(100, 20);
        street.setLocation(100, 300);
        c.add(street);

        tStreet = new JTextArea();
        tStreet.setFont(new Font("Arial", Font.PLAIN, 15));
        tStreet.setSize(200, 40);
        tStreet.setLocation(200, 300);
        tStreet.setLineWrap(true);
        c.add(tStreet);

        numberStreet = new JLabel("Numéro");
        numberStreet.setFont(new Font("Arial", Font.PLAIN, 20));
        numberStreet.setSize(100, 20);
        numberStreet.setLocation(100, 350);
        c.add(numberStreet);

        tNumberStreet = new JTextArea();
        tNumberStreet.setFont(new Font("Arial", Font.PLAIN, 15));
        tNumberStreet.setSize(50, 30);
        tNumberStreet.setLocation(200, 350);
        tNumberStreet.setLineWrap(true);
        c.add(tNumberStreet);


        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        /*tout = new JTextArea();
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

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
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
                        + (String)date.getSelectedItem()
                        + "/" + (String)month.getSelectedItem()
                        + "/" + (String)year.getSelectedItem()
                        + "\n";

                String data3 = "Address : " + tStreet.getText();
                tout.setText(data + data1 + data2 + data3);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
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
    }
}

// Driver Code
class Registration {

    public static void main(String[] args) throws Exception
    {
        BuyRegister f = new BuyRegister();
    }
}