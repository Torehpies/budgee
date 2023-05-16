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
import java.awt.Window;

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
	private JPanel registerFrame;
	private JTextField fname;
	private JTextField lname;
	private JTextField contactInfo;
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
	      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
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
		registerFrame = new JPanel();
		registerFrame.setBackground(new Color(69, 92, 123));
		registerFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(registerFrame);
		registerFrame.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(224, 72, -119, 166);
		registerFrame.add(panel);
		
		JLabel createAccoount = new JLabel("Create Account");
		createAccoount.setBounds(10, 11, 292, 60);
		createAccoount.setForeground(new Color(252, 187, 109));
		createAccoount.setFont(new Font("Quicksand Light", Font.BOLD, 33));
		registerFrame.add(createAccoount);
		
		JLabel firstNameL = new JLabel("Firstname");
		firstNameL.setBounds(32, 60, 138, 36);
		firstNameL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		registerFrame.add(firstNameL);
		
		fname = new JTextField();
		fname.setForeground(new Color(252, 187, 109));
		fname.setBounds(32, 93, 270, 43);
		fname.setBackground(new Color(66, 83, 109));
		fname.setMargin(new Insets(10, 10, 10, 10));
		registerFrame.add(fname);
		fname.setColumns(10);
		
		JLabel lastNameL = new JLabel("Last Name");
		lastNameL.setBounds(32, 130, 138, 36);
		lastNameL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		registerFrame.add(lastNameL);
		
		lname = new JTextField();
		lname.setForeground(new Color(252, 187, 109));
		lname.setBounds(31, 161, 270, 43);
		lname.setBackground(new Color(66, 83, 109));
		lname.setColumns(10);
		lname.setMargin(new Insets(10, 10, 10, 10));
		registerFrame.add(lname);
		
		JLabel contactInfoL = new JLabel("Contact or email");
		contactInfoL.setBounds(31, 196, 241, 36);
		contactInfoL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		registerFrame.add(contactInfoL);
		
		contactInfo = new JTextField();
		contactInfo.setForeground(new Color(252, 187, 109));
		contactInfo.setBounds(32, 229, 270, 43);
		contactInfo.setBackground(new Color(66, 83, 109));
		contactInfo.setColumns(10);
		contactInfo.setMargin(new Insets(10, 10, 10, 10));
		registerFrame.add(contactInfo);
		
		username = new JTextField();
		username.setForeground(new Color(252, 187, 109));
		username.setBounds(32, 298, 270, 43);
		username.setBackground(new Color(66, 83, 109));
		username.setColumns(10);
		username.setMargin(new Insets(10, 10, 10, 10));
		registerFrame.add(username);
		
		JLabel username1 = new JLabel("Username");
		username1.setBounds(31, 264, 138, 36);
		username1.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		registerFrame.add(username1);
		
		JLabel passwordL = new JLabel("Password");
		passwordL.setBounds(31, 332, 138, 36);
		passwordL.setFont(new Font("Quicksand Light", Font.BOLD, 17));
		registerFrame.add(passwordL);
		
//		JLabel budgeeLogo = new JLabel("");
//		budgeeLogo.setBounds(353, -12, 166, 238);
//		Image img = new ImageIcon(this.getClass().getResource("/budgeeLogo1.png")).getImage();
//		budgeeLogo.setIcon(new ImageIcon(img));
//		registerFrame.add(budgeeLogo);
		
		final JButton register = new JButton("Create Account");
		register.setBounds(31, 419, 270, 36);
		register.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String first_name = fname.getText();
				String last_name = lname.getText();
				String contacts = contactInfo.getText();
				String userName = username.getText();
				String passWord = new String (password.getText());
				
				try {
					
				pst = con.prepareStatement("INSERT INTO budgee_accounts.accounts1(first_name, last_name, contact, username, password) VALUE(?,?,?,?,?)");
				pst.setString(1, first_name);
				pst.setString(2, last_name);
				pst.setString(3, contacts);
				pst.setString(4, userName);
				pst.setString(5, passWord);
				
				if (first_name.isEmpty() || last_name.isEmpty() || contacts.isEmpty() || userName.isEmpty() || passWord.isEmpty()) {
				    JOptionPane.showMessageDialog(register, "Please fill in all the required fields.");
				    return;
				}
				
				int rs=pst.executeUpdate();
				
				if (rs==1) {
				    JOptionPane.showMessageDialog(register, "You Have Successfully Registered");
				    fname.setText("");
				    lname.setText("");
				    contactInfo.setText("");
				    username.setText("");
				    password.setText("");
				    dispose();
				} else {
				    JOptionPane.showMessageDialog(register, "You Failed Now Flee");
				    dispose();
				}

					
				} catch(SQLException ex) {
					Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				try {
			         // Connect to the database
			         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
			         // Create a prepared statement to retrieve the latest primary key ID
			         PreparedStatement pst = con.prepareStatement("SELECT MAX(id) FROM budgee_accounts.accounts1");
			         
			         // Execute the prepared statement and retrieve the result set
			         ResultSet rs = pst.executeQuery();
			         
			         // Check if the result set contains any rows
			         if (rs.next()) {
			            // Retrieve the latest primary key ID from the result set
			            int id = rs.getInt(1);
			            
			            // Print out the latest primary key ID
			            System.out.println("The latest primary key ID is: " + id);
			            
			            String tableName = "user_" + id; // Get the table name from the text field
			            
				            String sql = "CREATE TABLE budgee_accounts." + tableName + " (\r\n"
				                    + "  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
				                    + "  date DATE NOT NULL,\r\n"
				                    + "  time TIME NOT NULL,\r\n"
				                    + "  balance_update DECIMAL(12,2) NOT NULL,\r\n"
				                    + "  notes TEXT NOT NULL,\r\n"
				                    + "  action ENUM('income','expense'),\r\n"
				                    + "  category VARCHAR(45) ,\r\n"
				                    + "  account ENUM('savings','cash'),\r\n"
				                    + " cash_value DECIMAL(12,2) NOT NULL, \r\n"
				                    + " savings_value DECIMAL(12,2) NOT NULL);";

			            try {
			                PreparedStatement pst1 = con.prepareStatement(sql);
			                pst1.executeUpdate();
			            } catch (SQLException e2) {
			                System.out.println("Error creating table: " + e2.getMessage());
			            }
			            
			         } else {
			            System.out.println("No rows found in the result set.");
			         }
			         
			         // Close the result set, prepared statement, and connection
			         rs.close();
			         pst.close();
			         con.close();
			      } catch (SQLException e2) {
			         System.out.println("SQLException: " + e2.getMessage());
			         System.out.println("SQLState: " + e2.getSQLState());
			         System.out.println("VendorError: " + e2.getErrorCode());
			      }
				
				
				
			}
		});
		register.setForeground(new Color(252, 187, 109));
		register.setBackground(new Color(66, 83, 109));
		register.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		registerFrame.add(register);
		
		password = new JPasswordField();
		password.setForeground(new Color(252, 187, 109));
		password.setBounds(31, 361, 270, 43);
		password.setBackground(new Color(66, 83, 109));
		password.setMargin(new Insets(10, 10, 10, 10));
		registerFrame.add(password);
		
	}
}