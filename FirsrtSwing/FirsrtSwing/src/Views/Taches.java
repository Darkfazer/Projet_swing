package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.SQLException;

public class Taches extends JFrame {
    private controllers.Taches tache;
	private JPanel cardsPanel ;
	private DefaultTableModel model;
	  private JTextField textField;
	  private JScrollPane scrollPane;
	private static final long serialVersionUID = -3078573403281680580L;
	public Taches() throws SQLException {
		
		setSize(800,600);
		
		cardsPanel = new JPanel();
	
	      
	      tache = new controllers.Taches();
	        setLayout(new BorderLayout());
	        model = new controllers.Taches().getModel();
	        // Créer un JPanel pour contenir les cartes
	        cardsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
	        cardsPanel.setBorder(new EmptyBorder(50, 30, 10, 10)); // Ajouter une marge extérieure
	        cardsPanel.setBackground(new Color(255, 255, 255));
	        
	        //cardsPanel.setLayout(null);
	        // Parcourir le modèle de données et créer une carte pour chaque enregistrement
	     
	        for (int row = 0; row < model.getRowCount(); row++) {
	          
	            JPanel card = createCardPanel(row);
	            card.setBackground(new Color(251, 187, 68));
	            card.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(255, 128, 64)));
	          
	            cardsPanel.add(card);
	            
	            JPanel panel = new JPanel();
	            FlowLayout flowoptions = (FlowLayout) panel.getLayout();
	            flowoptions.setAlignOnBaseline(true);
	            panel.setBackground(new Color(255, 255, 255));
	            
	          
	          
	           
	            
	            JLabel lblNewLabel = new JLabel("Trier");
	            lblNewLabel.setForeground(new Color(255, 255, 255));
	            panel.add(lblNewLabel);
	           

	            // Ajouter le panel de cartes à un JScrollPane et l'ajouter à ce JPanel
	             scrollPane = new JScrollPane(cardsPanel);
	            add(scrollPane, BorderLayout.CENTER);
	        }
	        
	        
	        setVisible(true);
	        getContentPane().add(new Header(),BorderLayout.NORTH);
	        getContentPane().add(new Tasks(),BorderLayout.WEST);
	       getContentPane().add(scrollPane,BorderLayout.CENTER);
	        }
	        public void refresh() {
	            // Remove all existing card panels
	            cardsPanel.removeAll();
	          
	            for (int row = 0; row < model.getRowCount(); row++) {
	               
	                JPanel card = createCardPanel(row);
	                card.setBackground(new Color(251, 187, 68));
	                card.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(255, 128, 64)));
	               
	                cardsPanel.add(card);
	            }
	            // Revalidate and repaint the panel to reflect changes
	            cardsPanel.revalidate();
	            cardsPanel.repaint();
	        }
	        private JPanel createCardPanel(int row) {
	            JPanel card = new JPanel(new GridBagLayout());

	            // Récupérer les données de la ligne spécifiée dans le modèle de données
	            String nomProjet = (String) model.getValueAt(row, 11);
	            
	            java.sql.Date dateDebut = (java.sql.Date) model.getValueAt(row, 5);
	            String description = dateDebut.toString();
	            
	            java.sql.Date dateFin = (java.sql.Date) model.getValueAt(row, 6);
	            String budgetValue = dateFin.toString(); // Convert java.sql.Date to String
                 if(model.getValueAt(row, 4)==null) {
                 model.setValueAt(0, row, 4);
                 }
	            Integer progressValue = (Integer) model.getValueAt(row, 4);

	            // Créer des JLabels pour afficher les données
	            JLabel nameLabel = new JLabel(nomProjet);
	            JLabel descriptionLabel = new JLabel(description);
	            JLabel budgetLabel = new JLabel(budgetValue);
	            JProgressBar progressBar = new JProgressBar(0, 100);
	            progressBar.setValue(progressValue);
	            progressBar.setStringPainted(true);
	            progressBar.setBackground(new Color(255, 255, 255));
	            if(progressValue>50) {
	            	progressBar.setForeground(new Color(0, 255, 0));
	            }else {
	            progressBar.setForeground(new Color(255, 128, 64));
	            }
	            // Ajouter un peu d'espace entre les lignes
	          GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = 0;
	            gbc.gridy = 0;
	            gbc.anchor = GridBagConstraints.CENTER; // Aligner à gauche
	            gbc.insets = new Insets(5, 5, 5, 5); // Ajouter des marges intérieures

	            card.add(nameLabel, gbc);

	            gbc.gridy = 1;
	            card.add(descriptionLabel, gbc);

	            gbc.gridy = 2;
	            card.add(budgetLabel, gbc);

	            gbc.gridy = 3;
	            gbc.fill = GridBagConstraints.HORIZONTAL; // Remplissage horizontal
	            card.add(progressBar, gbc);
	             
	            gbc.gridy=4;
	            JButton btnNewButton = new JButton("Detaille");
	            btnNewButton.setBackground(new Color(255, 128, 64));
	            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	            card.add(btnNewButton, gbc);
	           btnNewButton.addActionListener(new ActionListener() {
	               @Override
	               public void actionPerformed(ActionEvent e) {
	            	   // Create a new JFrame to contain the DetailsProjet panel
	            	   
	                 
	               }

				
				});
	               
	            
	           

	            return card;
	        }
	

	

}
