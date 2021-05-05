package app.mp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MainTable extends JPanel {

    String[] columnNames = {"A","B","C","D","E"};
    Object[][] numberData = {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };

    JTable mainTable = new JTable(numberData, columnNames);

    JScrollPane scrollPane = new JScrollPane(mainTable);

    TableSliders tableSliders = new TableSliders();

    TableInput tableInput = new TableInput();

    MainTextField mainTextField = new MainTextField();

    Dimension dimension = mainTable.getPreferredSize();


    DefaultTableModel tableModel = new DefaultTableModel(numberData,columnNames) {
        @Override
        public Class getColumnClass(int index) {
            return Integer.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };


    MainTable() {
       scrollPane.setPreferredSize(new Dimension(dimension.width, mainTable.getRowHeight() * (mainTable.getModel().getColumnCount() + 6)));

       mainTable.setCellSelectionEnabled(true);
       mainTable.setModel(tableModel);
       mainTable.getTableHeader().setReorderingAllowed(false);
       mainTable.getTableHeader().setResizingAllowed(false);
       mainTable.setRowHeight(19);

       this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

       tableSliders.setPreferredSize(new Dimension(1000,50));
       tableSliders.setMaximumSize(new Dimension(1000,50));

       mainTextField.setPreferredSize(new Dimension(1000,180));
       mainTextField.setMaximumSize(new Dimension(1000,180));

       tableInput.setPreferredSize(new Dimension(1000,40));
       tableInput.setMaximumSize(new Dimension(1000,40));

       this.add(tableSliders);
       this.add(scrollPane);
       this.add(tableInput);
       this.add(mainTextField);


        tableSliders.rowSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                tableSliders.rowLabel.setText("Wiersz numer = " + tableSliders.rowSlider.getValue());

                if (e.getSource() == tableSliders.rowSlider) {
                    mainTable.changeSelection(tableSliders.rowSlider.getValue() - 1,tableSliders.columnSlider.getValue() - 1,false,false);
                }
            }
        });

        tableSliders.columnSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                tableSliders.columnLabel.setText("Kolumna numer = " + tableSliders.columnSlider.getValue());

                if (e.getSource() == tableSliders.columnSlider) {
                    mainTable.changeSelection(tableSliders.rowSlider.getValue() - 1,tableSliders.columnSlider.getValue() - 1,false,false);
                }
            }
        });

        mainTable.changeSelection(tableSliders.rowSlider.getValue() - 1, tableSliders.columnSlider.getValue() - 1, true,false);

       this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       this.setBackground(Color.LIGHT_GRAY);
    }
}




