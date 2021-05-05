package app.mp;

import javax.swing.*;
import java.awt.*;

public class TableSliders extends JPanel {

    JSlider rowSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
    JLabel rowLabel = new JLabel();

    JSlider columnSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
    JLabel columnLabel = new JLabel();

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

        this.setLayout(new GridLayout(1, 4, 0, 5));
        this.add(rowLabel);
        this.add(rowSlider);
        this.add(columnLabel);
        this.add(columnSlider);

        //JPanel settings
        this.setPreferredSize(new Dimension(10, 87));
        this.setBackground(Color.LIGHT_GRAY);

    }
}
