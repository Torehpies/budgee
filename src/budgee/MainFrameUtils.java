package budgee;

import budgee.BudgeeDAOImpl;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainFrameUtils {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	JPanel createRecordPanel(Record record) {
		
		JPanel recordPanel = new JPanel();
		recordPanel.setBackground(new Color(1, 1, 1));
		recordPanel.setLayout(null);
		recordPanel.setVisible(true);
			
		JLabel categoryLabel = new JLabel(record.getCategory());
		categoryLabel.setForeground(new Color(255, 255, 255));
		categoryLabel.setBounds(10, 11, 148, 37);
		recordPanel.add(categoryLabel);
		
		JLabel amountLabel = new JLabel((record.getBalance_update()).toString());
		amountLabel.setForeground(new Color(255, 255, 255));
		amountLabel.setBounds(10, 67, 114, 37);
		recordPanel.add(amountLabel);
		
		return recordPanel;
	}
	
	public void displayAllRecords(List<Record> records, JPanel parentPanel) {		
		parentPanel.removeAll();
		
		for (Record record : records) {
			JPanel recordPanel = createRecordPanel(record);
			parentPanel.add(recordPanel);
		}
		
		parentPanel.revalidate();
		parentPanel.repaint();
		System.out.println("revalidating..");
	}
}
