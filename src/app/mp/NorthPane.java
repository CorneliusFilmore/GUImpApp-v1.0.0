package app.mp;

import javax.swing.*;
import java.awt.*;

public class NorthPane extends JToolBar {

    JButton firstButton = new JButton();
    ImageIcon iconSave = new ImageIcon("grafika/saveIconImage.jpg");

    JButton secondButton = new JButton();
    ImageIcon iconPrint = new ImageIcon("grafika/printerIcon.jpg");

    JButton thirdButton = new JButton();
    ImageIcon iconExit = new ImageIcon("grafika/exitIcon.jpg");

    JButton fourthButton = new JButton();
    ImageIcon iconAdd = new ImageIcon("grafika/addIcon.jpg");

    JButton fifthButton = new JButton();
    ImageIcon iconZero = new ImageIcon("grafika/zeroIcon.jpg");

    JButton sixthButton = new JButton();
    ImageIcon iconFillIn = new ImageIcon("grafika/fillInIcon.jpg");

    JButton seventhButton = new JButton();
    ImageIcon iconSum = new ImageIcon("grafika/sumIcon.jpg");

    JButton eighthButton = new JButton();
    ImageIcon iconAverage = new ImageIcon("grafika/averageIcon.jpg");

    JButton ninthButton = new JButton();
    ImageIcon iconMin = new ImageIcon("grafika/minIcon.jpg");

    JButton tenthButton = new JButton();
    ImageIcon iconMax = new ImageIcon("grafika/maxIcon.jpg");

    JButton eleventhButton = new JButton();
    ImageIcon iconHelp = new ImageIcon("grafika/helpIcon.jpg");

    JButton twelfthButton = new JButton();
    ImageIcon iconAuthor = new ImageIcon("grafika/authorIcon.jpg");




    public NorthPane() {
       this.setFont(new Font("Segoe Ui Light", Font.PLAIN,12));
       this.setVisible(true);
       this.setFloatable(false);


       // Add save button with icon
       firstButton.setIcon(iconSave);
       firstButton.setToolTipText("Zapisz");
       this.add(firstButton);

        // Add printer button with icon
       secondButton.setIcon(iconPrint);
       secondButton.setToolTipText("Drukuj");
       this.add(secondButton);

        // Add Exit button with icon
        thirdButton.setIcon(iconExit);
        thirdButton.setToolTipText("Wyjdz");
        this.add(thirdButton);

        // Add Separator
        this.addSeparator(new Dimension(25,1));

        // Add ADD button with icon
        fourthButton.setIcon(iconAdd);
        fourthButton.setToolTipText("Dodaj");
        this.add(fourthButton);

        // Add zero button with icon
        fifthButton.setIcon(iconZero);
        fifthButton.setToolTipText("Wyzeruj");
        this.add(fifthButton);

        // Add Fill button with icon
        sixthButton.setIcon(iconFillIn);
        sixthButton.setToolTipText("Wypełnij");
        this.add(sixthButton);

        // Add Separator
        this.addSeparator(new Dimension(25,1));

        // Add Sum button with icon
        seventhButton.setIcon(iconSum);
        seventhButton.setToolTipText("Suma");
        this.add(seventhButton);

        // Add Average button with icon
        eighthButton.setIcon(iconAverage);
        eighthButton.setToolTipText("Średnia");
        this.add(eighthButton);

        // Add Min button with icon
        ninthButton.setIcon(iconMin);
        ninthButton.setToolTipText("Minimum");
        this.add(ninthButton);

        // Add Max button with icon
        tenthButton.setIcon(iconMax);
        tenthButton.setToolTipText("Maksimum");
        this.add(tenthButton);

        // Add Separator
        this.addSeparator(new Dimension(25,1));

        // Add Help button with icon
        eleventhButton.setIcon(iconHelp);
        eleventhButton.setToolTipText("Pomoc");
        this.add(eleventhButton);

        // Add Help button with icon
        eleventhButton.setIcon(iconHelp);
        eleventhButton.setToolTipText("Pomoc");
        this.add(eleventhButton);

        // Add Author button with icon
        twelfthButton.setIcon(iconAuthor);
        twelfthButton.setToolTipText("Autor");
        this.add(twelfthButton);


    }
}
