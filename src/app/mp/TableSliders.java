package app.mp;

import javax.swing.*;
import java.awt.*;

public class TableSliders extends JPanel {

    JSlider rowSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
    JLabel rowLabel = new JLabel();

    JSlider columnSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
    JLabel columnLabel = new JLabel();

    JLabel labelField = new JLabel("Wpisz wartość");
    JTextField textField = new JTextField();

    Dimension sliderDimension = new Dimension(150,50);
    Dimension textFieldDimension = new Dimension(300,25);


    TableSliders() {

        rowSlider.setPaintLabels(true);
        rowSlider.setPaintTicks(true);
        rowSlider.setPaintLabels(true);
        rowSlider.setMajorTickSpacing(1);
        rowSlider.setMinorTickSpacing(1);
        rowSlider.setBackground(Color.LIGHT_GRAY);

        columnSlider.setPaintLabels(true);
        columnSlider.setPaintTicks(true);
        columnSlider.setPaintLabels(true);
        columnSlider.setMajorTickSpacing(1);
        columnSlider.setMinorTickSpacing(1);
        columnSlider.setBackground(Color.LIGHT_GRAY);

        rowLabel.setFont(new Font(null, Font.BOLD, 12));
        rowLabel.setText("Wiersz numer = " + rowSlider.getValue());
        rowLabel.setHorizontalAlignment(SwingConstants.CENTER);

        columnLabel.setFont(new Font(null, Font.BOLD, 12));
        columnLabel.setText("Kolumna Numer = " + columnSlider.getValue());
        columnLabel.setHorizontalAlignment(SwingConstants.CENTER);

        labelField.setFont(new Font(null, Font.BOLD, 12));
        labelField.setText("Wpisz wartość:");
        labelField.setHorizontalAlignment(SwingConstants.CENTER);

        textField.setFont(new Font(null, Font.BOLD, 12));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        rowLabel.setPreferredSize(sliderDimension);
        rowLabel.setMaximumSize(sliderDimension);

        rowSlider.setPreferredSize(sliderDimension);
        rowSlider.setMaximumSize(sliderDimension);

        columnLabel.setPreferredSize(sliderDimension);
        columnLabel.setMaximumSize(sliderDimension);

        columnSlider.setPreferredSize(sliderDimension);
        columnSlider.setMaximumSize(sliderDimension);

        labelField.setPreferredSize(sliderDimension);
        labelField.setMaximumSize(sliderDimension);

        textField.setPreferredSize(textFieldDimension);
        textField.setMaximumSize(textFieldDimension);


        this.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        this.add(rowLabel);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(rowSlider);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(columnLabel);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(columnSlider);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(labelField);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(textField);


        //JPanel settings

        this.setBackground(Color.LIGHT_GRAY);

    }
}
