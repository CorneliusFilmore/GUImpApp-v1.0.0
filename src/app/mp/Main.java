package app.mp;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.util.Log;
import org.w3c.dom.DOMConfiguration;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.*;


/**
 *  Main Class with all created objects and state listeners
 * @author Maciej Palubicki
 * @version v1.0.2
 */

public class Main extends JFrame {

    static StatusBar statusBar = new StatusBar();

    final static Logger consoleLogger = Logger.getLogger("consoleLogger");
    final static Logger fileLogger = Logger.getLogger("fileLogger");

    public static void main(String[] args) {
        DOMConfigurator.configure("logconfig.xml");

        fileLogger.info("Start Aplikacji");
        consoleLogger.info("Start Aplikacji");

        MainFrame frame = new MainFrame();
        NorthPane northPane = new NorthPane();
        JavaMenu javaMenu = new JavaMenu();
        SideButtons sideButtons = new SideButtons();
        MainTable mainTable = new MainTable();
        TaskPane taskPane = new TaskPane();

        frame.setJMenuBar(javaMenu);
        frame.setLayout(new BorderLayout());
        frame.add(northPane, BorderLayout.NORTH);
        frame.add(mainTable, BorderLayout.CENTER);
        frame.add(sideButtons, BorderLayout.EAST);
        frame.add(taskPane, BorderLayout.WEST);
        frame.add(statusBar, BorderLayout.PAGE_END);

        mainTable.mainTable.changeSelection(mainTable.tableSliders.rowSlider.getValue() - 1, mainTable.tableSliders.columnSlider.getValue() - 1, true,false);

        /**
         *  Interface scaling Listeners maximized window and minimized
         */

        frame.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                // maximized window
                if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {

                    mainTable.mainTable.setRowHeight(frame.getWidth() / 18);

                    mainTable.mainTable.setFont(new Font(null, Font.PLAIN, 24));

                    mainTable.tableSliders.rowLabel.setFont(new Font(null, Font.BOLD, 18));
                    mainTable.tableSliders.columnLabel.setFont(new Font(null, Font.BOLD, 18));

                    mainTable.mainTextArea.centerBorder.setTitleFont(new Font(null, Font.BOLD, 25));
                    mainTable.mainTextArea.setFont(new Font(null, Font.BOLD, 25));

                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 18));
                    mainTable.tableSliders.labelField.setFont(new Font(null, Font.BOLD, 18));

                    mainTable.calendarField.calendar.setFont(new Font(null, Font.BOLD, 18));
                    mainTable.calendarField.chartButton.setFont(new Font(null, Font.BOLD, 18));

                    mainTable.calendarField.calendar.setPreferredSize(new Dimension(120, 50));
                    mainTable.calendarField.calendar.setMaximumSize(new Dimension(120, 50));

                    mainTable.tableSliders.setPreferredSize(new Dimension(frame.getWidth(), 100));
                    mainTable.tableSliders.setMaximumSize(new Dimension(frame.getWidth(), 100));

                    mainTable.tableSliders.rowLabel.setPreferredSize(new Dimension(frame.getWidth() / 6, 50));
                    mainTable.tableSliders.rowLabel.setMaximumSize(new Dimension(frame.getWidth() / 6, 50));

                    mainTable.tableSliders.rowSlider.setPreferredSize(new Dimension(frame.getWidth() / 6, 50));
                    mainTable.tableSliders.rowSlider.setMaximumSize(new Dimension(frame.getWidth() / 6, 50));

                    mainTable.tableSliders.columnLabel.setPreferredSize(new Dimension(frame.getWidth() / 6, 50));
                    mainTable.tableSliders.columnLabel.setMaximumSize(new Dimension(frame.getWidth() / 6, 50));

                    mainTable.tableSliders.columnSlider.setPreferredSize(new Dimension(frame.getWidth() / 6, 50));
                    mainTable.tableSliders.columnSlider.setMaximumSize(new Dimension(frame.getWidth() / 6, 50));

