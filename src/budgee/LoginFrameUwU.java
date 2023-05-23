package budgee;

import budgee.UserSession;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFrameUwU {

	JFrame frmLoginBudgee;
	private JTextField user;
	private JLabel budgeeLogo;
	private JLabel budgeeLabel;
	private JButton resetBTN;
	private JButton newAccBTN;
	private JPasswordField pass;

	private String tableID;
	
	


	public String sessionId;


	public LoginFrameUwU() {
		initialize();		
		setIcon();
	}
	 private void setIcon() {
	        ImageIcon icon = new ImageIcon("imgs/budgeeLogoMain.png");
	        frmLoginBudgee.setIconImage(icon.getImage());
	    }
	

	public String getTableID(int sessionId) {
        return "user_" + sessionId;
    }
	

	private void initialize() {
		
		frmLoginBudgee = new JFrame();
		frmLoginBudgee.setResizable(false);
		frmLoginBudgee.setTitle("Login Budgee");
		frmLoginBudgee.getContentPane().setBackground(new Color(69, 92, 123));
		frmLoginBudgee.getContentPane().setLayout(null);
		
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setForeground(new Color(252, 187, 109, 50));
		usernameLabel.setFont(new Font("Quicksand Bold", Font.BOLD, 22));
		usernameLabel.setBounds(232, 294, 130, 40);
		frmLoginBudgee.getContentPane().add(usernameLabel);
		
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setForeground(new Color(252, 187, 109, 50));
		passwordLabel.setFont(new Font("Quicksand Bold", Font.BOLD, 22));
		passwordLabel.setBounds(232, 341, 130, 36);
		frmLoginBudgee.getContentPane().add(passwordLabel);
		
		
		user = new JTextField();
		user.setBackground(new Color(66, 83, 109));
		user.setForeground(Color.WHITE);
		user.setColumns(10);
		user.setBounds(211, 294, 307, 40);
		user.setMargin(new Insets(10, 10, 10, 10));
		frmLoginBudgee.getContentPane().add(user);
		
		
		budgeeLogo = new JLabel("");
		ImageIcon logo = new ImageIcon("imgs/budgeeLogo1.png");
		budgeeLogo.setIcon(logo);
		budgeeLogo.setBounds(210, 81, 236, 191);
		frmLoginBudgee.getContentPane().add(budgeeLogo);
		
		
		budgeeLabel = new JLabel("budgee");
		budgeeLabel.setForeground(new Color(252, 187, 109));
		budgeeLabel.setFont(new Font("Quicksand Bold", Font.BOLD, 21));
		budgeeLabel.setBounds(21, 463, 111, 32);
		frmLoginBudgee.getContentPane().add(budgeeLabel);
		
		
		JButton loginBTN = new JButton("login");
		loginBTN.setForeground(new Color(252, 187, 109));
		loginBTN.setFont(new Font("Segoe UI", Font.BOLD, 12));
		loginBTN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");

		            String loginQuery = "SELECT * FROM budgee_accounts.accounts1 WHERE username=? AND password=?";
		            PreparedStatement statement = connection.prepareStatement(loginQuery);
		            statement.setString(1, user.getText());
		            statement.setString(2, pass.getText());
		            ResultSet resultLoginQuery = statement.executeQuery();

		            if (resultLoginQuery.next()) {
		                int sessionId = resultLoginQuery.getInt("ID");
		                String sessionUsername = resultLoginQuery.getString("username");

		                // Setting session variables
		                UserSession session = UserSession.getInstance();
		                session.setId(sessionId);
		                session.setUsername(sessionUsername);

		                mainmain main = new mainmain();
		                main.setVisible(true);
		                frmLoginBudgee.dispose();
		                JOptionPane.showMessageDialog(null, "Login Successfully...");
		            } else {
		                JOptionPane.showMessageDialog(null, "Login Denied...");
		            }

		            resultLoginQuery.close();
		            statement.close();
		            connection.close();
		        } catch (Exception e1) {
		            JOptionPane.showMessageDialog(null, "An error occurred during login: " + e1.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		loginBTN.setBounds(270, 396, 89, 23);
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
		resetBTN.setBounds(373, 397, 89, 23);
		resetBTN.setFocusable(false);
		frmLoginBudgee.getContentPane().add(resetBTN);
		
		
		newAccBTN = new JButton("Create new account");
		newAccBTN.setForeground(new Color(252, 187, 109));
		newAccBTN.setBackground(new Color(66, 83, 109));
		newAccBTN.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		newAccBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAccount newAcc = new NewAccount();
				newAcc.setVisible(true);
				frmLoginBudgee.dispose();
			}
		});
		newAccBTN.setBounds(270, 430, 192, 23);
		newAccBTN.setFocusable(false);
		frmLoginBudgee.getContentPane().add(newAccBTN);
		
		pass = new JPasswordField();
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            loginBTN.doClick();
		        }
			}
		});
		pass.setForeground(new Color(252, 187, 109));
		pass.setBackground(new Color(66, 83, 109));
		pass.setBounds(211, 341, 307, 37);
		pass.setMargin(new Insets(10, 10, 10, 10));
		frmLoginBudgee.getContentPane().add(pass);
		frmLoginBudgee.setBounds(100, 100, 756, 547);
		frmLoginBudgee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginBudgee.setLocationRelativeTo(null);
	}


	public void closeFrame() {
	    frmLoginBudgee.dispose();
	}
}
