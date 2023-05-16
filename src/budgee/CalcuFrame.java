package budgee;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
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




	public class CalcuFrame extends JFrame {
		
	
		

	
		private JPanel contentPane;
		private JTextField textField, textField_2;
		private JLabel lbl1,lbl2;

		
		double first;
		double second;
		double result;
		String operation;
		String answer;
		private JTextField txtAddNote, txtAddNote_2;
		
	
				
		
		
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
					second=Double.parseDouble(textField.getText());
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
			});
			
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
			
			JComboBox<String>  Expense_Acc = new JComboBox<String> ();
			Expense_Acc.setFocusable(false);
			Expense_Acc.setToolTipText("");
			Expense_Acc.setBounds(45, 68, 318, 35);
			panel.add(Expense_Acc);
			
			Expense_Acc.addItem("Card");
			Expense_Acc.addItem("Cash");
			Expense_Acc.addItem("Savings");
			
			JComboBox<String> Expense_Categ = new JComboBox<String> ();
			Expense_Categ.setFocusable(false);
			Expense_Categ.setBounds(389, 68, 318, 35);
			panel.add(Expense_Categ);
			
			Expense_Categ.addItem("Bills");
			Expense_Categ.addItem("Food");
			Expense_Categ.addItem("Tax");
			Expense_Categ.addItem("Insurance");
			Expense_Categ.addItem("Health");
			Expense_Categ.addItem("Shopping");
			
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
					