                    mainTable.tableSliders.labelField.setPreferredSize(new Dimension(frame.getWidth() / 6, 50));
                    mainTable.tableSliders.labelField.setMaximumSize(new Dimension(frame.getWidth() / 6, 50));

                    mainTable.tableSliders.textField.setPreferredSize(new Dimension(frame.getWidth() / 6, 30));
                    mainTable.tableSliders.textField.setMaximumSize(new Dimension(frame.getWidth() / 6, 30));

                    mainTable.mainTextArea.setPreferredSize(new Dimension(frame.getWidth(), 200));
                    mainTable.mainTextArea.setMaximumSize(new Dimension(frame.getWidth(), 200));

                    mainTable.calendarField.setPreferredSize(new Dimension(frame.getWidth(), 50));
                    mainTable.calendarField.setMaximumSize(new Dimension(frame.getWidth(), 50));


                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 40));
                    statusBar.setMaximumSize(new Dimension(frame.getWidth(), 40));

                    statusBar.statusBar.setPreferredSize(new Dimension(frame.getWidth() / 2, 30));
                    statusBar.statusBar.setMaximumSize(new Dimension(frame.getWidth() / 2, 30));

                    statusBar.infoBar.setPreferredSize(new Dimension(frame.getWidth() / 2, 30));
                    statusBar.infoBar.setMaximumSize(new Dimension(frame.getWidth() / 2, 30));


                }
                else {
                    mainTable.mainTable.setRowHeight(33);

                    mainTable.tableSliders.rowLabel.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.columnLabel.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.mainTextArea.centerBorder.setTitleFont(new Font(null, Font.BOLD, 12));
                    mainTable.mainTextArea.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.textField.setFont(new Font(null, Font.BOLD, 12));
                    mainTable.tableSliders.labelField.setFont(new Font(null, Font.BOLD, 12));

                    mainTable.mainTable.setFont(new Font(null, Font.PLAIN, 14));
                    mainTable.calendarField.calendar.setFont(new Font(null, Font.BOLD, 14));
                    mainTable.calendarField.chartButton.setFont(new Font(null,Font.BOLD,14));

                    mainTable.tableSliders.setPreferredSize(new Dimension(frame.getWidth(), 60));
                    mainTable.tableSliders.setMaximumSize(new Dimension(frame.getWidth(), 60));

                    mainTable.mainTextArea.setPreferredSize(new Dimension(frame.getWidth(), 180));
                    mainTable.mainTextArea.setMaximumSize(new Dimension(frame.getWidth(), 180));

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

                    mainTable.calendarField.setPreferredSize(new Dimension(frame.getWidth(),30));
                    mainTable.calendarField.setMaximumSize(new Dimension(frame.getWidth(),30));

                    mainTable.calendarField.calendar.setPreferredSize(new Dimension(100,50));
                    mainTable.calendarField.calendar.setMaximumSize(new Dimension(100,50));

                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 30));
                    statusBar.setPreferredSize(new Dimension(frame.getWidth(), 30));

                }
            }
        });

        /**
         * State changed Row Slider and Table Slider
         */

        mainTable.tableSliders.rowSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                mainTable.tableSliders.rowLabel.setText("Wiersz numer = " + mainTable.tableSliders.rowSlider.getValue());

                if (e.getSource() == mainTable.tableSliders.rowSlider) {
                    mainTable.mainTable.changeSelection(mainTable.tableSliders.rowSlider.getValue() - 1,mainTable.tableSliders.columnSlider.getValue() - 1,false,false);
                }
            }
        });

        mainTable.tableSliders.columnSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                mainTable.tableSliders.columnLabel.setText("Kolumna numer = " + mainTable.tableSliders.columnSlider.getValue());

                if (e.getSource() == mainTable.tableSliders.columnSlider) {
                    mainTable.mainTable.changeSelection(mainTable.tableSliders.rowSlider.getValue() - 1,mainTable.tableSliders.columnSlider.getValue() - 1,false,false);
                }
            }
        });




        /**
         * Tip of the Day listener
         */

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                TipOfTheDay tipOfTheDay = new TipOfTheDay();
                super.windowOpened(e);
            }
        });



        /**
         * Sum button listener JavaTaskPane
         */

        taskPane.sumButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sumMethod(mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.sumButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.sumButton.setBackground(null);
            }
        });

        /**
         * Average button listener JavaTaskPane
         */
        taskPane.averageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                averageMethod(mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.averageButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.averageButton.setBackground(null);

            }
        });

        /**
         * Max button listener JavaTaskPane
         */
        taskPane.maxButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                maxMethod(mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.maxButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.maxButton.setBackground(null);
            }
        });

        /**
         * Min button listener JavaTaskPane
         */
        taskPane.minButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                minMethod(mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.minButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.minButton.setBackground(null);
            }
        });

        /**
         * Open file button listener JavaTaskPane
         */
        taskPane.openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openMethod(frame,mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.openButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.openButton.setBackground(null);
            }
        });

        /**
         * Help button listener JavaTaskPane
         */
        taskPane.helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helpMethod();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.helpButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.helpButton.setBackground(null);
            }
        });

        /**
         * Author button listener JavaTaskPane
         */

        taskPane.authorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                authorMethod(frame);
            }


            public void mouseEntered(MouseEvent e) {
                taskPane.authorButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.authorButton.setBackground(null);
            }
        });

        /**
         * Save button listener JavaTaskPane
         */
        taskPane.saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveMethod(frame,mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.saveButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.saveButton.setBackground(null);
            }
        });

        /**
         * Save as button listener JavaTaskPane
         */
        taskPane.saveAsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveAsMethod(frame,mainTable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.saveAsButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.saveAsButton.setBackground(null);
            }
        });

        /**
         * Printer button listener JavaTaskPane
         */
        taskPane.printButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                printMethod();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                taskPane.printButton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                taskPane.printButton.setBackground(null);
            }
        });




        /**
         * JavaMenu Creating a new empty table button
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
                        zeroMethod(mainTable);
                    }

                    statusBar.infoBar.setText("UTWORZONO");
                    statusBar.statusBar.setText("Utworzono pusty plik");

                    fileLogger.info("Utworzono pusty plik");
                    consoleLogger.info("Utworzono pusty plik");
                }
        });

        /**
         * JavaMenu Open a file button
         */
        javaMenu.otworz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    openMethod(frame,mainTable);
                }
        });

        /**
         *JavaMenu Saving the table results to default file table.txt button
         */
        javaMenu.zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         * JavaMenu Saving to a custom named file button
         */
        javaMenu.zapiszJako.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsMethod(frame,mainTable);
            }

    });

        /**
         * JavaMenu Exit the java application button
         */
        javaMenu.zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                statusBar.infoBar.setText("WYJŚCIE");
                statusBar.statusBar.setText("WyLączono aplikacje");

                fileLogger.info("WyLączono aplikacje");
                consoleLogger.info("WyLączono aplikacje");

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        /**
         * JavaMenu Hide the right menuBar button
         */
        javaMenu.schowajPasekNarzedzi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sideButtons.visibilitySideButtons) {

                    fileLogger.info("Schowano Pasek Narzędzi");
                    consoleLogger.info("Schowano Pasek Narzędzi");

                    statusBar.infoBar.setText("SCHOWANO");
                    statusBar.statusBar.setText("Schowano Pasek Narzędzi");

                    sideButtons.setVisible(false);
                    sideButtons.visibilitySideButtons = false;
                } else {

                    fileLogger.info("Odkryto Pasek Narzędzi");
                    consoleLogger.info("Odkryto Pasek Narzędzi");

                    statusBar.infoBar.setText("ODKRYTO");
                    statusBar.statusBar.setText("Odkryto Pasek Narzędzi");

                    sideButtons.setVisible(true);
                    sideButtons.visibilitySideButtons = true;
                }

            }
        });

        /**
         * JavaMenu Hide status bar button
         */
        javaMenu.schowajPasekStatusu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusBar.statusBarVisibility) {

                    mainTable.mainTable.setRowHeight(mainTable.mainTable.getRowHeight() + 7);

                    fileLogger.info("Schowano Pasek Statusu");
                    consoleLogger.info("Schowano Pasek Statusu");

                    statusBar.infoBar.setText("SCHOWANO");
                    statusBar.statusBar.setText("Schowano Pasek Statusu");

                    statusBar.setVisible(false);
                    statusBar.statusBarVisibility = false;
                } else {

                    mainTable.mainTable.setRowHeight(mainTable.mainTable.getRowHeight() - 7);

                    fileLogger.info("Odkryto Pasek Statusu");
                    consoleLogger.info("Odkryto Pasek Statusu");

                    statusBar.infoBar.setText("ODKRYTO");
                    statusBar.statusBar.setText("Odkryto Pasek Statusu");

                    statusBar.setVisible(true);
                    statusBar.statusBarVisibility = true;
                }

            }
        });

        /**
         * JavaMenu Hide task pane button
         */

        javaMenu.schowajTaskPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taskPane.taskPaneVisibility) {

                    statusBar.infoBar.setText("SCHOWANO");
                    statusBar.statusBar.setText("Schowano Pasek Statusu");

                    fileLogger.info("Schowano Pasek Statusu");
                    consoleLogger.info("Schowano Pasek Statusu");


                    taskPane.setVisible(false);
                    taskPane.taskPaneVisibility = false;
                } else {

                    statusBar.infoBar.setText("ODKRYTO");
                    statusBar.statusBar.setText("Odkryto Pasek Statusu");

                    fileLogger.info("Odkryto Pasek Statusu");
                    consoleLogger.info("Odkryto Pasek Statusu");

                    taskPane.setVisible(true);
                    taskPane.taskPaneVisibility = true;
                }
            }
        });

        /**
         * JavaMenu The sum of all Elements in the array button
         */
        javaMenu.sumaElementow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumMethod(mainTable);
            }
        });

        /**
         * JavaMenu The average of all Elements in the array button
         */
        javaMenu.sredniaElementow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageMethod(mainTable);
            }
        });

        /**
         * JavaMenu The Max and Min value in the array button
         */
        javaMenu.wartoscMaxMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maxMinMethod(mainTable);

            }
        });

        /**
         * JavaMenu Help instructions button
         */
        javaMenu.pomocInformacje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpMethod();
            }
        });

        /**
         * JavaMenu Information about the author button
         */
        javaMenu.informacjeAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               authorMethod(frame);
            }
        });


        /**
         *  Save button NorthPane button
         */
        northPane.firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         *  Print NorthPane button
         */
        northPane.secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               printMethod();
            }
        });

        /**
         * Exit NorthPane button
         */
        northPane.thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusBar.infoBar.setText("WYJŚCIE");
                statusBar.statusBar.setText("WyLączono aplikacje");

                fileLogger.info("WyLączono aplikacje");
                consoleLogger.info("WyLączono aplikacje");

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        /**
         * Add to the table button NorthPane
         */
        northPane.fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMethod(frame, mainTable);
            }
        });

        /**
         * Zero the table button NorthPane
         */
        northPane.fifthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                zeroMethod(mainTable);

                statusBar.infoBar.setText("WYZEROWANO");
                statusBar.statusBar.setText("Wyzerowano table");

                fileLogger.info("Wyzerowano table");
                consoleLogger.info("Wyzerowano table");

            }
        });

        /**
         * Fill the Whole table button NorthPane
         */
        northPane.sixthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillMethod(frame, mainTable);
            }

        });

        /**
         * Sum the whole table button NorthPane
         */
        northPane.seventhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumMethod(mainTable);
            }
        });

        /**
         * Average the whole table button NorthPane
         */
        northPane.eighthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageMethod(mainTable);
            }
        });

        /**
         * Min Value in the whole table button NorthPane
         */
        northPane.ninthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minMethod(mainTable);
            }

        });

        /**
         * Max Value in the whole table button NorthPane
         */
        northPane.tenthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maxMethod(mainTable);
            }

        });

        /**
         * Help button NorthPane
         */
        northPane.eleventhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpMethod();
            }
        });

        /**
         * Author button NorthPane
         */
        northPane.twelfthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorMethod(frame);
            }
        });


        /**
         * Side Buttons add button
         */
        sideButtons.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMethod(frame, mainTable);
            }
        });

        /**
         * Side Buttons fill button
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
                            mainTable.tableModel.setValueAt(a, i, j);
                        }
                    }
                    mainTable.mainTextArea.setText("WypeLniono tablicę wartością: " + a);

                    fileLogger.info("Tablica wypeLniona warotścią: " + a);
                    consoleLogger.info("Tablica wypeLniona warotścią: " + a);

                    statusBar.infoBar.setText("WYPELNIONO");
                    statusBar.statusBar.setText("Tablica wypeLniona warotścią: " + a);


                } else {
                    statusBar.infoBar.setText("BLĄD");
                    statusBar.statusBar.setText("Wpisana wartość to nie liczba!");

                    fileLogger.info("Wpisano wartość do tablicy nie bedaca liczba!");
                    consoleLogger.info("Wpisano wartość do tablicy nie bedaca liczba!");

                    mainTable.tableSliders.textField.setBackground(Color.RED);

                    JOptionPane.showMessageDialog(frame,
                            "Wpisana wartość to nie liczba!",
                            "UWAGA",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /**
         * Side Buttons zero button
         */
        sideButtons.zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    zeroMethod(mainTable);
                }

                fileLogger.info("Wyzerowano table");
                consoleLogger.info("Wyzerowano table");

                statusBar.infoBar.setText("WYZEROWANO");
                statusBar.statusBar.setText("Wyzerowano table");
            }
        });

        /**
         * Side Buttons save button
         */
        sideButtons.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMethod(frame,mainTable);
            }
        });

        /**
         * Side button count button
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


        /**
         * Calendar change date button
         */
        mainTable.calendarField.chartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] dataTable = new double[25];
                int q = 0;
                int emptyTableInt=0;

                for(int i=0;i<5;i++) {
                    for (int j=0;j<5;j++) {
                        dataTable[q] = Double.parseDouble(mainTable.mainTable.getValueAt(i,j).toString());
                        q++;
                    }
                }

                q=0;
              double checkB = dataTable[0];
                for(int i=0;i<5;i++) {
                    for (int j=0;j<5;j++) {
                        double test = Double.parseDouble(mainTable.mainTable.getValueAt(i,j).toString());
                        if(checkB == test) {
                            q++;
                        }
                    }
                }


                if(q==25) {
                    for(int i=0;i<5;i++) {
                        for (int j=0;j<5;j++) {
                            dataTable[emptyTableInt] = checkB;
                            emptyTableInt++;
                        }
                    }
                }


                createChart(dataTable,frame);
            }
        });

        /**
         * Calendar Date listiner
         */

        mainTable.calendarField.calendar.addDateListener(new DateListener() {
            @Override
            public void dateChanged(DateEvent e) {
                mainTable.mainTextArea.setText("Zmieniono datę: " + mainTable.calendarField.calendar.getSelectedItem());
                fileLogger.info("Zmieniono datę: " + mainTable.calendarField.calendar.getSelectedItem());
                consoleLogger.info("Zmieniono datę: " + mainTable.calendarField.calendar.getSelectedItem());
            }
        });

        frame.setVisible(true);
    }


    /**
     * Method which zeros the whole table
     * @param mainTable JTable
     */
    private static void zeroMethod(MainTable mainTable) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    mainTable.tableModel.setValueAt("0", i, j);
                      }
                }
    }

    /**
     * Method which selects the max and min value of the table and prints them out
     * @param mainTable JTable
     */
    private static void maxMinMethod(MainTable mainTable) {
        ArrayList<Double> arrayList = new ArrayList<Double>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayList.add((Double.parseDouble(String.valueOf(mainTable.tableModel.getValueAt(i, j)))));

            }
        }

        mainTable.mainTextArea.setText("Wartość Min:  " + Collections.min(arrayList) + " Wartość Max: " + Collections.max(arrayList));

        fileLogger.info("Wyznaczono wartość Min = " + Collections.min(arrayList) + " oraz wartość Max = " + Collections.max(arrayList));
        consoleLogger.info("Wyznaczono wartość Min = " + Collections.min(arrayList) + " oraz wartość Max = " + Collections.max(arrayList));

        statusBar.statusBar.setText("Wartość Min: " + Collections.min(arrayList) + " Wartość Max: " + Collections.max(arrayList));
        statusBar.infoBar.setText("WYZNACZONO");

    }

    /**
     * Method which fills the whole table with a given number
     * @param frame JFrame
     * @param mainTable JTable
     */

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
                            mainTable.tableModel.setValueAt(a, i, j);
                        }
                    }
                    mainTable.mainTextArea.setText("WypeLniono tablicę wartością: " + a);

                    statusBar.infoBar.setText("WYPELNIONO");
                    statusBar.statusBar.setText("Tablica wypeLniona warotścią: " + a);

                    fileLogger.info("Wypelnino tablice warotścią: " + a);
                    consoleLogger.info("Wypelnino tablice warotścią: " + a);


                    loop = false;

                } else {
                    statusBar.infoBar.setText("BLAD");
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

    /**
     * Method which adds a number from imput field to the selected row and column
     * @param frame JFrame
     * @param mainTable JTable
     */
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
            mainTable.tableModel.setValueAt(a, mainTable.tableSliders.rowSlider.getValue() - 1, mainTable.tableSliders.columnSlider.getValue() - 1);
            mainTable.mainTextArea.setText("Dodano wartość: " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());

            fileLogger.info("Dodano " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());
            consoleLogger.info("Dodano " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());

            statusBar.infoBar.setText("DODANO");
            statusBar.statusBar.setText("Dodano " + mainTable.tableSliders.textField.getText() + " do rzędu: " + mainTable.tableSliders.rowSlider.getValue() + " do kolumny " + mainTable.tableSliders.columnSlider.getValue());


        }else if(a.isEmpty()) {

            fileLogger.info("Nie podano wartości w polu dodania liczby!");
            consoleLogger.info("Nie podano wartości w polu dodania liczby!");

            statusBar.infoBar.setText("BLĄD");
            statusBar.statusBar.setText("Nie podano wartości!");
            mainTable.tableSliders.textField.setBackground(Color.RED);

            JOptionPane.showMessageDialog(
                    frame,
                    "Podanaj jakąś liczbę!",
                    "Uwaga",
                    JOptionPane.WARNING_MESSAGE);

            mainTable.mainTextArea.setText("Nie podano żadnej liczby!");
        } else {

            mainTable.tableSliders.textField.setBackground(Color.RED);
            statusBar.infoBar.setText("BLAD");
            statusBar.statusBar.setText("Podana wartość nie jest liczbą!");

            JOptionPane.showMessageDialog(
                    frame,
                    "Podana wartość nie jest liczbą!",
                    "Uwaga",
                    JOptionPane.WARNING_MESSAGE);


            fileLogger.info("Podano bLędną wartość do tabeli nie będącą liczbą!");
            consoleLogger.info("Podano bLędną wartość do tabeli nie będącą liczbą!");

            fileLogger.info("Podano bLędną wartość do tabeli nie będącą liczbą!");
            consoleLogger.info("Podano bLędną wartość do tabeli nie będącą liczbą!");

            mainTable.mainTextArea.setText("Podano bLędną wartość nie będącą liczbą!");
            mainTable.tableSliders.textField.setText("");
        }
        mainTable.tableSliders.textField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        mainTable.tableSliders.textField.requestFocus(true);

    }

    /**
     * Method which designates the average of all numbers in the table and prints them out
     * @param mainTable JTable
     */
    private static void averageMethod(MainTable mainTable) {
        float value = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                value += Double.parseDouble(String.valueOf(mainTable.tableModel.getValueAt(i, j)));
            }
        }
        value = value / 25;
        mainTable.mainTextArea.setText("Średnia ze wszystkich elementów jest równa: " + value);

        fileLogger.info("Obliczono srednia = " + value);
        consoleLogger.info("Obliczono srednia = " + value);

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Średnia wynosi: " + value);
    }

    /**
     * Method which sums every element in the table and prints them out
     * @param mainTable JTable
     */
    private static void sumMethod(MainTable mainTable) {
        float value = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                value += Double.parseDouble(String.valueOf(mainTable.tableModel.getValueAt(i, j)));
            }
        }
        mainTable.mainTextArea.setText("Suma wszystkich elementów jest równa: " + value);

        fileLogger.info("Obliczono sume wszystkich elementów = " + value);
        consoleLogger.info("Obliczono sume wszystkich elementów = " + value);

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Suma wynosi: " + value);

    }

    private static void saveMethod(MainFrame frame, MainTable mainTable) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("Zapisane pliki\\table.txt"));

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    bufferedWriter.write(mainTable.tableModel.getValueAt(i, j).toString() + " ");
                }
                bufferedWriter.write(" \n");
            }

            fileLogger.info("Zapisano tabele do pliku table.txt");
            consoleLogger.info("Zapisano tabele do pliku table.txt");

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

    /**
     * Method which opens the help window
     */
    private static void helpMethod(){

            String url = "pomoc/index.html";
            File file = new File(url);

            try {
                statusBar.infoBar.setText("OTWARTO");
                statusBar.statusBar.setText("Otwarto Pomoc");

                fileLogger.info("Otwarto pomoc");
                consoleLogger.info("Otwarto pomoc");

                Desktop.getDesktop().open(file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
    }

    /**
     * Method which designates the max value from table and prints it out
     * @param mainTable JTable
     */
    private static void maxMethod(MainTable mainTable){
        ArrayList<Double> arrayList = new ArrayList<Double>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayList.add((Double.parseDouble(String.valueOf(mainTable.mainTable.getValueAt(i, j)))));

            }
        }

        mainTable.mainTextArea.setText("Wartość Max:  " + Collections.max(arrayList));

        fileLogger.info("Obliczono wartość Max = " + Collections.max(arrayList));
        consoleLogger.info("Obliczono wartość Max = " + Collections.max(arrayList));

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Wartość Max: " + Collections.max(arrayList));

    }

    /**
     * Method which designates the min value from table and prints it out
     * @param mainTable JTable
     */
    private static void minMethod(MainTable mainTable) {
        ArrayList<Double> arrayList = new ArrayList<Double>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayList.add((Double.parseDouble(String.valueOf(mainTable.mainTable.getValueAt(i, j)))));

            }
        }

        mainTable.mainTextArea.setText("Wartość Min:  " + Collections.min(arrayList));

        fileLogger.info("Obliczono wartość Min = " + Collections.min(arrayList));
        consoleLogger.info("Obliczono wartość Min = " + Collections.min(arrayList));

        statusBar.infoBar.setText("OBLICZONO");
        statusBar.statusBar.setText("Wartość Min: " + Collections.min(arrayList));
    }

    /**
     * Method which open a window from which you select the file you want to open
     * @param frame JFrame
     * @param mainTable JTable
     */
    private static void openMethod(MainFrame frame,MainTable mainTable) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Cornelius Filmore\\IdeaProjects\\GUIappMP\\Zapisane pliki"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt", "text");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);

        int elementCounter = 0;
        int lineCounter = 0;
        Scanner sc = null;

        int openFile = fileChooser.showOpenDialog(frame);

        if (openFile == JFileChooser.APPROVE_OPTION) {

            try {
                sc = new Scanner(fileChooser.getSelectedFile());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            while (sc.hasNextDouble()) {
                Double ns = sc.nextDouble();
                elementCounter++;
            }
            sc.close();

            try {
                sc = new Scanner(fileChooser.getSelectedFile());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            while (sc.hasNextLine()) {
                String ns = sc.nextLine();
                lineCounter++;
            }
            sc.close();


            try {
                sc = new Scanner(fileChooser.getSelectedFile());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


            if (elementCounter == 25 && lineCounter == 5) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mainTable.tableModel.setValueAt(sc.next(), i, j);
                    }
                }

                fileLogger.info("Otwarto plik o nazwie: " + fileChooser.getSelectedFile().getName());
                consoleLogger.info("Otwarto plik o nazwie: " + fileChooser.getSelectedFile().getName());

                statusBar.infoBar.setText("OTWARTO");
                statusBar.statusBar.setText("Otwarto plik o nazwie: " + fileChooser.getSelectedFile().getName());
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Otwarto bLedny plik tekstowy",
                        "BLędny Plik!",
                        JOptionPane.ERROR_MESSAGE);

                fileLogger.info("Otwarto bLedny plik tekstowy");
                consoleLogger.info("Otwarto bLedny plik tekstowy");

                statusBar.infoBar.setText("BLAD");
                statusBar.statusBar.setText("Otwarto bLedny plik o nazwie: " + fileChooser.getSelectedFile().getName());

                System.out.println("Wrong file");
            }
            sc.close();
        }
    }

    /**
     * Method which opens a window in which you save the file with a custom name
     * @param frame JFrame
     * @param mainTable JTable
     */
    private static void saveAsMethod(Frame frame, MainTable mainTable) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Cornelius Filmore\\IdeaProjects\\GUIappMP\\Zapisane pliki"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki tekstowe", "txt", ".txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        BufferedWriter bufferedWriter = null;

        int returnVal = fileChooser.showSaveDialog(frame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                bufferedWriter = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    try {
                        bufferedWriter.write(mainTable.tableModel.getValueAt(i, j).toString() + " ");
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

    /**
     * Method which is used to print files with the printer
     */
    private static void printMethod() {
        try {

            fileLogger.info("Wydrukowano plik");
            consoleLogger.info("Wydrukowano plik");

            statusBar.infoBar.setText("WYDRUKOWANO");
            statusBar.statusBar.setText("Wydrukowano plik");

            PrinterJob job = PrinterJob.getPrinterJob();
            PageFormat pf = new PageFormat();
            job.pageDialog(pf);

            if (job.printDialog()) {
                job.print();
            }
        } catch (Exception exc) {

            fileLogger.info("Blad drukowania");
            consoleLogger.info("Blad drukowania");

            statusBar.infoBar.setText("BLAD");
            statusBar.statusBar.setText("Blad drukowania");
        }
    }

    /**
     * Method that opens a window with the name of the author
     * @param frame JFrame
     */
    private static void authorMethod(MainFrame frame) {
        ImageIcon logoIcon = new ImageIcon("grafika/logo.jpg");

        statusBar.infoBar.setText("OTWARTO");
        statusBar.statusBar.setText("Otwarto Infromacje o autorze");

        JOptionPane.showMessageDialog(frame,
                "Java Gui App v1.0.1 \n Autor: Maciej PaLubicki \n\n Email: palubicki@codestack.com \n Numer Telefonu: 123456789 \n Copyright \u00a9 by M.PaLubicki 2021",
                "Autor",
                JOptionPane.PLAIN_MESSAGE,
                logoIcon);
    }

    /**
     * Method which creates a windows with a chart for number data
     * @param numberDataHis double[]
     * @param mainFrame JFrame
     */
    private static void createChart(double[] numberDataHis,JFrame mainFrame) {
        JDialog dialog = new JDialog();
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Update",numberDataHis,25);

        JFreeChart histogram = ChartFactory.createHistogram(
                "Wykres",
                "Liczby",
                "Powtarzanie",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(histogram);

        panel.setMouseWheelEnabled(true);
        panel.setMouseZoomable(true);

        dialog.add(panel);
        dialog.setTitle("Histogram");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(new Dimension(600,400));
        dialog.setLocationRelativeTo(dialog);

        dialog.setModal(true);
        dialog.setVisible(true);
    }
}
