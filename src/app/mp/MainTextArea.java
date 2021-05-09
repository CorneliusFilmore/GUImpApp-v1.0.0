package app.mp;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainTextArea extends JTextArea{

    LineBorder lineBorder = new LineBorder(Color.BLACK,2,true);
    TitledBorder centerBorder = BorderFactory.createTitledBorder(lineBorder,"Wynik Działania");

    MainTextArea() {
        centerBorder.setTitleFont(new Font("Arial",Font.BOLD,14));
        centerBorder.setTitleJustification(TitledBorder.CENTER);

        this.setEditable(false);
        this.setEnabled(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.setFont(new Font("Arial",Font.BOLD,14));
        this.setText("Wynik Twoje Działania to");
        this.setBorder(centerBorder);

        this.setVisible(true);
    }
}
