package modelPackage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class Dates extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<ResultsSearchDate> contents;


    public Dates(ArrayList<ResultsSearchDate> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("Identifiant de la personne");
        columnNames.add("Prénom de la personne");
        columnNames.add("Nom de la personne");
        columnNames.add("Date du début");
        columnNames.add("Date de fin");
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
            case 3 : return results.getStartDate().getTime();
            case 4 : return results.getEndDate().getTime();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        Class c;
        switch(column) {
            case 1 :
            case 2 :
                c = Integer.class; break;
            case 3 :
            case 4 : c = Date.class; break;
            default: c = String.class; break;
        }
        return c;
    }

}
