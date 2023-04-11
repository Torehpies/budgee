import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class welcum {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("holabels");
	
	welcum(String userID){
		
		welcomeLabel.setBounds(250, 250, 250, 25);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Holabels "+ userID);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(welcomeLabel);
	}
	
}
