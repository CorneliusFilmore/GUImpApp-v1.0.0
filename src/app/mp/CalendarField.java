package app.mp;

import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

import javax.swing.*;
import java.awt.*;

import java.text.SimpleDateFormat;

public class CalendarField extends JPanel {


    JCalendarCombo calendar = new JCalendarCombo(JCalendar.DISPLAY_DATE,false);
    JButton chartButton = new JButton("Wykres");


    CalendarField() {

        calendar.setPreferredSize(new Dimension(100,30));
        calendar.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        calendar.setFont(new Font("Arial",Font.BOLD,14));
        chartButton.setFont(new Font("Arial",Font.BOLD,14));

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000,30));
        this.setMaximumSize(new Dimension(1000,30));
        this.setBorder(BorderFactory.createEmptyBorder(10,5,1,10));
        this.setBackground(Color.LIGHT_GRAY);
        this.add(calendar, BorderLayout.EAST);
        this.add(chartButton, BorderLayout.WEST);


    }

}


