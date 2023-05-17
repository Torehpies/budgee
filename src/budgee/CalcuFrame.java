package budgee;


import java.awt.EventQueue;

import budgee.UserSession; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
import java.util.logging.Level;
import java.util.logging.Logger;


	public class CalcuFrame extends JFrame {

		//Session variables
		UserSession session = UserSession.getInstance();
		private int sessionId = session.getId();
		
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

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CalcuFrame frame = new CalcuFrame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		private final JLayeredPane LayeredPanel = new JLayeredPane();
		
		
		public CalcuFrame() {
			setTitle("Calcu");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane = new JPanel();
			setContentPane(contentPane);
			setBounds(100, 100, 754, 606);
			contentPane.setLayout(null);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			LayeredPanel.setBounds(0, 53, 748, 516);
			contentPane.add(LayeredPanel);
			
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(69, 92, 123));
			panel.setBounds(0, 0, 748, 516);
			LayeredPanel.add(panel);
			JButton btnEqual = new JButton("=");
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
			textField.setFont(new Font("Tahoma", Font.BOLD, 20));
			textField.setColumns(10);
			
			lbl1 = new JLabel(" ");
			lbl1.setBackground(new Color(255, 255, 255));
			lbl1.setForeground(new Color(71, 86, 122));
			lbl1.setBounds(10, 11, 298, 33);
			panel_1.add(lbl1);
			
			txtAddNote = new JTextField();
			txtAddNote.setHorizontalAlignment(SwingConstants.LEFT);
			txtAddNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtAddNote.setForeground(Color.BLACK);
			txtAddNote.setText("Add Note");
			txtAddNote.setBounds(45, 107, 662, 93);
			panel.add(txtAddNote);
			txtAddNote.setColumns(10);
			
			JComboBox<String>  accounts = new JComboBox<String> ();
			accounts.setFocusable(false);
			accounts.setToolTipText("");
			accounts.setBounds(45, 68, 318, 35);
			panel.add(accounts);
			
			accounts.addItem("Card");
			accounts.addItem("Cash");
			accounts.addItem("Savings");
			
			JComboBox<String> category = new JComboBox<String> ();
			category.setFocusable(false);
			category.setBounds(389, 68, 318, 35);
			panel.add(category);
			
			category.addItem("Bills");
			category.addItem("Food");
			category.addItem("Tax");
			category.addItem("Insurance");
			category.addItem("Health");
			category.addItem("Shopping");
			
			JLabel lblAcc = new JLabel("Account");
			lblAcc.setForeground(new Color(255, 255, 255));
			lblAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblAcc.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblAcc.setBounds(45, 42, 318, 17);
			panel.add(lblAcc);
			
			JLabel lblCategory = new JLabel("Category");
			lblCategory.setForeground(new Color(255, 255, 255));
			lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategory.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblCategory.setBounds(385, 40, 318, 21);
			panel.add(lblCategory);
			
			JComboBox<Integer> dayComboBox = new JComboBox<>();
			dayComboBox.setBounds(45, 324, 49, 50);
			panel.add(dayComboBox);

			JComboBox<Month> monthComboBox = new JComboBox<>();
			monthComboBox.setBounds(104, 324, 91, 50);
			panel.add(monthComboBox);

			JComboBox<Integer> yearComboBox = new JComboBox<>();
			yearComboBox.setBackground(new Color(255, 255, 255));
			yearComboBox.setBounds(205, 324, 91, 50);
			panel.add(yearComboBox);

			int currentYear = LocalDate.now().getYear();
			int startYear = currentYear - 10;
			int endYear = currentYear + 100;
			for (int year = startYear; year <= endYear; year++) {
			    yearComboBox.addItem(year);
			}

			for (Month month : Month.values()) {
			    monthComboBox.addItem(month);
			}

			monthComboBox.addActionListener(new ActionListener() {
			    
			    public void actionPerformed(ActionEvent e) {
			        int selectedYear = (int) yearComboBox.getSelectedItem();
			        Month selectedMonth = Month.valueOf(monthComboBox.getSelectedItem().toString());
			        int maxDays = selectedMonth.length(Year.of(selectedYear).isLeap());

			        dayComboBox.removeAllItems();
			        for (int day = 1; day <= maxDays; day++) {
			            dayComboBox.addItem(day);
			        }
			    }
			    }
			
			
			
					);
			

			Month currentMonth = LocalDate.now().getMonth();
			monthComboBox.setSelectedItem(currentMonth.toString());
			yearComboBox.setSelectedItem(currentYear);

			

			int selectedYear = (int) yearComboBox.getSelectedItem();
			int maxDays = currentMonth.length(Year.of(selectedYear).isLeap());

			for (int day = 1; day <= maxDays; day++) {
			    dayComboBox.addItem(day);
			}
			
			
			JLabel tutuldok_1 = new JLabel(":");
			tutuldok_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
			tutuldok_1.setBounds(161, 375, 49, 50);
			panel.add(tutuldok_1);
			
			JComboBox<String> hourComboBox = new JComboBox<>();
		    hourComboBox.setBounds(45, 385, 117, 50);
		    panel.add(hourComboBox);
		 
		    for (int hour = 1; hour <= 12; hour++) {
			 hourComboBox.addItem(String.valueOf(hour));
	        }
		 
		    JComboBox<String> minuteComboBox = new JComboBox<>();
		    minuteComboBox.setBounds(179, 385, 117, 50);
		    panel.add(minuteComboBox);
		 
		    for (int minute = 0; minute <= 59; minute++) {
	        String formattedMinute = String.format("%02d", minute);
	        minuteComboBox.addItem(formattedMinute);
            }
		    
		    hourComboBox.setSelectedItem(1);
	        minuteComboBox.setSelectedItem("00");
		    
		 
		        
			JButton btnSave_1 = new JButton("Save");
			btnSave_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						System.out.println(" eto oh user: " + sessionId);

						// Connect to the database
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root",
								"");
						Statement pst=con.createStatement();

						String sql = "SELECT * FROM budgee_accounts.user_" + sessionId;
						pst.executeQuery(sql);
						
						ResultSet rs = pst.executeQuery(sql);
						
						if (rs.next()) {
							int id = rs.getInt(1);

							// kunin mo yung mga items gawin mong string
							Object selectedValue = accounts.getSelectedItem();
							String selectedString;

							if (selectedValue == null) {
								int lastIndex = accounts.getItemCount() - 1;
								selectedString = accounts.getItemAt(lastIndex).toString();
							} else {
								selectedString = selectedValue.toString();
							}

							Object selectedValue1 = category.getSelectedItem();
							String selectedString1;

							if (selectedValue == null) {

								int lastIndex = category.getItemCount() - 1;
								selectedString1 = category.getItemAt(lastIndex).toString();
							} else {

								selectedString1 = selectedValue1.toString();
							}
							
							
							
//							pst = con.prepareStatement(
//							"INSERT INTO budgee_accounts."+ userTable +"(date, time, balance_update, notes, action, category, account, cash_value, savings_value) VALUE(?,?,?,?,?,?,?,?,?)");
////							pst.setString(1, date);
////							pst.setString(2, time);
////							pst.setString(3, balance_update);
////							pst.setString(4, notes);
////							pst.setString(5, notes);
////							pst.setString(6, last_name);
//							pst.setString(7, selectedString1);
//							pst.setString(8, selectedString);
////							pst.setString(9, cash_value);
//
//							pst.executeUpdate();
						}

						else {
							System.out.println("No rows found in the result set.");
						}

						// Close the result set, prepared statement, and connection
						rs.close();
						pst.close();
						con.close();
					} catch (SQLException e1) {
						System.out.println("SQLException: " + e1.getMessage());
						System.out.println("SQLState: " + e1.getSQLState());
						System.out.println("VendorError: " + e1.getErrorCode());
					}
					timeAndDate();
					System.out.println(currentTime);
				}
			});
			btnSave_1.setFocusable(false);
			btnSave_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnSave_1.setBounds(616, 460, 91, 38);
			panel.add(btnSave_1);
			
			JButton btnCancel_1 = new JButton("Cancel");
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
			
			JButton btnIncome = new JButton("Income");
			btnIncome.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnIncome.setForeground(new Color(252, 187, 109));
			btnIncome.setFocusable(false);
			btnIncome.setBackground(new Color(69, 92, 123));
			btnIncome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
			btnIncome.setBounds(10, 5, 355, 45);
			panel_3.add(btnIncome);
			
			JButton btnExpense = new JButton("Expense");
			btnExpense.setForeground(new Color(252, 187, 109));
			btnExpense.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnExpense.setBackground(new Color(69, 92, 123));
			btnExpense.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
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
		
				


