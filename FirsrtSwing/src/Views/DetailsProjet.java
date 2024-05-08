package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class DetailsProjet extends JFrame {

  
    private Object projet;
    public DetailsProjet(int row,DefaultTableModel model) {
    	
    	String nom = (String) model.getValueAt(row, 1); ;
    	String adresse = (String) model.getValueAt(row, 2);
    	String client = (String) model.getValueAt(row, 3);
    	String chefProjet = (String) model.getValueAt(row, 4);
    	java.sql.Date dateDebut = (java.sql.Date) model.getValueAt(row, 5);
        String DateDebut = dateDebut.toString();
        java.sql.Date dateFin = (java.sql.Date) model.getValueAt(row, 6);
        String DateFin = dateDebut.toString(); 	
        BigDecimal budgetdc = (BigDecimal) model.getValueAt(row, 7);
        String budget = (budgetdc != null) ? budgetdc.toString() : ""; // Check for null to avoid NullPointerException

    	String echancier =  (String) model.getValueAt(row, 8);
    	String type = (String) model.getValueAt(row, 9);
    	String taches = (String) model.getValueAt(row, 10);
    	String image = (String) model.getValueAt(row, 11);
    	Integer etat = (Integer) model.getValueAt(row, 12);
    	getContentPane().setBackground(new Color(255, 255, 255));
       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the entire application when this frame is closed
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(235, 59, 429, 35);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton modifierButton = new JButton("Modifier", null);
        modifierButton.setBounds(144, 5, 81, 23);
        panel.add(modifierButton);
        
        JButton supprimerButton = new JButton("Supprimer", null);
        supprimerButton.setBounds(258, 5, 107, 23);
        panel.add(supprimerButton);
        
        JButton btnNewButton_1 = new JButton("Enregistrer");
        btnNewButton_1.setBounds(32, 5, 89, 23);
        panel.add(btnNewButton_1);

        Header header = new Header();
        header.setBounds(0, 0, 794, 48);
        getContentPane().add(header);
        Tasks tasks = new Tasks();
        tasks.setBounds(0, 48, 200, 600);
        getContentPane().add(tasks);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(242, 205, 94));
        panel_1.setBounds(201, 105, 519, 445);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel(nom);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(156, 11, 100, 19);
        panel_1.add(lblNewLabel);
        image = "C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/close.png";
        ImageIcon imageIcon = new ImageIcon(image);
        Image plan = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(plan);

        // Attribution de l'icône à JLabel
       
        JLabel lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setIcon(imageIcon);
        lblNewLabel_1.setBackground(new Color(192, 192, 192));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(317, 36, 192, 171);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Adresse: "+adresse);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(10, 65, 297, 36);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Client :"+client);
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1.setBounds(10, 112, 185, 19);
        panel_1.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Chef de Projet :"+chefProjet);
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_2.setBounds(15, 144, 185, 19);
        panel_1.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("debut :"+DateDebut);
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_3.setBounds(15, 176, 185, 19);
        panel_1.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel_2_4 = new JLabel("Date Fin :"+DateFin);
        lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_4.setBounds(15, 211, 185, 19);
        panel_1.add(lblNewLabel_2_4);
        
        JLabel lblNewLabel_2_5 = new JLabel("Budget :"+budget);
        lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_5.setBounds(15, 253, 185, 19);
        panel_1.add(lblNewLabel_2_5);
        
        JLabel lblNewLabel_2_6 = new JLabel("echancier :"+echancier);
        lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_6.setBounds(15, 295, 185, 19);
        panel_1.add(lblNewLabel_2_6);
        
        JLabel lblNewLabel_2_7 = new JLabel("type :"+type);
        lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_7.setBounds(15, 337, 185, 19);
        panel_1.add(lblNewLabel_2_7);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(new Color(0, 255, 0));
        progressBar.setStringPainted(true);
        progressBar.setValue(etat);
        progressBar.setBounds(66, 386, 146, 14);
        panel_1.add(progressBar);
        
        JButton btnNewButton = new JButton("les taches");
        btnNewButton.setBounds(241, 411, 112, 23);
        panel_1.add(btnNewButton);
        setVisible(true);
    }

	

	public Object getProjet() {
		return projet;
	}

	public void setProjet(Object projet) {
		this.projet = projet;
	}
}
