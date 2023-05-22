package budgee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Budget {
	

	public Budget(int userId, Date date, String category, BigDecimal limitBudget, BigDecimal spentBudget) {
		super();
		this.userId = userId;
		this.date = date;
		this.category = category;
		this.limitBudget = limitBudget;
		this.spentBudget = spentBudget;
	}
	public Budget(int id, int userId, Date date, String category, BigDecimal limitBudget, BigDecimal spentBudget) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.category = category;
		this.limitBudget = limitBudget;
		this.spentBudget = spentBudget;
	}
	//Class attributes
	
	private int id;
	private int userId;
	private Date date;
	private String category;
	private BigDecimal limitBudget;
	private BigDecimal spentBudget;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
