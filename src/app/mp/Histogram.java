package app.mp;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Histogram extends JFrame {

    HistogramDataset dataset = new HistogramDataset();

    public double[] numberDataHis = {
            1, 2, 3, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0
    };



    Histogram() {
        dataset.addSeries("klucz", numberDataHis, 25);


        JFreeChart histogram = ChartFactory.createHistogram(
                "Wykres",
                "Liczby",
                "Powtarzanie",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(histogram);

        this.add(panel);
        this.setTitle("Histogram");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(600,400));
        this.setVisible(true);
    }
}
