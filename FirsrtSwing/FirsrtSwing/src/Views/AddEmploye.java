package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddEmploye extends JFrame {
	public AddEmploye() {}
	 setTitle("Ajouter Employe");
	  setSize(800,600);
	  getContentPane().setLayout(null);
	  
	  JPanel panel = new JPanel();
	  panel.setBounds(10, 116, 764, 434);
	  getContentPane().add(panel);
	  
	  JPanel panel_1 = new JPanel();
	  panel_1.setBounds(10, 11, 764, 45);
	  getContentPane().add(panel_1);
	  setVisible(true);

}
