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
	private JTextField cashbal_txtfld;
	private JTextField savebal_txtfld;

	private JButton rec_button;
	private JButton analytic_button;
	private JButton budget_button;
	private JButton acc_button;
	private JButton categ_button;
	private JButton user_button;
	private JPanel analytic_panel;
	private JPanel budget_panel;
	private JPanel acc_panel;
	private JPanel categ_panel;
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
	private List<Record> recordsByDate;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
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
		List<Record> records = BudgeeDAOImpl.getAllRecords();
		
		MainFrameUtils mainFrameUtils = new MainFrameUtils();

		mainFrameUtils.displayAllRecords(records, recordScrollPane);		
				
		
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
		

		analytic_panel = new JPanel();
		analytic_panel.setBackground(new Color(66, 83, 109));
		analytic_panel.setBounds(0, 0, 792, 459);

		budget_panel = new JPanel();
		budget_panel.setBackground(new Color(66, 83, 109));
		budget_panel.setBounds(0, 0, 792, 459);
		budget_panel.setLayout(null);
		
		acc_panel = new JPanel();
		acc_panel.setBackground(new Color(66, 83, 109));
		acc_panel.setBounds(0, 0, 792, 459);
		acc_panel.setLayout(null);

		categ_panel = new JPanel();
		categ_panel.setForeground(new Color(252, 187, 109));
		categ_panel.setBackground(new Color(66, 83, 109));
		categ_panel.setBounds(0, 0, 792, 459);
		categ_panel.setLayout(null);

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
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
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
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);

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
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
//				activeScrollPane = budgetScrollPane;
				user_panel.setVisible(false);
			}
		});
		budget_button.setFocusable(false);

		acc_button = new JButton("Account");
		acc_button.setBorder(null);
		acc_button.setBounds(37, 429, 139, 40);
		acc_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		acc_button.setForeground(new Color(252, 187, 109));
		acc_button.setBackground(new Color(85, 111, 146));
		acc_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(216, 115, 127));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(true);
				categ_panel.setVisible(false);
				user_panel.setVisible(false);
			}
		});
		acc_button.setFocusable(false);

		categ_button = new JButton("Category");
		categ_button.setBorder(null);
		categ_button.setBounds(37, 489, 139, 40);
		categ_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		categ_button.setForeground(new Color(252, 187, 109));
		categ_button.setBackground(new Color(85, 111, 146));
		categ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(216, 115, 127));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(true);
				user_panel.setVisible(false);
			}
		});
		categ_button.setFocusable(false);

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
		
		JLabel expense_anal = new JLabel("" + expenseTotal );
		expense_anal.setToolTipText("Expense");
		expense_anal.setForeground(new Color(231, 65, 115));
		expense_anal.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		expense_anal.setBounds(289, 101, 145, 51);
		panel_1.add(expense_anal);
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
		
		final JLabel income_anal = new JLabel("PHP"+ incomeTotal);
		income_anal.setToolTipText("Income");
		income_anal.setForeground(new Color(0, 234, 117));
		income_anal.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		income_anal.setBounds(451, 102, 133, 51);
		panel_1.add(income_anal);
		
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
		
		JLabel expense_anal1 = new JLabel("<expenseSav>");
		expense_anal1.setToolTipText("Expense");
		expense_anal1.setForeground(new Color(231, 65, 115));
		expense_anal1.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		expense_anal1.setBounds(289, 87, 151, 51);
		panel_1_1.add(expense_anal1);
		
		JLabel income_anal1 = new JLabel("<incomeSav>");
		income_anal1.setToolTipText("Income");
		income_anal1.setForeground(new Color(0, 234, 117));
		income_anal1.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
		income_anal1.setBounds(450, 88, 132, 51);
		panel_1_1.add(income_anal1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		class SelectedDateWrapper {
		    private Date selectedDate;
		    
		    public void setSelectedDate(Date date) {
		        selectedDate = date;
		    }
		    
		    public Date getSelectedDate() {
		        return selectedDate;
		    }
		}

		final SelectedDateWrapper selectedDateWrapper = new SelectedDateWrapper();

		layerpanebelow.add(budget_panel);

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
		
		JScrollPane budgeted_scrlpn = new JScrollPane();
		budgeted_scrlpn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		budgeted_scrlpn.setBounds(10, 62, 447, 246);
		budget_panel.add(budgeted_scrlpn);
		
		List<Budget> budgets = BudgeeDAOImpl.getAllBudgets();

		mainFrameUtils.displayAllBudget(budgets, budgeted_scrlpn);
		
		JScrollPane unbudget_scrlpn = new JScrollPane();
		unbudget_scrlpn.setBounds(467, 62, 315, 246);
	    unbudget_scrlpn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		budget_panel.add(unbudget_scrlpn);

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


		layerpanebelow.add(acc_panel, Integer.valueOf(0));



		JButton acc_calcu = new JButton("+");
		acc_calcu.setFont(new Font("Quicksand Light", Font.BOLD, 50));
		acc_calcu.setFocusable(false);
		acc_calcu.setBackground(new Color(85, 111, 146));
		acc_calcu.setForeground(new Color(252, 187, 109));
		acc_calcu.setBounds(690, 365, 70, 70);
		acc_calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame(recordScrollPane);
				win.setVisible(true);
			}
		});
		acc_panel.add(acc_calcu);

		JPanel overall_acc_panel = new JPanel();
		overall_acc_panel.setBackground(new Color(85, 111, 146));
		overall_acc_panel.setBounds(25, 62, 430, 246);
		acc_panel.add(overall_acc_panel);
		overall_acc_panel.setLayout(null);

		JLabel income_atm_lbl = new JLabel("Income until now");
		income_atm_lbl.setBounds(30, 31, 150, 19);
		income_atm_lbl.setForeground(new Color(252, 187, 109));
		income_atm_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 18));
		overall_acc_panel.add(income_atm_lbl);

		JLabel expense_atm_lbl = new JLabel("Expense until now");
		expense_atm_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		expense_atm_lbl.setForeground(new Color(252, 187, 109));
		expense_atm_lbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		expense_atm_lbl.setBounds(240, 31, 180, 19);
		overall_acc_panel.add(expense_atm_lbl);

		JLabel totalbal_lbl = new JLabel("Total Balance");
		totalbal_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalbal_lbl.setForeground(new Color(252, 187, 109));
		totalbal_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 18));
		totalbal_lbl.setBounds(155, 130, 130, 19);
		overall_acc_panel.add(totalbal_lbl);

		JLabel income_lbl = new JLabel("");
		income_lbl.setForeground(new Color(252, 187, 109));
		income_lbl.setBackground(new Color(85, 111, 146));
		income_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		income_lbl.setBounds(21, 61, 186, 57);
		overall_acc_panel.add(income_lbl);

		JLabel expense_lbl = new JLabel("");
		expense_lbl.setForeground(new Color(252, 187, 109));
		expense_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		expense_lbl.setBackground(new Color(85, 111, 146));
		expense_lbl.setBounds(226, 61, 186, 57);
		overall_acc_panel.add(expense_lbl);

		JLabel total_lbl = new JLabel("");
		total_lbl.setForeground(new Color(252, 187, 109));
		total_lbl.setBounds(125, 159, 186, 57);
		overall_acc_panel.add(total_lbl);
		total_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		total_lbl.setBackground(new Color(85, 111, 146));

		JPanel cash_acc_panel = new JPanel();
		cash_acc_panel.setBackground(new Color(85, 111, 146));
		cash_acc_panel.setBounds(471, 62, 300, 112);
		acc_panel.add(cash_acc_panel);
		cash_acc_panel.setLayout(null);

		JLabel cash_lbl = new JLabel("Cash");
		cash_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		cash_lbl.setBounds(21, 11, 70, 22);
		cash_lbl.setForeground(new Color(252, 187, 109));
		cash_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 25));
		cash_acc_panel.add(cash_lbl);

		JLabel cashbal_lbl = new JLabel("Balance:");
		cashbal_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		cashbal_lbl.setForeground(new Color(252, 187, 109));
		cashbal_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		cashbal_lbl.setBounds(21, 48, 70, 19);
		cash_acc_panel.add(cashbal_lbl);

		cashbal_txtfld = new JTextField();
		cashbal_txtfld.setForeground(new Color(252, 187, 109));
		cashbal_txtfld.setFocusable(false);
		cashbal_txtfld.setColumns(10);
		cashbal_txtfld.setBackground(new Color(66, 83, 109));
		cashbal_txtfld.setBounds(103, 44, 187, 27);
		cash_acc_panel.add(cashbal_txtfld);

		JButton cashsve_btn = new JButton("Save");
		cashsve_btn.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		cashsve_btn.setFocusable(false);
		cashsve_btn.setForeground(new Color(252, 187, 109));
		cashsve_btn.setBackground(new Color(66, 83, 109));
		cashsve_btn.setBounds(154, 78, 89, 23);
		cash_acc_panel.add(cashsve_btn);

		JPanel savings_acc_panel = new JPanel();
		savings_acc_panel.setBackground(new Color(85, 111, 146));
		savings_acc_panel.setBounds(471, 196, 300, 112);
		acc_panel.add(savings_acc_panel);
		savings_acc_panel.setLayout(null);

		JLabel savings_lbl = new JLabel("Savings");
		savings_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		savings_lbl.setBounds(21, 11, 95, 30);
		savings_lbl.setForeground(new Color(252, 187, 109));
		savings_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 25));
		savings_acc_panel.add(savings_lbl);

		JLabel savebal_lbl = new JLabel("Balance:");
		savebal_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		savebal_lbl.setForeground(new Color(252, 187, 109));
		savebal_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		savebal_lbl.setBounds(21, 48, 70, 19);
		savings_acc_panel.add(savebal_lbl);

		savebal_txtfld = new JTextField();
		savebal_txtfld.setForeground(new Color(252, 187, 109));
		savebal_txtfld.setColumns(10);
		savebal_txtfld.setBackground(new Color(66, 83, 109));
		savebal_txtfld.setBounds(103, 44, 187, 27);
		savings_acc_panel.add(savebal_txtfld);

		JButton svngssve_btn = new JButton("Save");
		svngssve_btn.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		svngssve_btn.setFocusable(false);
		svngssve_btn.setForeground(new Color(252, 187, 109));
		svngssve_btn.setBackground(new Color(66, 83, 109));
		svngssve_btn.setBounds(154, 78, 89, 23);
		savings_acc_panel.add(svngssve_btn);

		JLabel ovrall_lbl = new JLabel("Overall");
		ovrall_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		ovrall_lbl.setForeground(new Color(252, 187, 109));
		ovrall_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 25));
		ovrall_lbl.setBounds(187, 30, 97, 25);
		acc_panel.add(ovrall_lbl);

		JLabel accs_lbl = new JLabel("Accounts");
		accs_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		accs_lbl.setForeground(new Color(252, 187, 109));
		accs_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 25));
		accs_lbl.setBounds(560, 30, 125, 25);
		acc_panel.add(accs_lbl);

		layerpanebelow.add(categ_panel, Integer.valueOf(5));



		JButton categ_calcu = new JButton("+");
		categ_calcu.setFont(new Font("Quicksand Light", Font.BOLD, 50));
		categ_calcu.setFocusable(false);
		categ_calcu.setForeground(new Color(252, 187, 109));
		categ_calcu.setBackground(new Color(85, 111, 146));
		categ_calcu.setBounds(690, 365, 70, 70);
		categ_calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame(recordScrollPane);
				win.setVisible(true);
			}
		});
		categ_panel.add(categ_calcu);

		JScrollPane income_categ_sp = new JScrollPane();
		income_categ_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		income_categ_sp.setBounds(10, 63, 382, 244);
		categ_panel.add(income_categ_sp);

		JPanel income_categ_pnl = new JPanel();
		income_categ_pnl.setBackground(new Color(85, 111, 146));
		income_categ_pnl.setForeground(new Color(85, 111, 146));
		income_categ_pnl.setPreferredSize(new Dimension(382, 400));
		income_categ_sp.setViewportView(income_categ_pnl);
		income_categ_pnl.setLayout(null);

		JPanel salary_categ_pnl = new JPanel();
		salary_categ_pnl.setLayout(null);
		salary_categ_pnl.setBackground(new Color(69, 92, 123));
		salary_categ_pnl.setBounds(10, 11, 346, 76);
		income_categ_pnl.add(salary_categ_pnl);

		JLabel bills_lbl_1_3 = new JLabel("SALARY");
		bills_lbl_1_3.setForeground(new Color(252, 187, 109));
		bills_lbl_1_3.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_3.setBounds(140, 8, 75, 25);
		salary_categ_pnl.add(bills_lbl_1_3);

		JButton edit_btn_inc_1 = new JButton("Edit");
		edit_btn_inc_1.setFocusable(false);
		edit_btn_inc_1.setForeground(new Color(252, 187, 103));
		edit_btn_inc_1.setBackground(new Color(85, 111, 146));
		edit_btn_inc_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_1.setBounds(83, 40, 89, 25);
		salary_categ_pnl.add(edit_btn_inc_1);

		JButton del_btn_inc_1 = new JButton("Delete");
		del_btn_inc_1.setFocusable(false);
		del_btn_inc_1.setBackground(new Color(85, 111, 146));
		del_btn_inc_1.setForeground(new Color(252, 187, 103));
		del_btn_inc_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_inc_1.setBounds(180, 40, 89, 25);
		salary_categ_pnl.add(del_btn_inc_1);

		JPanel sale_categ_pnl = new JPanel();
		sale_categ_pnl.setLayout(null);
		sale_categ_pnl.setBackground(new Color(69, 92, 123));
		sale_categ_pnl.setBounds(10, 97, 346, 76);
		income_categ_pnl.add(sale_categ_pnl);

		JLabel bills_lbl_1_4 = new JLabel("SALE");
		bills_lbl_1_4.setForeground(new Color(252, 187, 109));
		bills_lbl_1_4.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_4.setBounds(152, 8, 48, 25);
		sale_categ_pnl.add(bills_lbl_1_4);

		JButton edit_btn_inc_2 = new JButton("Edit");
		edit_btn_inc_2.setFocusable(false);
		edit_btn_inc_2.setForeground(new Color(252, 187, 103));
		edit_btn_inc_2.setBackground(new Color(85, 111, 146));
		edit_btn_inc_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_2.setBounds(83, 40, 89, 25);
		sale_categ_pnl.add(edit_btn_inc_2);

		JButton del_btn_inc_2 = new JButton("Delete");
		del_btn_inc_2.setFocusable(false);
		del_btn_inc_2.setBackground(new Color(85, 111, 146));
		del_btn_inc_2.setForeground(new Color(252, 187, 103));
		del_btn_inc_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_inc_2.setBounds(180, 40, 89, 25);
		sale_categ_pnl.add(del_btn_inc_2);

		JPanel refund_categ_pnl = new JPanel();
		refund_categ_pnl.setLayout(null);
		refund_categ_pnl.setBackground(new Color(69, 92, 123));
		refund_categ_pnl.setBounds(10, 184, 346, 76);
		income_categ_pnl.add(refund_categ_pnl);

		JLabel bills_lbl_1_5 = new JLabel("REFUNDS");
		bills_lbl_1_5.setForeground(new Color(252, 187, 109));
		bills_lbl_1_5.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_5.setBounds(130, 8, 93, 25);
		refund_categ_pnl.add(bills_lbl_1_5);

		JButton edit_btn_inc_3 = new JButton("Edit");
		edit_btn_inc_3.setFocusable(false);
		edit_btn_inc_3.setForeground(new Color(252, 187, 103));
		edit_btn_inc_3.setBackground(new Color(85, 111, 146));
		edit_btn_inc_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_3.setBounds(83, 40, 89, 25);
		refund_categ_pnl.add(edit_btn_inc_3);

		JButton del_btn_inc_3 = new JButton("Delete");
		del_btn_inc_3.setFocusable(false);
		del_btn_inc_3.setForeground(new Color(252, 187, 103));
		del_btn_inc_3.setBackground(new Color(85, 111, 146));
		del_btn_inc_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_inc_3.setBounds(180, 40, 89, 25);
		refund_categ_pnl.add(del_btn_inc_3);

		JPanel awards_categ_pnl = new JPanel();
		awards_categ_pnl.setLayout(null);
		awards_categ_pnl.setBackground(new Color(69, 92, 123));
		awards_categ_pnl.setBounds(10, 271, 346, 76);
		income_categ_pnl.add(awards_categ_pnl);

		JLabel bills_lbl_1_5_1 = new JLabel("AWARDS");
		bills_lbl_1_5_1.setForeground(new Color(252, 187, 109));
		bills_lbl_1_5_1.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_5_1.setBounds(132, 8, 89, 25);
		awards_categ_pnl.add(bills_lbl_1_5_1);

		JButton edit_btn_inc_4 = new JButton("Edit");
		edit_btn_inc_4.setFocusable(false);
		edit_btn_inc_4.setForeground(new Color(252, 187, 103));
		edit_btn_inc_4.setBackground(new Color(85, 111, 146));
		edit_btn_inc_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_4.setBounds(83, 40, 89, 25);
		awards_categ_pnl.add(edit_btn_inc_4);

		JButton del_btn_inc_4 = new JButton("Delete");
		del_btn_inc_4.setFocusable(false);
		del_btn_inc_4.setBackground(new Color(85, 111, 146));
		del_btn_inc_4.setForeground(new Color(252, 187, 103));
		del_btn_inc_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_inc_4.setBounds(180, 40, 89, 25);
		awards_categ_pnl.add(del_btn_inc_4);

		JScrollPane expense_categ_sp = new JScrollPane();
		expense_categ_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		expense_categ_sp.setBounds(402, 63, 382, 244);
		categ_panel.add(expense_categ_sp);

		JPanel expense_categ_pnl = new JPanel();
		expense_categ_pnl.setPreferredSize(new Dimension(382, 400));
		expense_categ_pnl.setBackground(new Color(85, 111, 146));
		expense_categ_sp.setViewportView(expense_categ_pnl);
		expense_categ_pnl.setLayout(null);

		JPanel bills_categ_pnl = new JPanel();
		bills_categ_pnl.setBackground(new Color(69, 92, 123));
		bills_categ_pnl.setBounds(10, 11, 346, 76);
		expense_categ_pnl.add(bills_categ_pnl);
		bills_categ_pnl.setLayout(null);

		JLabel bills_lbl = new JLabel("BILLS");
		bills_lbl.setBackground(new Color(85, 111, 146));
		bills_lbl.setBounds(147, 8, 52, 25);
		bills_lbl.setForeground(new Color(252, 187, 103));
		bills_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_categ_pnl.add(bills_lbl);

		JButton edit_btn_exp_1 = new JButton("Edit");
		edit_btn_exp_1.setFocusable(false);
		edit_btn_exp_1.setForeground(new Color(252, 187, 103));
		edit_btn_exp_1.setBackground(new Color(85, 111, 146));
		edit_btn_exp_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_1.setBounds(84, 40, 89, 25);
		bills_categ_pnl.add(edit_btn_exp_1);

		JButton del_btn_exp_1 = new JButton("Delete");
		del_btn_exp_1.setFocusable(false);
		del_btn_exp_1.setForeground(new Color(252, 187, 103));
		del_btn_exp_1.setBackground(new Color(85, 111, 146));
		del_btn_exp_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_exp_1.setBounds(181, 40, 89, 25);
		bills_categ_pnl.add(del_btn_exp_1);

		JPanel shop_categ_pnl = new JPanel();
		shop_categ_pnl.setLayout(null);
		shop_categ_pnl.setBackground(new Color(69, 92, 123));
		shop_categ_pnl.setBounds(10, 98, 346, 76);
		expense_categ_pnl.add(shop_categ_pnl);

		JLabel bills_lbl_1 = new JLabel("SHOPPING");
		bills_lbl_1.setForeground(new Color(252, 187, 109));
		bills_lbl_1.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1.setBounds(127, 8, 103, 25);
		shop_categ_pnl.add(bills_lbl_1);

		JButton edit_btn_exp_2 = new JButton("Edit");
		edit_btn_exp_2.setFocusable(false);
		edit_btn_exp_2.setForeground(new Color(252, 187, 103));
		edit_btn_exp_2.setBackground(new Color(85, 111, 146));
		edit_btn_exp_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_2.setBounds(83, 40, 89, 25);
		shop_categ_pnl.add(edit_btn_exp_2);

		JButton del_btn_exp_2 = new JButton("Delete");
		del_btn_exp_2.setFocusable(false);
		del_btn_exp_2.setForeground(new Color(252, 187, 103));
		del_btn_exp_2.setBackground(new Color(85, 111, 146));
		del_btn_exp_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_exp_2.setBounds(180, 40, 89, 25);
		shop_categ_pnl.add(del_btn_exp_2);

		JPanel food_categ_pnl = new JPanel();
		food_categ_pnl.setLayout(null);
		food_categ_pnl.setBackground(new Color(69, 92, 123));
		food_categ_pnl.setBounds(10, 185, 346, 76);
		expense_categ_pnl.add(food_categ_pnl);

		JLabel bills_lbl_1_1 = new JLabel("FOOD");
		bills_lbl_1_1.setForeground(new Color(252, 187, 109));
		bills_lbl_1_1.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_1.setBounds(147, 8, 58, 25);
		food_categ_pnl.add(bills_lbl_1_1);

		JButton edit_btn_exp_3 = new JButton("Edit");
		edit_btn_exp_3.setFocusable(false);
		edit_btn_exp_3.setBackground(new Color(85, 111, 146));
		edit_btn_exp_3.setForeground(new Color(252, 187, 103));
		edit_btn_exp_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_3.setBounds(83, 40, 89, 25);
		food_categ_pnl.add(edit_btn_exp_3);

		JButton del_btn_exp_3 = new JButton("Delete");
		del_btn_exp_3.setFocusable(false);
		del_btn_exp_3.setForeground(new Color(252, 187, 103));
		del_btn_exp_3.setBackground(new Color(85, 111, 146));
		del_btn_exp_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_exp_3.setBounds(180, 40, 89, 25);
		food_categ_pnl.add(del_btn_exp_3);

		JPanel home_categ_pnl = new JPanel();
		home_categ_pnl.setLayout(null);
		home_categ_pnl.setBackground(new Color(69, 92, 123));
		home_categ_pnl.setBounds(10, 272, 346, 76);
		expense_categ_pnl.add(home_categ_pnl);

		JLabel bills_lbl_1_2 = new JLabel("HOME");
		bills_lbl_1_2.setForeground(new Color(252, 187, 109));
		bills_lbl_1_2.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills_lbl_1_2.setBounds(147, 8, 60, 25);
		home_categ_pnl.add(bills_lbl_1_2);

		JButton edit_btn_exp_4 = new JButton("Edit");
		edit_btn_exp_4.setFocusable(false);
		edit_btn_exp_4.setForeground(new Color(252, 187, 103));
		edit_btn_exp_4.setBackground(new Color(85, 111, 146));
		edit_btn_exp_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_4.setBounds(83, 40, 89, 25);
		home_categ_pnl.add(edit_btn_exp_4);

		JButton del_btn_exp_4 = new JButton("Delete");
		del_btn_exp_4.setFocusable(false);
		del_btn_exp_4.setForeground(new Color(252, 187, 103));
		del_btn_exp_4.setBackground(new Color(85, 111, 146));
		del_btn_exp_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		del_btn_exp_4.setBounds(180, 40, 89, 25);
		home_categ_pnl.add(del_btn_exp_4);

		JLabel income_categ_lbl = new JLabel("Income Categories");
		income_categ_lbl.setForeground(new Color(252, 187, 109));
		income_categ_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		income_categ_lbl.setBounds(113, 27, 179, 25);
		categ_panel.add(income_categ_lbl);

		JLabel expense_categ_lbl = new JLabel("Expense Categories");
		expense_categ_lbl.setForeground(new Color(252, 187, 109));
		expense_categ_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		expense_categ_lbl.setBounds(502, 27, 188, 25);
		categ_panel.add(expense_categ_lbl);
		
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
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
				user_panel.setVisible(false);
				activeScrollPane = recordScrollPane;
				recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(daily_year_now, daily_year_now);
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
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
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
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
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
				activeScrollPane = budgeted_scrlpn;
				user_panel.setVisible(false);
				List<Budget> budgets = BudgeeDAOImpl.getAllBudgets();
				List<String> unbudgetedCategories = BudgeeDAOImpl.getUnbudgetedCategories(budgets);
				mainFrameUtils.displayUnbudgetedCategories(unbudgetedCategories, unbudget_scrlpn);
			}
		});
		budget_button.setFocusable(false);

		acc_button = new JButton("Account");
		acc_button.setBorder(null);
		acc_button.setBounds(37, 429, 139, 40);
		acc_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		acc_button.setForeground(new Color(252, 187, 109));
		acc_button.setBackground(new Color(85, 111, 146));
		acc_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(216, 115, 127));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(true);
				categ_panel.setVisible(false);
				user_panel.setVisible(false);
			}
		});
		acc_button.setFocusable(false);

		categ_button = new JButton("Category");
		categ_button.setBorder(null);
		categ_button.setBounds(37, 489, 139, 40);
		categ_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		categ_button.setForeground(new Color(252, 187, 109));
		categ_button.setBackground(new Color(85, 111, 146));
		categ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_button.setBackground(new Color(85, 111, 146));
				analytic_button.setBackground(new Color(85, 111, 146));
				budget_button.setBackground(new Color(85, 111, 146));
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(216, 115, 127));
				user_button.setBackground(new Color(85, 111, 146));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(true);
				user_panel.setVisible(false);
			}
		});
		categ_button.setFocusable(false);

		
		
		daily_year_now = LocalDate.now();
        daily_date = new JLabel(formatDate(daily_year_now));
        daily_date.setHorizontalAlignment(SwingConstants.CENTER);
        daily_date.setForeground(new Color(252, 187, 109));
        daily_date.setFont(new Font("Quicksand Light", Font.BOLD, 20));
        daily_date.setBounds(140, 11, 185, 34);

		final JPanel Daily = new JPanel();
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);				
			}
		});
		daily_right.setBounds(406, 11, 41, 34);
		Daily.add(daily_right);
		Daily.add(daily_date);

		final JPanel Weekly = new JPanel();
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
			}
		});
		weekly_right.setBounds(406, 11, 41, 34);
		Weekly.add(weekly_right);

		final JPanel Monthly = new JPanel();
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
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(month_year_now.withDayOfMonth(1), month_year_now.withDayOfMonth(month_year_now.lengthOfMonth()));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = month_year_now.withDayOfMonth(1);
				endDate = month_year_now.withDayOfMonth(month_year_now.lengthOfMonth());
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
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
	            recordsByDate = BudgeeDAOImpl.getRecordsByDateRange(month_year_now.withDayOfMonth(1), month_year_now.withDayOfMonth(month_year_now.lengthOfMonth()));
				MainFrameUtils.displayAllRecords(recordsByDate, activeScrollPane);
				expenseTotal = BudgeeDAOImpl.getExpenseTotal(recordsByDate);
				incomeTotal = BudgeeDAOImpl.getIncomeTotal(recordsByDate);
				exint_EX_lbl.setText("-PHP " + expenseTotal);
				exint_inc_lbl.setText("PHP " + incomeTotal);
				exint_total_lbl.setText("PHP " + (incomeTotal.subtract(expenseTotal)));
				startDate = month_year_now.withDayOfMonth(1);
				endDate = month_year_now.withDayOfMonth(month_year_now.lengthOfMonth());
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
			}
		});
		monthly_right.setBounds(406, 11, 41, 34);
		Monthly.add(monthly_right);

		final JPanel Yearly = new JPanel();
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
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
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
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

		frmMain.add(monthly_butt);
		frmMain.add(yearly_butt);
		frmMain.add(daily_butt);
		frmMain.add(weekly_butt);
		frmMain.add(exint);

		frmMain.add(categ_button);
		frmMain.add(acc_button);
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
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		usernameLabel.setBounds(53, 11, 123, 42);
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
				acc_button.setBackground(new Color(85, 111, 146));
				categ_button.setBackground(new Color(85, 111, 146));
				user_button.setBackground(new Color(216, 115, 127));
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
				user_panel.setVisible(true);
				income_anal.setText("PHP"+ incomeTotal);
				expense_anal.setText("PHP"+ expenseTotal);
			}
		});
		user_button.setBounds(37, 546, 139, 40);
		frmMain.add(user_button);

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
