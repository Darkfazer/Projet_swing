package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.MatteBorder;

public class DetailsProjet extends JFrame {

  
    private Object projet;
    private JTextField adresField;
    private JTextField clientField;
    private JTextField chefField;
    private JTextField dateDField;
    private JTextField dateFField;
    private JTextField budgetField;
    private JTextField echancierField;
    private JTextField typeField;
    private JTextField nomField;
    private JPanel panel_1;
    private JTextField etatField;
    private String nomProjet , adresseProjet,client , budget,dateFin ,dateDebut,chefProjet,echancier,typeProjet,etat;
    
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
        modifierButton.setBackground(new Color(0, 255, 0));
        modifierButton.setBounds(144, 5, 81, 23);
        panel.add(modifierButton);
        
        
        JButton supprimerButton = new JButton("Supprimer", null);
        supprimerButton.setBackground(new Color(253, 111, 85));
        supprimerButton.setBounds(258, 5, 107, 23);
        panel.add(supprimerButton);

        Header header = new Header();
        header.setBounds(0, 0, 794, 48);
        getContentPane().add(header);
        Tasks tasks = new Tasks();
        tasks.setBounds(0, 48, 200, 600);
        getContentPane().add(tasks);
        
        panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 128)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(230, 105, 519, 445);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
       
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
        
        JLabel lblNewLabel_2 = new JLabel("Adresse: ");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(10, 71, 53, 30);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Client :");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1.setBounds(15, 112, 53, 19);
        panel_1.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("chef Projet");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_2.setBounds(10, 146, 58, 19);
        panel_1.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("debut :");
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_3.setBounds(15, 176, 53, 19);
        panel_1.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel_2_4 = new JLabel("Fin ");
        lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_4.setBounds(10, 212, 48, 19);
        panel_1.add(lblNewLabel_2_4);
        
        JLabel lblNewLabel_2_5 = new JLabel("Budget :");
        lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_5.setBounds(15, 253, 48, 19);
        panel_1.add(lblNewLabel_2_5);
        
        JLabel lblNewLabel_2_6 = new JLabel("echancier :");
        lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_6.setBounds(15, 295, 53, 19);
        panel_1.add(lblNewLabel_2_6);
        
        JLabel lblNewLabel_2_7 = new JLabel("type :");
        lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_7.setBounds(15, 337, 48, 19);
        panel_1.add(lblNewLabel_2_7);
        
        JButton btntache = new JButton("les taches");
        btntache.setFont(new Font("Tahoma", Font.BOLD, 12));
        btntache.setForeground(new Color(255, 255, 255));
        btntache.setBackground(new Color(128, 0, 128));
        btntache.setBounds(352, 411, 112, 23);
        panel_1.add(btntache);
        
        adresField = new JTextField(adresse);
        adresField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        adresField.setBackground(new Color(255, 255, 255));
        adresField.setBounds(75, 79, 220, 19);
        panel_1.add(adresField);
        adresField.setColumns(10);
        
        clientField = new JTextField(client);
        clientField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        clientField.setBackground(new Color(255, 255, 255));
        clientField.setColumns(10);
        clientField.setBounds(76, 112, 220, 19);
        panel_1.add(clientField);
        
        chefField = new JTextField(chefProjet);
        chefField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        chefField.setColumns(10);
        chefField.setBackground(new Color(255, 255, 255));
        chefField.setBounds(76, 143, 220, 19);
        panel_1.add(chefField);
        
        dateDField = new JTextField(DateDebut);
        dateDField.setHorizontalAlignment(SwingConstants.CENTER);
        dateDField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        dateDField.setColumns(10);
        dateDField.setBackground(new Color(255, 255, 255));
        dateDField.setBounds(76, 175, 220, 19);
        panel_1.add(dateDField);
        
        dateFField = new JTextField(DateFin);
        dateFField.setHorizontalAlignment(SwingConstants.CENTER);
        dateFField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        dateFField.setColumns(10);
        dateFField.setBackground(new Color(255, 255, 255));
        dateFField.setBounds(76, 210, 220, 19);
        panel_1.add(dateFField);
        
      
        
        budgetField = new JTextField(budget);
        budgetField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        budgetField.setColumns(10);
        budgetField.setBackground(new Color(255, 255, 255));
        budgetField.setBounds(76, 252, 220, 19);
        panel_1.add(budgetField);
        
        echancierField = new JTextField(echancier);
        echancierField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        echancierField.setColumns(10);
        echancierField.setBackground(new Color(255, 255, 255));
        echancierField.setBounds(76, 294, 220, 19);
        panel_1.add(echancierField);
        
        typeField = new JTextField(type);
        typeField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        typeField.setColumns(10);
        typeField.setBackground(new Color(255, 255, 255));
        typeField.setBounds(73, 336, 220, 19);
        panel_1.add(typeField);
        
        nomField = new JTextField(nom);
        nomField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        nomField.setBackground(new Color(255, 255, 255));
        nomField.setBounds(112, 11, 241, 20);
        panel_1.add(nomField);
        nomField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("etat d'avancement");
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblNewLabel.setBounds(17, 388, 112, 14);
        panel_1.add(lblNewLabel);
        
        etatField = new JTextField("20");
        etatField.setBounds(122, 385, 173, 20);
        panel_1.add(etatField);
        etatField.setColumns(10);
        setVisible(true);
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les nouvelles valeurs depuis les labels
              try {
				projecter();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }});
           
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					new controllers.Projets().DeletProjet((Integer) model.getValueAt(row, 0));
					refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }});
        btntache.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					new controllers.Taches().LesTache(row);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }});
            
    }
 public void refresh() {
	 panel_1.removeAll();
	 JButton btnnouveau = new JButton("+ ajouter nouvelle projet");
	 btnnouveau.setBackground(new Color(255, 128, 64));
	 btnnouveau.setFont(new Font("Tahoma", Font.PLAIN, 13));
	 btnnouveau.setBounds(150, 166, 173, 32);
	 panel_1.add(btnnouveau);
 }
 
 public void projecter() throws SQLException, ParseException {
    
      nomProjet = nomField.getText();
      adresseProjet = adresField.getText();
      client =clientField.getText();
    chefProjet = chefField.getText();
     dateDebut = dateDField.getText();
     dateFin = dateFField.getText();
     budget = budgetField.getText();
      echancier = echancierField.getText();
     typeProjet = typeField.getText();
      etat = etatField.getText();

     if (nomProjet.isEmpty() || adresseProjet.isEmpty() || chefProjet.isEmpty() || dateDebut.isEmpty() || dateFin.isEmpty() || budget.isEmpty() || echancier.isEmpty() || typeProjet.isEmpty()|| etat.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Remplir tous les champs.", "Error", JOptionPane.ERROR_MESSAGE);
         return;
     }

     try {
         String dateString = (String) dateDebut;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = sdf.parse(dateString);
         java.sql.Date sqlDate = new java.sql.Date(date.getTime());
         
         String dateFinString = (String) dateFin;
         date = sdf.parse(dateFinString);
         java.sql.Date sqlDatefin = new java.sql.Date(date.getTime());
         
         // Parse the budget string to a BigDecimal
         BigDecimal budgetdc = new BigDecimal((String) budget);
         int etas = Integer.parseInt(etat);
       
         new models.Projet().updatePro(new Object[]{nomProjet, adresseProjet, client, chefProjet, sqlDate, sqlDatefin, budgetdc, chefProjet, echancier, typeProjet,etas});
         JOptionPane.showMessageDialog(this, "le projet a été bien modifié ", nomProjet, JOptionPane.INFORMATION_MESSAGE);
         
     } catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(this, "Erreur: Le budget doit être un nombre valide.", "Erreur de Budget", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     } catch (ParseException e) {
         JOptionPane.showMessageDialog(this, "Erreur: Format de date invalide.", "Erreur de Date", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }

   
     return;
 }

	

	public Object getProjet() {
		return projet;
	}

	public void setProjet(Object projet) {
		this.projet = projet;
	}
}
