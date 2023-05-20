package budgee;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class AccountAnalysis {


    public void createChart() {
        // Defining string to label XAxis
        String Euro = "Euro";
        String Pound = "British Pound";
        String A_Dollar = "Australian Dollar";
        String frenc = "Swiss Franc";

        // Configuring category and NumberAxis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Currency");
        yAxis.setLabel("Dollar price");

        // Creating dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0.83, "Currency", Euro);
        dataset.addValue(0.73, "Currency", Pound);
        dataset.addValue(1.00, "Currency", frenc);
        dataset.addValue(1.32, "Currency", A_Dollar);

        // Creating chart
        JFreeChart chart = ChartFactory.createBarChart("Dollar Conversion Chart", "Currency", "Dollar Price", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // Customizing the chart plot
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeAxis(yAxis);
        plot.setDomainAxis(xAxis);

        // Creating chart frame
        ChartFrame frame = new ChartFrame("BarChart Example", chart);
        frame.setDefaultCloseOperation(ChartFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
