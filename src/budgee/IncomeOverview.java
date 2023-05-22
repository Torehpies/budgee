package budgee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import budgee.DatabaseManager;
import budgee.BudgeeDAOImpl;

public class IncomeOverview {
	DefaultPieDataset dataset = new DefaultPieDataset();
	
	
//	public void addData(String category, double value) {
//		Connection connection = null;
//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		BudgeeDAOImpl bdi = new BudgeeDAOImpl(connection);
//		bdi.getRecordsByDateRange();		
//		
//		String category = bdi.getCategory;
//		String category = bdi.getValue;
//	    dataset.setValue(category, value);
//	}

    public void createChart() {  
        dataset.setValue("JavaScript", 80);
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
        ChartFrame frame = new ChartFrame("Expense Overview", chart);
        frame.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
