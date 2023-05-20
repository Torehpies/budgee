package budgee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import budgee.DatabaseManager;
//import javafx.scene.layout.Border;

public class MainFrameUtils {
	
	private JScrollPane parentPanel;
	/**
	 * @wbp.parser.entryPoint
	 */
	static JPanel createRecordPanel(Record record, JScrollPane parentPanel) {
	
		JPanel recordPanel = new JPanel();
		recordPanel.setBackground(new Color(68, 83, 109));
		recordPanel.setBounds(10, 26, 613, 101);
		recordPanel.setLayout(null);
		
		JLabel lblGet_Categ = new JLabel(record.getCategory());
		lblGet_Categ.setBounds(301, 0, 55, 21);
		lblGet_Categ.setForeground(new Color(252, 187, 109));
		lblGet_Categ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGet_Categ.setBackground(Color.WHITE);
		recordPanel.add(lblGet_Categ);
		
		JLabel lbl_Categ = new JLabel("Category:");
		lbl_Categ.setForeground(new Color(216, 115, 127));
		lbl_Categ.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Categ.setBackground(Color.WHITE);
		lbl_Categ.setBounds(218, 0, 81, 19);
		recordPanel.add(lbl_Categ);
		
		JLabel Acc_Exp_lbl = new JLabel("Expense:");
		Acc_Exp_lbl.setForeground(new Color(216, 115, 127));
		Acc_Exp_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		Acc_Exp_lbl.setBackground(Color.WHITE);
		Acc_Exp_lbl.setBounds(320, 82, 70, 19);
		recordPanel.add(Acc_Exp_lbl);
		
		JLabel lbl_Notes = new JLabel(record.getNotes());
		lbl_Notes.setVerticalAlignment(SwingConstants.TOP);
		lbl_Notes.setForeground(new Color(85, 111, 146));
		lbl_Notes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Notes.setBackground(Color.WHITE);
		lbl_Notes.setBounds(84, 20, 420, 59);
		recordPanel.add(lbl_Notes);
		
		JButton btn_Del = new JButton("Delete");
		btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = DatabaseManager.getConnection();
				BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
				BudgeeDAOImpl.deleteRecord(record.getId());
				MainFrameUtils mainFrameUtils = new MainFrameUtils();
				mainFrameUtils.refreshRecords(parentPanel);
				
			}
		});
		btn_Del.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Del.setForeground(new Color(216, 115, 127));
		btn_Del.setBackground(new Color(68, 83, 109));
		btn_Del.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Del.setBounds(514, 48, 89, 36);
		recordPanel.add(btn_Del);
		
		JLabel lbl_Value = new JLabel("₱" + (record.getBalance_update()).toString());
		lbl_Value.setForeground(new Color(252, 187, 109));
		lbl_Value.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Value.setBackground(Color.WHITE);
		lbl_Value.setBounds(401, 82, 113, 19);
		recordPanel.add(lbl_Value);
		
		JButton btn_Edit = new JButton("Edit");
		btn_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Edit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn_Edit.setForeground(new Color(252, 187, 109));
		btn_Edit.setBackground(new Color(68, 83, 109));
		btn_Edit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Edit.setBounds(514, 11, 89, 36);
		recordPanel.add(btn_Edit);
		
		JLabel lblGet_Acc = new JLabel(record.getAccount());
		lblGet_Acc.setForeground(new Color(252, 187, 109));
		lblGet_Acc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGet_Acc.setBackground(Color.WHITE);
		lblGet_Acc.setBounds(93, 0, 43, 21);
		recordPanel.add(lblGet_Acc);
		
		JLabel lbl_Acc = new JLabel("Account:");
		lbl_Acc.setForeground(new Color(216, 115, 127));
		lbl_Acc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Acc.setBackground(Color.WHITE);
		lbl_Acc.setBounds(10, 0, 81, 19);
		recordPanel.add(lbl_Acc);
		
		JLabel lbl_Date = new JLabel((record.getDate()).toString());
		lbl_Date.setForeground(new Color(252, 187, 109));
		lbl_Date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Date.setBackground(Color.WHITE);
		lbl_Date.setBounds(10, 82, 90, 19);
		recordPanel.add(lbl_Date);
		
		JLabel lbl_Time = new JLabel((record.getTime()).toString());
		lbl_Time.setForeground(new Color(252, 187, 109));
		lbl_Time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Time.setBackground(Color.WHITE);
		lbl_Time.setBounds(100, 82, 70, 19);
		recordPanel.add(lbl_Time);
		
		return recordPanel;
	}
	
	public static void displayAllRecords(List<Record> records, JScrollPane parentPanel) {		
		JPanel containerPanel = new JPanel();
	    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
	    javax.swing.border.Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);  
	    EmptyBorder emptyBorder = new EmptyBorder(0, 0, 5, 0);  
	    CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);  
	    
	    
		for (Record record : records) {
			JPanel recordPanel = createRecordPanel(record, parentPanel);
			recordPanel.setPreferredSize(new Dimension(50,100));
			recordPanel.setBorder(compoundBorder);  	
			containerPanel.add(recordPanel);
		}
		
		parentPanel.setViewportView(containerPanel);
		parentPanel.revalidate();
		parentPanel.repaint();
	}
	
	public static void refreshRecords(JScrollPane parentPanel) {
		Connection connection = DatabaseManager.getConnection();
		
		BudgeeDAOImpl BudgeeDAOImpl = new BudgeeDAOImpl(connection);
		List<Record> records = BudgeeDAOImpl.getAllRecords();
	    displayAllRecords(records, parentPanel);
	}

}
