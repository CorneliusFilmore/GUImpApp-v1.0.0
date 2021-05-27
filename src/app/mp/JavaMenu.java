package app.mp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Class that contains the JMenuBar
 */
public class JavaMenu extends JMenuBar {

    JMenu plik = new JMenu("Plik");
    JMenu widok = new JMenu("Widok");
    JMenu obliczenia = new JMenu("Obliczenia");
    JMenu pomoc = new JMenu("Pomoc");

    JMenuItem nowy = new JMenuItem("Nowy");
    JMenuItem otworz = new JMenuItem("Otwórz..");
    JMenuItem zapisz = new JMenuItem("Zapisz");
    JMenuItem zapiszJako = new JMenuItem("Zapisz jako...");
    JMenuItem zakoncz= new JMenuItem("Zakończ");

    JMenuItem cofnij = new JMenuItem("Cofnij");
    JMenuItem wytnij = new JMenuItem("Wytnij");
    JMenuItem kopiuj = new JMenuItem("Kopiuj");
    JMenuItem wklej = new JMenuItem("Wklej");
    JMenuItem usun = new JMenuItem("Usuń");

    JCheckBoxMenuItem schowajPasekNarzedzi = new JCheckBoxMenuItem("Schowaj Pasek Narzędzi");
    JCheckBoxMenuItem schowajPasekStatusu = new JCheckBoxMenuItem("Schowaj Pasek Statusu");
    JCheckBoxMenuItem schowajTaskPane = new JCheckBoxMenuItem("Schowaj Pasek po lewej");

    JMenuItem sumaElementow = new JMenuItem("Suma Elementów");
    JMenuItem sredniaElementow = new JMenuItem("Średnia Elementów");
    JMenuItem wartoscMaxMin = new JMenuItem("Wartość Max i Min");

    JMenuItem pomocInformacje = new JMenuItem("Pomoc");
    JMenuItem informacjeAutor = new JMenuItem("Informacje o Autorze");


    JavaMenu() {
        this.add(plik);
        this.add(widok);
        this.add(obliczenia);
        this.add(pomoc);
        this.setBackground(Color.lightGray);

        plik.add(nowy);
        plik.add(otworz);
        plik.add(zapisz);
        plik.add(zapiszJako);
        plik.add(zakoncz);

        widok.add(schowajPasekNarzedzi);
        widok.add(schowajPasekStatusu);
        widok.add(schowajTaskPane);

        obliczenia.add(sumaElementow);
        obliczenia.add(sredniaElementow);
        obliczenia.add(wartoscMaxMin);

        pomoc.add(pomocInformacje);
        pomoc.add(informacjeAutor);


        /**
         * Accelerators for JMenuBar: CTRL + Z etc.
         */
        nowy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        otworz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        zapisz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        zapiszJako.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));

        cofnij.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        wytnij.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        kopiuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        wklej.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        usun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,ActionEvent.CTRL_MASK));

        sumaElementow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        sredniaElementow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        wartoscMaxMin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));



    }


}
