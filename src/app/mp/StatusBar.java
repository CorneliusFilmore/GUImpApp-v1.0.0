package app.mp;

import javax.swing.*;
import java.awt.*;


public class StatusBar extends JPanel {

    JLabel infoBarLabel = new JLabel("Info");
    JLabel statusBarLabel = new JLabel("Status");

    JTextField infoBar = new JTextField("Info");
    JTextField statusBar = new JTextField("Status aplilacji");

    Dimension labelDimension = new Dimension(70,20);
    Dimension barDimension = new Dimension(440,20);

    boolean statusBarVisibility = true;

    StatusBar() {
        this.setVisible(statusBarVisibility);

        this.setBackground(Color.GRAY);
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        infoBar.setEditable(false);
        statusBar.setEditable(false);

        /**
         * Label size and center text
         */

        infoBarLabel.setPreferredSize(labelDimension);
        infoBarLabel.setMaximumSize(labelDimension);
        infoBarLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusBarLabel.setPreferredSize(labelDimension);
        statusBarLabel.setMaximumSize(labelDimension);
        statusBarLabel.setHorizontalAlignment(SwingConstants.CENTER);

        /**
         * Set Bar Size
         */

        infoBar.setPreferredSize(barDimension);
        infoBar.setMaximumSize(barDimension);

        statusBar.setPreferredSize(barDimension);
        statusBar.setMaximumSize(barDimension);

        /**
         * Add Components to the panel
         */

        this.add(infoBarLabel);
        this.add(infoBar);
        this.add(statusBarLabel);
        this.add(statusBar);
    }
}
