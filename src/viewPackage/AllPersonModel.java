package viewPackage;

import modelPackage.Person;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;


public class AllPersonModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Person> contents;

    public AllPersonModel(ArrayList<Person> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("Identifiant");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Second prénom");
        columnNames.add("Rue");
        columnNames.add("Numéro");
        columnNames.add("Date de naissance");
        columnNames.add("Handicape");
        columnNames.add("Numéro de téléphone");
        columnNames.add("Localité");
        this.contents = contents;
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Person person = contents.get(row);
        switch(column) {
            case 0 : return person.getIdentifier();
            case 1 : return person.getLastName();
            case 2 : return person.getFistName();
            case 3 : if (person.getMiddleName() != null)
                        return person.getMiddleName();
                    else
                        return null;
            case 4 : return person.getStreet();
            case 5 : return person.getStreetNumber();
            case 6 : return person.getBirthDate();
            case 7 : return person.getIsDisable();
            case 8 : if (person.getPhoneNumber() != null)
                        return person.getPhoneNumber();
                    else
                        return null;
            case 9 : return person.getIdentifierLocality();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        Class c;
        switch(column) {
            case 0 :
            case 5 :
            case 9 :
            case 8 :
                c = Integer.class; break;

            case 7 : c = Boolean.class; break;

            case 6 : c = LocalDate.class; break;
            default: c = String.class; break;
        }
        return c;
    }

}
