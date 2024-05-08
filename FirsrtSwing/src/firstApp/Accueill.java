package firstApp;

import java.sql.SQLException;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Accueill {
	public void Acceuil(String user) throws SQLException {
		new Views.Acceuil(user);
	}
	
	public void DetailProjet(int row,DefaultTableModel model) throws SQLException {
		Views.Acceuil acceuil = new controllers.VerifyLogin().getAcceuil();
		acceuil.setVisible(false);
		acceuil.dispose();
		new Views.DetailsProjet(row,model);
	}

	public static void main(String[] args) throws SQLException {
	
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            try {
					new controllers.VerifyLogin().main(args);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            	
	            }
	        });

	}

}
 