package budgee;

import java.awt.BorderLayout;
import budgee.MainFrameUtils;
import budgee.UserSession;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.math.BigDecimal;

import com.toedter.calendar.JCalendar;
import javax.swing.border.LineBorder;

import budgee.DatabaseManager;
import budgee.UserSession;
import budgee.Record;

public class mainmain extends JFrame {

	private UserSession session = UserSession.getInstance();
	private String sessionUsername = session.getUsername();
	private MainFrameUtils mainFrameUtils = new MainFrameUtils();
	
	private JPanel frmMain;
	private final Action action = new SwingAction();

	private JButton rec_button;
	private JButton analytic_button;
	private JButton budget_button;
	private JButton user_button;
	private JPanel analytic_panel;
	private JPanel budget_panel;
	private JPanel rec_panel;
	private JPanel user_panel;
		
	private LocalDate daily_year_now;
	private JLabel daily_date;
	
	private LocalDate week_year_now;
	private JLabel weekly_date;
	
	private LocalDate month_year_now;
	private JLabel monthly_date;
	
	private LocalDate year_year_now;
	private JLabel yearly_date;
	
	private JButton daily_butt;
	private JButton weekly_butt;
	private JButton monthly_butt;
	private JButton yearly_butt;
	
	private JScrollPane activeScrollPane;
	private JPanel activeDatePanel;
	
	private BigDecimal expenseTotal = new BigDecimal("0");
	private BigDecimal incomeTotal = new BigDecimal("0");
	
	private BigDecimal CashIncomeTotal = new BigDecimal("0");
	private BigDecimal SavingsIncomeTotal = new BigDecimal("0");
	private BigDecimal CashExpenseTotal = new BigDecimal("0");
	private BigDecimal SavingsExpenseTotal = new BigDecimal("0");
	private List<Record> recordsByDate;
	private List<Budget> budgetsByDate;
	
	private LocalDate startDate = LocalDate.now().withDayOfMonth(1);
	private LocalDate endDate = LocalDate.now().withDayOfMonth(1);
	
	private JScrollPane unbudgetedPane;
	
	public mainmain() {		
		
        setSize(400, 300);
        setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 697);
		frmMain = new JPanel();
		frmMain.setBackground(new Color(49, 64, 83));
		frmMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(frmMain);

		JLayeredPane layerpanebelow = new JLayeredPane();
		layerpanebelow.setBounds(208, 182, 792, 460);

		rec_panel = new JPanel();
		rec_panel.setBackground(new Color(68, 83, 109));
		rec_panel.setBounds(0, 0, 792, 459);
		rec_panel.setLayout(null);
		
		JScrollPane recordScrollPane = new JScrollPane();
		recordScrollPane.setBackground(new Color(1,1,1));
		recordScrollPane.setBounds(0,52,670,385);
		rec_panel.add(recordScrollPane);
		recordScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		activeScrollPane = recordScrollPane;
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
		List<Record> records = BudgeeDAOImpl.getRecordsByDateRange(startDate, endDate);
		MainFrameUtils mainFrameUtils = new MainFrameUtils();
		MainFrameUtils.displayAllRecords(records, recordScrollPane);		
				
		
		JPanel exint = new JPanel();
		exint.setBounds(675, 64, 325, 100);
		exint.setBackground(new Color(66, 83, 109));
		exint.setForeground(new Color(255, 255, 255));

		JLabel ex_lebel = new JLabel("Expense:");
		ex_lebel.setHorizontalAlignment(SwingConstants.CENTER);
		ex_lebel.setForeground(new Color(252, 187, 109));
		ex_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		ex_lebel.setBounds(10, 15, 78, 18);
		exint.add(ex_lebel);

		JLabel inc_lebel = new JLabel("Income:");
		inc_lebel.setHorizontalAlignment(SwingConstants.CENTER);
		inc_lebel.setForeground(new Color(252, 187, 109));
		inc_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		inc_lebel.setBounds(10, 44, 80, 18);
		exint.add(inc_lebel);

		JLabel tot_lebel = new JLabel("Total:");
		tot_lebel.setHorizontalAlignment(SwingConstants.CENTER);
		tot_lebel.setForeground(new Color(252, 187, 109));
		tot_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		tot_lebel.setBounds(10, 71, 78, 18);
		exint.add(tot_lebel);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(208, 106, 457, 58);
		
