/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budgee.java;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class welcome {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("holabels");
	
	welcome(String userID){
		
		welcomeLabel.setBounds(250, 250, 250, 25);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Holabels "+ userID);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366,768);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(welcomeLabel);
	}
	
}
