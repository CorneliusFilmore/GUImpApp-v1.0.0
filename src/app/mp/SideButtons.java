package app.mp;

import javax.swing.*;
import java.awt.*;

public class SideButtons extends JPanel {

    //Add button on Right menu
    JButton addButton = new JButton("Dodaj");
    ImageIcon iconAdd = new ImageIcon("grafika/addIcon.jpg");

    JButton zeroButton = new JButton("Wyzeruj");
    ImageIcon iconZero = new ImageIcon("grafika/zeroIcon.jpg");

    JButton fillButton = new JButton("Wypełnij");
    ImageIcon iconFillIn = new ImageIcon("grafika/fillInIcon.jpg");

    JButton saveButton = new JButton("Zapisz");
    ImageIcon iconSave = new ImageIcon("grafika/saveIconImage.jpg");

    JButton countButton = new JButton("Oblicz");
    ImageIcon iconCount = new ImageIcon("grafika/countIcon.jpg");

    Dimension buttonDimension = new Dimension(120,40);

    String[] listData = {"Suma elementów","Średnia elementów","Wartość max i min"};
    JList sideList = new JList();
    ListModel listModel = new ListModel();

    boolean visibilitySideButtons = true;


    SideButtons() {

        //Set Up box Layout of the SideButtons Window
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(null);
        this.setVisible(visibilitySideButtons);

        sideList.setModel(listModel);
        for(int i=0;i<3;i++) {
            listModel.add(listData[i].toString());
        }

        addButton.setIcon(iconAdd);
        zeroButton.setIcon(iconZero);
        fillButton.setIcon(iconFillIn);
        saveButton.setIcon(iconSave);
        countButton.setIcon(iconCount);

        addButton.setBackground(Color.WHITE);
        zeroButton.setBackground(Color.WHITE);
        fillButton.setBackground(Color.WHITE);
        saveButton.setBackground(Color.WHITE);
        countButton.setBackground(Color.WHITE);

        addButton.setMaximumSize(buttonDimension);
        addButton.setPreferredSize(buttonDimension) ;

        zeroButton.setMaximumSize(buttonDimension);
        zeroButton.setPreferredSize(buttonDimension);

        fillButton.setMaximumSize(buttonDimension);
        fillButton.setPreferredSize(buttonDimension);

        saveButton.setMaximumSize(buttonDimension);
        saveButton.setPreferredSize(buttonDimension);

        countButton.setMaximumSize(buttonDimension);
        countButton.setPreferredSize(buttonDimension);

        sideList.setPreferredSize(new Dimension(120,58));
        sideList.setMaximumSize(new Dimension(120,58));

        sideList.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(addButton);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(zeroButton);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(fillButton);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(saveButton);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(sideList);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(countButton);

        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

    }
}
