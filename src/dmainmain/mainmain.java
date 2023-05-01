package dmainmain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;

public class mainmain extends JFrame {

	private JPanel frmMain;
	private JTextField ex_tf;
	private JTextField in_tf;
	private JTextField tot_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmain frame = new mainmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		JLabel acclebel = new JLabel("ACCOUNT");
		acclebel.setBounds(370, 5, 49, 14);
		acclebel.setForeground(new Color(255, 255, 255));
		acc_panel.add(acclebel);
		
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
		layerpanebelow.add(analytic_panel);
		layerpanebelow.add(budget_panel);
		layerpanebelow.add(acc_panel);
		layerpanebelow.add(categ_panel);
		
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
		tot_lebel.setBounds(32, 72, 36, 14);
		exint.add(tot_lebel);
		
		ex_tf = new JTextField();
		ex_tf.setBounds(86, 11, 225, 20);
		exint.add(ex_tf);
		ex_tf.setColumns(10);
		
		in_tf = new JTextField();
		in_tf.setColumns(10);
		in_tf.setBounds(86, 40, 225, 20);
		exint.add(in_tf);
		
		tot_tf = new JTextField();
		tot_tf.setColumns(10);
		tot_tf.setBounds(86, 69, 225, 20);
		exint.add(tot_tf);
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
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon loglog = new ImageIcon (this.getClass().getResource("/budgee_logo1.png"));
		lblNewLabel.setIcon(loglog);
		lblNewLabel.setBounds(53, 64, 100, 120);
		frmMain.add(lblNewLabel);
		
	}
}