package viewPackage;

import modelPackage.ResultsSearchDate;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dates extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResultsSearchDate> contents;


    public Dates(ArrayList<ResultsSearchDate> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("Identifiant de la personne");
        columnNames.add("Prénom de la personne");
        columnNames.add("Nom de la personne");
        columnNames.add("Date de la séance");
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
        ResultsSearchDate results = contents.get(row);
        switch(column) {
            case 0 : return results.getIdentifier();
            case 1 : return results.getFirstName();
            case 2 : return results.getLastName();
            case 3 : return results.getDateSession();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        Class c;
        switch(column) {
            case 1 :
            case 2 :
                c = String.class; break;
            case 3 : c = LocalDate.class; break;
            default: c = Integer.class; break;
        }
        return c;
    }

}
