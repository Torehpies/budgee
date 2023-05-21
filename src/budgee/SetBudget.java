package budgee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetBudget extends JFrame {

	private JPanel contentPane;
	private JTextField SetLimit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetBudget frame = new SetBudget();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SetBudget() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 83, 109));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Budget");
		lblNewLabel.setForeground(new Color(252, 187, 129));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(124, 11, 173, 48);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66, 83, 109));
		panel.setBounds(52, 70, 332, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(new Color(252, 197, 129), 3);

        // Set the border for the panel
        panel.setBorder(border);
		
		JLabel lblNewLabel_1 = new JLabel("Baby");
		lblNewLabel_1.setForeground(new Color(252, 187, 129));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 28, 312, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setForeground(new Color(85, 111, 146));
		lblNewLabel_2.setBackground(new Color(85, 111, 146));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(125, 11, 69, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Limit");
		lblNewLabel_3.setForeground(new Color(252, 187, 129));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(52, 204, 60, 31);
		contentPane.add(lblNewLabel_3);
		
		SetLimit = new JTextField();
		SetLimit.setFont(new Font("Tahoma", Font.BOLD, 15));
		SetLimit.setForeground(new Color(252, 187, 129));
		SetLimit.setBackground(new Color(66, 83, 109));
		SetLimit.setBounds(115, 198, 269, 48);
		contentPane.add(SetLimit);
		SetLimit.setColumns(10);
		
		SetLimit.setBorder(border);
		
		JLabel lblNewLabel_4 = new JLabel("Month:");
		lblNewLabel_4.setBackground(new Color(85, 111, 146));
		lblNewLabel_4.setForeground(new Color(85, 111, 146));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(115, 268, 71, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("May, 2023");
		lblNewLabel_4_1.setBackground(new Color(85, 111, 146));
		lblNewLabel_4_1.setForeground(new Color(85, 111, 146));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(196, 268, 113, 31);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setForeground(new Color(252, 187, 129));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBackground(new Color(66, 83, 109));
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCancel.setBounds(85, 310, 130, 40);
		contentPane.add(btnCancel);
		
		JButton button_1 = new JButton("New button");
		button_1.setForeground(new Color(252, 187, 129));
		button_1.setBackground(new Color(66, 83, 109));
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button_1.setBounds(225, 310, 130, 40);
		contentPane.add(button_1);
	}
}
