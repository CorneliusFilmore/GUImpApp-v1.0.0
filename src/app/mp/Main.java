package app.mp;

import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.*;


public class Main extends JFrame {

    static StatusBar statusBar = new StatusBar();

    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        NorthPane northPane = new NorthPane();
        JavaMenu javaMenu = new JavaMenu();
        SideButtons sideButtons = new SideButtons();
        MainTable mainTable = new MainTable();




        frame.setJMenuBar(javaMenu);
        frame.setLayout(new BorderLayout());
        frame.add(northPane, BorderLayout.NORTH);
        frame.add(mainTable, BorderLayout.CENTER);
        frame.add(sideButtons, BorderLayout.EAST);
        frame.add(statusBar, BorderLayout.PAGE_END);


        /**
         *  Interface scaling
         */

        frame.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                // maximized window
                if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {

                    mainTable.mainTable.setRowHeight(frame.getWidth() / 16);

                    mainTable.mainTable.setFont(new Font(null, Font.PLAIN, 24));

                    mainTable.tableSliders.rowLabel.setFont(new Font(null, Font.BOLD, 18));
                    mainTable.tableSliders.columnLabel.setFont(new Font(null, Font.BOLD, 18));

                    mainTable.mainTextField.centerBorder.setTitleFont(new Font(null, Font.BOLD, 25));
                    mainTable.mainTextField.setFont(new Font(null, Font.BOLD, 25));

                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 18));
                    mainTable.tableSliders.labelField.setFont(new Font(null, Font.BOLD, 18));

                    mainTable.tableSliders.setPreferredSize(new Dimension(frame.getWidth(), 100));
                    mainTable.tableSliders.setMaximumSize(new Dimension(frame.getWidth(), 100));

                    mainTable.tableSliders.rowLabel.setPreferredSize(new Dimension(frame.getWidth()/6, 50));
                    mainTable.tableSliders.rowLabel.setMaximumSize(new Dimension(frame.getWidth()/6, 50));

                    mainTable.tableSliders.rowSlider.setPreferredSize(new Dimension(frame.getWidth()/6, 50));
                    mainTable.tableSliders.rowSlider.setMaximumSize(new Dimension(frame.getWidth()/6, 50));

                    mainTable.tableSliders.columnLabel.setPreferredSize(new Dimension(frame.getWidth()/6, 50));
                    mainTable.tableSliders.columnLabel.setMaximumSize(new Dimension(frame.getWidth()/6, 50));

                    mainTable.tableSliders.columnSlider.setPreferredSize(new Dimension(frame.getWidth()/6, 50));
                    mainTable.tableSliders.columnSlider.setMaximumSize(new Dimension(frame.getWidth()/6, 50));

                    mainTable.tableSliders.labelField.setPreferredSize(new Dimension(frame.getWidth()/6, 50));
                    mainTable.tableSliders.labelField.setMaximumSize(new Dimension(frame.getWidth()/6, 50));

                    mainTable.tableSliders.textField.setPreferredSize(new Dimension(frame.getWidth()/6, 30));
                    mainTable.tableSliders.textField.setMaximumSize(new Dimension(frame.getWidth()/6, 30));

                    mainTable.mainTextField.setPreferredSize(new Dimension(frame.getWidth(), 200));
                    mainTable.mainTextField.setMaximumSize(new Dimension(frame.getWidth(), 200));


                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 40));
                    statusBar.setMaximumSize(new Dimension(frame.getWidth(), 40));

                    statusBar.statusBar.setPreferredSize(new Dimension(frame.getWidth() / 2, 30));
                    statusBar.statusBar.setMaximumSize(new Dimension(frame.getWidth() / 2, 30));

                    statusBar.infoBar.setPreferredSize(new Dimension(frame.getWidth() / 2, 30));
                    statusBar.infoBar.setMaximumSize(new Dimension(frame.getWidth() / 2, 30));


                }
                // minimized window
                else {
                    mainTable.mainTable.setRowHeight(39);

                    mainTable.tableSliders.rowLabel.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.columnLabel.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.mainTextField.centerBorder.setTitleFont(new Font(null, Font.BOLD, 12));
                    mainTable.mainTextField.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.labelField.setFont(new Font(null, Font.BOLD, 12));

                    mainTable.mainTable.setFont(new Font(null, Font.PLAIN, 12));

                    mainTable.tableSliders.setPreferredSize(new Dimension(frame.getWidth(), 60));
                    mainTable.tableSliders.setMaximumSize(new Dimension(frame.getWidth(), 60));

                    mainTable.mainTextField.setPreferredSize(new Dimension(frame.getWidth(), 180));
                    mainTable.mainTextField.setMaximumSize(new Dimension(frame.getWidth(), 180));

                    mainTable.tableSliders.rowLabel.setPreferredSize(new Dimension(frame.getWidth()/5, 30));
                    mainTable.tableSliders.rowLabel.setMaximumSize(new Dimension(frame.getWidth()/5, 30));

                    mainTable.tableSliders.rowSlider.setPreferredSize(new Dimension(frame.getWidth()/2, 50));
                    mainTable.tableSliders.rowSlider.setMaximumSize(new Dimension(frame.getWidth()/2, 50));

                    mainTable.tableSliders.columnLabel.setPreferredSize(new Dimension(frame.getWidth()/5, 30));
                    mainTable.tableSliders.columnLabel.setMaximumSize(new Dimension(frame.getWidth()/5, 30));

                    mainTable.tableSliders.columnSlider.setPreferredSize(new Dimension(frame.getWidth()/2, 50));
                    mainTable.tableSliders.columnSlider.setMaximumSize(new Dimension(frame.getWidth()/2, 50));

                    mainTable.tableSliders.labelField.setPreferredSize(new Dimension(frame.getWidth()/2, 30));
                    mainTable.tableSliders.labelField.setMaximumSize(new Dimension(frame.getWidth()/2, 30));

                    mainTable.tableSliders.labelField.setPreferredSize(new Dimension(frame.getWidth()/6, 40));
                    mainTable.tableSliders.labelField.setMaximumSize(new Dimension(frame.getWidth()/6, 40));

                    mainTable.tableSliders.textField.setPreferredSize(new Dimension(frame.getWidth()/2, 25));
                    mainTable.tableSliders.textField.setMaximumSize(new Dimension(frame.getWidth()/2, 25));

                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 30));
                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 30));

                }
            }
        });

        /**
         *                    JavaMenu Action Listeners
         */

        /**
         * Creating a new empty table
         */
        javaMenu.nowy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int newInt = JOptionPane.showOptionDialog(
                        frame,
                        "Czy napewno chcesz utworzyć nowy plik?",
                        "Uwaga",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        new String[]{"Tak", "Nie"},
                        "Tak"
                );

                if (newInt == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            mainTable.mainTable.getModel().setValueAt(0, i, j);
                        }
                    }

                    statusBar.infoBar.setText("UTWORZONO");
                    statusBar.statusBar.setText("Utworzono pusty plik");

                }
            }
        });

        /**
         * Open a file
         */
        javaMenu.otworz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\Cornelius Filmore\\IdeaProjects\\GUIappMP\\Zapisane pliki"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt", "text");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setFileFilter(filter);

                int elementCounter = 0;
                int lineCounter = 0;
                Scanner sc = null;

                int openFile = fileChooser.showOpenDialog(frame);

                if(openFile == JFileChooser.APPROVE_OPTION) {

                    try {
                        sc = new Scanner(fileChooser.getSelectedFile());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                   while(sc.hasNextDouble()){
                        Double ns = sc.nextDouble();
                        elementCounter++;
                    }
                    sc.close();

                    try {
                        sc = new Scanner(fileChooser.getSelectedFile());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    while(sc.hasNextLine()){
                        String ns = sc.nextLine();
                        lineCounter++;
                    }
                    sc.close();


                    try {
                        sc = new Scanner(fileChooser.getSelectedFile());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }


                    if(elementCounter == 25 && lineCounter == 5 ) {

                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                mainTable.mainTable.setValueAt(sc.next(), i, j);
                            }
                        }

                        statusBar.infoBar.setText("OTWARTO");
                        statusBar.statusBar.setText("Otwarto plik o nazwie: " + fileChooser.getSelectedFile().getName());
                    }else {
                        JOptionPane.showMessageDialog(frame,
                                "Otwarto błedny plik tekstowy",
                                "Błędny Plik!",
                                JOptionPane.ERROR_MESSAGE);

                        statusBar.infoBar.setText("BŁĄD");
                        statusBar.statusBar.setText("Otwarto błedny plik o nazwie: " + fileChooser.getSelectedFile().getName());

                        System.out.println("Wrong file");
                    }
                    sc.close();
                }
            }
        });

        /**
         * Saving the table results to default file table.txt
         */
        javaMenu.zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         * Saving to a custom named file
         */
        javaMenu.zapiszJako.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\Cornelius Filmore\\IdeaProjects\\GUIappMP\\Zapisane pliki"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt", ".txt");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setFileFilter(filter);
                BufferedWriter bufferedWriter = null;

                int returnVal = fileChooser.showSaveDialog(frame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {

                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile() + ".txt"));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {

                            try {
                                bufferedWriter.write(mainTable.mainTable.getModel().getValueAt(i, j).toString() + " ");
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        try {
                            bufferedWriter.write(" \n");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }

                    try {
                        bufferedWriter.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    System.out.println("File Saved");

                } else {
                    System.out.println("Canceled Save");
                }


            }

    });

        /**
         * Exit the java application
         */
        javaMenu.zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                statusBar.infoBar.setText("WYJŚCIE");
                statusBar.statusBar.setText("Wyłączono aplikacje");

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        /**
         * Hide the right menuBar
         */
        javaMenu.schowajPasekNarzedzi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sideButtons.visibilitySideButtons) {

                    statusBar.infoBar.setText("SCHOWANO");
                    statusBar.statusBar.setText("Schowano Pasek Narzędzi");

                    sideButtons.setVisible(false);
                    sideButtons.visibilitySideButtons = false;
                } else {

                    statusBar.infoBar.setText("ODKRYTO");
                    statusBar.statusBar.setText("Odkryto Pasek Narzędzi");

                    sideButtons.setVisible(true);
                    sideButtons.visibilitySideButtons = true;
                }

            }
        });

        /**
         * Hide status bar
         */
        javaMenu.schowajPasekStatusu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusBar.statusBarVisibility) {

                    mainTable.mainTable.setRowHeight(mainTable.mainTable.getRowHeight() + 6);

                    statusBar.infoBar.setText("SCHOWANO");
                    statusBar.statusBar.setText("Schowano Pasek Statusu");

                    statusBar.setVisible(false);
                    statusBar.statusBarVisibility = false;
                } else {

                    mainTable.mainTable.setRowHeight(mainTable.mainTable.getRowHeight() - 6);

                    statusBar.infoBar.setText("ODKRYTO");
                    statusBar.statusBar.setText("Odkryto Pasek Statusu");

                    statusBar.setVisible(true);
                    statusBar.statusBarVisibility = true;
                }

            }
        });

        /**
         * The sum of all Elements in the array
         */
        javaMenu.sumaElementow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumMethod(mainTable);
            }
        });

        /**
         * The average of all Elements in the array
         */
        javaMenu.sredniaElementow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageMethod(mainTable);
            }
        });

        /**
         * The Max and Min value in the array
         */
        javaMenu.wartoscMaxMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maxMinMethod(mainTable);

            }
        });

        /**
         *  Help instructions
         */
        javaMenu.pomocInformacje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpMethod();
            }
        });

        /**
         *  Information about the author
         */
        javaMenu.informacjeAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ImageIcon logoIcon = new ImageIcon("grafika/logo.jpg");

                statusBar.infoBar.setText("OTWARTO");
                statusBar.statusBar.setText("Otwarto Infromacje o autorze");

                JOptionPane.showMessageDialog(frame,
                        "Java Gui App v1.0.0 \n Autor: Maciej Pałubicki \n\n Email: palubicki@codestack.com \n Numer Telefonu: 123456789 \n Copyright \u00a9 by M.Pałubicki 2021",
                        "Autor",
                        JOptionPane.PLAIN_MESSAGE,
                        logoIcon);
            }
        });


        /**
         *                       North Pane Action listiners
         */


        /**
         * Save button NorthPane
         */
        northPane.firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         * Print Button NorthPane
         */
        northPane.secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statusBar.infoBar.setText("WYDRUKOWANO");
                    statusBar.statusBar.setText("Wydrukowano plik");

                    PrinterJob job = PrinterJob.getPrinterJob();
                    PageFormat pf = new PageFormat();
                    job.pageDialog(pf);
                    // job.setPrintable(ListFrame, pf);
                    if (job.printDialog()) {
                        job.print();
                    }
                } catch (Exception exc) {
                    statusBar.infoBar.setText("BŁĄD");
                    statusBar.statusBar.setText("Blad drukowania");

                }
            }
        });

        /**
         * Exit NorthPane
         */
        northPane.thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusBar.infoBar.setText("WYJŚCIE");
                statusBar.statusBar.setText("Wyłączono aplikacje");

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        /**
         * Add to the table NorthPane
         */
        northPane.fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMethod(frame, mainTable);
            }
        });

        /**
         * Zero the table NorthPane
         */
        northPane.fifthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                zeroMethod(frame, mainTable);

            }
        });

        /**
         * Fill the Whole table NorthPane
         */
        northPane.sixthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillMethod(frame, mainTable);
            }

        });

        /**
         * Sum the whole table NorthPane
         */
        northPane.seventhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumMethod(mainTable);
            }
        });

        /**
         * Average the whole table NorthPane
         */
        northPane.eighthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageMethod(mainTable);
            }
        });

        /**
         * Min Value in the whole table NorthPane
         */
        northPane.ninthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> arrayList = new ArrayList<Double>();

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        arrayList.add((Double.parseDouble(String.valueOf(mainTable.mainTable.getModel().getValueAt(i, j)))));

                    }
                }

                mainTable.mainTextField.setText("Wartość Min:  " + Collections.min(arrayList));

                statusBar.infoBar.setText("OBLICZONO");
                statusBar.statusBar.setText("Wartość Min: " + Collections.min(arrayList));
            }

        });

        /**
         * Max Value in the whole table NorthPane
         */
        northPane.tenthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> arrayList = new ArrayList<Double>();

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        arrayList.add((Double.parseDouble(String.valueOf(mainTable.mainTable.getModel().getValueAt(i, j)))));

                    }
                }

                mainTable.mainTextField.setText("Wartość Max:  " + Collections.max(arrayList));

                statusBar.infoBar.setText("OBLICZONO");
                statusBar.statusBar.setText("Wartość Max: " + Collections.max(arrayList));
            }

        });

        /**
         * Help NorthPane
         */
        northPane.eleventhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpMethod();
            }
        });

        /**
         * Author NorthPane
         */
        northPane.twelfthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon logoIcon = new ImageIcon("grafika/logo.jpg");

                statusBar.infoBar.setText("OTWARTO");
                statusBar.statusBar.setText("Otwarto Informacje o Autorze");

                JOptionPane.showMessageDialog(
                        frame,
                        "Java Gui App v1.0.0 \n\n Autor: Maciej Pałubicki \n Email: palubicki@codestack.com \n Numer Telefonu: 123456789 \n Copyright \u00a9 by 2021",
                        "Autor",
                        JOptionPane.PLAIN_MESSAGE,
                        logoIcon);
            }
        });

        /**
         *                      Side Buttons Listiners
         */

        /**
         * Side Buttons add
         */
        sideButtons.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMethod(frame, mainTable);
            }
        });

        /**
         * Side Buttons fill
         */
        sideButtons.fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean numeric = true;

                String a = mainTable.tableSliders.textField.getText();

                try {
                    Double num = Double.parseDouble(a);
                } catch (NumberFormatException exx) {
                    numeric = false;
                }

                if (numeric) {
                    mainTable.tableSliders.textField.setBackground(Color.WHITE);
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            mainTable.mainTable.getModel().setValueAt(a, i, j);
                        }
                    }
                    mainTable.mainTextField.setText("Wypełniono tablicę wartością: " + a);

                    statusBar.infoBar.setText("WYPEŁNIONO");
                    statusBar.statusBar.setText("Tablica wypełniona warotścią: " + a);


                } else {
                    statusBar.infoBar.setText("BŁĄD");
                    statusBar.statusBar.setText("Wpisana wartość to nie liczba!");
                    mainTable.tableSliders.textField.setBackground(Color.RED);

                    JOptionPane.showMessageDialog(frame,
                            "Wpisana wartość to nie liczba!",
                            "UWAGA",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /**
         * Side Buttons zero
         */
        sideButtons.zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeroMethod(frame, mainTable);
            }
        });

        /**
         * Side Buttons save
         */
        sideButtons.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         * Side button count
         */
        sideButtons.countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sideButtons.sideList.getSelectedValue() != null) {


                    switch (sideButtons.sideList.getSelectedValue().toString()) {
                        case "Suma elementów":
                            sumMethod(mainTable);
                            break;
                        case "Średnia elementów":
                            averageMethod(mainTable);
                            break;
                        case "Wartość max i min":
                            maxMinMethod(mainTable);
                            break;
                    }

                }else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Nie wybrano opcji",
                            "UWAGA!",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });



        frame.setVisible(true);
    }

    private static void zeroMethod(MainFrame frame, MainTable mainTable) {
        int newInt = JOptionPane.showOptionDialog(
                frame,
                "Czy napewno chcesz wyzerować tablicę?",
                "Uwaga",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[]{"Tak", "Nie"},
                "Tak"
        );

        if (newInt == JOptionPane.YES_OPTION) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    mainTable.mainTable.getModel().setValueAt(0, i, j);
                }
            }

            statusBar.infoBar.setText("WYZEROWANO");
            statusBar.statusBar.setText("Wyzerowano table");
        }
    }

    private static void maxMinMethod(MainTable mainTable) {
        ArrayList<Double> arrayList = new ArrayList<Double>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayList.add((Double.parseDouble(String.valueOf(mainTable.mainTable.getModel().getValueAt(i, j)))));

            }
        }

        mainTable.mainTextField.setText("Wartość Min:  " + Collections.min(arrayList) + " Wartość Max: " + Collections.max(arrayList));

        statusBar.statusBar.setText("Wartość Min: " + Collections.min(arrayList) + " Wartość Max: " + Collections.max(arrayList));
        statusBar.infoBar.setText("WYZNACZONO");

    }

    private static void fillMethod(MainFrame frame, MainTable mainTable) {
        boolean loop = true;

        while (loop) {
            boolean numeric = true;

            try {
                String a = JOptionPane.showInputDialog(
                        frame,
                        "Podaj wartość",
                        "UWAGA",
                        JOptionPane.PLAIN_MESSAGE
                );

                //Check if the String is a number
                try {
                    Double num = Double.parseDouble(a);
                } catch (NumberFormatException exx) {
                    numeric = false;
                }

                if (numeric) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            mainTable.mainTable.getModel().setValueAt(a, i, j);
                        }
                    }
                    mainTable.mainTextField.setText("Wypełniono tablicę wartością: " + a);

                    statusBar.infoBar.setText("WYPEŁNIONO");
                    statusBar.statusBar.setText("Tablica wypełniona warotścią: " + a);


                    loop = false;

                } else {
                    statusBar.infoBar.setText("BŁĄD");
                    statusBar.statusBar.setText("Wpisana wartość to nie liczba!");

                    JOptionPane.showMessageDialog(frame,
                            "Wpisana wartość to nie liczba!",
                            "UWAGA",
                            JOptionPane.WARNING_MESSAGE);

                }
            }catch (NullPointerException e) {
                loop = false;
            }

            mainTable.tableSliders.textField.requestFocus(true);
        }
    }

    private static void addMethod(MainFrame frame, MainTable mainTable) {
        boolean check = true;
        String a = mainTable.tableSliders.textField.getText();
        mainTable.tableSliders.textField.setBackground(Color.WHITE);

        try {
          double b = Double.parseDouble(a);
        } catch (NumberFormatException ex) {
            check = false;
        }

        if(check) {
            mainTable.mainTable.getModel().setValueAt(a, mainTable.tableSliders.rowSlider.getValue() - 1, mainTable.tableSliders.columnSlider.getValue() - 1);
            mainTable.mainTextField.setText("Dodano wartość: " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());

            statusBar.infoBar.setText("DODANO");
            statusBar.statusBar.setText("Dodano " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());
        }else if(a.isEmpty()) {

            statusBar.infoBar.setText("BŁĄD");
            statusBar.statusBar.setText("Nie podano wartości!");
            mainTable.tableSliders.textField.setBackground(Color.RED);

            JOptionPane.showMessageDialog(
                    frame,
                    "Podanaj jakąś liczbę!",
                    "Uwaga",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            mainTable.tableSliders.textField.setBackground(Color.RED);
            statusBar.infoBar.setText("BŁĄD");
            statusBar.statusBar.setText("Podana wartość nie jest liczbą!");

            JOptionPane.showMessageDialog(
                    frame,
                    "Podana wartość nie jest liczbą!",
                    "Uwaga",
                    JOptionPane.WARNING_MESSAGE);
        }
        mainTable.tableSliders.textField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        mainTable.tableSliders.textField.requestFocus(true);
    }

    private static void averageMethod(MainTable mainTable) {
        float value = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                value += Double.parseDouble(String.valueOf(mainTable.mainTable.getModel().getValueAt(i, j)));
            }
        }
        value = value / 25;
        mainTable.mainTextField.setText("Średnia ze wszystkich elementów jest równa: " + value);

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Średnia wynosi: " + value);
    }

    private static void sumMethod(MainTable mainTable) {
        float value = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                value += Double.parseDouble(String.valueOf(mainTable.mainTable.getModel().getValueAt(i, j)));
            }
        }
        mainTable.mainTextField.setText("Suma wszystkich elementów jest równa: " + value);

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Suma wynosi: " + value);

    }

    private static void saveMethod(MainFrame frame, MainTable mainTable) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("Zapisane pliki\\table.txt"));

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    bufferedWriter.write(mainTable.mainTable.getModel().getValueAt(i, j).toString() + " ");
                }
                bufferedWriter.write(" \n");
            }

            statusBar.infoBar.setText("ZAPISANO");
            statusBar.statusBar.setText("Zapisano do pliku table.txt");

            JOptionPane.showMessageDialog(
                    frame,
                    "Zapisano do pliku table.txt",
                    "UWAGA",
                    JOptionPane.WARNING_MESSAGE);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private static void helpMethod(){

            String url = "pomoc/index.html";
            File file = new File(url);

            try {
                statusBar.infoBar.setText("OTWARTO");
                statusBar.statusBar.setText("Otwarto Pomoc");

                Desktop.getDesktop().open(file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
    }

}
