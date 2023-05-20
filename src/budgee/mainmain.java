package budgee;

import java.awt.BorderLayout;

import budgee.UserSession;

import javafx.application.Platform;
import javafx.stage.Stage;

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
import javax.swing.JScrollPane;


import java.util.Date;
import java.sql.Time;
import java.sql.Types;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;

import javafx.application.Application;  
import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;  
import javafx.scene.Scene;  
import javafx.scene.chart.PieChart;  
import javafx.scene.chart.PieChart.Data;  
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage; 

public class mainmain extends JFrame {

	private UserSession session = UserSession.getInstance();
	private String sessionUsername = session.getUsername();

	private JPanel frmMain;
	private final Action action = new SwingAction();
	private JTextField cashbal_txtfld;
	private JTextField savebal_txtfld;

	private JButton rec_button;
	private JButton analytic_button;
	private JButton budget_button;
	private JButton acc_button;
	private JButton categ_button;

	
	private boolean isExpenseOverviewRunning = false;
	private ExpenseOverview expenseOverviewApp;

	private static void openChartTest() {
		// Launch the ChartTest JavaFX application

		ExpenseOverview chartTest = new ExpenseOverview();
		try {
			chartTest.init();
			chartTest.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public mainmain() {		

        setSize(400, 300);
        setLocationRelativeTo(null);


		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 697);
		frmMain = new JPanel();
		frmMain.setBackground(new Color(69, 92, 123));
		frmMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(frmMain);

		JLayeredPane layerpanebelow = new JLayeredPane();
		layerpanebelow.setBounds(208, 182, 792, 460);

		final JPanel rec_panel = new JPanel();
		rec_panel.setBackground(new Color(68, 83, 109));
		rec_panel.setBounds(0, 0, 792, 459);
		rec_panel.setLayout(null);

		JLabel reclebel = new JLabel("RECORDS");
		reclebel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		reclebel.setBounds(265, 11, 131, 30);
		reclebel.setForeground(new Color(252, 187, 109));
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

		final JPanel acc_panel = new JPanel();
		acc_panel.setBackground(new Color(66, 83, 109));
		acc_panel.setBounds(0, 0, 792, 459);
		acc_panel.setLayout(null);

		final JPanel categ_panel = new JPanel();
		categ_panel.setForeground(new Color(252, 187, 109));
		categ_panel.setBackground(new Color(66, 83, 109));
		categ_panel.setBounds(0, 0, 792, 459);
		categ_panel.setLayout(null);

		rec_button = new JButton("Record");
		rec_button.setBounds(37, 249, 139, 40);
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
				rec_panel.setVisible(true);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		rec_button.setFocusable(false);

		analytic_button = new JButton("Analytics");
		analytic_button.setBounds(37, 327, 139, 40);
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
				rec_panel.setVisible(false);
				analytic_panel.setVisible(true);
				budget_panel.setVisible(false);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		analytic_button.setFocusable(false);

		budget_button = new JButton("Budget");
		budget_button.setBounds(37, 400, 139, 40);
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
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(true);
				acc_panel.setVisible(false);
				categ_panel.setVisible(false);
			}
		});
		budget_button.setFocusable(false);

		acc_button = new JButton("Account");
		acc_button.setBounds(37, 471, 139, 40);
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
				rec_panel.setVisible(false);
				analytic_panel.setVisible(false);
				budget_panel.setVisible(false);
				acc_panel.setVisible(true);
				categ_panel.setVisible(false);
			}
		});
		acc_button.setFocusable(false);

		categ_button = new JButton("Category");
		categ_button.setBounds(37, 544, 139, 40);
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