		JLabel exint_EX_lbl = new JLabel("PHP 0");
		exint_EX_lbl.setForeground(new Color(252, 187, 109));
		exint_EX_lbl.setBackground(new Color(85, 111, 146));
		exint_EX_lbl.setBounds(109, 15, 194, 18);
		exint.add(exint_EX_lbl);

		JLabel exint_inc_lbl = new JLabel("PHP 0");
		exint_inc_lbl.setForeground(new Color(252, 187, 109));
		exint_inc_lbl.setBackground(new Color(85, 111, 146));
		exint_inc_lbl.setBounds(109, 42, 194, 18);
		exint.add(exint_inc_lbl);

		JLabel exint_total_lbl = new JLabel("PHP " + (incomeTotal.subtract(expenseTotal)));
		exint_total_lbl.setForeground(new Color(252, 187, 109));
		exint_total_lbl.setBackground(new Color(85, 111, 146));
		exint_total_lbl.setBounds(109, 74, 194, 18);
		exint.add(exint_total_lbl);
		
		JButton rec_calcu = new JButton("+");
		rec_calcu.setFocusable(false);
		rec_calcu.setFont(new Font("Quicksand Light", Font.BOLD, 50));
		rec_calcu.setForeground(new Color(252, 187, 109));
		rec_calcu.setBackground(new Color(85, 111, 146));
		rec_calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame(recordScrollPane);
				win.setVisible(true);
			}
		});
		rec_calcu.setBounds(690, 365, 70, 70);
		rec_panel.add(rec_calcu);

		JLabel reclebel = new JLabel("RECORDS");
		reclebel.setFont(new Font("Quicksand Light", Font.BOLD, 30));
		reclebel.setBounds(262, 11, 146, 30);
		reclebel.setForeground(new Color(252, 187, 109));
		rec_panel.add(reclebel);
		
		JScrollPane budgeted_scrlpn = new JScrollPane();
		JScrollPane unbudget_scrlpn = new JScrollPane();
		
		analytic_panel = new JPanel();
		analytic_panel.setBackground(new Color(66, 83, 109));
		analytic_panel.setBounds(0, 0, 792, 459);

		budget_panel = new JPanel();
		budget_panel.setBackground(new Color(66, 83, 109));
		budget_panel.setBounds(0, 0, 792, 459);
		budget_panel.setLayout(null);

		rec_button = new JButton("Record");
		rec_button.setBorder(null);
		rec_button.setBounds(37, 247, 139, 40);
		rec_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		rec_button.setForeground(new Color(252, 187, 109));
		rec_button.setBackground(new Color(85, 111, 146));
		rec_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(216, 115, 127));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				
				user_panel.setVisible(false);

				MainFrameUtils.refreshRecords(recordScrollPane);
				activeScrollPane = recordScrollPane;

			}
		});
		rec_button.setFocusable(false);

		analytic_button = new JButton("Analytics");
		analytic_button.setBorder(null);
		analytic_button.setBounds(37, 307, 139, 40);
		analytic_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		analytic_button.setForeground(new Color(252, 187, 109));
		analytic_button.setBackground(new Color(85, 111, 146));
		analytic_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(216, 115, 127));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
		

