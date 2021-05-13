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
    MainTextArea mainTextArea = new MainTextArea();
    CalendarField calendarField = new CalendarField();
    Dimension dimension = mainTable.getPreferredSize();


    public TableModel tableModel = new TableModel();

    MainTable() {

        double[] dataTable = new double[25];
        for(int i=0;i<5;i++) {
            for (int j=0;j<5;j++){
                dataTable[i+j] = Double.parseDouble(mainTable.getValueAt(i,j).toString());
            }
        }


       scrollPane.setPreferredSize(new Dimension(dimension.width, mainTable.getRowHeight() * (mainTable.getModel().getColumnCount() + 6)));

       mainTable.setCellSelectionEnabled(true);
       mainTable.setModel(tableModel);
       mainTable.getTableHeader().setReorderingAllowed(false);
       mainTable.getTableHeader().setResizingAllowed(false);
       mainTable.setRowHeight(33);
       mainTable.setFont(new Font("Arial",Font.PLAIN,14));

       this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

       tableSliders.setPreferredSize(new Dimension(1500,60));
       tableSliders.setMaximumSize(new Dimension(1500,60));

       mainTextArea.setPreferredSize(new Dimension(1000,180));
       mainTextArea.setMaximumSize(new Dimension(1000,180));

       tableSliders.textField.setPreferredSize(new Dimension(160,25));
       tableSliders.textField.setMaximumSize(new Dimension(160,25));

       tableSliders.labelField.setPreferredSize(new Dimension(110,30));
       tableSliders.labelField.setMaximumSize(new Dimension(110,30));

       tableSliders.rowLabel.setPreferredSize(new Dimension(120, 30));
       tableSliders.rowLabel.setMaximumSize(new Dimension(120, 30));

       tableSliders.rowSlider.setPreferredSize(new Dimension(170, 50));
       tableSliders.rowSlider.setMaximumSize(new Dimension(170, 50));

       tableSliders.columnLabel.setPreferredSize(new Dimension(120, 30));
       tableSliders.columnLabel.setMaximumSize(new Dimension(120, 30));

       tableSliders.columnSlider.setPreferredSize(new Dimension(170, 50));
       tableSliders.columnSlider.setMaximumSize(new Dimension(170, 50));


       this.add(tableSliders);
       this.add(scrollPane);
       this.add(calendarField);
       this.add(mainTextArea);




       this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
       this.setBackground(Color.LIGHT_GRAY);


    }
}




