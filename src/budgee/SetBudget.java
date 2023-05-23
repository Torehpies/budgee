package budgee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.math.BigDecimal;

import budgee.UserSession;
import budgee.DatabaseManager;

public class SetBudget extends JFrame {

	private JPanel SetBudgetPanel;
	private JTextField SetLimit;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetBudget frame = new SetBudget();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SetBudget(String category, LocalDate dateBudget, JScrollPane parentPanel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 415);
		SetBudgetPanel = new JPanel();
		SetBudgetPanel.setBackground(new Color(66, 83, 109));
		SetBudgetPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(SetBudgetPanel);
		SetBudgetPanel.setLayout(null);
		
		JLabel lblSetBudget = new JLabel("Set Budget");
		lblSetBudget.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetBudget.setForeground(new Color(252, 187, 129));
		lblSetBudget.setFont(new Font("Quicksand Light", Font.BOLD, 30));
		lblSetBudget.setBounds(130, 11, 173, 48);
		SetBudgetPanel.add(lblSetBudget);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66, 83, 109));
		panel.setBounds(50, 70, 332, 101);
		SetBudgetPanel.add(panel);
		panel.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(new Color(252, 197, 129), 3);

        // Set the border for the panel
        panel.setBorder(border);
		
		JLabel SetCateg = new JLabel(category);
		SetCateg.setForeground(new Color(252, 187, 129));
		SetCateg.setHorizontalAlignment(SwingConstants.CENTER);
		SetCateg.setFont(new Font("Quicksand Light", Font.BOLD, 35));
		SetCateg.setBounds(10, 28, 312, 43);
		panel.add(SetCateg);
		
		JLabel lblCateg = new JLabel("Category");
		lblCateg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCateg.setForeground(new Color(85, 111, 146));
		lblCateg.setBackground(new Color(85, 111, 146));
		lblCateg.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lblCateg.setBounds(132, 11, 69, 19);
		panel.add(lblCateg);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setForeground(new Color(252, 187, 129));
		lblLimit.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblLimit.setBounds(50, 204, 60, 31);
		SetBudgetPanel.add(lblLimit);
		
		SetLimit = new JTextField();
		SetLimit.setHorizontalAlignment(SwingConstants.CENTER);
		SetLimit.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		SetLimit.setForeground(new Color(252, 187, 129));
		SetLimit.setBackground(new Color(66, 83, 109));
		SetLimit.setBounds(113, 198, 269, 48);
		SetBudgetPanel.add(SetLimit);
		SetLimit.setColumns(10);
		
		SetLimit.setBorder(border);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBackground(new Color(85, 111, 146));
		lblMonth.setForeground(new Color(85, 111, 146));
		lblMonth.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblMonth.setBounds(115, 268, 71, 31);
		SetBudgetPanel.add(lblMonth);
		
		JLabel SetMonth = new JLabel("May, 2023");
		SetMonth.setHorizontalAlignment(SwingConstants.CENTER);
		SetMonth.setBackground(new Color(85, 111, 146));
		SetMonth.setForeground(new Color(85, 111, 146));
		SetMonth.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		SetMonth.setBounds(196, 268, 113, 31);
		SetBudgetPanel.add(SetMonth);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(252, 187, 129));
		btnCancel.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		btnCancel.setBackground(new Color(66, 83, 109));
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCancel.setBounds(85, 310, 130, 40);
		SetBudgetPanel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LocalDate startDate = dateBudget;
				LocalDate endDate = dateBudget.withDayOfMonth(dateBudget.lengthOfMonth());
				
				UserSession session = UserSession.getInstance();
				int sessionId = session.getId();
				Date date = Date.valueOf(dateBudget);
				BigDecimal limitBudget = new BigDecimal(SetLimit.getText());
				BigDecimal spentBudget = new BigDecimal("0");
				
				Budget budget = new Budget(sessionId, date, category, limitBudget, spentBudget);
				
				Connection connection = DatabaseManager.getConnection();
				BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
				BudgeeDAOImpl.addBudget(budget);
				List <Budget> budgets = BudgeeDAOImpl.getBudgetsByDateRange(startDate, endDate);
				MainFrameUtils.displayAllBudget(budgets, parentPanel);
				
				dispose();
			}
		});
		btnSave.setForeground(new Color(252, 187, 129));
		btnSave.setBackground(new Color(66, 83, 109));
		btnSave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSave.setBounds(225, 310, 130, 40);
		SetBudgetPanel.add(btnSave);

	}
}
