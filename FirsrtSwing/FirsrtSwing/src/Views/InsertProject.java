package Views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import models.Projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

public class InsertProject extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3938293449889104031L;
	private JTextField nomProjetField, clientField , dateDebutField, dateFinField, budgetField,adresseProjetField;
    private JComboBox<String> echancierCombo, typeProjetCombo , chefProjetField;
    private JButton suivantButton;
    private JFormattedTextField dateTextField,datefinTextField;
    private String nomProjet , adresseProjet,client , budget,dateFin ,dateDebut,chefProjet,echancier,typeProjet;
   

    public InsertProject() throws SQLException {
        setTitle("Insertion de Projet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true); // Remove default window decorations
        setSize(800, 700);
        setLocationRelativeTo(null); // Center the frame on screen


        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/slide1.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance( 400, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
        JLabel slide = new JLabel(scaledCloseIcon);
        slide. setBounds(0, 0, 692, 100);
        panel.add(slide);
        
        
        JLabel label = new JLabel("Nom de Projet:");
        label.setBounds(94, 124, 98, 36);
        panel.add(label);
        nomProjetField = new JTextField();
        nomProjetField.setBounds(234, 124, 243, 36);
        panel.add(nomProjetField);

        JLabel label_2 = new JLabel("Client:");
        label_2.setBounds(132, 171, 92, 36);
        panel.add(label_2);
        clientField = new JTextField();
        clientField.setBounds(234, 171, 243, 36);
        panel.add(clientField);

        JLabel label_3 = new JLabel("Chef de Projet:");
        label_3.setBounds(94, 218, 88, 36);
        panel.add(label_3);
        String[] chefProjet = new controllers.Projets().chefs();
        
        chefProjetField = new JComboBox<>(chefProjet);
       
        chefProjetField.setBounds(234, 218, 243, 36);
        
        panel.add(chefProjetField);

        JLabel label_4 = new JLabel("Date de Début:");
        label_4.setBounds(94, 265, 98, 36);
        panel.add(label_4);
       
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####/##/##");
            dateTextField = new JFormattedTextField(dateFormatter);
            dateTextField.setColumns(10);
            dateTextField.setBounds(234, 265, 243, 36);
            
            panel.add(dateTextField);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        JLabel label_5 = new JLabel("Date de Fin:");
        label_5.setBounds(94, 312, 98, 36);
        panel.add(label_5);
       
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####/##/##");
            datefinTextField = new JFormattedTextField(dateFormatter);
            datefinTextField.setColumns(10);
            datefinTextField.setBounds(234, 312, 243, 36);
            
            panel.add(datefinTextField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel label_6 = new JLabel("Budget:");
        label_6.setBounds(113, 359, 69, 36);
        panel.add(label_6);
        budgetField = new JTextField();
        budgetField.setBounds(234, 359, 243, 36);
        panel.add(budgetField);

        JLabel label_7 = new JLabel("Échéancier:");
        label_7.setBounds(100, 406, 92, 36);
        panel.add(label_7);
        String[] echancierOptions = {"Option 1", "Option 2", "Option 3"}; // Remplacer par vos propres options
        echancierCombo = new JComboBox<>(echancierOptions);
        echancierCombo.setBounds(234, 406, 243, 36);
        panel.add(echancierCombo);

        JLabel label_8 = new JLabel("Type de Projet:");
        label_8.setBounds(81, 453, 111, 36);
        panel.add(label_8);
        String[] typeProjetOptions = {"Hôtel", "Bâtiment", "Villa", "Appartement", "Maison"};
        typeProjetCombo = new JComboBox<>(typeProjetOptions);
        typeProjetCombo.setBounds(234, 453, 243, 36);
        panel.add(typeProjetCombo);
        
        adresseProjetField = new JTextField();

        suivantButton = new JButton("suivant");
        suivantButton.setBackground(new Color(128, 255, 128));
        suivantButton.setBounds(479, 571, 169, 31);
        suivantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                 try {
					projecter();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
     
        panel.add(suivantButton);
        getContentPane().add(panel);
        panel.setLayout(null);
        
       
        adresseProjetField.setBounds(234, 502, 243, 36);
        panel.add(adresseProjetField);
        
        JLabel label_1 = new JLabel("Adresse de Projet:");
        label_1.setBounds(81, 502, 105, 36);
        panel.add(label_1);
        
       
        getContentPane().add(new Header(),BorderLayout.NORTH);
       
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    public void projecter() throws SQLException, ParseException {
        DefaultTableModel model = new DefaultTableModel();

         nomProjet = nomProjetField.getText();
         adresseProjet = adresseProjetField.getText();
         client = clientField.getText();
       chefProjet = (String) chefProjetField.getSelectedItem();
        dateDebut = dateTextField.getText();
        dateFin = datefinTextField.getText();
        budget = budgetField.getText();
         echancier = (String) echancierCombo.getSelectedItem();
        typeProjet = (String) typeProjetCombo.getSelectedItem();

        if (nomProjet.isEmpty() || adresseProjet.isEmpty() || chefProjet.isEmpty() || dateDebut.isEmpty() || dateFin.isEmpty() || budget.isEmpty() || echancier.isEmpty() || typeProjet.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Remplir tous les champs.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String dateString = (String) dateDebut;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date date = sdf.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            String dateFinString = (String) dateFin;
            date = sdf.parse(dateFinString);
            java.sql.Date sqlDatefin = new java.sql.Date(date.getTime());
            
            // Parse the budget string to a BigDecimal
            BigDecimal budgetdc = new BigDecimal((String) budget);
            String one = "01";
            int etas = Integer.parseInt(one);
            new controllers.Taches().setNomProjet(nomProjet);
            new controllers.Taches().addtache(new Object[]{nomProjet, adresseProjet, client, chefProjet, sqlDate, sqlDatefin, budgetdc, chefProjet, echancier, typeProjet,etas},1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur: Le budget doit être un nombre valide.", "Erreur de Budget", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur: Format de date invalide.", "Erreur de Date", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

      
        return;
    }
 

}
