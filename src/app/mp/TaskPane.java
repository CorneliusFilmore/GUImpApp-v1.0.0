package app.mp;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.TaskPaneGroupUI;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class TaskPane extends JPanel {
    JTaskPane taskPane = new JTaskPane();

    // calculation group
    JTaskPaneGroup calculationGroup = new JTaskPaneGroup();

    JLabel sumLabel = new JLabel("Suma");
    JLabel averageLabel = new JLabel("Średnia");
    JLabel maxLabel = new JLabel("Maksymalna wartość");
    JLabel minLabel = new JLabel("Minimalna wartość");

    //file group
    JTaskPaneGroup fileGroup = new JTaskPaneGroup();

    JLabel openLabel = new JLabel("Otwórz");
    JLabel saveLabel = new JLabel("Zapisz");
    JLabel saveAsLabel = new JLabel("Zapisz jako");
    JLabel printLabel = new JLabel("Drukuj");

    //help group
    JTaskPaneGroup helpGroup = new JTaskPaneGroup();

    JLabel helpLabel = new JLabel("Pomoc");
    JLabel authorLabel = new JLabel("Autor");

    TaskPaneGroupUI groupUI = new TaskPaneGroupUI();

    TaskPane() {
        UIManager.put("TaskPane.backround",Color.LIGHT_GRAY);

        //Label Backround
        sumLabel.setOpaque(true);
        averageLabel.setOpaque(true);
        maxLabel.setOpaque(true);
        minLabel.setOpaque(true);
        openLabel.setOpaque(true);
        saveLabel.setOpaque(true);
        saveAsLabel.setOpaque(true);
        printLabel.setOpaque(true);
        helpLabel.setOpaque(true);
        authorLabel.setOpaque(true);

        //calculation group text
        calculationGroup.setTitle("Obliczenia");
        calculationGroup.add(sumLabel);
        calculationGroup.add(averageLabel);
        calculationGroup.add(maxLabel);
        calculationGroup.add(minLabel);

        //file group text
        fileGroup.setTitle("Opcje");
        fileGroup.add(openLabel);
        fileGroup.add(saveLabel);
        fileGroup.add(saveAsLabel);
        fileGroup.add(printLabel);

        //help group
        helpGroup.setTitle("Pomoc");
        helpGroup.add(helpLabel);
        helpGroup.add(authorLabel);


        //Adding to task pane
        taskPane.add(calculationGroup);
        taskPane.add(fileGroup);
        taskPane.add(helpGroup);
        taskPane.setBackground(Color.LIGHT_GRAY);

        this.add(taskPane);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }
}
