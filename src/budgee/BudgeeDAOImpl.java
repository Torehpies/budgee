package budgee;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import budgee.UserSession;
import budgee.Record;
import java.time.LocalDate;

public class BudgeeDAOImpl implements BudgeeDAO {
	
	
	//UserSession object and variables
	UserSession session = UserSession.getInstance();
	int sessionId = session.getId();

	private Connection connection;
	
	public BudgeeDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addRecord(Record record) {
		String insertQuery = "INSERT INTO budgee_accounts.recordsTable(userID, date, time, balanceUpdate, notes, action, category, account) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		 try (PreparedStatement preparedStatement = 
				connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
			 preparedStatement.setInt(1, record.getUserId());
			 preparedStatement.setDate(2, record.getDate());
			 preparedStatement.setTime(3, record.getTime());
			 preparedStatement.setBigDecimal(4, record.getBalance_update());
			 preparedStatement.setString(5, record.getNotes());
			 preparedStatement.setString(6, record.getAction());
			 preparedStatement.setString(7, record.getCategory());
			 preparedStatement.setString(8, record.getAccount());
			 
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
	public void updateRecord(Record record) {
	
		
	}

	@Override
	public void deleteRecord(int recordId) {
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM budgee_accounts.recordsTable WHERE id = ? AND userID = ?")) {
			statement.setInt(1,  recordId);
			statement.setInt(2, sessionId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Record> getAllRecords() {
		 List<Record> records = new ArrayList<>();

	        String selectQuery = "SELECT id, userID, date, time, balanceUpdate, notes, action, category, account FROM budgee_accounts.recordsTable WHERE userID = " + sessionId;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                int userId = resultSet.getInt("userID");
	                Date date = resultSet.getDate("date");
	                Time time = resultSet.getTime("time");
	                BigDecimal balanceUpdate = resultSet.getBigDecimal("balanceUpdate");
	                String notes = resultSet.getString("notes");
	                String action = resultSet.getString("action");
	                String category = resultSet.getString("category");
	                String account = resultSet.getString("account");

	                Record record = new Record(id, userId, date, time, balanceUpdate, notes, action,  category, account);
	                records.add(record);
	            }

	            resultSet.close();
	        } catch (SQLException e) {
	            // Handle any exceptions that may occur during the execution of the query
	            e.printStackTrace();
	        }

	        return records;
	}

	@Override
	public List<Record> getRecordsByDateRange(java.time.LocalDate startDate, java.time.LocalDate endDate) {
	    try {
	        Connection conn = DatabaseManager.getConnection();
	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recordsTable WHERE date >= ? AND date <= ?");
	        stmt.setDate(1, java.sql.Date.valueOf(startDate));
	        stmt.setDate(2, java.sql.Date.valueOf(endDate));
	        ResultSet resultSet = stmt.executeQuery();

	        List<Record> records = new ArrayList<>();
	        while (resultSet.next()) {
	        	 int id = resultSet.getInt("id");
	                int userId = resultSet.getInt("userID");
	                Date date = resultSet.getDate("date");
	                Time time = resultSet.getTime("time");
	                BigDecimal balanceUpdate = resultSet.getBigDecimal("balanceUpdate");
	                String notes = resultSet.getString("notes");
	                String action = resultSet.getString("action");
	                String category = resultSet.getString("category");
	                String account = resultSet.getString("account");

	                Record record = new Record(id, userId, date, time, balanceUpdate, notes, action,  category, account);
	                records.add(record);
	        }

	        resultSet.close();
	        stmt.close();
	        conn.close();

	        return records;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public void addBudget(Budget budget) {
		String insertQuery = "INSERT INTO budgee_accounts.budgetsTable(userID, category, limitBudget, spentBudget) VALUES(?, ?, ?, ?)";
		
		 try (PreparedStatement preparedStatement = 
				connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
			 preparedStatement.setInt(1, budget.getUserId());
			 preparedStatement.setString(2, budget.getCategory());
			 preparedStatement.setBigDecimal(3, budget.getLimitBudget());
			 preparedStatement.setBigDecimal(4, budget.getSpentBudget());
		
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
	public void updateBudget(Budget budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBudget(int budgetId) {
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM budgee_accounts.recordsTable WHERE id = ? AND userID = ?")) {
			statement.setInt(1,  budgetId);
			statement.setInt(2, sessionId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Budget> getAllBudgets() {
		 List<Budget> budgets = new ArrayList<>();

	        String selectQuery = "SELECT id, userID, category, limitBudget, spentBudget account FROM budgee_accounts.budgetsTable WHERE userID = " + sessionId;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                int userId = resultSet.getInt("userID");
	                String category = resultSet.getString("category");
	                BigDecimal limitBudget = resultSet.getBigDecimal("limitBudget");
	                BigDecimal spentBudget = resultSet.getBigDecimal("spentBudget");

	                Budget budget = new Budget(id, userId, category, limitBudget, spentBudget);
	                budgets.add(budget);
	            }

	            resultSet.close();
	        } catch (SQLException e) {
	            // Handle any exceptions that may occur during the execution of the query
	            e.printStackTrace();
	        }

	        return budgets;
	}
	
}
