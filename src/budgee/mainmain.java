package budgee;

import java.awt.BorderLayout;

import budgee.UserSession;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.util.Date;
import java.sql.Time;
import java.sql.Types;

public class mainmain extends JFrame {

	private UserSession session = UserSession.getInstance();
	private String sessionUsername = session.getUsername();
	
	private JPanel frmMain;
	private final Action action = new SwingAction();
	private JTextField cashbal_txtfld;
	private JTextField savebal_txtfld;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPasswordField password;
	
	public void Connect() {
	try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
	    } catch (ClassNotFoundException | SQLException ex) {
	      Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
	        // Handle the exception appropriately, e.g. show an error message to the user
	    }


	}

	/**
	 * Create the frame.
	 */
	public mainmain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 697);
		frmMain = new JPanel();
		frmMain.setBackground(new Color(69, 92, 123));
		frmMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frmMain);

		JLayeredPane layerpanebelow = new JLayeredPane();
		layerpanebelow.setBounds(208, 182, 792, 460);

		final JPanel rec_panel = new JPanel();
		rec_panel.setBackground(new Color(66, 83, 109));
		rec_panel.setBounds(0, 0, 792, 459);
		rec_panel.setLayout(null);

		JLabel reclebel = new JLabel("RECORD");
		reclebel.setBounds(373, 5, 42, 14);
		reclebel.setForeground(new Color(255, 255, 255));
		rec_panel.add(reclebel);

		final JPanel analytic_panel = new JPanel();
		analytic_panel.setBackground(new Color(66, 83, 109));
		analytic_panel.setBounds(0, 0, 792, 459);
		analytic_panel.setLayout(null);

		JLabel anallebel = new JLabel("ANALYTIC");
		anallebel.setBounds(370, 5, 49, 14);
		anallebel.setForeground(new Color(255, 255, 255));
		analytic_panel.add(anallebel);

		final JPanel budget_panel = new JPanel();
		budget_panel.setBackground(new Color(66, 83, 109));
		budget_panel.setBounds(0, 0, 792, 459);
		budget_panel.setLayout(null);

		JLabel budglebel = new JLabel("BUDGET");
		budglebel.setBounds(375, 5, 39, 14);
		budglebel.setForeground(new Color(255, 255, 255));
		budget_panel.add(budglebel);

		final JPanel acc_panel = new JPanel();
		acc_panel.setBackground(new Color(66, 83, 109));
		acc_panel.setBounds(0, 0, 792, 459);
		acc_panel.setLayout(null);

		final JPanel categ_panel = new JPanel();
		categ_panel.setBackground(new Color(66, 83, 109));
		categ_panel.setBounds(0, 0, 792, 459);
		categ_panel.setLayout(null);

		JLabel categlebel = new JLabel("CATEGORY");
		categlebel.setBounds(367, 5, 54, 14);
		categlebel.setForeground(new Color(255, 255, 255));
		categ_panel.add(categlebel);

		JButton rec_button = new JButton("Record");
		rec_button.setBounds(37, 251, 139, 40);
		rec_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		rec_button.setForeground(new Color(252, 187, 109));
		rec_button.setBackground(new Color(85, 111, 146));
		rec_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		rec_button.setFocusable(false);

		JButton analytic_button = new JButton("Analytics");
		analytic_button.setBounds(37, 327, 139, 40);
		analytic_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		analytic_button.setForeground(new Color(252, 187, 109));
		analytic_button.setBackground(new Color(85, 111, 146));
		analytic_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		analytic_button.setFocusable(false);

		JButton budget_button = new JButton("Budget");
		budget_button.setBounds(37, 400, 139, 40);
		budget_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		budget_button.setForeground(new Color(252, 187, 109));
		budget_button.setBackground(new Color(85, 111, 146));
		budget_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		budget_button.setFocusable(false);

		JButton acc_button = new JButton("Account");
		acc_button.setBounds(37, 471, 139, 40);
		acc_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		acc_button.setForeground(new Color(252, 187, 109));
		acc_button.setBackground(new Color(85, 111, 146));
		acc_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(true);
				categ_panel.setVisible(false);
			}
		});
		acc_button.setFocusable(false);

		JButton categ_button = new JButton("Category");
		categ_button.setBounds(37, 544, 139, 40);
		categ_button.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		categ_button.setForeground(new Color(252, 187, 109));
		categ_button.setBackground(new Color(85, 111, 146));
		categ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(true);
			}
		});
		categ_button.setFocusable(false);
		layerpanebelow.setLayout(null);
		layerpanebelow.add(rec_panel);

		JButton calcu = new JButton("New button");

		calcu.setForeground(new Color(252, 187, 109));
		calcu.setBackground(new Color(85, 111, 146));
		calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame();
				win.setVisible(true);
			}
		});
		calcu.setBounds(685, 378, 97, 70);
		rec_panel.add(calcu);
		layerpanebelow.add(analytic_panel);

		JButton calcu1 = new JButton("New button");
		calcu1.setAction(action);
		calcu1.setBackground(new Color(85, 111, 146));
		calcu1.setForeground(new Color(252, 187, 109));
		calcu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame();
				win.setVisible(true);
			}
		});
		calcu1.setBounds(685, 378, 97, 70);
		analytic_panel.add(calcu1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 46, 524, 182);
		analytic_panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(29, 259, 524, 162);
		analytic_panel.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
		new DefaultComboBoxModel(new String[] { "Expense overview", "Income overview", "Account analysis" }));
		comboBox.setBounds(620, 46, 132, 31);
		analytic_panel.add(comboBox);
		layerpanebelow.add(budget_panel);

		JButton budget_btn = new JButton("New button");
		budget_btn.setForeground(new Color(252, 187, 109));
		budget_btn.setBackground(new Color(85, 111, 146));
		budget_btn.setBounds(685, 378, 97, 70);
		budget_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame();
				win.setVisible(true);
			}
		});
		budget_panel.add(budget_btn);
		layerpanebelow.add(acc_panel, Integer.valueOf(5));
		
		JButton acc_btn = new JButton("New button");
		acc_btn.setBackground(new Color(85, 111, 146));
		acc_btn.setForeground(new Color(252, 187, 109));
		acc_btn.setBounds(685, 378, 97, 70);
		acc_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame();
				win.setVisible(true);
			}
		});
		acc_panel.add(acc_btn);

		JPanel overall_acc_panel = new JPanel();
		overall_acc_panel.setBackground(new Color(69, 92, 123));
		overall_acc_panel.setBounds(25, 62, 430, 246);
		acc_panel.add(overall_acc_panel);
		overall_acc_panel.setLayout(null);

		JLabel income_atm_lbl = new JLabel("Income until now");
		income_atm_lbl.setBounds(46, 31, 128, 19);
		income_atm_lbl.setForeground(new Color(252, 187, 109));
		income_atm_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		overall_acc_panel.add(income_atm_lbl);

		JLabel expense_atm_lbl = new JLabel("Expense until now");
		expense_atm_lbl.setForeground(new Color(252, 187, 109));
		expense_atm_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		expense_atm_lbl.setBounds(253, 31, 135, 19);
		overall_acc_panel.add(expense_atm_lbl);

		JLabel totalbal_lbl = new JLabel("Total Balance");
		totalbal_lbl.setForeground(new Color(252, 187, 109));
		totalbal_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalbal_lbl.setBounds(167, 129, 101, 19);
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
		cash_acc_panel.setBackground(new Color(69, 92, 123));
		cash_acc_panel.setBounds(471, 62, 300, 112);
		acc_panel.add(cash_acc_panel);
		cash_acc_panel.setLayout(null);

		JLabel cash_lbl = new JLabel("Cash");
		cash_lbl.setBounds(21, 11, 56, 19);
		cash_lbl.setForeground(new Color(252, 187, 109));
		cash_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));
		cash_acc_panel.add(cash_lbl);

		JLabel cashbal_lbl = new JLabel("Balance:");
		cashbal_lbl.setForeground(new Color(252, 187, 109));
		cashbal_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		cashbal_lbl.setBounds(21, 48, 70, 19);
		cash_acc_panel.add(cashbal_lbl);

		cashbal_txtfld = new JTextField();
		cashbal_txtfld.setColumns(10);
		cashbal_txtfld.setBackground(new Color(85, 111, 146));
		cashbal_txtfld.setBounds(103, 44, 187, 27);
		cash_acc_panel.add(cashbal_txtfld);

		
		JButton cashsve_btn = new JButton("Save");
		cashsve_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String Cash = cashbal_txtfld.getText();
		    	Date date = new Date();

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");

		            String sql = "INSERT INTO budgee_accounts.user_1 (date, time, cash_value) VALUES (?, ?, ?)";
		            pst = con.prepareStatement(sql);
		            pst.setDate(1, new java.sql.Date(date.getTime()));
		            pst.setTime(2, new java.sql.Time(date.getTime()));
		            pst.setString(3, Cash);
		            


		            pst.executeUpdate();
		            
		            con.close();
		        } catch (Exception err) {
		            System.out.println(err.getMessage());
		        }
		    }
		});

		cashsve_btn.setForeground(new Color(252, 187, 109));
		cashsve_btn.setBackground(new Color(85, 111, 146));
		cashsve_btn.setBounds(154, 78, 89, 23);
		cash_acc_panel.add(cashsve_btn);
		
		JPanel savings_acc_panel = new JPanel();
		savings_acc_panel.setBackground(new Color(69, 92, 123));
		savings_acc_panel.setBounds(471, 196, 300, 112);
		acc_panel.add(savings_acc_panel);
		savings_acc_panel.setLayout(null);

		JLabel savings_lbl = new JLabel("Savings");
		savings_lbl.setBounds(21, 11, 90, 28);
		savings_lbl.setForeground(new Color(252, 187, 109));
		savings_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));
		savings_acc_panel.add(savings_lbl);

		JLabel savebal_lbl = new JLabel("Balance:");
		savebal_lbl.setForeground(new Color(252, 187, 109));
		savebal_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		savebal_lbl.setBounds(21, 48, 70, 19);
		savings_acc_panel.add(savebal_lbl);

		savebal_txtfld = new JTextField();
		savebal_txtfld.setColumns(10);
		savebal_txtfld.setBackground(new Color(85, 111, 146));
		savebal_txtfld.setBounds(103, 44, 187, 27);
		savings_acc_panel.add(savebal_txtfld);
		
		JButton svngssve_btn = new JButton("Save");
		svngssve_btn.setForeground(new Color(252, 187, 109));
		svngssve_btn.setBackground(new Color(85, 111, 146));
		svngssve_btn.setBounds(154, 78, 89, 23);
		savings_acc_panel.add(svngssve_btn);
		
		JLabel ovrall_lbl = new JLabel("Overall");
		ovrall_lbl.setForeground(new Color(252, 187, 109));
		ovrall_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		ovrall_lbl.setBounds(211, 37, 56, 14);
		acc_panel.add(ovrall_lbl);

		JLabel accs_lbl = new JLabel("Accounts");
		accs_lbl.setForeground(new Color(252, 187, 109));
		accs_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		accs_lbl.setBounds(590, 37, 67, 14);
		acc_panel.add(accs_lbl);
		layerpanebelow.add(categ_panel);

		JButton categ_btn = new JButton("New button");
		categ_btn.setForeground(new Color(252, 187, 109));
		categ_btn.setBackground(new Color(85, 111, 146));
		categ_btn.setBounds(685, 378, 97, 70);
		categ_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcuFrame win = new CalcuFrame();
				win.setVisible(true);
			}
		});
		categ_panel.add(categ_btn);

		JPanel exint = new JPanel();
		exint.setBounds(675, 64, 325, 100);
		exint.setBackground(new Color(66, 83, 109));
		exint.setForeground(new Color(255, 255, 255));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(208, 106, 457, 58);

		final JPanel Daily = new JPanel();
		Daily.setLayout(null);
		Daily.setBackground(new Color(66, 83, 109));
		Daily.setBounds(0, 0, 457, 58);
		layeredPane.add(Daily);

		JButton daily_left = new JButton("<");
		daily_left.setBounds(10, 11, 41, 34);
		Daily.add(daily_left);

		JButton daily_right = new JButton(">");
		daily_right.setBounds(406, 11, 41, 34);
		Daily.add(daily_right);

		JLabel dailydet = new JLabel("January 1, 2023");
		dailydet.setForeground(new Color(252, 187, 109));
		dailydet.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		dailydet.setBounds(150, 11, 154, 34);
		Daily.add(dailydet);
		exint.setLayout(null);

		final JPanel Weekly = new JPanel();
		Weekly.setLayout(null);
		Weekly.setBackground(new Color(66, 83, 109));
		Weekly.setBounds(0, 0, 457, 58);
		layeredPane.add(Weekly);

		JButton weekly_left = new JButton("<");
		weekly_left.setBounds(10, 11, 41, 34);
		Weekly.add(weekly_left);

		JButton weekly_right = new JButton(">");
		weekly_right.setBounds(406, 11, 41, 34);
		Weekly.add(weekly_right);

		JLabel weeklydet = new JLabel("January 1 - January 7 2023");
		weeklydet.setForeground(new Color(252, 187, 109));
		weeklydet.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		weeklydet.setBounds(102, 11, 269, 34);
		Weekly.add(weeklydet);

		final JPanel Monthly = new JPanel();
		Monthly.setLayout(null);
		Monthly.setBackground(new Color(66, 83, 109));
		Monthly.setBounds(0, 0, 457, 58);
		layeredPane.add(Monthly);

		JButton monthly_left = new JButton("<");
		monthly_left.setBounds(10, 11, 41, 34);
		Monthly.add(monthly_left);

		JButton monthly_right = new JButton(">");
		monthly_right.setBounds(406, 11, 41, 34);
		Monthly.add(monthly_right);

		JLabel monthlydet = new JLabel("January 1 - February 1 2023");
		monthlydet.setForeground(new Color(252, 187, 109));
		monthlydet.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		monthlydet.setBounds(102, 11, 268, 34);
		Monthly.add(monthlydet);

		final JPanel Yearly = new JPanel();
		Yearly.setLayout(null);
		Yearly.setBackground(new Color(66, 83, 109));
		Yearly.setBounds(0, 0, 457, 58);
		layeredPane.add(Yearly);

		JButton yearly_left = new JButton("<");
		yearly_left.setBounds(10, 11, 40, 34);
		Yearly.add(yearly_left);

		JButton yearly_right = new JButton(">");
		yearly_right.setBounds(407, 11, 40, 34);
		Yearly.add(yearly_right);

		JLabel yearlydet = new JLabel("January 1 , 2023 - January 1, 2024");
		yearlydet.setForeground(new Color(252, 187, 109));
		yearlydet.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		yearlydet.setBounds(60, 11, 326, 34);
		Yearly.add(yearlydet);

		JButton daily_butt = new JButton("Daily");
		daily_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Daily.setVisible(true);
				Weekly.setVisible(false);
				Monthly.setVisible(false);
				Yearly.setVisible(false);
			}
		});
		daily_butt.setBounds(227, 64, 89, 31);
		daily_butt.setForeground(new Color(252, 187, 109));
		daily_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		daily_butt.setFocusable(false);
		daily_butt.setBackground(new Color(85, 111, 146));

		JButton monthly_butt = new JButton("Monthly");
		monthly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Daily.setVisible(false);
				Weekly.setVisible(false);
				Monthly.setVisible(true);
				Yearly.setVisible(false);
			}
		});
		monthly_butt.setBounds(448, 64, 89, 31);
		monthly_butt.setForeground(new Color(252, 187, 109));
		monthly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		monthly_butt.setFocusable(false);
		monthly_butt.setBackground(new Color(85, 111, 146));

		JButton weekly_butt = new JButton("Weekly");
		weekly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Daily.setVisible(false);
				Weekly.setVisible(true);
				Monthly.setVisible(false);
				Yearly.setVisible(false);
			}
		});
		weekly_butt.setBounds(340, 64, 89, 31);
		weekly_butt.setForeground(new Color(252, 187, 109));
		weekly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		weekly_butt.setFocusable(false);
		weekly_butt.setBackground(new Color(85, 111, 146));

		JButton yearly_butt = new JButton("Yearly");
		yearly_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Daily.setVisible(false);
				Weekly.setVisible(false);
				Monthly.setVisible(false);
				Yearly.setVisible(true);
			}
		});
		yearly_butt.setBounds(556, 64, 89, 31);
		yearly_butt.setForeground(new Color(252, 187, 109));
		yearly_butt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		yearly_butt.setFocusable(false);
		yearly_butt.setBackground(new Color(85, 111, 146));

		JLabel ex_lebel = new JLabel("Expense:");
		ex_lebel.setForeground(new Color(252, 187, 109));
		ex_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		ex_lebel.setBounds(10, 14, 66, 14);
		exint.add(ex_lebel);

		JLabel inc_lebel = new JLabel("Income:");
		inc_lebel.setForeground(new Color(252, 187, 109));
		inc_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		inc_lebel.setBounds(17, 43, 56, 14);
		exint.add(inc_lebel);

		JLabel tot_lebel = new JLabel("Total:");
		tot_lebel.setForeground(new Color(252, 187, 109));
		tot_lebel.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		tot_lebel.setBounds(27, 72, 41, 14);
		exint.add(tot_lebel);
		frmMain.setLayout(null);
		frmMain.add(layeredPane);

		frmMain.add(monthly_butt);
		frmMain.add(yearly_butt);
		frmMain.add(daily_butt);
		frmMain.add(weekly_butt);
		frmMain.add(exint);
		
		JLabel exint_EX_lbl = new JLabel("");
		exint_EX_lbl.setForeground(new Color(252, 187, 109));
		exint_EX_lbl.setBackground(new Color(85, 111, 146));
		exint_EX_lbl.setBounds(86, 11, 225, 20);
		exint.add(exint_EX_lbl);
		
		JLabel exint_int_lbl = new JLabel("");
		exint_int_lbl.setForeground(new Color(252, 187, 109));
		exint_int_lbl.setBackground(new Color(85, 111, 146));
		exint_int_lbl.setBounds(86, 40, 225, 20);
		exint.add(exint_int_lbl);
		
		JLabel exint_total_lbl = new JLabel("");
		exint_total_lbl.setForeground(new Color(252, 187, 109));
		exint_total_lbl.setBackground(new Color(85, 111, 146));
		exint_total_lbl.setBounds(86, 70, 225, 20);
		exint.add(exint_total_lbl);
		frmMain.add(categ_button);
		frmMain.add(acc_button);
		frmMain.add(budget_button);
		frmMain.add(analytic_button);
		frmMain.add(rec_button);
		frmMain.add(layerpanebelow);

		JLabel logoBudgee = new JLabel("");
		ImageIcon loglog = new ImageIcon("imgs/budgee_logo1.png");
		logoBudgee.setIcon(loglog);
		logoBudgee.setBounds(53, 64, 100, 120);
		frmMain.add(logoBudgee);
		
		JLabel usernameLabel = new JLabel(sessionUsername);
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameLabel.setBounds(53, 11, 123, 42);
		frmMain.add(usernameLabel);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
