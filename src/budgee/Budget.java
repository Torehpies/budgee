package budgee;

import java.math.BigDecimal;
import java.util.List;

public class Budget {
	
	public Budget(int id, int userId, String category, BigDecimal limitBudget, BigDecimal spentBudget) {
		super();
		this.id = id;
		this.userId = userId;
		this.category = category;
		this.limitBudget = limitBudget;
		this.spentBudget = spentBudget;
	}
	public Budget(int userId, String category, BigDecimal limitBudget, BigDecimal spentBudget) {
		super();
		this.userId = userId;
		this.category = category;
		this.limitBudget = limitBudget;
		this.spentBudget = spentBudget;
	}
	
	//Class attributes
	
	private int id;
	private int userId;
	private String category;
	private BigDecimal limitBudget;
	private BigDecimal spentBudget;
	private boolean isBudgeted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getLimitBudget() {
		return limitBudget;
	}
	public void setLimitBudget(BigDecimal limitBudget) {
		this.limitBudget = limitBudget;
	}
	public BigDecimal getSpentBudget() {
		return spentBudget;
	}
	public void setSpentBudget(BigDecimal spentBudget) {
		this.spentBudget = spentBudget;
	}
	
	
	
}
