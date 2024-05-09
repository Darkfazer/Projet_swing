package firstApp;

import java.sql.SQLException;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controllers.VerifyLogin;

public class Accueill {
	
	public void Acceuil(String user) throws SQLException {
		new Views.Acceuil(user);
	}
	
	
	

	public static void main(String[] args) throws SQLException {
	
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            try {
					new controllers.VerifyLogin();
					VerifyLogin.main(args);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            	
	            }
	        });

	}

	

}
 