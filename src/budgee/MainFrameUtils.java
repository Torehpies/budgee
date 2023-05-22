package budgee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import budgee.DatabaseManager;
import budgee.mainmain;
//import javafx.scene.layout.Border;

public class MainFrameUtils {

	private static List<Record> recordsByDate; 
	/**
	 * @wbp.parser.entryPoint
	 */
	static JPanel createRecordPanel(Record record, JScrollPane parentPanel_rec) {
	
		JPanel recordPanel = new JPanel();
		recordPanel.setBackground(new Color(68, 83, 109));
		recordPanel.setBounds(10, 26, 613, 100);
		recordPanel.setLayout(null);
		
		JLabel lblGet_Categ = new JLabel(record.getCategory());
		lblGet_Categ.setBounds(290, 8, 89, 21);
		lblGet_Categ.setForeground(new Color(252, 187, 109));
		lblGet_Categ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblGet_Categ.setBackground(Color.WHITE);
		recordPanel.add(lblGet_Categ);
		
		JLabel lbl_Categ = new JLabel("Category:");
		lbl_Categ.setForeground(new Color(216, 115, 127));
		lbl_Categ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lbl_Categ.setBackground(Color.WHITE);
		lbl_Categ.setBounds(209, 9, 81, 19);
		recordPanel.add(lbl_Categ);
		
		JLabel Acc_Exp_lbl = new JLabel((record.getAction()).toString());
		Acc_Exp_lbl.setForeground(new Color(216, 115, 127));
		Acc_Exp_lbl.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Acc_Exp_lbl.setBackground(Color.WHITE);
		Acc_Exp_lbl.setBounds(286, 77, 70, 19);
		recordPanel.add(Acc_Exp_lbl);
		
		JLabel lbl_Notes = new JLabel(record.getNotes());
		lbl_Notes.setVerticalAlignment(SwingConstants.TOP);
		lbl_Notes.setForeground(new Color(252, 187, 109));
		lbl_Notes.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 15));
		lbl_Notes.setBackground(Color.WHITE);
		lbl_Notes.setBounds(20, 32, 484, 45);
		recordPanel.add(lbl_Notes);
		
		JButton btn_Del = new JButton("Delete");
		btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = DatabaseManager.getConnection();
				BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
				BudgeeDAOImpl.deleteRecord(record.getId());
				MainFrameUtils mainFrameUtils = new MainFrameUtils();
				mainmain mainFrame = new mainmain();
				recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(mainFrame.getPanelStartDate(), mainFrame.getPanelEndDate());
				mainFrameUtils.displayAllRecords(recordsByDate, parentPanel_rec);
				
			}
		});
		btn_Del.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Del.setForeground(new Color(216, 115, 127));
		btn_Del.setBackground(new Color(68, 83, 109));
		btn_Del.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btn_Del.setBounds(514, 41, 89, 36);
		recordPanel.add(btn_Del);
		
		JLabel lbl_Value = new JLabel("PHP " + (record.getBalance_update()).toString());
		lbl_Value.setForeground(new Color(252, 187, 109));
		lbl_Value.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lbl_Value.setBackground(Color.WHITE);
		lbl_Value.setBounds(366, 77, 113, 19);
		recordPanel.add(lbl_Value);
		
		JButton btn_Edit = new JButton("Edit");
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Edit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Edit.setForeground(new Color(252, 187, 109));
		btn_Edit.setBackground(new Color(68, 83, 109));
		btn_Edit.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btn_Edit.setBounds(514, 8, 89, 36);
		recordPanel.add(btn_Edit);
		
		JLabel lblGet_Acc = new JLabel(record.getAccount());
		lblGet_Acc.setForeground(new Color(252, 187, 109));
		lblGet_Acc.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblGet_Acc.setBackground(Color.WHITE);
		lblGet_Acc.setBounds(91, 7, 89, 21);
		recordPanel.add(lblGet_Acc);
		
		JLabel lbl_Acc = new JLabel("Account:");
		lbl_Acc.setForeground(new Color(216, 115, 127));
		lbl_Acc.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lbl_Acc.setBackground(Color.WHITE);
		lbl_Acc.setBounds(10, 9, 81, 19);
		recordPanel.add(lbl_Acc);
		
		JLabel lbl_Date = new JLabel((record.getDate()).toString());
		lbl_Date.setForeground(new Color(252, 187, 109));
		lbl_Date.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl_Date.setBackground(Color.WHITE);
		lbl_Date.setBounds(10, 77, 80, 19);
		recordPanel.add(lbl_Date);
		
		JLabel lbl_Time = new JLabel((record.getTime()).toString());
		lbl_Time.setForeground(new Color(252, 187, 109));
		lbl_Time.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl_Time.setBackground(Color.WHITE);
		lbl_Time.setBounds(100, 77, 80, 19);
		recordPanel.add(lbl_Time);
		
		return recordPanel;
	}
	
	public static void displayAllRecords(List<Record> records, JScrollPane parentPanel_rec) {		
		JPanel containerPanel = new JPanel();
	    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
	    javax.swing.border.Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);  
	    EmptyBorder emptyBorder = new EmptyBorder(0, 0, 5, 0);  
	    CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);  
	    
	    
		for (Record record : records) {
			JPanel recordPanel = createRecordPanel(record, parentPanel_rec);
			recordPanel.setPreferredSize(new Dimension(50,100));
			recordPanel.setBorder(compoundBorder);  	
			containerPanel.add(recordPanel);
		}
		
		parentPanel_rec.setViewportView(containerPanel);
		parentPanel_rec.revalidate();
		parentPanel_rec.repaint();
	}
	
	public static void refreshRecords(JScrollPane parentPanel_rec) {
		Connection connection = DatabaseManager.getConnection();
		
		BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
		List<Record> records = BudgeeDAOImpl.getAllRecords();
	    displayAllRecords(records, parentPanel_rec);
	}
	
	
	
	static JPanel createBudgetPanel(Budget budget, JScrollPane parentPanel_budget) {
		
		JPanel budgetPanel = new JPanel();
		budgetPanel.setBackground(new Color(68, 83, 109));
		budgetPanel.setBounds(10, 11, 410, 104);
		budgetPanel.setLayout(null);
		
		JLabel lblGet_Categ = new JLabel(budget.getCategory());
		lblGet_Categ.setBounds(21, 11, 61, 18);
		lblGet_Categ.setForeground(new Color(252, 187, 109));
		lblGet_Categ.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblGet_Categ.setBackground(Color.WHITE);
		budgetPanel.add(lblGet_Categ);
		
		JLabel lbl_limit = new JLabel("Limit: ");
		lbl_limit.setForeground(new Color(252, 187, 109));
		lbl_limit.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lbl_limit.setBackground(Color.WHITE);
		lbl_limit.setBounds(21, 37, 43, 14);
		budgetPanel.add(lbl_limit);
		
		JLabel lbl_blnce_limit = new JLabel("PHP " + (budget.getLimitBudget()).toString());
		lbl_blnce_limit.setForeground(new Color(216, 115, 127));
		lbl_blnce_limit.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lbl_blnce_limit.setBackground(Color.WHITE);
		lbl_blnce_limit.setBounds(72, 39, 60, 14);
		budgetPanel.add(lbl_blnce_limit);
		
		JLabel lbl_spent = new JLabel("Spent: ");
		lbl_spent.setForeground(new Color(252, 187, 109));
		lbl_spent.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lbl_spent.setBackground(Color.WHITE);
		lbl_spent.setBounds(21, 55, 51, 18);
		budgetPanel.add(lbl_spent);
		
		JLabel lbl_blnce_spent = new JLabel("PHP " + (budget.getSpentBudget()).toString());
		lbl_blnce_spent.setForeground(new Color(216, 115, 127));
		lbl_blnce_spent.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lbl_blnce_spent.setBackground(Color.WHITE);
		lbl_blnce_spent.setBounds(82, 59, 60, 14);
		budgetPanel.add(lbl_blnce_spent);
		
		JButton budget_btn_Del = new JButton("Delete Budget");
		budget_btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = DatabaseManager.getConnection();
				BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
				BudgeeDAOImpl.deleteRecord(budget.getId());
				MainFrameUtils mainFrameUtils_budget = new MainFrameUtils();
				mainFrameUtils_budget.refreshBudgets(parentPanel_budget);
				
			}
		});
		budget_btn_Del.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		budget_btn_Del.setForeground(new Color(252, 187, 109));
		budget_btn_Del.setBackground(new Color(85, 111, 146));
		budget_btn_Del.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		budget_btn_Del.setBounds(245, 63, 148, 30);
		budgetPanel.add(budget_btn_Del);
		
		JButton budget_btn_Edit = new JButton("Change Limit");
		budget_btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		budget_btn_Edit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		budget_btn_Edit.setForeground(new Color(252, 187, 109));
		budget_btn_Edit.setBackground(new Color(85, 111, 146));
		budget_btn_Edit.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		budget_btn_Edit.setBounds(514, 8, 89, 36);
		budgetPanel.add(budget_btn_Edit);
		
		return budgetPanel;
	}
	
	public static JPanel createUnbudgetedPanel(String category, JScrollPane parentPanel, LocalDate dateBudget, JScrollPane budgetedPane) {
		JPanel unbudgetedPanel = new JPanel();
		unbudgetedPanel.setBackground(new Color(69, 92, 123));
		unbudgetedPanel.setBounds(10, 11, 281, 67);
		parentPanel.add(unbudgetedPanel);
		unbudgetedPanel.setLayout(null);

		JLabel categoryLabel = new JLabel(category);
		categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryLabel.setForeground(new Color(252, 187, 109));
		categoryLabel.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		categoryLabel.setBounds(51, 10, 62, 45);
		unbudgetedPanel.add(categoryLabel);

		JButton set_bdgt_btn = new JButton("Set Budget");
		set_bdgt_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetBudget setbudget = new SetBudget(category, dateBudget, budgetedPane);
                setbudget.setVisible(true);
			}
		});
		set_bdgt_btn.setFocusable(false);
		set_bdgt_btn.setBackground(new Color(85, 111, 146));
		set_bdgt_btn.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		set_bdgt_btn.setForeground(new Color(252, 187, 109));
		set_bdgt_btn.setBounds(155, 20, 116, 29);
		unbudgetedPanel.add(set_bdgt_btn);
		
		return unbudgetedPanel;
	}
	
	public static void displayAllBudget(List<Budget> budgets, JScrollPane parentPanel_budget) {		
		JPanel containerPanel = new JPanel();
	    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
	    javax.swing.border.Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);  
	    EmptyBorder emptyBorder = new EmptyBorder(0, 0, 5, 0);  
	    CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);  
	    
	    
		for (Budget budget : budgets) {
			JPanel budgetPanel = createBudgetPanel(budget, parentPanel_budget);
			budgetPanel.setPreferredSize(new Dimension(50,100));
			budgetPanel.setBorder(compoundBorder);
			containerPanel.add(budgetPanel);
		}
		
		parentPanel_budget.setViewportView(containerPanel);
		parentPanel_budget.revalidate();
		parentPanel_budget.repaint();
	}
	
	public static void displayUnbudgetedCategories(List<String> unbudgetedCategories, JScrollPane parentPanel, LocalDate budgetDate, JScrollPane budgetedPane) {
		JPanel containerPanel = new JPanel();
	    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
	    javax.swing.border.Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);  
	    EmptyBorder emptyBorder = new EmptyBorder(0, 0, 5, 0);  
	    CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);  
		
		for (String category : unbudgetedCategories) {
			JPanel unbudgetedPanel = createUnbudgetedPanel(category, parentPanel, budgetDate, budgetedPane);
			unbudgetedPanel.setPreferredSize(new Dimension(50,60));
			unbudgetedPanel.setBorder(compoundBorder);
			containerPanel.add(unbudgetedPanel);
		}
		
		parentPanel.setViewportView(containerPanel);
		parentPanel.revalidate();
		parentPanel.repaint();
	}
	
	public static void refreshBudgets(JScrollPane parentPanel_budget) {
		Connection connection = DatabaseManager.getConnection();
		
		BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
		List<Budget> budgets = BudgeeDAOImpl.getAllBudgets();
	    displayAllBudget(budgets, parentPanel_budget);	
	}

}
