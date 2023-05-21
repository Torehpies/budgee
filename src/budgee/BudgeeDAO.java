package budgee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.time.LocalDate;

public interface BudgeeDAO {
	
	void addRecord(Record record);
    void updateRecord(Record record);
    void deleteRecord(int recordId);
    
    void addBudget(Budget budget);
    void updateBudget(Budget budget);
    void deleteBudget(int budgetId);
    
    BigDecimal getExpenseTotal();
    BigDecimal getIncomeTotal();
    
    List<Budget> getAllBudgets();
    List<Record> getAllRecords();
    List<Record> getRecordsByDateRange(LocalDate startDate, LocalDate endDate);
    
}
