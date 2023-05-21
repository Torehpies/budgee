package budgee;

import java.io.File;
import java.sql.*;

import javax.swing.ImageIcon;


public class ImageUpload {
	


File f = null;
String path = null;
private ImageIcon format = null;
String fname = null;
int s = 0;
byte[] pimage = null;

PreparedStatement pst;
ResultSet rs;

public ImageUpload() {
	connect();
}
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/budgee_accounts", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