//		, Integer.valueOf(7)

		
		JScrollPane Record_panel = new JScrollPane();
		Record_panel.setBackground(new Color(85, 111, 146));
		Record_panel.setBounds(10, 50, 653, 398);
		rec_panel.add(Record_panel);
		Record_panel.setLayout(null);
		
		JPanel Date_Container = new JPanel();
		Date_Container.setBackground(new Color(68, 83, 109));
		Date_Container.setBounds(10, 9, 633, 138);
		Record_panel.add(Date_Container);
		Date_Container.setLayout(null);
		
		JLabel lbl_Date = new JLabel("May 19, Friday");
		lbl_Date.setBounds(10, 0, 113, 19);
		Date_Container.add(lbl_Date);
		lbl_Date.setForeground(new Color(216, 115, 127));
		lbl_Date.setBackground(new Color(255, 255, 255));
		lbl_Date.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel Rec_Container = new JPanel();
		Rec_Container.setBackground(new Color(68, 83, 109));
		Rec_Container.setBounds(10, 26, 613, 101);
		Date_Container.add(Rec_Container);
		Rec_Container.setLayout(null);
		
		JLabel lblGet_Categ = new JLabel("Bills");
		lblGet_Categ.setBounds(301, 0, 43, 21);
		lblGet_Categ.setForeground(new Color(252, 187, 109));
		lblGet_Categ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGet_Categ.setBackground(Color.WHITE);
		Rec_Container.add(lblGet_Categ);
		
		JLabel lbl_Categ = new JLabel("Category:");
		lbl_Categ.setForeground(new Color(216, 115, 127));
		lbl_Categ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Categ.setBackground(Color.WHITE);
		lbl_Categ.setBounds(218, 0, 81, 19);
		Rec_Container.add(lbl_Categ);
		
		JLabel Acc_Exp_lbl = new JLabel("Expense:");
		Acc_Exp_lbl.setForeground(new Color(216, 115, 127));
		Acc_Exp_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		Acc_Exp_lbl.setBackground(Color.WHITE);
		Acc_Exp_lbl.setBounds(320, 82, 70, 19);
		Rec_Container.add(Acc_Exp_lbl);
		
		JLabel lbl_Notes = new JLabel("Ito ay notes lamang. Wag seryusuhin");
		lbl_Notes.setVerticalAlignment(SwingConstants.TOP);
		lbl_Notes.setForeground(new Color(85, 111, 146));
		lbl_Notes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Notes.setBackground(Color.WHITE);
		lbl_Notes.setBounds(84, 20, 420, 59);
		Rec_Container.add(lbl_Notes);
		
		JButton btn_Del = new JButton("Delete");
		btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Del.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Del.setForeground(new Color(216, 115, 127));
		btn_Del.setBackground(new Color(68, 83, 109));
		btn_Del.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Del.setBounds(514, 48, 89, 36);
		Rec_Container.add(btn_Del);
		
		JLabel lbl_Value = new JLabel("₱5,000.00");
		lbl_Value.setForeground(new Color(252, 187, 109));
		lbl_Value.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Value.setBackground(Color.WHITE);
		lbl_Value.setBounds(401, 82, 113, 19);
		Rec_Container.add(lbl_Value);
		
		JButton btn_Edit = new JButton("Edit");
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Edit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Edit.setForeground(new Color(252, 187, 109));
		btn_Edit.setBackground(new Color(68, 83, 109));
		btn_Edit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Edit.setBounds(514, 11, 89, 36);
		Rec_Container.add(btn_Edit);
		
		JLabel lblGet_Acc = new JLabel("Cash");
		lblGet_Acc.setForeground(new Color(252, 187, 109));
		lblGet_Acc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGet_Acc.setBackground(Color.WHITE);
		lblGet_Acc.setBounds(93, 0, 43, 21);
		Rec_Container.add(lblGet_Acc);
		
		JLabel lbl_Acc = new JLabel("Account:");
		lbl_Acc.setForeground(new Color(216, 115, 127));
		lbl_Acc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Acc.setBackground(Color.WHITE);
		lbl_Acc.setBounds(10, 0, 81, 19);
		Rec_Container.add(lbl_Acc);
		
		JLabel lbl_Time = new JLabel("11:40 PM");
		lbl_Time.setForeground(new Color(252, 187, 109));
		lbl_Time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Time.setBackground(Color.WHITE);
		lbl_Time.setBounds(10, 82, 70, 19);
		Rec_Container.add(lbl_Time);
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


		JPanel analyticsBTN = new JPanel();
		analyticsBTN.setBackground(new Color(85, 111, 146));
		analyticsBTN.setBounds(23, 11, 583, 63);
		analytic_panel.add(analyticsBTN);
		analyticsBTN.setLayout(null);

		JComboBox<String> overView = new JComboBox();
		overView.setName("");
		overView.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == overView) {
		            System.out.println(overView.getSelectedItem());
		            String selectedItem = (String) overView.getSelectedItem();
		            if (selectedItem.equals("Expense Overview")) {
		            	
		            	javafx.application.Application.launch(ExpenseOverview.class);
		                System.out.println("Expense Overview command");
		            } else if (selectedItem.equals("Income Overview")) {
		            	
		            	javafx.application.Application.launch(IncomeOverview.class);
		                System.out.println("Income Overview command");
		            } else if (selectedItem.equals("Income Flow")) {
		            	
		                
		                System.out.println("Income Flow command");
		            } else if (selectedItem.equals("Expense Flow")) {
		            	
		            	
		                System.out.println("Expense Flow command");
		            } else if (selectedItem.equals("Account Analysis")) {
		                
		            	javafx.application.Application.launch(AccountAnalysis.class);
		                System.out.println("Account Analysis command");
		            }
		        }
		    }
		});
		overView.setBounds(10, 11, 563, 41);
		analyticsBTN.add(overView);
		overView.setForeground(new Color(252, 187, 109));
		overView.setFont(new Font("Quicksand Light", Font.BOLD, 13));
		overView.setModel(new DefaultComboBoxModel(new String[] { "Expense Overview", "Income Overview", "Income Flow",
		"Expense Flow", "Account Analysis" }));

		JPanel Categories = new JPanel();
		Categories.setBackground(new Color(85, 111, 146));
		Categories.setBounds(23, 105, 582, 343);
		analytic_panel.add(Categories);

		JLabel piechart = new JLabel("Piechart");
		piechart.setBackground(new Color(66, 83, 109));
		piechart.setBounds(10, 25, 536, 309);
		analytic_panel.add(piechart);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(66, 83, 109));
		lblNewLabel_1.setBounds(10, 345, 536, 103);
		analytic_panel.add(lblNewLabel_1);

		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(595, 11, 139, 34);
		analytic_panel.add(comboBox);
		comboBox.setModel(
		new DefaultComboBoxModel(new String[] { "Expense overview", "Income overview", "Account analysis" }));
		layerpanebelow.add(budget_panel, Integer.valueOf(5));


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
		
		JScrollPane budgeted_scrlpn = new JScrollPane();
		budgeted_scrlpn.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		budgeted_scrlpn.setBounds(10, 62, 447, 246);
		budget_panel.add(budgeted_scrlpn);
		
		JPanel stted_bdgt_pnl = new JPanel();
		stted_bdgt_pnl.setPreferredSize(new Dimension(447, 400));
		budgeted_scrlpn.setViewportView(stted_bdgt_pnl);
		stted_bdgt_pnl.setBackground(new Color(85, 111, 146));
		stted_bdgt_pnl.setLayout(null);
		
		JPanel std_home_bdgt_pnl = new JPanel();
		std_home_bdgt_pnl.setBackground(new Color(63, 83, 109));
		std_home_bdgt_pnl.setBounds(10, 11, 410, 104);
		stted_bdgt_pnl.add(std_home_bdgt_pnl);
		std_home_bdgt_pnl.setLayout(null);
		
		JLabel std_bdgt_lbl = new JLabel("HOME");
		std_bdgt_lbl.setForeground(new Color(252, 187, 109));
		std_bdgt_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		std_bdgt_lbl.setBounds(21, 11, 61, 18);
		std_home_bdgt_pnl.add(std_bdgt_lbl);
		
		JLabel limit_bdgt_lbl = new JLabel("Limit:");
		limit_bdgt_lbl.setForeground(new Color(252, 187, 109));
		limit_bdgt_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		limit_bdgt_lbl.setBounds(21, 37, 43, 14);
		std_home_bdgt_pnl.add(limit_bdgt_lbl);
		
		JLabel spent_bdgt_lbl = new JLabel("Spent:");
		spent_bdgt_lbl.setForeground(new Color(252, 187, 109));
		spent_bdgt_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		spent_bdgt_lbl.setBounds(21, 55, 51, 18);
		std_home_bdgt_pnl.add(spent_bdgt_lbl);
		
		JLabel remain_bdgt_lbl = new JLabel("Remaining:");
		remain_bdgt_lbl.setForeground(new Color(252, 187, 109));
		remain_bdgt_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		remain_bdgt_lbl.setBounds(21, 75, 81, 18);
		std_home_bdgt_pnl.add(remain_bdgt_lbl);
		
		JLabel limamount_lbl = new JLabel("P500");
		limamount_lbl.setForeground(new Color(216, 115, 127));
		limamount_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		limamount_lbl.setBounds(72, 39, 37, 14);
		std_home_bdgt_pnl.add(limamount_lbl);
		
		JLabel spamount_lbl = new JLabel("P250");
		spamount_lbl.setForeground(new Color(216, 115, 127));
		spamount_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		spamount_lbl.setBounds(82, 59, 37, 14);
		std_home_bdgt_pnl.add(spamount_lbl);
		
		JLabel remamoun_lbl = new JLabel("P250");
		remamoun_lbl.setForeground(new Color(216, 115, 127));
		remamoun_lbl.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		remamoun_lbl.setBounds(115, 79, 37, 14);
		std_home_bdgt_pnl.add(remamoun_lbl);
		
		JButton chnge_limit_btn = new JButton("Change Limit");
		chnge_limit_btn.setBackground(new Color(85, 111, 146));
		chnge_limit_btn.setForeground(new Color(252, 191, 109));
		chnge_limit_btn.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		chnge_limit_btn.setBounds(245, 31, 148, 30);
		std_home_bdgt_pnl.add(chnge_limit_btn);
		
		JButton del_bdgt = new JButton("Delete Budget");
		del_bdgt.setForeground(new Color(252, 191, 109));
		del_bdgt.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		del_bdgt.setBackground(new Color(85, 111, 146));
		del_bdgt.setBounds(245, 63, 148, 30);
		std_home_bdgt_pnl.add(del_bdgt);
		
		JScrollPane unbudget_scrlpn = new JScrollPane();
		unbudget_scrlpn.setBounds(467, 62, 315, 246);
	    unbudget_scrlpn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		budget_panel.add(unbudget_scrlpn);

		JScrollPane budget_scrlpn = new JScrollPane();
		budget_scrlpn.setBounds(467, 62, 315, 246);
		budget_scrlpn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		budget_panel.add(budget_scrlpn);

		JPanel unstted_bdgt_pnl = new JPanel();
		unstted_bdgt_pnl.setPreferredSize(new Dimension(200, 400));
		unbudget_scrlpn.setViewportView(unstted_bdgt_pnl);
		unstted_bdgt_pnl.setBackground(new Color(85, 111, 146));
		unstted_bdgt_pnl.setLayout(null);

		JPanel bill_bdgt = new JPanel();
		bill_bdgt.setBackground(new Color(69, 92, 123));
		bill_bdgt.setBounds(10, 11, 281, 67);
		unstted_bdgt_pnl.add(bill_bdgt);
		bill_bdgt.setLayout(null);

		JLabel bills = new JLabel("BILLS");
		bills.setForeground(new Color(252, 187, 109));
		bills.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		bills.setBounds(51, 10, 62, 45);
		bill_bdgt.add(bills);

		JButton set_bdgt_btn = new JButton("Set Budget");
		set_bdgt_btn.setBackground(new Color(85, 111, 146));
		set_bdgt_btn.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		set_bdgt_btn.setForeground(new Color(252, 187, 109));
		set_bdgt_btn.setBounds(155, 20, 116, 29);
		bill_bdgt.add(set_bdgt_btn);

		JPanel shoppng_bdgt = new JPanel();
		shoppng_bdgt.setBackground(new Color(69, 92, 123));
		shoppng_bdgt.setBounds(10, 89, 281, 67);
		unstted_bdgt_pnl.add(shoppng_bdgt);
		shoppng_bdgt.setLayout(null);

		JLabel shopping = new JLabel("SHOPPING");
		shopping.setBounds(25, 10, 103, 45);
		shopping.setForeground(new Color(252, 187, 109));
		shopping.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		shoppng_bdgt.add(shopping);

		JButton set_bdgt_btn_2 = new JButton("Set Budget");
		set_bdgt_btn_2.setBackground(new Color(85, 111, 146));
		set_bdgt_btn_2.setForeground(new Color(252, 187, 109));
		set_bdgt_btn_2.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		set_bdgt_btn_2.setBounds(155, 20, 116, 29);
		shoppng_bdgt.add(set_bdgt_btn_2);

		JPanel food_bdgt = new JPanel();
		food_bdgt.setBackground(new Color(69, 92, 123));
		food_bdgt.setBounds(10, 168, 281, 67);
		unstted_bdgt_pnl.add(food_bdgt);
		food_bdgt.setLayout(null);

		JLabel food = new JLabel("FOOD");
		food.setBounds(50, 10, 58, 45);
		food.setForeground(new Color(252, 187, 109));
		food.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		food_bdgt.add(food);

		JButton set_bdgt_btn_3 = new JButton("Set Budget");
		set_bdgt_btn_3.setBackground(new Color(85, 111, 146));
		set_bdgt_btn_3.setForeground(new Color(252, 187, 109));
		set_bdgt_btn_3.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		set_bdgt_btn_3.setBounds(155, 20, 116, 29);
		food_bdgt.add(set_bdgt_btn_3);

		JPanel educ_bdgt = new JPanel();
		educ_bdgt.setLayout(null);
		educ_bdgt.setBackground(new Color(69, 92, 123));
		educ_bdgt.setBounds(10, 247, 281, 67);
		unstted_bdgt_pnl.add(educ_bdgt);

		JLabel educ = new JLabel("EDUCATION");
		educ.setForeground(new Color(252, 187, 109));
		educ.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		educ.setBounds(21, 10, 118, 45);
		educ_bdgt.add(educ);

		JButton set_bdgt_btn_3_1 = new JButton("Set Budget");
		set_bdgt_btn_3_1.setBackground(new Color(85, 111, 146));
		set_bdgt_btn_3_1.setForeground(new Color(252, 187, 109));
		set_bdgt_btn_3_1.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		set_bdgt_btn_3_1.setBounds(155, 20, 116, 29);
		educ_bdgt.add(set_bdgt_btn_3_1);

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
		layerpanebelow.add(acc_panel);

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
		edit_btn_inc_1.setForeground(new Color(252, 187, 103));
		edit_btn_inc_1.setBackground(new Color(85, 111, 146));
		edit_btn_inc_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_1.setBounds(83, 40, 89, 25);
		salary_categ_pnl.add(edit_btn_inc_1);

		JButton del_btn_inc_1 = new JButton("Delete");
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
		edit_btn_inc_2.setForeground(new Color(252, 187, 103));
		edit_btn_inc_2.setBackground(new Color(85, 111, 146));
		edit_btn_inc_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_2.setBounds(83, 40, 89, 25);
		sale_categ_pnl.add(edit_btn_inc_2);

		JButton del_btn_inc_2 = new JButton("Delete");
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
		edit_btn_inc_3.setForeground(new Color(252, 187, 103));
		edit_btn_inc_3.setBackground(new Color(85, 111, 146));
		edit_btn_inc_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_3.setBounds(83, 40, 89, 25);
		refund_categ_pnl.add(edit_btn_inc_3);

		JButton del_btn_inc_3 = new JButton("Delete");
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
		edit_btn_inc_4.setForeground(new Color(252, 187, 103));
		edit_btn_inc_4.setBackground(new Color(85, 111, 146));
		edit_btn_inc_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_inc_4.setBounds(83, 40, 89, 25);
		awards_categ_pnl.add(edit_btn_inc_4);

		JButton del_btn_inc_4 = new JButton("Delete");
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
		edit_btn_exp_1.setForeground(new Color(252, 187, 103));
		edit_btn_exp_1.setBackground(new Color(85, 111, 146));
		edit_btn_exp_1.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_1.setBounds(84, 40, 89, 25);
		bills_categ_pnl.add(edit_btn_exp_1);

		JButton del_btn_exp_1 = new JButton("Delete");
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
		edit_btn_exp_2.setForeground(new Color(252, 187, 103));
		edit_btn_exp_2.setBackground(new Color(85, 111, 146));
		edit_btn_exp_2.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_2.setBounds(83, 40, 89, 25);
		shop_categ_pnl.add(edit_btn_exp_2);

		JButton del_btn_exp_2 = new JButton("Delete");
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
		edit_btn_exp_3.setBackground(new Color(85, 111, 146));
		edit_btn_exp_3.setForeground(new Color(252, 187, 103));
		edit_btn_exp_3.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_3.setBounds(83, 40, 89, 25);
		food_categ_pnl.add(edit_btn_exp_3);

		JButton del_btn_exp_3 = new JButton("Delete");
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
		edit_btn_exp_4.setForeground(new Color(252, 187, 103));
		edit_btn_exp_4.setBackground(new Color(85, 111, 146));
		edit_btn_exp_4.setFont(new Font("Quicksand Light", Font.BOLD, 14));
		edit_btn_exp_4.setBounds(83, 40, 89, 25);
		home_categ_pnl.add(edit_btn_exp_4);

		JButton del_btn_exp_4 = new JButton("Delete");
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

		JButton add_categ_btn = new JButton("Add Category");
		add_categ_btn.setBackground(new Color(85, 111, 146));
		add_categ_btn.setForeground(new Color(252, 187, 109));
		add_categ_btn.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		add_categ_btn.setBounds(292, 318, 211, 36);
		categ_panel.add(add_categ_btn);

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
		ImageIcon loglog = new ImageIcon("imgs/budgeeLogoMain.png");
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
