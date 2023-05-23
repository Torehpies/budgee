package budgee;


import java.awt.EventQueue;

import budgee.UserSession; 
import budgee.Record;
import budgee.DatabaseManager;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;


import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;


	public class CalcuFrame extends JFrame {

		private UserSession session = UserSession.getInstance();
		private int sessionId = session.getId();		
		private JScrollPane parentPanel;		
		private String recordAction = "income";	
		private JPanel contentPane;
		private JTextField textField;
		private JLabel lbl1,lbl2;		
		double first;
		double second;
		double result;
		String operation;
		String answer;
		private JTextField txtAddNote;	
		public static Instant currentTime;
		public static void timeAndDate()  
		{      
		System.out.println(java.time.Clock.systemUTC().instant());
		currentTime = java.time.Clock.systemUTC().instant();
		}		
		public static String userTable;
		public static String useText(String text) {
		String userTable = text;
		return text;
		}		
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		private JPasswordField password;		
		public void Connect() {
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
		    } catch (ClassNotFoundException | SQLException ex) {
		      Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);}
		        // Handle the exception appropriately, e.g. show an error message to the user
		    }
		 private void updateComboBoxItems(JComboBox<String> category, List<String> items) {
		        category.removeAllItems();
		        for (String item : items) {
		            category.addItem(item);
		        }
		    }

		  
		private final JLayeredPane LayeredPanel = new JLayeredPane();
		
		
		public CalcuFrame(JScrollPane parentPanel) {
			this.parentPanel = parentPanel;
			
			setTitle("Calcu");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			contentPane = new JPanel();
			setContentPane(contentPane);
			setBounds(100, 100, 754, 606);
			contentPane.setLayout(null);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			
			 ImageIcon icon = new ImageIcon("imgs/budgeeLogoMain.png");
			 Image image = icon.getImage();

			 // Set the frame icon
			 setIconImage(image);

			LayeredPanel.setBounds(0, 53, 748, 516);
			contentPane.add(LayeredPanel);		
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(69, 92, 123));
			panel.setBounds(0, 0, 748, 516);
			LayeredPanel.add(panel);
			JButton btnEqual = new JButton("=");
			btnEqual.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnEqual.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnEqual.setBackground(new Color(71, 86, 122));
			btnEqual.setFocusable(false);
			btnEqual.setForeground(new Color(252, 187, 109));
			btnEqual.setBounds(634, 385, 73, 50);
			btnEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String answer;
					String text = textField.getText();
			        
			        if (!text.isEmpty()) {
			            second = Double.parseDouble(text);
					if(operation=="+")
					{
						result=first+second;
						answer=String.format("%.2f", result);
						textField.setText(answer);
						lbl1.setText(first + " + " + second + " = " );
					}
					else if(operation=="-")
					{
						result=first-second;
						answer=String.format("%.2f", result);
						textField.setText(answer);
						lbl1.setText(first + " - " + second + " = " );
					}
					else if(operation=="*")
					{
						result=first*second;
						answer=String.format("%.2f", result);
						textField.setText(answer);
						lbl1.setText(first + " * " + second + " = " );
					}
					else if(operation=="/")
					{
						result=first/second;
						answer=String.format("%.2f", result);
						textField.setText(answer);
						lbl1.setText(first + " / " + second + " = " );
						}
					operation=null;
					
					
				}
				}});
			
			JButton btnDot = new JButton(".");
			btnDot.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnDot.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDot.setBackground(new Color(71, 86, 122));
			btnDot.setFocusable(false);
			btnDot.setForeground(new Color(252, 187, 109));
			btnDot.setBounds(551, 385, 73, 50);
			btnDot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						String number=textField.getText()+btnDot.getText();
						textField.setText(number);
						
				}
			});
			
			JButton btn3 = new JButton("3");
			btn3.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn3.setBackground(new Color(71, 86, 122));
			btn3.setFocusable(false);
			btn3.setForeground(new Color(252, 187, 109));
			btn3.setBounds(634, 324, 73, 50);
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn3.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btn2 = new JButton("2");
			btn2.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn2.setBackground(new Color(71, 86, 122));
			btn2.setFocusable(false);
			btn2.setForeground(new Color(252, 187, 109));
			btn2.setBounds(551, 324, 73, 50);
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn2.getText();
					textField.setText(number);
				
				}
			});
			
			JButton btn0 = new JButton("0");
			btn0.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn0.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn0.setBackground(new Color(71, 86, 122));
			btn0.setFocusable(false);
			btn0.setForeground(new Color(252, 187, 109));
			btn0.setBounds(468, 385, 73, 50);
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn0.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btnDash = new JButton("-");
			btnDash.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnDash.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDash.setBackground(new Color(71, 86, 122));
			btnDash.setFocusable(false);
			btnDash.setForeground(new Color(252, 187, 109));
			btnDash.setBounds(385, 385, 73, 50);
			btnDash.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField.getText()); 
					textField.setText("");
					operation="-";
					lbl1.setText(first + " - ");
					
					
				}
			});
			
			JButton btn1 = new JButton("1");
			btn1.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn1.setBackground(new Color(71, 86, 122));
			btn1.setFocusable(false);
			btn1.setForeground(new Color(252, 187, 109));
			btn1.setBounds(468, 324, 73, 50);
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn1.getText();
					textField.setText(number);
				;
				}
			});
			
			JButton btnMulti = new JButton("x");
			btnMulti.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnMulti.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnMulti.setBackground(new Color(71, 86, 122));
			btnMulti.setFocusable(false);
			btnMulti.setForeground(new Color(252, 187, 109));
			btnMulti.setBounds(385, 324, 73, 50);
			btnMulti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField.getText()); 
					textField.setText("");
					operation="*";
					lbl1.setText(first + " * ");
				}
			});
			
			JButton btn6 = new JButton("6");
			btn6.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn6.setBackground(new Color(71, 86, 122));
			btn6.setForeground(new Color(252, 187, 109));
			btn6.setFocusable(false);
			btn6.setBounds(634, 263, 73, 50);
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn6.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btn5 = new JButton("5");
			btn5.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn5.setBackground(new Color(71, 86, 122));
			btn5.setForeground(new Color(252, 187, 109));
			btn5.setFocusable(false);
			btn5.setBounds(551, 263, 73, 50);
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn5.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btn4 = new JButton("4");
			btn4.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn4.setForeground(new Color(252, 187, 109));
			btn4.setBackground(new Color(71, 86, 122));
			btn4.setFocusable(false);
			btn4.setBounds(468, 263, 73, 50);
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn4.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btnDivide = new JButton("÷");
			btnDivide.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnDivide.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDivide.setForeground(new Color(252, 187, 109));
			btnDivide.setBackground(new Color(71, 86, 122));
			btnDivide.setFocusable(false);
			btnDivide.setBounds(385, 263, 73, 50);
			btnDivide.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField.getText()); 
					textField.setText("");
					operation="/";
					lbl1.setText(first + " / ");
				}
			});
			
			JButton btnPlus = new JButton("+");
			btnPlus.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnPlus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnPlus.setForeground(new Color(252, 187, 109));
			btnPlus.setBackground(new Color(71, 86, 122));
			btnPlus.setFocusable(false);
			btnPlus.setBounds(385, 202, 73, 50);
			btnPlus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  first=Double.parseDouble(textField.getText()); 
				        textField.setText("");
				        operation="+";
				        lbl1.setText(first + " + ");
				       
				}
			});
			
			JButton btn7 = new JButton("7");
			btn7.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn7.setForeground(new Color(252, 187, 109));
			btn7.setBackground(new Color(71, 86, 122));
			btn7.setFocusable(false);
			btn7.setBounds(468, 202, 73, 50);
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn7.getText();
					textField.setText(number);
				
				}
			});
			
			JButton btn8 = new JButton("8");
			btn8.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn8.setForeground(new Color(252, 187, 109));
			btn8.setBackground(new Color(71, 86, 122));
			btn8.setFocusable(false);
			btn8.setBounds(551, 202, 73, 50);
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn8.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btn9 = new JButton("9");
			btn9.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btn9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn9.setForeground(new Color(252, 187, 109));
			btn9.setBackground(new Color(71, 86, 122));
			btn9.setFocusable(false);
			btn9.setBounds(634, 202, 73, 50);
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn9.getText();
					textField.setText(number);
				}
			});
			
			JButton btnC = new JButton("C");
			btnC.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnC.setForeground(new Color(71, 86, 122));
			btnC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnC.setBackground(new Color(216, 115, 127));
			btnC.setFocusable(false);
			btnC.setBounds(306, 324, 73, 50);
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				textField.setText("");
				operation=null;
	            lbl1.setText("");
				}
			});
			
			JButton btnDEL = new JButton("DEL");
			btnDEL.setFont(new Font("Quicksand Light", Font.BOLD, 13));
			btnDEL.setForeground(new Color(71, 86, 122));
			btnDEL.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDEL.setBackground(new Color(216, 115, 127));
			btnDEL.setFocusable(false);
			btnDEL.setBounds(306, 385, 73, 50);
			btnDEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String backSpace=null;
					if(textField.getText().length()>0)
					{
						StringBuilder str=new StringBuilder(textField.getText());
						str.deleteCharAt(textField.getText().length()-1);
						backSpace=str.toString();
						textField.setText(backSpace);
					}}
			});
			panel.setLayout(null);
			panel.add(btnDEL);
			panel.add(btnC);
			panel.add(btnPlus);
			panel.add(btn7);
			panel.add(btn8);
			panel.add(btn9);
			panel.add(btnDash);
			panel.add(btn0);
			panel.add(btnDot);
			panel.add(btnMulti);
			panel.add(btn1);
			panel.add(btn2);
			panel.add(btnDivide);
			panel.add(btn4);
			panel.add(btn5);
			panel.add(btn6);
			panel.add(btn3);
			panel.add(btnEqual);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(240, 240, 240));
			panel_1.setBounds(45, 202, 318, 93);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			textField = new JTextField();
			textField.setForeground(new Color(71, 86, 122));
			textField.setCaretColor(new Color(71, 86, 122));
			textField.setEditable(false);
			textField.setBackground(new Color(255, 255, 255));
			textField.setBounds(10, 45, 300, 45);
			panel_1.add(textField);
			textField.setHorizontalAlignment(SwingConstants.RIGHT);
			textField.setFont(new Font("Quicksand Light", Font.BOLD, 20));
			textField.setColumns(10);
			
			lbl1 = new JLabel(" ");
			lbl1.setBackground(new Color(255, 255, 255));
			lbl1.setForeground(new Color(71, 86, 122));
			lbl1.setBounds(10, 11, 298, 33);
			panel_1.add(lbl1);
			
			txtAddNote = new JTextField();
			txtAddNote.setText("      Add note");
			txtAddNote.setHorizontalAlignment(SwingConstants.LEFT);
			txtAddNote.setFont(new Font("Quicksand Light", Font.BOLD, 15));
			txtAddNote.setForeground(Color.BLACK);
			txtAddNote.setBounds(45, 107, 662, 93);
			panel.add(txtAddNote);
			txtAddNote.setColumns(10);
			
			JComboBox<String>  accounts = new JComboBox<String> ();
			accounts.setFocusable(false);
			accounts.setToolTipText("");
			accounts.setBounds(45, 68, 318, 35);
			panel.add(accounts);
			
			accounts.addItem("Cash");
			accounts.addItem("Savings");
			
			JComboBox<String> category = new JComboBox<String> ();
			category.setFocusable(false);
			category.setBounds(389, 68, 318, 35);
			panel.add(category);
			
			List<String> ExpenseItems = new ArrayList<>();
			ExpenseItems.add("Bills");
			ExpenseItems.add("Food");
			ExpenseItems.add("Tax");
			ExpenseItems.add("Insurance");
			ExpenseItems.add("Health");
			ExpenseItems.add("Shopping");
		    updateComboBoxItems(category, ExpenseItems);
			
			JLabel lblAcc = new JLabel("Account");
			lblAcc.setForeground(new Color(255, 255, 255));
			lblAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblAcc.setFont(new Font("Quicksand Light", Font.BOLD, 20));
			lblAcc.setBounds(45, 42, 318, 17);
			panel.add(lblAcc);
			
			JLabel lblCategory = new JLabel("Category");
			lblCategory.setForeground(new Color(255, 255, 255));
			lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategory.setFont(new Font("Quicksand Light", Font.BOLD, 20));
			lblCategory.setBounds(385, 39, 318, 23);
			panel.add(lblCategory);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(45, 324, 251, 50);
			panel.add(dateChooser);
			
			java.util.Date currentDate = new java.util.Date();
			 dateChooser.setDate(currentDate);
					
			JLabel tutuldok_1 = new JLabel(":");
			tutuldok_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
			tutuldok_1.setBounds(161, 375, 49, 50);
			panel.add(tutuldok_1);
			
			JComboBox<String> hourComboBox = new JComboBox<>();
			hourComboBox.setFont(new Font("Quicksand Light", Font.BOLD, 11));
			hourComboBox.setBounds(45, 385, 117, 50);
			panel.add(hourComboBox);

			for (int hour = 1; hour <= 24; hour++) {
			    hourComboBox.addItem(String.valueOf(hour));
			}

			JComboBox<String> minuteComboBox = new JComboBox<>();
			minuteComboBox.setFont(new Font("Quicksand Light", Font.BOLD, 11));
			minuteComboBox.setBounds(179, 385, 117, 50);
			panel.add(minuteComboBox);

			for (int minute = 0; minute <= 59; minute++) {
			    String formattedMinute = String.format("%02d", minute);
			    minuteComboBox.addItem(formattedMinute);
			}

			LocalTime currentTime = LocalTime.now();

			hourComboBox.setSelectedItem(String.valueOf(currentTime.getHour()));
			minuteComboBox.setSelectedItem(String.format("%02d",currentTime.getMinute()));
		        
			JButton btnSave_1 = new JButton("Save");
			btnSave_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String num = textField.getText();
					if (num.isEmpty()) {  
						JOptionPane.showMessageDialog(null, "Amount is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					else {
					
					String selectedDate = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
					
					Date recordDate = Date.valueOf(selectedDate);
					
					String selectedTime = (hourComboBox.getSelectedItem()).toString() + ":" + 
							(minuteComboBox.getSelectedItem()).toString() + ":" + "00";
					
					Time recordTime = Time.valueOf(selectedTime);
					
					BigDecimal recordBalanceUpdate = new BigDecimal(textField.getText());
					
					String recordNotes = txtAddNote.getText();
					
					Object accountObject = accounts.getSelectedItem();
					String recordAccount = "";

					if (accountObject == null) {
						int lastIndex = accounts.getItemCount() - 1;
						recordAccount = accounts.getItemAt(lastIndex).toString();
					} else {
						recordAccount = accountObject.toString();
					}

					Object categoryObject = category.getSelectedItem();
					String recordCategory = "";

					if (categoryObject == null) {

						int lastIndex = category.getItemCount() - 1;
						recordCategory = category.getItemAt(lastIndex).toString();
					} else {

						recordCategory = categoryObject.toString();
					}
					
					Record record = new Record(sessionId, recordDate, recordTime, recordBalanceUpdate, 
							recordNotes, recordAction, recordCategory, recordAccount);
					
					Connection connection = DatabaseManager.getConnection();				
					BudgeeDAOImpl BudgeeDAO = new BudgeeDAOImpl(connection);
					BudgeeDAO.addRecord(record);
					BudgeeDAO.updateAddBudget(record);
					
					MainFrameUtils.refreshRecords(parentPanel);
					
					dispose();
					}
				}
			});
			
			btnSave_1.setFocusable(false);
			btnSave_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnSave_1.setBounds(616, 460, 91, 38);
			panel.add(btnSave_1);
			
			JButton btnCancel_1 = new JButton("Cancel");
			btnCancel_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel_1.setFocusable(false);
			btnCancel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnCancel_1.setBounds(514, 460, 91, 38);
			panel.add(btnCancel_1);
			

			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(69, 92, 123));
			panel_3.setForeground(new Color(69, 92, 123));
			panel_3.setBounds(0, 0, 748, 60);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			
			  recordAction = "expense";
			
			
			JButton btnExpense = new JButton("Expense");
			JButton btnIncome = new JButton("Income");
			
			btnIncome.setFont(new Font("Quicksand Light", Font.BOLD, 15));
			btnIncome.setForeground(new Color(252, 187, 109));
			btnIncome.setFocusable(false);
			btnIncome.setBackground(new Color(69, 92, 123));
			btnIncome.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        btnIncome.setBackground(new Color(252, 187, 109));
					btnIncome.setForeground(new Color(71, 86, 122));
					
			        btnExpense.setBackground(new Color(69, 92, 123));
			        btnExpense.setForeground(new Color(252, 187, 109));
			        
			        List<String> incomeItems = new ArrayList<>();
			        incomeItems.add("Salary");
			        incomeItems.add("Awards");
			        incomeItems.add("Coupons");			      
			        incomeItems.add("Business");
			        updateComboBoxItems(category, incomeItems);

			        recordAction = "income";
			    }
			});
			btnIncome.setBounds(10, 5, 355, 45);
			panel_3.add(btnIncome);

		
			btnExpense.setForeground(new Color(71, 86, 122));
			btnExpense.setFont(new Font("Quicksand Light", Font.BOLD, 15));
			btnExpense.setBackground(new Color(252, 187, 109));
			btnExpense.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        btnExpense.setBackground(new Color(252, 187, 109));
			    	btnExpense.setForeground(new Color(71, 86, 122));
			    	
			        btnIncome.setBackground(null);
			        btnIncome.setForeground(new Color(252, 187, 109));

			        updateComboBoxItems(category, ExpenseItems);

			        recordAction = "expense";
			    }
			});
			btnExpense.setBounds(380, 5, 355, 45);
			btnExpense.setFocusable(false);
			panel_3.add(btnExpense);
			btnExpense.setBounds(380, 5, 355, 45);
			btnExpense.setFocusable(false);
			panel_3.add(btnExpense)
	;}
		
			
		
		public void Switch_panel(JPanel p) {
			LayeredPanel.removeAll();
			LayeredPanel.add(p);
			LayeredPanel.repaint();
			LayeredPanel.revalidate();
		}
}
		
				


