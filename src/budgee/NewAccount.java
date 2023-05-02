package budgee;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.sql.*;
public class NewAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel NewAccFrame;
	private JTextField fname;
	private JTextField lname;
	private JTextField contact;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccount frame = new NewAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPasswordField password;
	
	public void Connect() {
	try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "markypogi319");
	    } catch (ClassNotFoundException | SQLException ex) {
	      Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
	        // Handle the exception appropriately, e.g. show an error message to the user
	    }

	}
	
	/**
	 * Create the frame.
	 */
	public NewAccount() {
		
		Connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 551);
		NewAccFrame = new JPanel();
		NewAccFrame.setBackground(new Color(69, 92, 123));
		NewAccFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(NewAccFrame);
		NewAccFrame.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(224, 72, -119, 166);
		NewAccFrame.add(panel);
		
		JLabel createAccoount = new JLabel("Create Account");
		createAccoount.setBounds(10, 11, 292, 60);
		createAccoount.setForeground(new Color(252, 187, 109));
		createAccoount.setFont(new Font("Quicksand Light", Font.BOLD, 33));
		NewAccFrame.add(createAccoount);
		
		JLabel firstNameL = new JLabel("Firstname");
		firstNameL.setBounds(31, 74, 138, 36);
		firstNameL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		NewAccFrame.add(firstNameL);
		
		fname = new JTextField();
		fname.setForeground(new Color(252, 187, 109));
		fname.setBounds(32, 107, 270, 36);
		fname.setBackground(new Color(66, 83, 109));
		fname.setMargin(new Insets(10, 10, 10, 10));
		NewAccFrame.add(fname);
		fname.setColumns(10);
		
		JLabel lastNameL = new JLabel("Last Name");
		lastNameL.setBounds(31, 139, 138, 36);
		lastNameL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		NewAccFrame.add(lastNameL);
		
		lname = new JTextField();
		lname.setForeground(new Color(252, 187, 109));
		lname.setBounds(31, 168, 270, 36);
		lname.setBackground(new Color(66, 83, 109));
		lname.setColumns(10);
		lname.setMargin(new Insets(10, 10, 10, 10));
		NewAccFrame.add(lname);
		
		JLabel contactInfoL = new JLabel("Contact");
		contactInfoL.setBounds(31, 196, 138, 36);
		contactInfoL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		NewAccFrame.add(contactInfoL);
		
		contact = new JTextField();
		contact.setForeground(new Color(252, 187, 109));
		contact.setBounds(32, 229, 270, 36);
		contact.setBackground(new Color(66, 83, 109));
		contact.setColumns(10);
		contact.setMargin(new Insets(10, 10, 10, 10));
		NewAccFrame.add(contact);
		
		username = new JTextField();
		username.setForeground(new Color(252, 187, 109));
		username.setBounds(32, 298, 270, 36);
		username.setBackground(new Color(66, 83, 109));
		username.setColumns(10);
		username.setMargin(new Insets(10, 10, 10, 10));
		NewAccFrame.add(username);
		
		JLabel username1 = new JLabel("Username");
		username1.setBounds(31, 264, 138, 36);
		username1.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		NewAccFrame.add(username1);
		
		JLabel passwordL = new JLabel("Password");
		passwordL.setBounds(31, 332, 138, 36);
		passwordL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		NewAccFrame.add(passwordL);
		
//		JLabel budgeeLogo = new JLabel("");
//		budgeeLogo.setBounds(353, -12, 166, 238);
//		Image img = new ImageIcon(this.getClass().getResource("/budgeeLogo1.png")).getImage();
//		budgeeLogo.setIcon(new ImageIcon(img));
//		contentPane.add(budgeeLogo);
		
		final JButton register = new JButton("Create Account");
		register.setBounds(31, 417, 270, 36);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first_name = fname.getText();
				String last_name = lname.getText();
				String contacts = contact.getText();
				String userName = username.getText();
				String passWord = new String (password.getText());
				
				try {
				pst = con.prepareStatement("INSERT INTO budgee_accounts.accounts1(first_name, last_name, contact, username, password) VALUE(?,?,?,?,?)");
				pst.setString(1, first_name);
				pst.setString(2, last_name);
				pst.setString(3, contacts);
				pst.setString(4, userName);
				pst.setString(5, passWord);
				
				int rs=pst.executeUpdate();
				
				if (rs==1) {
					JOptionPane.showMessageDialog(register, "You Have Successfully Registered");
					fname.setText("");
					lname.setText("");
					contact.setText("");
					username.setText("");
					password.setText("");
					
					
				} else {
					JOptionPane.showMessageDialog(register, "You Failed Now Flee");
				}
			
				} catch(SQLException ex) {
					Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				
			}
		});
		register.setForeground(new Color(252, 187, 109));
		register.setBackground(new Color(66, 83, 109));
		register.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		NewAccFrame.add(register);
		
		password = new JPasswordField();
		password.setForeground(new Color(252, 187, 109));
		password.setBounds(31, 361, 270, 36);
		password.setBackground(new Color(66, 83, 109));
		password.setMargin(new Insets(10, 10, 10, 10));
		NewAccFrame.add(password);
	}
}
