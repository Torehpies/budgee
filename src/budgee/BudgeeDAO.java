package budgee;

import java.util.List;

public interface BudgeeDAO {
	
	void addExpense(Record record);
    void updateExpense(Record record);
    void deleteExpense(int recordId);
    List<Record> getAllRecords();
    List<Record> getExpensesByCategory(String category);
    
}
