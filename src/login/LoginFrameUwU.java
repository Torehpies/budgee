package login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

public class LoginFrameUwU {

	private JFrame frmLoginBudgee;
	private JTextField user;
	private JLabel budgeeLogo;
	private JLabel budgeeLabel;
	private JButton resetBTN;
	private JButton newAccBTN;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrameUwU window = new LoginFrameUwU();
					window.frmLoginBudgee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrameUwU() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLoginBudgee = new JFrame();
		frmLoginBudgee.setResizable(false);
		frmLoginBudgee.setTitle("Login Budgee");
		frmLoginBudgee.getContentPane().setBackground(new Color(69, 92, 123));
		frmLoginBudgee.getContentPane().setLayout(null);
		
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setForeground(new Color(252, 187, 109, 50));
		usernameLabel.setFont(new Font("Quicksand Light", Font.BOLD, 22));
		usernameLabel.setBounds(252, 295, 130, 40);
		frmLoginBudgee.getContentPane().add(usernameLabel);
		
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setForeground(new Color(252, 187, 109, 50));
		passwordLabel.setFont(new Font("Quicksand Light", Font.BOLD, 22));
		passwordLabel.setBounds(252, 342, 130, 36);
		frmLoginBudgee.getContentPane().add(passwordLabel);
		
		
		user = new JTextField();
		user.setBackground(new Color(66, 83, 109));
		user.setForeground(Color.WHITE);
		user.setColumns(10);
		user.setBounds(231, 295, 307, 40);
		user.setMargin(new Insets(10, 10, 10, 10));
		frmLoginBudgee.getContentPane().add(user);
		
		
		budgeeLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/budgeeLogo1.png")).getImage();
		budgeeLogo.setIcon(new ImageIcon(img));
		budgeeLogo.setBounds(302, -15, 180, 261);
		frmLoginBudgee.getContentPane().add(budgeeLogo);
		
		
		budgeeLabel = new JLabel("budgee");
		budgeeLabel.setForeground(new Color(252, 187, 109));
		budgeeLabel.setFont(new Font("Quicksand Light", Font.BOLD, 21));
		budgeeLabel.setBounds(21, 463, 111, 32);
		frmLoginBudgee.getContentPane().add(budgeeLabel);
		
		
		JButton loginBTN = new JButton("login");
		loginBTN.setForeground(new Color(252, 187, 109));
		loginBTN.setFont(new Font("Segoe UI", Font.BOLD, 12));
		loginBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","markypogi319");
					Statement stmt=con.createStatement();
					
					String sql="SELECT * FROM budgee_accounts.accounts1 where username='"+user.getText()+"' and password='"+pass.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next()) 
					JOptionPane.showMessageDialog(null,"Login Sucessfully... ");
				
					else
						JOptionPane.showMessageDialog(null,"Login Denied... ");
					con.close();
				}catch(Exception e1) {System.out.print(e1);}
			}
		});
		loginBTN.setBounds(290, 397, 89, 23);
		loginBTN.setFocusable(false);
		loginBTN.setBackground(new Color(66, 83, 109));
		frmLoginBudgee.getContentPane().add(loginBTN);
		
		
		resetBTN = new JButton("reset");
		resetBTN.setBackground(new Color(66, 83, 109));
		resetBTN.setForeground(new Color(252, 187, 109));
		resetBTN.setFont(new Font("Segoe UI Historic", Font.BOLD, 12));
		resetBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setText("");
				pass.setText("");
			}
		});
		resetBTN.setBounds(393, 398, 89, 23);
		resetBTN.setFocusable(false);
		frmLoginBudgee.getContentPane().add(resetBTN);
		
		
		newAccBTN = new JButton("Create new account");
		newAccBTN.setForeground(new Color(252, 187, 109));
		newAccBTN.setBackground(new Color(66, 83, 109));
		newAccBTN.setFont(new Font("Quicksand Light", Font.BOLD, 13));
		newAccBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAccount newAcc = new NewAccount();
				newAcc.setVisible(true);
				
			}
		});
		newAccBTN.setBounds(290, 431, 192, 23);
		newAccBTN.setFocusable(false);
		frmLoginBudgee.getContentPane().add(newAccBTN);
		
		pass = new JPasswordField();
		pass.setForeground(new Color(252, 187, 109));
		pass.setBackground(new Color(66, 83, 109));
		pass.setBounds(231, 342, 307, 37);
		pass.setMargin(new Insets(10, 10, 10, 10));
		frmLoginBudgee.getContentPane().add(pass);
		frmLoginBudgee.setBounds(100, 100, 756, 547);
		frmLoginBudgee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginBudgee.setLocationRelativeTo(null);
	}
}
