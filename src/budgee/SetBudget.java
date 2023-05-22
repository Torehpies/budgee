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

	private JPanel SetBudgetPanel;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 415);
		SetBudgetPanel = new JPanel();
		SetBudgetPanel.setBackground(new Color(66, 83, 109));
		SetBudgetPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(SetBudgetPanel);
		SetBudgetPanel.setLayout(null);
		
		JLabel lblSetBudget = new JLabel("Set Budget");
		lblSetBudget.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetBudget.setForeground(new Color(252, 187, 129));
		lblSetBudget.setFont(new Font("Quicksand Light", Font.BOLD, 30));
		lblSetBudget.setBounds(130, 11, 173, 48);
		SetBudgetPanel.add(lblSetBudget);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66, 83, 109));
		panel.setBounds(50, 70, 332, 101);
		SetBudgetPanel.add(panel);
		panel.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(new Color(252, 197, 129), 3);

        // Set the border for the panel
        panel.setBorder(border);
		
		JLabel SetCateg = new JLabel("BILLS");
		SetCateg.setForeground(new Color(252, 187, 129));
		SetCateg.setHorizontalAlignment(SwingConstants.CENTER);
		SetCateg.setFont(new Font("Quicksand Light", Font.BOLD, 35));
		SetCateg.setBounds(10, 35, 312, 43);
		panel.add(SetCateg);
		
		JLabel lblCateg = new JLabel("Category");
		lblCateg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCateg.setForeground(new Color(85, 111, 146));
		lblCateg.setBackground(new Color(85, 111, 146));
		lblCateg.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		lblCateg.setBounds(130, 11, 69, 19);
		panel.add(lblCateg);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setForeground(new Color(252, 187, 129));
		lblLimit.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblLimit.setBounds(52, 204, 60, 31);
		SetBudgetPanel.add(lblLimit);
		
		SetLimit = new JTextField();
		SetLimit.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		SetLimit.setForeground(new Color(252, 187, 129));
		SetLimit.setBackground(new Color(66, 83, 109));
		SetLimit.setBounds(115, 198, 269, 48);
		SetBudgetPanel.add(SetLimit);
		SetLimit.setColumns(10);
		
		SetLimit.setBorder(border);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBackground(new Color(85, 111, 146));
		lblMonth.setForeground(new Color(85, 111, 146));
		lblMonth.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblMonth.setBounds(115, 268, 71, 31);
		SetBudgetPanel.add(lblMonth);
		
		JLabel SetMonth = new JLabel("May, 2023");
		SetMonth.setHorizontalAlignment(SwingConstants.CENTER);
		SetMonth.setBackground(new Color(85, 111, 146));
		SetMonth.setForeground(new Color(85, 111, 146));
		SetMonth.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		SetMonth.setBounds(196, 268, 113, 31);
		SetBudgetPanel.add(SetMonth);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setForeground(new Color(252, 187, 129));
		btnCancel.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		btnCancel.setBackground(new Color(66, 83, 109));
		btnCancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCancel.setBounds(85, 310, 130, 40);
		SetBudgetPanel.add(btnCancel);
		
		JButton btnCancel_1 = new JButton("Set");
		btnCancel_1.setFont(new Font("Quicksand Light", Font.BOLD, 15));
		btnCancel_1.setForeground(new Color(252, 187, 129));
		btnCancel_1.setBackground(new Color(66, 83, 109));
		btnCancel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCancel_1.setBounds(225, 310, 130, 40);
		SetBudgetPanel.add(btnCancel_1);
	}
}
