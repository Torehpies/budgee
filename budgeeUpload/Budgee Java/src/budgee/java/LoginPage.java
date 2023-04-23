package budgee.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	JFrame frame = new JFrame();// gwa ng frame
	JButton loginButton = new JButton("login");// gwa ng login button
	JButton resetButton = new JButton("reset");//gwa ng reset button para mabura credentials
	JTextField userIDField = new JTextField();// gwa textbox for userID
	JPasswordField userPasswordField = new JPasswordField();// gwa textbox for pass
	JLabel userIDLabel = new JLabel("userID");// gwa ng userID na laberl naul may label
	JLabel userPasswordLabel = new JLabel("password");// same concept
	JLabel messageLabel = new JLabel();// gawa ng label na nagsasabi kung tama yung credentials
	HashMap<String,String> logininfo = new HashMap<String,String>();// call out ng hashmap para ma gets yung tamang credentials
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);//x,y,width,height //position 69
		userPasswordLabel.setBounds(50,150,75,25);//basta pag set bounds pang position sya ng elements
		
		messageLabel.setBounds(125, 250, 500, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,30));
		
		userIDField.setBounds(125, 100, 200, 35);
		userPasswordField.setBounds(125, 150, 200, 35);

		loginButton.setBounds(125, 200, 100, 30);
		loginButton.setFocusable(false);//yung focusable para mawala yung highlight sa text
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 30);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);// para ma add yung IDLabel sa frame...
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para ma exit yung program pag clinose
		frame.setSize(420,420);// size ng frame pag pop up
		frame.setLayout(null);
		frame.setVisible(true);// para makita yung frame
		frame.getContentPane().setBackground(new Color(0x475C7A));// pamalit ng bg color ng frame
		
		
	}

	public void actionPerformed(ActionEvent e) {//conditions 
		
		if(e.getSource()==resetButton) {//pag pinindot yung reset button mawawala yung mga nilagay na text
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {//yung log in eme
			
			String userID = userIDField.getText();//declaration nanaman
			String password = String.valueOf(userPasswordField.getPassword());//get Value of credentials
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)){//kapag tama yung user ID at pass login edi tama kapatid walaa tayong magagawa
					messageLabel.setForeground(Color.CYAN);
					messageLabel.setText("login succesful");
					frame.dispose();//para mawala yung loginpage na tab pag na met yung conditions
					welcome welcomePage = new welcome(userID);// kapag tama both mapupunta sa welcome page (welcum.java)
			}
			
			else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("mali mo kapatid");//kapag mali yung pass
			}
			
		}
		else {
			messageLabel.setForeground(Color.RED);
			messageLabel.setText("username di mahanap");//pag mali yung username
		}
		
	} 
	
}
}