//				activeScrollPane = analyticScrollPane;
				user_panel.setVisible(false);

			}
		});
		analytic_button.setFocusable(false);

		budget_button = new JButton("Budget");
		budget_button.setBorder(null);
		budget_button.setBounds(37, 368, 139, 40);
		budget_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		budget_button.setForeground(new Color(252, 187, 109));
		budget_button.setBackground(new Color(85, 111, 146));
		budget_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(216, 115, 127));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
				user_panel.setVisible(false);
	
			}
		});
		budget_button.setFocusable(false);

		layerpanebelow.setLayout(null);

		layerpanebelow.add(rec_panel);
		layerpanebelow.add(analytic_panel);


		JButton calcu_analy = new JButton("+");
		calcu_analy.setBounds(690, 365, 70, 70);
		calcu_analy.setFont(new Font("Quicksand Light", Font.BOLD, 50));
		calcu_analy.setFocusable(false);
		calcu_analy.setAction(action);
		calcu_analy.setBackground(new Color(85, 111, 146));
		calcu_analy.setForeground(new Color(252, 187, 109));
		calcu_analy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame(recordScrollPane);
				win.setVisible(true);
			}
		});
		analytic_panel.setLayout(null);
		analytic_panel.add(calcu_analy);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66, 83, 109));
		panel.setBounds(27, 57, 638, 378);
		analytic_panel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(49, 64, 83));
		panel_1.setBounds(10, 22, 618, 164);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel cash_txtlbl = new JLabel("Cash");
		cash_txtlbl.setForeground(new Color(252, 187, 109));
		cash_txtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		cash_txtlbl.setFont(new Font("Quicksand Light", Font.BOLD, 35));
		cash_txtlbl.setBounds(169, 11, 110, 65);
		panel_1.add(cash_txtlbl);
		
		JLabel lblNewLabel_2 = new JLabel("This Period:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(252, 187, 109));
		lblNewLabel_2.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(169, 101, 110, 51);
		panel_1.add(lblNewLabel_2);
		
		JLabel expense_cash = new JLabel("PHP" + CashExpenseTotal );
		expense_cash.setToolTipText("Expense");
		expense_cash.setForeground(new Color(231, 65, 115));
		expense_cash.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		expense_cash.setBounds(289, 101, 145, 51);
		panel_1.add(expense_cash);
		ImageIcon cashlogo = new ImageIcon("imgs/dollar1.png");
		
		JPanel bg = new JPanel();
		bg.setBorder(new LineBorder(new Color(252, 187, 109), 3));
		bg.setBackground(new Color(49, 64, 83));
		bg.setBounds(10, 11, 149, 141);
		panel_1.add(bg);
		bg.setLayout(null);
		
		JLabel cash_logo = new JLabel("");
		cash_logo.setBounds(0, 0, 149, 141);
		bg.add(cash_logo);
		cash_logo.setIcon(cashlogo);
		
		final JLabel income_savings = new JLabel("PHP" + SavingsIncomeTotal );
		income_savings.setBounds(452, 101, 132, 51);
		panel_1.add(income_savings);
		income_savings.setToolTipText("Income");
		income_savings.setForeground(new Color(0, 234, 117));
		income_savings.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(49, 64, 83));
		panel_1_1.setBounds(10, 197, 618, 164);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel savings_txtlbl = new JLabel("Savings");
		savings_txtlbl.setForeground(new Color(252, 187, 109));
		savings_txtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		savings_txtlbl.setFont(new Font("Quicksand Light", Font.BOLD, 35));
		savings_txtlbl.setBounds(169, 11, 140, 65);
		panel_1_1.add(savings_txtlbl);
		ImageIcon savingslogo = new ImageIcon("imgs/piggy1.png");
		
		JPanel bg1 = new JPanel();
		bg1.setBorder(new LineBorder(new Color(252, 187, 109), 3));
		bg1.setBackground(new Color(49, 64, 83));
		bg1.setBounds(10, 12, 149, 141);
		panel_1_1.add(bg1);
		bg1.setLayout(null);
		
		JLabel savings_logo = new JLabel("");
		savings_logo.setBackground(new Color(238, 123, 157));
		savings_logo.setBounds(0, 0, 149, 141);
		bg1.add(savings_logo);
		savings_logo.setIcon(savingslogo);
		
		JLabel lblNewLabel_2_1 = new JLabel("This Period:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(252, 187, 109));
		lblNewLabel_2_1.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(169, 87, 110, 51);
		panel_1_1.add(lblNewLabel_2_1);
		
		

		final JLabel income_cash = new JLabel("PHP"+ CashIncomeTotal);
		income_cash.setBounds(448, 83, 133, 51);
		panel_1_1.add(income_cash);
		income_cash.setToolTipText("Income");
		income_cash.setForeground(new Color(0, 234, 117));
		income_cash.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		
		final JLabel expense_savings = new JLabel("PHP" + SavingsExpenseTotal);
		expense_savings.setBounds(289, 88, 151, 51);
		panel_1_1.add(expense_savings);
		expense_savings.setToolTipText("Expense");
		expense_savings.setForeground(new Color(231, 65, 115));
		expense_savings.setFont(new Font("Rockwell Nova", Font.BOLD, 17));

		layerpanebelow.add(budget_panel, Integer.valueOf(5));

		JButton budget_calcu = new JButton("+");
		budget_calcu.setFont(new Font("Quicksand Light", Font.BOLD, 50));
		budget_calcu.setFocusable(false);
		budget_calcu.setForeground(new Color(252, 187, 109));
		budget_calcu.setBackground(new Color(85, 111, 146));
		budget_calcu.setBounds(690, 365, 70, 70);
		budget_calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame(recordScrollPane);
				win.setVisible(true);
			}
		});
		budget_panel.add(budget_calcu);
		
		budgeted_scrlpn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		budgeted_scrlpn.setBounds(10, 62, 447, 246);
		budget_panel.add(budgeted_scrlpn);
		
		unbudget_scrlpn.setBounds(467, 62, 315, 246);
	    unbudget_scrlpn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		budget_panel.add(unbudget_scrlpn);
		
		unbudgetedPane = unbudget_scrlpn;

