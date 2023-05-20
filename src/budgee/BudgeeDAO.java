package budgee;

import java.sql.Connection;
import java.util.List;

public interface BudgeeDAO {
	
	void addExpense(Record record);
    void updateRecord(Record record);
    void deleteRecord(int recordId);
    List<Record> getAllRecords();
    List<Record> getExpensesByCategory(String category);
    
}
