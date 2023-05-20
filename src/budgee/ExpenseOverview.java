package budgee;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ExpenseOverview {

    public void createChart() {
        // Creating dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("JavaScript", 30.8);
        dataset.setValue("Ruby", 11.8);
        dataset.setValue("Java", 10.8);
        dataset.setValue("Python", 11.6);
        dataset.setValue("PHP", 7.2);
        dataset.setValue("Objective-C", 10.7);
        dataset.setValue("C", 5.2);
        dataset.setValue("C++", 4.3);
        dataset.setValue("Go", 3.8);
        dataset.setValue("CSS", 3.8);

        // Creating chart
        JFreeChart chart = ChartFactory.createPieChart("Testtiiinhhhng", dataset, true, true, false);

        // Creating chart frame
        ChartFrame frame = new ChartFrame("PieChart Example", chart);
        frame.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