//		JPanel unstted_bdgt_pnl = new JPanel();
//		unstted_bdgt_pnl.setPreferredSize(new Dimension(200, 485));
//		unbudget_scrlpn.setViewportView(unstted_bdgt_pnl);
//		unstted_bdgt_pnl.setBackground(new Color(85, 111, 146));
//		unstted_bdgt_pnl.setLayout(null);

		JLabel budgeted_lbl = new JLabel("Budgeted Categories");
		budgeted_lbl.setForeground(new Color(252, 187, 109));
		budgeted_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		budgeted_lbl.setBounds(125, 26, 201, 25);
		budget_panel.add(budgeted_lbl);

		JLabel unbudgeted_lbl = new JLabel("Unbudgeted Categories");
		unbudgeted_lbl.setForeground(new Color(252, 187, 109));
		unbudgeted_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		unbudgeted_lbl.setBounds(508, 26, 227, 25);
		budget_panel.add(unbudgeted_lbl);
		
		JPanel dateSelectorContainer = new JPanel();
		final JPanel Daily = new JPanel();
		final JPanel Weekly = new JPanel();
		final JPanel Monthly = new JPanel();
		final JPanel Yearly = new JPanel();
		
		rec_button = new JButton("Record");
		rec_button.setBorder(null);
		rec_button.setBounds(37, 267, 139, 40);
		rec_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		rec_button.setForeground(new Color(252, 187, 109));
		rec_button.setBackground(new Color(85, 111, 146));
		rec_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(216, 115, 127));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
								user_panel.setVisible(false);
				activeScrollPane = recordScrollPane;
				recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(daily_year_now, daily_year_now);
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				layeredPane.setVisible(true);
				dateSelectorContainer.setVisible(true);
			}
		});
		rec_button.setFocusable(false);
		
		analytic_button = new JButton("Analytics");
		analytic_button.setBorder(null);
		analytic_button.setBounds(37, 327, 139, 40);
		analytic_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		analytic_button.setForeground(new Color(252, 187, 109));
		analytic_button.setBackground(new Color(85, 111, 146));
		analytic_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(216, 115, 127));
				budget_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
			
