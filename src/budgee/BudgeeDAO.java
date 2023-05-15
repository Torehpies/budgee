package budgee;

import java.sql.*;

public interface BudgeeDAO {
	
	void addExpense(Expense expense);
    void updateExpense(Expense expense);
    void deleteExpense(int expenseId);
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(String category);
    
}