//					try {
//						// comboBox_Acc
//						Object selectedValue = account.getSelectedItem();
//						String selectedString;
//
//						if (selectedValue == null) {
//							// If nothing is selected, use the last item in the ComboBox as the selected
//							// value
//							int lastIndex = account.getItemCount() - 1;
//							selectedString = account.getItemAt(lastIndex).toString();
//						} else {
//							// Convert the selected item to a string
//							selectedString = selectedValue.toString();
//						}
//
//						Object selectedValue1 = category.getSelectedItem();
//						String selectedString1;
//
//						if (selectedValue == null) {
//							// If nothing is selected, use the last item in the ComboBox as the selected
//							// value
//							int lastIndex = category.getItemCount() - 1;
//							selectedString1 = category.getItemAt(lastIndex).toString();
//						} else {
//							// Convert the selected item to a string
//							selectedString1 = selectedValue1.toString();
//						}
//						System.out.println(" eto oh user: " + userNum);
//
////						useText(textValue);
////						System.out.println("the user is " + textValue);
//
//						// Connect to the database
//						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root",
//								"");
//
//						String sql = "SELECT * FROM budgee_accounts." + userNum;
//						pst.executeQuery();
//						
//						if (rs.next()) {
//							int id = rs.getInt(1);
//
//							// kunin mo yung mga items gawin mong string
//
//							pst = con.prepareStatement(
//									"INSERT INTO budgee_accounts.accounts1(date, time, balance_update, notes, action, category, account, cash_value, savings_value) VALUE(?,?,?,?,?,?,?,?,?)");
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
//							 pst.executeUpdate();
//						}
//
//						else {
//							System.out.println("No rows found in the result set.");
//						}
//
//						// Close the result set, prepared statement, and connection
//						rs.close();
//						pst.close();
//						con.close();
//					} catch (SQLException e1) {
//						System.out.println("SQLException: " + e1.getMessage());
//						System.out.println("SQLState: " + e1.getSQLState());
//						System.out.println("VendorError: " + e1.getErrorCode());
//					}
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
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(69, 92, 123));
			panel_2.setBounds(0, 0, 748, 516);
			LayeredPanel.add(panel_2);
			panel_2.setLayout(null);
			
			JComboBox<String> Income_Acc = new JComboBox<String>();
			Income_Acc.setToolTipText("");
			Income_Acc.setFocusable(false);
			Income_Acc.setBounds(45, 68, 318, 35);
			panel_2.add(Income_Acc);

			Income_Acc.addItem("Card");
			Income_Acc.addItem("Cash");
			Income_Acc.addItem("Savings");
			
			
			JComboBox<String> Income_Categ = new JComboBox<String>();
			Income_Categ.setFocusable(false);
			Income_Categ.setBounds(389, 68, 318, 35);
			panel_2.add(Income_Categ);
			
			Income_Categ.addItem("Salary");
			Income_Categ.addItem("Rental");
			Income_Categ.addItem("Sale");
			Income_Categ.addItem("Coupons");
			Income_Categ.addItem("Refunds");
		
			
			JLabel lblAcc_2 = new JLabel("Account");
			lblAcc_2.setForeground(new Color(255, 255, 255));
			lblAcc_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblAcc_2.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblAcc_2.setBounds(45, 42, 318, 17);
			panel_2.add(lblAcc_2);
			
			JLabel lblCategory_2 = new JLabel("Category");
			lblCategory_2.setForeground(new Color(255, 255, 255));
			lblCategory_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategory_2.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblCategory_2.setBounds(385, 40, 318, 21);
			panel_2.add(lblCategory_2);
			
			JComboBox<Integer> dayComboBox_2 = new JComboBox<>();
			dayComboBox_2.setBounds(45, 324, 49, 50);
			panel_2.add(dayComboBox_2);

			JComboBox<Month> monthComboBox_2 = new JComboBox<>();
			monthComboBox_2.setBounds(104, 324, 91, 50);
			panel_2.add(monthComboBox_2);

			JComboBox<Integer> yearComboBox_2 = new JComboBox<>();
			yearComboBox_2.setBackground(new Color(255, 255, 255));
			yearComboBox_2.setBounds(205, 324, 91, 50);
			panel_2.add(yearComboBox_2);

			int currentYear_2 = LocalDate.now().getYear();
			int startYear_2 = currentYear_2 - 10;
			int endYear_2 = currentYear_2 + 100;
			for (int year = startYear_2; year <= endYear_2; year++) {
			    yearComboBox_2.addItem(year);
			}

			for (Month month : Month.values()) {
			    monthComboBox_2.addItem(month);
			}

			monthComboBox_2.addActionListener(new ActionListener() {
			    
			    public void actionPerformed(ActionEvent e) {
			        int selectedYear_2 = (int) yearComboBox_2.getSelectedItem();
			        Month selectedMonth_2 = Month.valueOf(monthComboBox_2.getSelectedItem().toString());
			        int maxDays = selectedMonth_2.length(Year.of(selectedYear_2).isLeap());

			        dayComboBox_2.removeAllItems();
			        for (int day = 1; day <= maxDays; day++) {
			            dayComboBox_2.addItem(day);
			        }
			    }
			    }
			
			
			
					);
			

			Month currentMonth_2 = LocalDate.now().getMonth();
			monthComboBox_2.setSelectedItem(currentMonth_2.toString());
			yearComboBox_2.setSelectedItem(currentYear);

			

			int selectedYear_2 = (int) yearComboBox.getSelectedItem();
			int maxDays_2 = currentMonth_2.length(Year.of(selectedYear_2).isLeap());

			for (int day = 1; day <= maxDays_2; day++) {
			    dayComboBox_2.addItem(day);
			}
			
			JLabel tutuldok_2 = new JLabel(":");
			tutuldok_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
			tutuldok_2.setBounds(161, 375, 49, 50);
			panel_2.add(tutuldok_2);
			
			JComboBox<String> hourComboBox_2 = new JComboBox<>();
		    hourComboBox_2.setBounds(45, 385, 117, 50);
		    panel_2.add(hourComboBox_2);
		 
		    for (int hour = 1; hour <= 12; hour++) {
			 hourComboBox_2.addItem(String.valueOf(hour));
	        }
		 
		    JComboBox<String> minuteComboBox_2 = new JComboBox<>();
		    minuteComboBox_2.setBounds(179, 385, 117, 50);
		    panel_2.add(minuteComboBox_2);
		 
		    for (int minute = 0; minute <= 59; minute++) {
	        String formattedMinute = String.format("%02d", minute);
	        minuteComboBox_2.addItem(formattedMinute);
            }
		    
		    hourComboBox_2.setSelectedItem(1);
	        minuteComboBox_2.setSelectedItem("00");
		
			
			txtAddNote_2 = new JTextField();
			txtAddNote_2.setHorizontalAlignment(SwingConstants.LEFT);
			txtAddNote_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtAddNote_2.setForeground(Color.BLACK);
			txtAddNote_2.setText("Add Note");
			txtAddNote_2.setBounds(45, 107, 662, 93);
			txtAddNote_2.setColumns(10);
			panel_2.add(txtAddNote_2);
			
			JButton btnPlus_2 = new JButton("+");
			btnPlus_2.setForeground(new Color(252, 187, 109));
			btnPlus_2.setBackground(new Color(71, 86, 122));
			btnPlus_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnPlus_2.setFocusable(false);
			btnPlus_2.setBounds(385, 202, 73, 50);
			panel_2.add(btnPlus_2);
			btnPlus_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  first=Double.parseDouble(textField_2.getText()); 
				        textField_2.setText("");
				        operation="+";
				        lbl2.setText(first + " + ");
				       
				}
			});
			
			JButton btn7_2 = new JButton("7");
			btn7_2.setForeground(new Color(252, 187, 109));
			btn7_2.setBackground(new Color(71, 86, 122));
			btn7_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn7_2.setFocusable(false);
			btn7_2.setBounds(468, 202, 73, 50);
			panel_2.add(btn7_2);
			btn7_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn7_2.getText();
					textField.setText(number);
					
				}
			});
			
			JButton btn8_2 = new JButton("8");
			btn8_2.setForeground(new Color(252, 187, 109));
			btn8_2.setBackground(new Color(71, 86, 122));
			btn8_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn8_2.setFocusable(false);
			btn8_2.setBounds(551, 202, 73, 50);
			panel_2.add(btn8_2);
			btn8_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn8_2.getText();
					textField.setText(number);
					
				}
			});
			
			
			JButton btn9_2 = new JButton("9");
			btn9_2.setForeground(new Color(252, 187, 109));
			btn9_2.setBackground(new Color(71, 86, 122));
			btn9_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn9_2.setFocusable(false);
			btn9_2.setBounds(634, 202, 73, 50);
			panel_2.add(btn9_2);
			btn9_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn9_2.getText();
					textField_2.setText(number);
					
				}
			});
			JPanel panel_result = new JPanel();
			panel_result.setLayout(null);
			panel_result.setBounds(45, 202, 318, 93);
			panel_2.add(panel_result);
			
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
			textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			textField_2.setColumns(10);
			textField_2.setBounds(10, 48, 300, 45);
			panel_result.add(textField_2);
			
			JLabel lbl2 = new JLabel(" ");
			lbl2.setBounds(10, 11, 298, 33);
			panel_result.add(lbl2);
			
			JButton btnC_2 = new JButton("C");
			btnC_2.setBackground(new Color(216, 115, 127));
			btnC_2.setForeground(new Color(71, 86, 122));
			btnC_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnC_2.setFocusable(false);
			btnC_2.setBounds(306, 324, 73, 50);
			panel_2.add(btnC_2);
			btnC_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				operation=null;
	            lbl2.setText("");
				}
			});
			
			JButton btnMulti_2 = new JButton("x");
			btnMulti_2.setForeground(new Color(252, 187, 109));
			btnMulti_2.setBackground(new Color(71, 86, 122));
			btnMulti_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnMulti_2.setFocusable(false);
			btnMulti_2.setBounds(385, 324, 73, 50);
			panel_2.add(btnMulti_2);
			btnMulti_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="*";
					lbl2.setText(first + " * ");
				}
			});
			
			JButton btnDiv_2 = new JButton("÷");
			btnDiv_2.setForeground(new Color(252, 187, 109));
			btnDiv_2.setBackground(new Color(71, 86, 122));
			btnDiv_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDiv_2.setFocusable(false);
			btnDiv_2.setBounds(385, 263, 73, 50);
			panel_2.add(btnDiv_2);
			btnDiv_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="/";
					lbl2.setText(first + " /");
				}});
			
			JButton btn4_2 = new JButton("4");
			btn4_2.setForeground(new Color(252, 187, 109));
			btn4_2.setBackground(new Color(71, 86, 122));
			btn4_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn4_2.setFocusable(false);
			btn4_2.setBounds(468, 263, 73, 50);
			panel_2.add(btn4_2);
			btn4_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn4_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btn5_2 = new JButton("5");
			btn5_2.setForeground(new Color(252, 187, 109));
			btn5_2.setBackground(new Color(71, 86, 122));
			btn5_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn5_2.setFocusable(false);
			btn5_2.setBounds(551, 263, 73, 50);
			panel_2.add(btn5_2);
			btn5_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn5_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btn6_2 = new JButton("6");
			btn6_2.setForeground(new Color(252, 187, 109));
			btn6_2.setBackground(new Color(71, 86, 122));
			btn6_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn6_2.setFocusable(false);
			btn6_2.setBounds(634, 263, 73, 50);
			panel_2.add(btn6_2);
			btn6_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn6_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btn3_2 = new JButton("3");
			btn3_2.setForeground(new Color(252, 187, 109));
			btn3_2.setBackground(new Color(71, 86, 122));
			btn3_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn3_2.setFocusable(false);
			btn3_2.setBounds(634, 324, 73, 50);
			panel_2.add(btn3_2);
			btn3_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn3_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btn2_2 = new JButton("2");
			btn2_2.setForeground(new Color(252, 187, 109));
			btn2_2.setBackground(new Color(71, 86, 122));
			btn2_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn2_2.setFocusable(false);
			btn2_2.setBounds(551, 324, 73, 50);
			panel_2.add(btn2_2);
			btn2_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn2_2.getText();
					textField_2.setText(number);
				}});
			
			
			JButton btn1_2 = new JButton("1");
			btn1_2.setForeground(new Color(252, 187, 109));
			btn1_2.setBackground(new Color(71, 86, 122));
			btn1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn1_2.setFocusable(false);
			btn1_2.setBounds(468, 324, 73, 50);
			panel_2.add(btn1_2);
			btn1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn1_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btn0_2 = new JButton("0");
			btn0_2.setForeground(new Color(252, 187, 109));
			btn0_2.setBackground(new Color(71, 86, 122));
			btn0_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn0_2.setFocusable(false);
			btn0_2.setBounds(468, 385, 73, 50);
			panel_2.add(btn0_2);
			btn0_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn0_2.getText();
					textField_2.setText(number);
				}
			});
			
			JButton btnDot_2 = new JButton(".");
			btnDot_2.setForeground(new Color(252, 187, 109));
			btnDot_2.setBackground(new Color(71, 86, 122));
			btnDot_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDot_2.setFocusable(false);
			btnDot_2.setBounds(551, 385, 73, 50);
			panel_2.add(btnDot_2);
			btnDot_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						String number=textField_2.getText()+btnDot_2.getText();
						textField_2.setText(number);
						
				}
			});
			
			JButton btnEqual2 = new JButton("=");
			btnEqual2.setForeground(new Color(252, 187, 109));
			btnEqual2.setBackground(new Color(71, 86, 122));
			btnEqual2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnEqual2.setFocusable(false);
			btnEqual2.setBounds(634, 385, 73, 50);
			panel_2.add(btnEqual2);
			btnEqual2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String answer;
					second=Double.parseDouble(textField_2.getText());
					if(operation=="+")
					{
						result=first+second;
						answer=String.format("%.2f", result);
						textField_2.setText(answer);
						lbl2.setText(first + " + " + second + " = " );
					}
					else if(operation=="-")
					{
						result=first-second;
						answer=String.format("%.2f", result);
						textField_2.setText(answer);
						lbl2.setText(first + " - " + second + " = " );
					}
					else if(operation=="*")
					{
						result=first*second;
						answer=String.format("%.2f", result);
						textField_2.setText(answer);
						lbl2.setText(first + " * " + second + " = " );
					}
					else if(operation=="/")
					{
						result=first/second;
						answer=String.format("%.2f", result);
						textField_2.setText(answer);
						lbl2.setText(first + " / " + second + " = " );
						}
					operation=null;
					
					
				}
			});
			
			JButton btnDash_2 = new JButton("-");
			btnDash_2.setForeground(new Color(252, 187, 109));
			btnDash_2.setBackground(new Color(71, 86, 122));
			btnDash_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDash_2.setBounds(0, 34, 73, -34);
			btnDash_2.setFocusable(false);
			btnDash_2.setBounds(385, 385, 73, 50);
			panel_2.add(btnDash_2);
			btnDash_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="-";
					lbl2.setText(first + " - ");
					
					
				}
			});
			
			
			JButton btnDEL_2 = new JButton("DEL");
			btnDEL_2.setBackground(new Color(216, 115, 127));
			btnDEL_2.setForeground(new Color(71, 86, 122));
			btnDEL_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDEL_2.setFocusable(false);
			btnDEL_2.setBounds(306, 385, 73, 50);
			panel_2.add(btnDEL_2);
			
			JButton btnSave_2 = new JButton("Save");
			btnSave_2.setBounds(616, 460, 91, 38);
			panel_2.add(btnSave_2);
			btnSave_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnSave_2.setFocusable(false);
			
			JButton btnCancel_2 = new JButton("Cancel");
			btnCancel_2.setBounds(514, 460, 91, 38);
			panel_2.add(btnCancel_2);
			btnCancel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnCancel_2.setFocusable(false);
	
			btnDEL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String backSpace=null;
					if(textField_2.getText().length()>0)
					{
						StringBuilder str=new StringBuilder(textField_2.getText());
						str.deleteCharAt(textField_2.getText().length()-1);
						backSpace=str.toString();
						textField_2.setText(backSpace);
					}}
			});
			
			
			
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
					Switch_panel(panel_2);
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
					Switch_panel(panel);
				}
			});
			btnExpense.setBounds(380, 5, 355, 45);
			btnExpense.setFocusable(false);
			panel_3.add(btnExpense);
			
		}
		public void Switch_panel(JPanel p) {
			LayeredPanel.removeAll();
			LayeredPanel.add(p);
			LayeredPanel.repaint();
			LayeredPanel.revalidate();
		}		
}
		
				


