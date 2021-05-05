package app.mp;

import javax.swing.*;
import java.awt.*;

public class TableInput extends JPanel {

    JLabel labelField = new JLabel("Wpisz wartość");
    JTextField textField = new JTextField();


    TableInput() {

        int size = 1000;
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        labelField.setHorizontalAlignment(SwingConstants.CENTER);
        labelField.setPreferredSize(new Dimension(size/3 ,20));
        labelField.setMaximumSize(new Dimension(size/3,20));

        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setPreferredSize(new Dimension(size ,20));
        textField.setMaximumSize(new Dimension(size,20));

        this.add(labelField);
        this.add(textField);

        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);

    }
}
