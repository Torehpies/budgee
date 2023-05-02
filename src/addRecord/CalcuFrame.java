package addRecord;

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
		private JTextField textField;
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
		private JTextField textField_1;
		private JTextField textField_2;
		
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
			
			
			
			
			final JPanel panel = new JPanel();
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
			
			final JButton btnDot = new JButton(".");
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
			
			final JButton btn3 = new JButton("3");
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
			
			final JButton btn2 = new JButton("2");
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
			
			final JButton btn0 = new JButton("0");
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
			
			final JButton btn1 = new JButton("1");
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
			
			final JButton btn6 = new JButton("6");
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
			
			final JButton btn5 = new JButton("5");
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
			
			final JButton btn4 = new JButton("4");
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
			
			final JButton btnDivide = new JButton("÷");
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
			
			final JButton btnPlus = new JButton("+");
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
			
			final JButton btn7 = new JButton("7");
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
			
			final JButton btn8 = new JButton("8");
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
			
			final JButton btn9 = new JButton("9");
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
			
			JComboBox comboBox_Acc = new JComboBox();
			comboBox_Acc.setFocusable(false);
			comboBox_Acc.setToolTipText("");
			comboBox_Acc.setBounds(45, 68, 318, 35);
			panel.add(comboBox_Acc);
			
			comboBox_Acc.addItem("Card");
			comboBox_Acc.addItem("Cash");
			comboBox_Acc.addItem("Savings");
			
			JComboBox comboBox_Categ = new JComboBox();
			comboBox_Categ.setFocusable(false);
			comboBox_Categ.setBounds(389, 68, 318, 35);
			panel.add(comboBox_Categ);
			
			comboBox_Categ.addItem("Bills");
			comboBox_Categ.addItem("Food");
			comboBox_Categ.addItem("Tax");
			comboBox_Categ.addItem("Insurance");
			comboBox_Categ.addItem("Health");
			comboBox_Categ.addItem("Shopping");
			
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
			
			JButton btnDate = new JButton("*date");
			btnDate.setForeground(new Color(252, 187, 109));
			btnDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDate.setBackground(new Color(71, 86, 122));
			btnDate.setFocusable(false);
			btnDate.setBounds(45, 324, 251, 50);
			panel.add(btnDate);
			
			JButton btnTime = new JButton("*time");
			btnTime.setForeground(new Color(252, 187, 109));
			btnTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnTime.setBackground(new Color(71, 86, 122));
			btnTime.setFocusable(false);
			btnTime.setBounds(45, 387, 251, 48);
			panel.add(btnTime);
			
			JButton btnSave_1_1 = new JButton("Save");
			btnSave_1_1.setFocusable(false);
			btnSave_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnSave_1_1.setBounds(616, 460, 91, 38);
			panel.add(btnSave_1_1);
			
			JButton btnCancel_1_1 = new JButton("Cancel");
			btnCancel_1_1.setFocusable(false);
			btnCancel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnCancel_1_1.setBounds(514, 460, 91, 38);
			panel.add(btnCancel_1_1);
			
			
			final JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(69, 92, 123));
			panel_2.setBounds(0, 0, 748, 516);
			LayeredPanel.add(panel_2);
			panel_2.setLayout(null);
			
			JComboBox comboBox_Acc_1 = new JComboBox();
			comboBox_Acc_1.setToolTipText("");
			comboBox_Acc_1.setFocusable(false);
			comboBox_Acc_1.setBounds(45, 68, 318, 35);
			panel_2.add(comboBox_Acc_1);
			
			JComboBox comboBox_Categ_1 = new JComboBox();
			comboBox_Categ_1.setFocusable(false);
			comboBox_Categ_1.setBounds(389, 68, 318, 35);
			panel_2.add(comboBox_Categ_1);
			
			JLabel lblAcc_1 = new JLabel("Account");
			lblAcc_1.setForeground(new Color(255, 255, 255));
			lblAcc_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblAcc_1.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblAcc_1.setBounds(45, 42, 318, 17);
			panel_2.add(lblAcc_1);
			
			JLabel lblCategory_1 = new JLabel("Category");
			lblCategory_1.setForeground(new Color(255, 255, 255));
			lblCategory_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategory_1.setFont(new Font("Stencil", Font.PLAIN, 20));
			lblCategory_1.setBounds(385, 40, 318, 21);
			panel_2.add(lblCategory_1);
			
			txtAddNote_2 = new JTextField();
			txtAddNote_2.setHorizontalAlignment(SwingConstants.LEFT);
			txtAddNote_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtAddNote_2.setForeground(Color.BLACK);
			txtAddNote_2.setText("Add Note");
			txtAddNote_2.setBounds(45, 107, 662, 93);
			txtAddNote_2.setColumns(10);
			panel_2.add(txtAddNote_2);
			
			JButton btnPlus_1 = new JButton("+");
			btnPlus_1.setForeground(new Color(252, 187, 109));
			btnPlus_1.setBackground(new Color(71, 86, 122));
			btnPlus_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnPlus_1.setFocusable(false);
			btnPlus_1.setBounds(385, 202, 73, 50);
			panel_2.add(btnPlus_1);
			btnPlus_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  first=Double.parseDouble(textField_2.getText()); 
				        textField_2.setText("");
				        operation="+";
				        lbl2.setText(first + " + ");
				       
				}
			});
			
			final JButton btn7_1 = new JButton("7");
			btn7_1.setForeground(new Color(252, 187, 109));
			btn7_1.setBackground(new Color(71, 86, 122));
			btn7_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn7_1.setFocusable(false);
			btn7_1.setBounds(468, 202, 73, 50);
			panel_2.add(btn7_1);
			btn7_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn7_1.getText();
					textField.setText(number);
					
				}
			});
			
			final JButton btn8_1 = new JButton("8");
			btn8_1.setForeground(new Color(252, 187, 109));
			btn8_1.setBackground(new Color(71, 86, 122));
			btn8_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn8_1.setFocusable(false);
			btn8_1.setBounds(551, 202, 73, 50);
			panel_2.add(btn8_1);
			btn8_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField.getText()+btn8_1.getText();
					textField.setText(number);
					
				}
			});
			
			
			final JButton btn9_1 = new JButton("9");
			btn9_1.setForeground(new Color(252, 187, 109));
			btn9_1.setBackground(new Color(71, 86, 122));
			btn9_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn9_1.setFocusable(false);
			btn9_1.setBounds(634, 202, 73, 50);
			panel_2.add(btn9_1);
			btn9_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn9_1.getText();
					textField_2.setText(number);
					
				}
			});
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setLayout(null);
			panel_1_2.setBounds(45, 202, 318, 93);
			panel_2.add(panel_1_2);
			
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
			textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			textField_2.setColumns(10);
			textField_2.setBounds(10, 48, 300, 45);
			panel_1_2.add(textField_2);
			
			final JLabel lbl2 = new JLabel(" ");
			lbl2.setBounds(10, 11, 298, 33);
			panel_1_2.add(lbl2);
			
			JButton btnC_1 = new JButton("C");
			btnC_1.setBackground(new Color(216, 115, 127));
			btnC_1.setForeground(new Color(71, 86, 122));
			btnC_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnC_1.setFocusable(false);
			btnC_1.setBounds(306, 324, 73, 50);
			panel_2.add(btnC_1);
			btnC_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				operation=null;
	            lbl2.setText("");
				}
			});
			
			JButton btnMulti_1 = new JButton("x");
			btnMulti_1.setForeground(new Color(252, 187, 109));
			btnMulti_1.setBackground(new Color(71, 86, 122));
			btnMulti_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnMulti_1.setFocusable(false);
			btnMulti_1.setBounds(385, 324, 73, 50);
			panel_2.add(btnMulti_1);
			btnMulti_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="*";
					lbl2.setText(first + " * ");
				}
			});
			
			JButton btnDiv_1 = new JButton("÷");
			btnDiv_1.setForeground(new Color(252, 187, 109));
			btnDiv_1.setBackground(new Color(71, 86, 122));
			btnDiv_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDiv_1.setFocusable(false);
			btnDiv_1.setBounds(385, 263, 73, 50);
			panel_2.add(btnDiv_1);
			btnDiv_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="/";
					lbl2.setText(first + " /");
				}});
			
			final JButton btn4_1 = new JButton("4");
			btn4_1.setForeground(new Color(252, 187, 109));
			btn4_1.setBackground(new Color(71, 86, 122));
			btn4_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn4_1.setFocusable(false);
			btn4_1.setBounds(468, 263, 73, 50);
			panel_2.add(btn4_1);
			btn4_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn4_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btn5_1 = new JButton("5");
			btn5_1.setForeground(new Color(252, 187, 109));
			btn5_1.setBackground(new Color(71, 86, 122));
			btn5_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn5_1.setFocusable(false);
			btn5_1.setBounds(551, 263, 73, 50);
			panel_2.add(btn5_1);
			btn5_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn5_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btn6_1 = new JButton("6");
			btn6_1.setForeground(new Color(252, 187, 109));
			btn6_1.setBackground(new Color(71, 86, 122));
			btn6_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn6_1.setFocusable(false);
			btn6_1.setBounds(634, 263, 73, 50);
			panel_2.add(btn6_1);
			btn6_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn6_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btn3_1 = new JButton("3");
			btn3_1.setForeground(new Color(252, 187, 109));
			btn3_1.setBackground(new Color(71, 86, 122));
			btn3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn3_1.setFocusable(false);
			btn3_1.setBounds(634, 324, 73, 50);
			panel_2.add(btn3_1);
			btn3_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn3_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btn2_1 = new JButton("2");
			btn2_1.setForeground(new Color(252, 187, 109));
			btn2_1.setBackground(new Color(71, 86, 122));
			btn2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn2_1.setFocusable(false);
			btn2_1.setBounds(551, 324, 73, 50);
			panel_2.add(btn2_1);
			btn2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn2_1.getText();
					textField_2.setText(number);
				}});
			
			
			final JButton btn1_1 = new JButton("1");
			btn1_1.setForeground(new Color(252, 187, 109));
			btn1_1.setBackground(new Color(71, 86, 122));
			btn1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn1_1.setFocusable(false);
			btn1_1.setBounds(468, 324, 73, 50);
			panel_2.add(btn1_1);
			btn1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn1_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btn0_1 = new JButton("0");
			btn0_1.setForeground(new Color(252, 187, 109));
			btn0_1.setBackground(new Color(71, 86, 122));
			btn0_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btn0_1.setFocusable(false);
			btn0_1.setBounds(468, 385, 73, 50);
			panel_2.add(btn0_1);
			btn0_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String number=textField_2.getText()+btn0_1.getText();
					textField_2.setText(number);
				}
			});
			
			final JButton btnDot_1 = new JButton(".");
			btnDot_1.setForeground(new Color(252, 187, 109));
			btnDot_1.setBackground(new Color(71, 86, 122));
			btnDot_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDot_1.setFocusable(false);
			btnDot_1.setBounds(551, 385, 73, 50);
			panel_2.add(btnDot_1);
			btnDot_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						String number=textField_2.getText()+btnDot_1.getText();
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
			
			JButton btnDash_1 = new JButton("-");
			btnDash_1.setForeground(new Color(252, 187, 109));
			btnDash_1.setBackground(new Color(71, 86, 122));
			btnDash_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDash_1.setBounds(0, 34, 73, -34);
			btnDash_1.setFocusable(false);
			btnDash_1.setBounds(385, 385, 73, 50);
			panel_2.add(btnDash_1);
			btnDash_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					first=Double.parseDouble(textField_2.getText()); 
					textField_2.setText("");
					operation="-";
					lbl2.setText(first + " - ");
					
					
				}
			});
			
			
			JButton btnDEL_1 = new JButton("DEL");
			btnDEL_1.setBackground(new Color(216, 115, 127));
			btnDEL_1.setForeground(new Color(71, 86, 122));
			btnDEL_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDEL_1.setFocusable(false);
			btnDEL_1.setBounds(306, 385, 73, 50);
			panel_2.add(btnDEL_1);
			
			JButton btnSave_1 = new JButton("Save");
			btnSave_1.setBounds(616, 460, 91, 38);
			panel_2.add(btnSave_1);
			btnSave_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnSave_1.setFocusable(false);
			
			JButton btnCancel_1 = new JButton("Cancel");
			btnCancel_1.setBounds(514, 460, 91, 38);
			panel_2.add(btnCancel_1);
			btnCancel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnCancel_1.setFocusable(false);
			
			JButton btnDate_1 = new JButton("*date");
			btnDate_1.setForeground(new Color(252, 187, 109));
			btnDate_1.setFocusable(false);
			btnDate_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnDate_1.setBackground(new Color(71, 86, 122));
			btnDate_1.setBounds(45, 324, 251, 50);
			panel_2.add(btnDate_1);
			
			JButton btnTime_1 = new JButton("*time");
			btnTime_1.setForeground(new Color(252, 187, 109));
			btnTime_1.setFocusable(false);
			btnTime_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			btnTime_1.setBackground(new Color(71, 86, 122));
			btnTime_1.setBounds(45, 387, 251, 48);
			panel_2.add(btnTime_1);
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
		
				


