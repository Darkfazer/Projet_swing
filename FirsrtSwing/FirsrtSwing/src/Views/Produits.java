package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Produits extends JFrame {

    private static final long serialVersionUID = 2246410918209859746L;
    private JTextField nomField;
    private JTextField typeField;
    private JTextField quantField;
    private JTextField prixField;
    private JTextPane textPane;
    private JLabel tacheLabel;
    private String nom , type,quatite,prix,descrption,tache;
    private JTable table;
    private String[] nomPrtx;
    private DefaultTableModel model;
    private JScrollPane scrollPane_1;

    public Produits(JList<String> jList, String[] nomPrtx) throws SQLException {
    	this.nomPrtx = nomPrtx;
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 700); 
        setTitle("Insertion de Projet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        Header header = new Header();
        header.setBounds(0, 0, 794, 48);
        getContentPane().add(header);
        
        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(3, 3, 3, 3, new Color(128, 0, 128)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 55, 764, 606);
        panel.setLayout(null);
        
        jList.setFixedCellHeight(30);
        
        JLabel lblNewLabel = new JLabel("nom de Produit");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(249, 162, 131, 30);
        panel.add(lblNewLabel);
        
        JLabel lblTypeDeProduit = new JLabel("type de produit");
        lblTypeDeProduit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTypeDeProduit.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTypeDeProduit.setBounds(249, 196, 131, 30);
        panel.add(lblTypeDeProduit);
        
        JLabel lblQuantit = new JLabel("Quantité");
        lblQuantit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQuantit.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblQuantit.setBounds(249, 237, 131, 30);
        panel.add(lblQuantit);
        
        JLabel lblPrixTotal = new JLabel("prix total");
        lblPrixTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrixTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPrixTotal.setBounds(262, 278, 118, 30);
        panel.add(lblPrixTotal);
        
        JLabel lblDescription = new JLabel("Description");
        lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDescription.setBounds(262, 330, 118, 30);
        panel.add(lblDescription);
        
        nomField = new JTextField();
        nomField.setBounds(405, 165, 235, 26);
        panel.add(nomField);
        nomField.setColumns(10);
        
        typeField = new JTextField();
        typeField.setColumns(10);
        typeField.setBounds(405, 202, 235, 26);
        panel.add(typeField);
        
        quantField = new JTextField();
        quantField.setColumns(10);
        quantField.setBounds(405, 239, 235, 26);
        panel.add(quantField);
        
        prixField = new JTextField();
        prixField.setColumns(10);
        prixField.setBounds(405, 281, 235, 26);
        panel.add(prixField);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(128, 0, 128)));
        panel_1.setBounds(395, 325, 359, 99);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        textPane = new JTextPane();
        textPane.setBounds(10, 11, 339, 84);
        panel_1.add(textPane);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(128, 0, 128)));
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(22, 172, 172, 203);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setBounds(10, 36, 151, 156);
        panel_2.add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel lblNewLabel_1 = new JLabel("Les taches");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(10, 11, 137, 14);
        panel_2.add(lblNewLabel_1);
        
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/slide2.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance( 400, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
        JLabel slide = new JLabel(scaledCloseIcon);
        slide. setBounds(32, 11, 671, 66);
        
        getContentPane().add(panel);
        panel.add(slide);
        
        JButton btnNewButton = new JButton("enregistrer");
        btnNewButton.setBackground(new Color(128, 0, 128));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(46, 386, 136, 23);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   try {
   					produire();
   					table = new JTable(new models.Produits().selectpro(nomPrtx[0], nomPrtx[1]));
                	scrollPane_1.setViewportView(table);
                	scrollPane_1.revalidate();
                	scrollPane_1.repaint();
   				} catch (SQLException e1) {
   					
   					e1.printStackTrace();
   				} catch (ParseException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
            }
        });
        
        tacheLabel = new JLabel("tache");
        tacheLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        tacheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tacheLabel.setBounds(424, 111, 152, 23);
        panel.add(tacheLabel);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 128)));
        panel_3.setBounds(21, 435, 495, 156);
        panel.add(panel_3);
        panel_3.setLayout(null);
        
         scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 11, 481, 134);
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel_3.add(scrollPane_1);
        
     
        
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = jList.getSelectedValue();
                    tacheLabel.setText(selectedValue);
                    nomPrtx[0]= selectedValue;
                    try {
                    	table = new JTable(new models.Produits().selectpro(nomPrtx[0], nomPrtx[1]));
                    	scrollPane_1.setViewportView(table);
                    	scrollPane_1.revalidate();
                    	scrollPane_1.repaint();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }

		
        });
        table = new JTable(new models.Produits().selectpro(nomPrtx[0], nomPrtx[1]));
        scrollPane_1.setViewportView(table);
        
        JButton btnSupprimer = new JButton("supprimer");
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSupprimer.setBackground(new Color(128, 0, 128));
        btnSupprimer.setBounds(526, 474, 136, 23);
        panel.add(btnSupprimer);
        
        JButton btnTerminer = new JButton("terminer");
        btnTerminer.setForeground(Color.WHITE);
        btnTerminer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTerminer.setBackground(new Color(128, 0, 128));
        btnTerminer.setBounds(618, 568, 136, 23);
        panel.add(btnTerminer);
        btnTerminer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					new controllers.Acceuil().terminer();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }});
     // Ajoutez un ActionListener au bouton "supprimer"
        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selectedRow = table.getSelectedRow();
                
              
                if (selectedRow != -1) {
                   
                    int idProduit = (Integer) table.getValueAt(selectedRow, 0); // Remplacez 0 par l'indice de la colonne contenant le nom du produit
                    // Remplacez 1 par l'indice de la colonne contenant l'autre donnée nécessaire pour la suppression
                    
                    // Appelez la fonction deleteProduit avec les données de la ligne sélectionnée
                    try {
                        // Supprimez le produit de la base de données en utilisant la fonction deleteProduit
                        new models.Produits().deleteProduit(idProduit);
                        
                        // Rafraîchissez la table après la suppression
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                    } catch (SQLException ex) {
                        // Gérez les exceptions SQLException ici
                        ex.printStackTrace();
                    }
                } else {
                    // Si aucune ligne n'est sélectionnée, affichez un message à l'utilisateur pour lui demander de sélectionner une ligne.
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à supprimer.");
                }
            }
        });


        setVisible(true);
    }

    public void produire() throws SQLException, ParseException {
        //nom , type,quatite,prix,descrption,tache;
    	
        
        nom = nomField.getText(); 
       type = typeField.getText();
     quatite = quantField.getText();
     
        prix = prixField.getText();
        descrption = textPane.getText();
     tache = tacheLabel.getText();
     
       if (nom.isEmpty() || type.isEmpty() || quatite.isEmpty() || prix.isEmpty() || descrption.isEmpty() || tache.isEmpty() ) {
           JOptionPane.showMessageDialog(this, "Remplir tous les champs.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       try {
         
    	   int quantite = Integer.parseInt(quatite);
           // Parse the budget string to a BigDecimal
           BigDecimal budgetdc = new BigDecimal((String) prix);
                 if(tache.equals("tache"))  {                                       //nomProduit, type, idtache, idprojet, quantite, prix_total, description
           new models.Produits().InsertProduits(new Object[]{nom , type,nomPrtx[0],nomPrtx[1],quantite,budgetdc,descrption});
                 }else {
           new models.Produits().InsertProduits(new Object[]{nom , type,tache,nomPrtx[1],quantite,budgetdc,descrption});
                 }
           JOptionPane.showMessageDialog(this, "le produit est enregestré avec succée", nom, JOptionPane.INFORMATION_MESSAGE);
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "Erreur: Le prix et la quantité doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }
     
       return;
   }
    
    public static void main(String[] args) throws SQLException {
        String[] data = {"peinture", "charpenterie", "Maçonnerie", "Item 4", "Item 5"};
        JList<String> jList = new JList<>(data);
        String[] nom = {"peinture", "project R"};
        new Produits(jList, nom);
    }
}