//				activeScrollPane = analyticScrollPane;
				user_panel.setVisible(false);

				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
				dateSelectorContainer.setVisible(true);
				layeredPane.setVisible(true);
			}
		});
		analytic_button.setFocusable(false);
		
		budget_button = new JButton("Budget");
		budget_button.setBorder(null);
		budget_button.setBounds(37, 388, 139, 40);
		budget_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		budget_button.setForeground(new Color(252, 187, 109));
		budget_button.setBackground(new Color(85, 111, 146));
		budget_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(216, 115, 127));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
			
				activeScrollPane = budgeted_scrlpn;
				user_panel.setVisible(false);
				List<Budget> budgets = BudgeeDAOImpl.getAllBudgets();
				List<String> unbudgetedCategories = BudgeeDAOImpl.getUnbudgetedCategories(budgets);
				MainFrameUtils.displayUnbudgetedCategories(unbudgetedCategories, unbudget_scrlpn, startDate.withDayOfMonth(1),budgeted_scrlpn);
				List<Budget> budgetsByDate = BudgeeDAOImpl.getBudgetsByDateRange(startDate);
				MainFrameUtils.displayAllBudget(budgetsByDate, activeScrollPane);
				Daily.setVisible(false);
				Weekly.setVisible(false);
				Monthly.setVisible(true);
				Yearly.setVisible(false);
				activeDatePanel = Monthly;
				dateSelectorContainer.setVisible(false);
				layeredPane.setVisible(true);
			}
		});
		budget_button.setFocusable(false);

		
		
		daily_year_now = LocalDate.now();
        daily_date = new JLabel(formatDate(daily_year_now));
        daily_date.setHorizontalAlignment(SwingConstants.CENTER);
        daily_date.setForeground(new Color(252, 187, 109));
        daily_date.setFont(new Font("Quicksand Light", Font.BOLD, 20));
        daily_date.setBounds(140, 11, 185, 34);

	
		Daily.setLayout(null);
		Daily.setBackground(new Color(66, 83, 109));
		Daily.setBounds(0, 0, 457, 58);
		layeredPane.add(Daily);
		
		JButton daily_left = new JButton("<");
		daily_left.setFocusable(false);
		daily_left.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		daily_left.setForeground(new Color(252, 187, 109));
		daily_left.setBackground(new Color(85, 111, 146));
		daily_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_year_now = daily_year_now.minusDays(1);
				daily_date.setText(formatDate(daily_year_now));
				recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(daily_year_now, daily_year_now);
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = daily_year_now;
				endDate = daily_year_now;
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
			}
		});
		daily_left.setBounds(10, 11, 41, 34);
		Daily.add(daily_left);

		JButton daily_right = new JButton(">");
		daily_right.setFocusable(false);
		daily_right.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		daily_right.setForeground(new Color(252, 187, 109));
		daily_right.setBackground(new Color(85, 111, 146));
		daily_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_year_now = daily_year_now.plusDays(1);
				daily_date.setText(formatDate(daily_year_now));
				recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(daily_year_now, daily_year_now);
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = daily_year_now;
				endDate = daily_year_now;
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);				
			}
		});
		daily_right.setBounds(406, 11, 41, 34);
		Daily.add(daily_right);
		Daily.add(daily_date);


		Weekly.setLayout(null);
		Weekly.setBackground(new Color(66, 83, 109));
		Weekly.setBounds(0, 0, 457, 58);
		layeredPane.add(Weekly);
		
        week_year_now = LocalDate.now();
        weekly_date = new JLabel(getFormattedDateweek());
        weekly_date.setHorizontalAlignment(SwingConstants.CENTER);
        weekly_date.setForeground(new Color(252, 187, 109));
        weekly_date.setFont(new Font("Quicksand Light", Font.BOLD, 17));
        weekly_date.setBounds(10, 11, 437, 34);
        Weekly.add(weekly_date);
        
		JButton weekly_left = new JButton("<");
		weekly_left.setFocusable(false);
		weekly_left.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		weekly_left.setForeground(new Color(252, 187, 109));
		weekly_left.setBackground(new Color(85, 111, 146));
		weekly_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				week_year_now = week_year_now.minusWeeks(1);
	            weekly_date.setText(getFormattedDateweek());
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(week_year_now, week_year_now.plusDays(6));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = week_year_now;
				endDate = week_year_now.plusDays(6);
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
			}
		});
		weekly_left.setBounds(10, 11, 41, 34);
		Weekly.add(weekly_left);

		JButton weekly_right = new JButton(">");
		weekly_right.setFocusable(false);
		weekly_right.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		weekly_right.setForeground(new Color(252, 187, 109));
		weekly_right.setBackground(new Color(85, 111, 146));
		weekly_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				week_year_now = week_year_now.plusWeeks(1);
	            weekly_date.setText(getFormattedDateweek());
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(week_year_now, week_year_now.plusDays(6));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = week_year_now;
				endDate = week_year_now.plusDays(6);
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
			}
		});
		weekly_right.setBounds(406, 11, 41, 34);
		Weekly.add(weekly_right);

		
		Monthly.setLayout(null);
		Monthly.setBackground(new Color(66, 83, 109));
		Monthly.setBounds(0, 0, 457, 58);
		layeredPane.add(Monthly);
		
		month_year_now = LocalDate.now();
        monthly_date = new JLabel(getFormattedDatemonth());
        monthly_date.setHorizontalAlignment(SwingConstants.CENTER);
        monthly_date.setForeground(new Color(252, 187, 109));
        monthly_date.setFont(new Font("Quicksand Light", Font.BOLD, 17));
        monthly_date.setBounds(10, 11, 437, 34);
        Monthly.add(monthly_date);

		JButton monthly_left = new JButton("<");
		monthly_left.setFocusable(false);
		monthly_left.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		monthly_left.setForeground(new Color(252, 187, 109));
		monthly_left.setBackground(new Color(85, 111, 146));
		monthly_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month_year_now = month_year_now.minusMonths(1);
	            monthly_date.setText(getFormattedDatemonth());
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = month_year_now.withDayOfMonth(1);
				endDate = month_year_now.withDayOfMonth(month_year_now.lengthOfMonth());
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
				
				if (activeScrollPane == recordScrollPane) {
					recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(month_year_now.withDayOfMonth(1), month_year_now.withDayOfMonth(month_year_now.lengthOfMonth()));
	            	MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
	            }
	          else {
	        	  budgetsByDate = BudgeeDAOImpl.getBudgetsByDateRange(startDate.withDayOfMonth(1));
					List<String> unbudgetedCategories = BudgeeDAOImpl.getUnbudgetedCategories(budgetsByDate);
					MainFrameUtils.displayUnbudgetedCategories(unbudgetedCategories, unbudget_scrlpn, startDate.withDayOfMonth(1),budgeted_scrlpn);
	        	  MainFrameUtils.displayAllBudget(budgetsByDate, activeScrollPane);
	          }
			}
		});
		monthly_left.setBounds(10, 11, 41, 34);
		Monthly.add(monthly_left);

		JButton monthly_right = new JButton(">");
		monthly_right.setFocusable(false);
		monthly_right.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		monthly_right.setForeground(new Color(252, 187, 109));
		monthly_right.setBackground(new Color(85, 111, 146));
		monthly_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month_year_now = month_year_now.plusMonths(1);
	            monthly_date.setText(getFormattedDatemonth());
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = month_year_now.withDayOfMonth(1);
				endDate = month_year_now.withDayOfMonth(month_year_now.lengthOfMonth());
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
				
				if (activeScrollPane == recordScrollPane) {
					recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(month_year_now.withDayOfMonth(1), month_year_now.withDayOfMonth(month_year_now.lengthOfMonth()));
	            	MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
	            }
				else {
	        	  	budgetsByDate = BudgeeDAOImpl.getBudgetsByDateRange(startDate.withDayOfMonth(1));
					List<String> unbudgetedCategories = BudgeeDAOImpl.getUnbudgetedCategories(budgetsByDate);
					MainFrameUtils.displayUnbudgetedCategories(unbudgetedCategories, unbudget_scrlpn, startDate.withDayOfMonth(1),budgeted_scrlpn);
					MainFrameUtils.displayAllBudget(budgetsByDate, activeScrollPane);
				}
			}
		});
		monthly_right.setBounds(406, 11, 41, 34);
		Monthly.add(monthly_right);


		Yearly.setLayout(null);
		Yearly.setBackground(new Color(66, 83, 109));
		Yearly.setBounds(0, 0, 457, 58);
		layeredPane.add(Yearly);
		
		year_year_now = LocalDate.now();
        yearly_date = new JLabel(getFormattedDateyear());
        yearly_date.setBackground(new Color(85, 111, 146));
        yearly_date.setHorizontalAlignment(SwingConstants.CENTER);
        yearly_date.setForeground(new Color(252, 187, 109));
        yearly_date.setFont(new Font("Quicksand Light", Font.BOLD, 17));
        yearly_date.setBounds(10, 11, 437, 34);
        Yearly.add(yearly_date);

		JButton yearly_left = new JButton("<");
		yearly_left.setFocusable(false);
		yearly_left.setBackground(new Color(85, 111, 146));
		yearly_left.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		yearly_left.setForeground(new Color(252, 187, 109));
		yearly_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year_year_now = year_year_now.minusYears(1);
	            yearly_date.setText(getFormattedDateyear());
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(year_year_now.withDayOfYear(1), year_year_now.withDayOfYear(year_year_now.lengthOfYear()));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = year_year_now.withDayOfYear(1);
				endDate = year_year_now.withDayOfYear(year_year_now.lengthOfYear());
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
			}
		});
		yearly_left.setBounds(10, 11, 41, 34);
		Yearly.add(yearly_left);

		JButton yearly_right = new JButton(">");
		yearly_right.setFocusable(false);
		yearly_right.setBackground(new Color(85, 111, 146));
		yearly_right.setForeground(new Color(252, 187, 109));
		yearly_right.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		yearly_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year_year_now = year_year_now.plusYears(1);
	            yearly_date.setText(getFormattedDateyear());
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(year_year_now.withDayOfYear(1), year_year_now.withDayOfYear(year_year_now.lengthOfYear()));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = year_year_now.withDayOfYear(1);
				endDate = year_year_now.withDayOfYear(year_year_now.lengthOfYear());
				CashExpenseTotal = BudgeeDAOImpl.getCashExpenseTotal(recordsByDate);
				CashIncomeTotal = BudgeeDAOImpl.getCashIncomeTotal(recordsByDate);
				SavingsExpenseTotal = BudgeeDAOImpl.getSavingsExpenseTotal(recordsByDate);
				SavingsIncomeTotal = BudgeeDAOImpl.getSavingsIncomeTotal(recordsByDate);
				income_cash.setText("PHP"+ CashIncomeTotal);
				expense_cash.setText("PHP"+ SavingsExpenseTotal);
				income_cash.setText("PHP"+ SavingsIncomeTotal);
				expense_cash.setText("PHP"+ CashExpenseTotal);
			}
		});
		yearly_right.setBounds(406, 11, 41, 34);
		Yearly.add(yearly_right);

		daily_butt = new JButton("Daily");
		daily_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_butt.setBackground(new Color(216, 115, 127));
				weekly_butt.setBackground(new Color(85, 111, 146));
				monthly_butt.setBackground(new Color(85, 111, 146));
				yearly_butt.setBackground(new Color(85, 111, 146));
				Daily.setVisible(true);
				Weekly.setVisible(false);
				Monthly.setVisible(false);
				Yearly.setVisible(false);
				activeDatePanel = Daily;
			}
		});
		daily_butt.setBounds(226, 64, 92, 31);
		daily_butt.setForeground(new Color(252, 187, 109));
		daily_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		daily_butt.setFocusable(false);
		daily_butt.setBackground(new Color(85, 111, 146));
		
		weekly_butt = new JButton("Weekly");
		weekly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_butt.setBackground(new Color(85, 111, 146));
				weekly_butt.setBackground(new Color(216, 115, 127));
				monthly_butt.setBackground(new Color(85, 111, 146));
				yearly_butt.setBackground(new Color(85, 111, 146));
				Daily.setVisible(false);
				Weekly.setVisible(true);
				Monthly.setVisible(false);
				Yearly.setVisible(false);
				activeDatePanel = Weekly;
			}
		});
		weekly_butt.setBounds(339, 64, 92, 31);
		weekly_butt.setForeground(new Color(252, 187, 109));
		weekly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		weekly_butt.setFocusable(false);
		weekly_butt.setBackground(new Color(85, 111, 146));

		monthly_butt = new JButton("Monthly");
		monthly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_butt.setBackground(new Color(85, 111, 146));
				weekly_butt.setBackground(new Color(85, 111, 146));
				monthly_butt.setBackground(new Color(216, 115, 127));
				yearly_butt.setBackground(new Color(85, 111, 146));
				Daily.setVisible(false);
				Weekly.setVisible(false);
				Monthly.setVisible(true);
				Yearly.setVisible(false);
				activeDatePanel = Monthly;
			}
		});
		monthly_butt.setBounds(447, 64, 92, 31);
		monthly_butt.setForeground(new Color(252, 187, 109));
		monthly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		monthly_butt.setFocusable(false);
		monthly_butt.setBackground(new Color(85, 111, 146));

		yearly_butt = new JButton("Yearly");
		yearly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daily_butt.setBackground(new Color(85, 111, 146));
				weekly_butt.setBackground(new Color(85, 111, 146));
				monthly_butt.setBackground(new Color(85, 111, 146));
				yearly_butt.setBackground(new Color(216, 115, 127));
				Daily.setVisible(false);
				Weekly.setVisible(false);
				Monthly.setVisible(false);
				Yearly.setVisible(true);
				activeDatePanel = Yearly;
			}
		});
		yearly_butt.setBounds(555, 64, 92, 31);
		yearly_butt.setForeground(new Color(252, 187, 109));
		yearly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		yearly_butt.setFocusable(false);
		yearly_butt.setBackground(new Color(85, 111, 146));
		exint.setLayout(null);
		
		frmMain.setLayout(null);
		frmMain.add(layeredPane);

