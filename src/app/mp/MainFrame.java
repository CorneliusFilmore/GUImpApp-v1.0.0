package app.mp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Class which contains the main window frame
 */

public class MainFrame extends JFrame {


    protected void exitFrame() {
        int frameInt = JOptionPane.showOptionDialog(
                this,
                "Czy chcesz zamknąć aplikację?",
                "Uwaga",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[] {"Tak", "Nie"},
                "Tak"
        );

        if(frameInt == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

    MainFrame() {
        this.setSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(null);
        this.setTitle("Java GUI app v 1.0.2");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(true);
        this.setBackground(Color.LIGHT_GRAY);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitFrame();
            }
        });


    }
}
