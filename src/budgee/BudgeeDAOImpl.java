package budgee;

import java.sql.*;
import java.util.List;

public class BudgeeDAOImpl implements BudgeeDAO {

	private String url = "jdbc:mysql://127.0.0.1:3306/budgee_accounts";
	private String username = "root";
	private String password = "";
	
	private Connection connection = DriverManager.getConnection(url, username, password);
	
	public BudgeeDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addExpense(Record record) {
		//String insertQuery = "INSERT INTO ";
		
	}

	@Override
	public void updateExpense(Record record) {
	
		
	}

	@Override
	public void deleteExpense(int recordId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Record> getAllExpenses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> getExpensesByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
