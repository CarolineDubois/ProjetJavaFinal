package viewPackage;

import modelPackage.Seat;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SeatModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Seat> contents;


    public SeatModel(ArrayList<Seat> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("Liste de sièges disponible");
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
        Seat results = contents.get(row);
        switch(column) {
            case 0 : return results.toString();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        return String.class;
    }

}
