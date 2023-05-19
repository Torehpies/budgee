package budgee;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Record {
	
	//Constructor with id
	public Record(int id, Date date, Time time, BigDecimal balance_update, String notes, String action,
			String category, String account, BigDecimal cash_value, BigDecimal savings_value) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.balance_update = balance_update;
		this.notes = notes;
		this.action = action;
		this.category = category;
		this.account = account;
		this.cash_value = cash_value;
		this.savings_value = savings_value;
	}
	
	//Constructor without id
	public Record(Date date, Time time, BigDecimal balance_update, String notes, String action, String category,
			String account, BigDecimal cash_value, BigDecimal savings_value) {
		super();
		this.date = date;
		this.time = time;
		this.balance_update = balance_update;
		this.notes = notes;
		this.action = action;
		this.category = category;
		this.account = account;
		this.cash_value = cash_value;
		this.savings_value = savings_value;
	}
	//Class attributes
	private int id;
	private Date date;
	private Time time;
	private BigDecimal balance_update;
	private String notes;
	private String action;
	private String category;
	private String account;
	private BigDecimal cash_value;
	private BigDecimal savings_value;
	
	public int getId() {
		return id;
	}
	/*
	public void setId(int id) {
	
		this.id = id;
	}
	*/
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public BigDecimal getBalance_update() {
		return balance_update;
	}
	public void setBalance_update(BigDecimal balance_update) {
		this.balance_update = balance_update;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public BigDecimal getCash_value() {
		return cash_value;
	}
	public void setCash_value(BigDecimal cash_value) {
		this.cash_value = cash_value;
	}
	public BigDecimal getSavings_value() {
		return savings_value;
	}
	public void setSavings_value(BigDecimal savings_value) {
		this.savings_value = savings_value;
	}
}