//		frmMain.add(monthly_butt);
//		frmMain.add(yearly_butt);
//		frmMain.add(daily_butt);
//		frmMain.add(weekly_butt);
		frmMain.add(exint);
		frmMain.add(budget_button);
		frmMain.add(analytic_button);
		frmMain.add(rec_button);
		frmMain.add(layerpanebelow);
		
		user_panel = new JPanel();
		user_panel.setBackground(new Color(66, 83, 109));
		user_panel.setBounds(0, 0, 792, 459);
		Border border = BorderFactory.createLineBorder(new Color(109, 74, 194, 18), 3);
		user_panel.setBorder(border);
		layerpanebelow.add(user_panel);
		user_panel.setLayout(null);
		
		JLabel user_image = new JLabel("");
		user_image.setBorder(new LineBorder(new Color(252, 187, 109), 3, true));
		user_image.setBounds(27, 104, 250, 250);
		user_panel.add(user_image);
		
		JButton btnNewButton = new JButton("Change Profile");
		btnNewButton.setFont(new Font("Quicksand Light", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(252, 187, 109));
		btnNewButton.setBackground(new Color(85, 111, 149));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter Image Extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				browseImageFile.addChoosableFileFilter(fnef);
				
				
				int showOpenDialogue = browseImageFile.showOpenDialog(null);
				if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display Image on Jlabel
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize Selected Image
					Image image = ii.getImage().getScaledInstance(user_image.getWidth(), user_image.getHeight(), Image.SCALE_SMOOTH);
					user_image.setIcon(new ImageIcon(image));
					
				}
			}
		});
		btnNewButton.setBounds(86, 365, 136, 23);
		user_panel.add(btnNewButton);
		
		JButton logOut_button = new JButton("Log Out");
		logOut_button.setFocusable(false);
		logOut_button.setBorder(null);
		logOut_button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane optionPane = new JOptionPane("Are you sure you want to logout?", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
		        JDialog dialog = optionPane.createDialog(user_panel, "Logout Confirmation");
		        dialog.setLocationRelativeTo(null); // Center on screen
		        dialog.setVisible(true);

		        Object selectedValue = optionPane.getValue();
		        if (selectedValue instanceof Integer && (int) selectedValue == JOptionPane.YES_OPTION) {
		            // Perform logout operations
		            // ...

		            // Create and show the new JFrame
		            LoginFrameUwU loginFrame = new LoginFrameUwU();
		            loginFrame.frmLoginBudgee.setVisible(true);

		            // Hide the current JFrame (login frame)
		            loginFrame.getClass();
		            dispose();
		            
		        }
		    }
		});
		logOut_button.setBounds(693, 425, 89, 23);
		user_panel.add(logOut_button);

		JLabel logoBudgee = new JLabel("");
		ImageIcon loglog = new ImageIcon("imgs/budgeeLogoMain.png");
		logoBudgee.setIcon(loglog);
		logoBudgee.setBounds(53, 64, 100, 120);
		frmMain.add(logoBudgee);

		JLabel usernameLabel = new JLabel(sessionUsername);
		usernameLabel.setBorder(null);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setForeground(new Color(252, 187, 109));
		usernameLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		usernameLabel.setBounds(37, 214, 139, 42);
		frmMain.add(usernameLabel);
		
		user_button = new JButton("User");
		user_button.setBorder(null);
		user_button.setFocusable(false);
		user_button.setBackground(new Color(85, 111, 146));
		user_button.setForeground(new Color(252, 187, 109));
		user_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		user_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(216, 115, 127));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				user_panel.setVisible(true);
				income_cash.setText("PHP"+ incomeTotal);
				expense_cash.setText("PHP"+ expenseTotal);
			}
		});
		user_button.setBounds(37, 447, 139, 40);
		frmMain.add(user_button);
		
		dateSelectorContainer.add(daily_butt);
		dateSelectorContainer.add(weekly_butt);
		dateSelectorContainer.add(monthly_butt);
		dateSelectorContainer.add(yearly_butt);
		
		dateSelectorContainer.setBackground(new Color(49, 64, 83));
		dateSelectorContainer.setBounds(208, 53, 457, 50);
		frmMain.add(dateSelectorContainer);

	}
	
	JScrollPane getUnbudgetedPane() {
		return unbudgetedPane;
	}
	
	LocalDate getPanelStartDate() {
		return startDate;
	}

	LocalDate getPanelEndDate() {
		return endDate;
	}
	
	private String formatDate(LocalDate year_now2) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY");
        return year_now2.format(formatter);
	}
	
	private String getFormattedDateweek() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate endDate = week_year_now.plusDays(6);
        return week_year_now.format(formatter) + " - " + endDate.format(formatter);
    }
	
	private String getFormattedDatemonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, yyyy");
        String monthAndYear;
        return monthAndYear = month_year_now.getMonth() + ", " + month_year_now.getYear();
//        LocalDate endDate = month_year_now.plusDays(30);
//        return month_year_now.format(formatter) + " - " + endDate.format(formatter);
    }
	
	private String getFormattedDateyear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String year;
        return year = String.valueOf(year_year_now.getYear());
//        LocalDate endDate = year_year_now.plusDays(365);
//        return year_year_now.format(formatter) + " - " + endDate.format(formatter);
    }

	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "+");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}