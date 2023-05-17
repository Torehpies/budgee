package budgee;

import java.sql.*;
import java.util.List;
import budgee.UserSession;

public class BudgeeDAOImpl implements BudgeeDAO {
	
	//UserSession object and variables
	UserSession session = UserSession.getInstance();
	int userId = session.getId();

	private Connection connection;
	
	public BudgeeDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addExpense(Record record) {
		String insertQuery = "INSERT INTO user_" + userId + "(date, time," + 
				"balance_update, notes, action, category, account, cash_value," +
				"savings_value) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		 try (PreparedStatement preparedStatement = 
				connection.prepareStatement(insertQuery, 
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			 preparedStatement.setString(1, record.getDate());
			 preparedStatement.setString(2, record.getTime());
			 preparedStatement.setBigDecimal(3, record.getBalance_update());
			 preparedStatement.setString(4, record.getNotes());
			 preparedStatement.setString(5, record.getAction());
			 preparedStatement.setString(6, record.getCategory());
			 preparedStatement.setString(7, record.getAccount());
			 preparedStatement.setBigDecimal(8, record.getCash_value());
			 preparedStatement.setBigDecimal(9, record.getSavings_value());
			 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		
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
