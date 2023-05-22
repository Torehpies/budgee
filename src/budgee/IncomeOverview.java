package budgee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import budgee.DatabaseManager;
import budgee.BudgeeDAOImpl;
import budgee.UserSession;

public class IncomeOverview {
	//LocalDate variables
	LocalDate startDate = LocalDate.now();
	LocalDate endDate = LocalDate.now();
		
	//UserSession object and variables
	UserSession session = UserSession.getInstance();
	int sessionId = session.getId();
	
	private Connection connection;
	private String category;
	private Double balanceUpdate;
	
	String newCategory = category;
	Double newValue = balanceUpdate;
	static DefaultPieDataset dataset = new DefaultPieDataset();
		
	
	
	public void addData(String category, double value) {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		BudgeeDAOImpl bdi = new BudgeeDAOImpl(connection);
//		daily_year_now = daily_year_now.plusDays(1);
//		daily_date.setText(formatDate(daily_year_now));
//		bdi.getRecordsByDateRange(startDate, endDate);	
//		bdi.getIncomeTotal(recordsByDate);
//		
		String category1 = newCategory;
		System.out.println(category);
//i		String value1 = balanceUpdate;
	    dataset.setValue(category, value);
	}

    public static void createChart() {  
  //      addData(newCategory, newValue);
        // Creating chart
        JFreeChart chart = ChartFactory.createPieChart("Testtiiinhhhng", dataset, true, true, false);

        // Creating chart frame
        ChartFrame frame = new ChartFrame("Expense Overview", chart);
        frame.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
