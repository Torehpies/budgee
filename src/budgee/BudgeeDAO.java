package budgee;

import java.sql.Connection;
import java.util.List;

public interface BudgeeDAO {
	
	void addExpense(Record record);
    void updateRecord(Record record);
    void deleteRecord(int recordId);
    void addBudget(Budget budget);
    void updateBudget(Budget budget);
    void deleteBudget(int budgetId);
    List<Budget> getAllBudgets();
    List<Record> getAllRecords();
    List<Record> getRecordsByDate(String Date);
    
}
