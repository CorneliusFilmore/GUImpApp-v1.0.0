package app.mp;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;

import javax.swing.*;
import java.awt.*;

public class TaskPane extends JPanel {
    JTaskPane taskPane = new JTaskPane();
    boolean taskPaneVisibility = true;

    // calculation group
    JTaskPaneGroup calculationGroup = new JTaskPaneGroup();

    JButton sumButton = new JButton("Suma");
    JButton averageButton = new JButton("Średnia");
    JButton maxButton = new JButton("Maksymalna wartość");
    JButton minButton = new JButton("Minimalna wartość");

    //file group
    JTaskPaneGroup fileGroup = new JTaskPaneGroup();

    JButton openButton = new JButton("Otwórz");
    JButton saveButton = new JButton("Zapisz");
    JButton saveAsButton = new JButton("Zapisz jako");
    JButton printButton = new JButton("Drukuj");

    //help group
    JTaskPaneGroup helpGroup = new JTaskPaneGroup();

    JButton helpButton = new JButton("Pomoc");
    JButton authorButton = new JButton("Autor");

    TaskPane() {

        //Button disable border and color
        sumButton.setBorderPainted(false);
        sumButton.setContentAreaFilled(false);
        sumButton.setFocusPainted(true);
        sumButton.setOpaque(true);
        sumButton.setHorizontalAlignment(SwingConstants.LEFT);


        averageButton.setBorderPainted(false);
        averageButton.setContentAreaFilled(false);
        averageButton.setFocusPainted(true);
        averageButton.setOpaque(true);
        averageButton.setHorizontalAlignment(SwingConstants.LEFT);


        maxButton.setBorderPainted(false);
        maxButton.setContentAreaFilled(false);
        maxButton.setFocusPainted(true);
        maxButton.setOpaque(true);
        maxButton.setHorizontalAlignment(SwingConstants.LEFT);

        minButton.setBorderPainted(false);
        minButton.setContentAreaFilled(false);
        minButton.setFocusPainted(true);
        minButton.setOpaque(true);
        minButton.setHorizontalAlignment(SwingConstants.LEFT);

        openButton.setBorderPainted(false);
        openButton.setContentAreaFilled(false);
        openButton.setFocusPainted(true);
        openButton.setOpaque(true);
        openButton.setHorizontalAlignment(SwingConstants.LEFT);

        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setFocusPainted(true);
        saveButton.setOpaque(true);
        saveButton.setHorizontalAlignment(SwingConstants.LEFT);

        saveAsButton.setBorderPainted(false);
        saveAsButton.setContentAreaFilled(false);
        saveAsButton.setFocusPainted(true);
        saveAsButton.setOpaque(true);
        saveAsButton.setHorizontalAlignment(SwingConstants.LEFT);

        printButton.setBorderPainted(false);
        printButton.setContentAreaFilled(false);
        printButton.setFocusPainted(true);
        printButton.setOpaque(true);
        printButton.setHorizontalAlignment(SwingConstants.LEFT);

        helpButton.setBorderPainted(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setFocusPainted(true);
        helpButton.setOpaque(true);
        helpButton.setHorizontalAlignment(SwingConstants.LEFT);

        authorButton.setBorderPainted(false);
        authorButton.setContentAreaFilled(false);
        authorButton.setFocusPainted(true);
        authorButton.setOpaque(true);
        authorButton.setHorizontalAlignment(SwingConstants.LEFT);

        //calculation group text
        calculationGroup.setTitle("Obliczenia");
        calculationGroup.add(sumButton);
        calculationGroup.add(averageButton);
        calculationGroup.add(maxButton);
        calculationGroup.add(minButton);

        //file group text
        fileGroup.setTitle("Opcje");
        fileGroup.add(openButton);
        fileGroup.add(saveButton);
        fileGroup.add(saveAsButton);
        fileGroup.add(printButton);

        //help group
        helpGroup.setTitle("Pomoc");
        helpGroup.add(helpButton);
        helpGroup.add(authorButton);


        //Adding to task pane
        taskPane.add(calculationGroup);
        taskPane.add(fileGroup);
        taskPane.add(helpGroup);
        taskPane.setBackground(Color.LIGHT_GRAY);

        this.add(taskPane);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(taskPaneVisibility);
    }
}
