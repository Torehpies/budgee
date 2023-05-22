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
    
    
    BigDecimal getExpenseTotal(List<Record> records);
    BigDecimal getIncomeTotal(List<Record> records);
    
    BigDecimal getCashIncomeTotal(List<Record> records);
    BigDecimal getSavingsIncomeTotal(List<Record> records);
    BigDecimal getCashExpenseTotal(List<Record> records);
    BigDecimal getSavingsExpenseTotal(List<Record> records);
    
    List<Budget> getAllBudgets();
    List<String> getUnbudgetedCategories(List<Budget> budgets);
    List<Record> getAllRecords();
    List<Record> getRecordsByDateRange(LocalDate startDate, LocalDate endDate);

    List<Budget> getBudgetsByDateRange(LocalDate startDate, LocalDate endDate);

}