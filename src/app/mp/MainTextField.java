package app.mp;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainTextField extends JTextField{

    LineBorder lineBorder = new LineBorder(Color.BLACK,2,true);
    TitledBorder centerBorder = BorderFactory.createTitledBorder(lineBorder,"Wynik Działania");

    MainTextField() {
        centerBorder.setTitleFont(new Font("Arial",Font.BOLD,14));
        centerBorder.setTitleJustification(TitledBorder.CENTER);

        this.setEditable(false);
        this.setEnabled(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.setFont(new Font("Arial",Font.BOLD,12));
        this.setText("Wynik Twoje Działania to");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBorder(centerBorder);

        this.setVisible(true);
    }
}
