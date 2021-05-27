package app.mp;

import javax.swing.table.AbstractTableModel;

/**
 * Class that Contains the Table Model and their Methods
 */
public class TableModel extends AbstractTableModel {

    private final int countRowTable = 5;
    private final int countColumnTable = 5;
    private String[][] data = new String[countRowTable][countColumnTable];
    private String[] colName = {"1","2","3","4","5"};


    public TableModel() {
        super();
        setZeroTable();
    }

    @Override
    public Class getColumnClass(int index) {
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public int getColumnCount() {
        return countColumnTable;
    }
    public int getRowCount() {
        return countColumnTable;
    }
    public Object getValueAt(int row, int col) {
        Object object = (Object) data[row][col];
        return object;
    }
    public String getColumnName(int col) {
        return colName[col];
    }

    public void setValueAt(String value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row,col);

    }

    public void setZeroTable() {
        for(int i=0; i<countRowTable; i++)
            for(int j=0; j<countColumnTable; j++) {
                data[i][j] = new String("0");
            }
        fireTableDataChanged();
    }

}
