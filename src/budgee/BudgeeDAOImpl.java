package budgee;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import budgee.UserSession;
import budgee.Record;

public class BudgeeDAOImpl implements BudgeeDAO {
	
	//UserSession object and variables
	UserSession session = UserSession.getInstance();
	String userTable = "user_" + session.getId();

	private Connection connection;
	
	public BudgeeDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addExpense(Record record) {
		String insertQuery = "INSERT INTO budgee_accounts." + userTable + "(date, time, balance_update, notes, action, category, account, cash_value, savings_value) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		 try (PreparedStatement preparedStatement = 
				connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
			 preparedStatement.setDate(1, record.getDate());
			 preparedStatement.setTime(2, record.getTime());
			 preparedStatement.setBigDecimal(3, record.getBalance_update());
			 preparedStatement.setString(4, record.getNotes());
			 preparedStatement.setString(5, record.getAction());
			 preparedStatement.setString(6, record.getCategory());
			 preparedStatement.setString(7, record.getAccount());
			 preparedStatement.setBigDecimal(8, record.getCash_value());
			 preparedStatement.setBigDecimal(9, record.getSavings_value());
			 
			 int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {
	                System.out.println("Insertion successful");
	            }
			 
			 preparedStatement.close();
			 connection.close();
			 
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
	public List<Record> getAllRecords() {
		 List<Record> records = new ArrayList<>();

	        String selectQuery = "SELECT ID, date, time, balance_update, notes, action, category, account, cash_value, savings_value FROM budgee_accounts." + userTable;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("ID");
	                Date date = resultSet.getDate("date");
	                Time time = resultSet.getTime("time");
	                BigDecimal balance_update = resultSet.getBigDecimal("balance_update");
	                String category = resultSet.getString("category");
	                double amount = resultSet.getDouble("amount");
	                
	                BigDecimal balanceUpdate = resultSet.getBigDecimal("balance_update");

	                Expense expense = new Expense(id, category, amount, date, balanceUpdate);
	                expenses.add(expense);
	            }

	            resultSet.close();
	        } catch (SQLException e) {
	            // Handle any exceptions that may occur during the execution of the query
	            e.printStackTrace();
	        }

	        return expenses;
	}

	@Override
	public List<Record> getExpensesByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
