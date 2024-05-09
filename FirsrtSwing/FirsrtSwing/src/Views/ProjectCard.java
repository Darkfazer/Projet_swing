package Views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import controllers.Projets;
import firstApp.BackLog;

public class ProjectCard extends JPanel {

    private DefaultTableModel model;
    private JPanel cardsPanel;
    private JTextField textField;
   private controllers.Projets projet;
   
    public ProjectCard() throws SQLException {
    	projet = new controllers.Projets();
        setLayout(new BorderLayout());
        model = new controllers.Projets().getModel();
        // Créer un JPanel pour contenir les cartes
        cardsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        cardsPanel.setBorder(new EmptyBorder(50, 30, 10, 10)); // Ajouter une marge extérieure
        cardsPanel.setBackground(new Color(255, 255, 255));
        
        //cardsPanel.setLayout(null);
        // Parcourir le modèle de données et créer une carte pour chaque enregistrement
        int cardsPerRow = 2; // Number of cards per row
        int cardWidth = 217;
        int cardHeight = 217;
        int horizontalGap = 20; // Horizontal gap between cards
        int verticalGap = 20; // Vertical gap between cards

        for (int row = 0; row < model.getRowCount(); row++) {
            int x = (row % cardsPerRow) * (cardWidth + horizontalGap); // Calculate x position
            int y = (row / cardsPerRow) * (cardHeight + verticalGap); // Calculate y position

            JPanel card = createCardPanel(row);
            card.setBackground(new Color(251, 187, 68));
            card.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(255, 128, 64)));
            //card.setBounds(x, y, cardWidth, cardHeight);
            //card.setLayout(null);
            cardsPanel.add(card);
        }

       
        String[] categorie = {"-                                   -",
        		"Trimestriel", "Bimensuel", "Mensuel"};
        JComboBox<String> scrollBar = new JComboBox<>(categorie);
        scrollBar.setBackground(new Color(244, 244, 244));

        scrollBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = (String) scrollBar.getSelectedItem();
                
                // Utiliser une structure switch pour déterminer la requête en fonction de l'option sélectionnée
                switch(option) {
                    case "Trimestriel": // Modifier la syntaxe de la condition
					try {
						model = projet.getQuery(option);
						refresh();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                        break; // Ajouter un break à la fin de chaque case
                    case "Bimensuel":
					try {
						model = projet.getQuery(option);
						refresh();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}// Remplacer "option2" par la requête appropriée
                        break;
                    case "Mensuel":
					try {
						model = projet.getQuery(option);
						refresh();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // Remplacer "option3" par la requête appropriée
                        break;
                }
                
                // Vérifier si la requête a été correctement déterminée
               
            }
        });
       

      
       
        
        JPanel panel = new JPanel();
        FlowLayout flowoptions = (FlowLayout) panel.getLayout();
        flowoptions.setAlignOnBaseline(true);
        panel.setBackground(new Color(255, 255, 255));
        
      
        add(panel, BorderLayout.SOUTH);
        
        textField = new JTextField();
        textField.setBackground(new Color(255, 255, 255));
        panel.add(textField);
        textField.setColumns(20);
        
        JButton btnNewButton = new JButton("chercher");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(new Color(255, 128, 64));
        panel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("-          -");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel);
       

       
        panel.add(scrollBar, BorderLayout.NORTH);
        scrollBar.setBorder(new LineBorder(new Color(255, 128, 64), 2)); 
        add(panel, BorderLayout.NORTH);

        // Ajouter le panel de cartes à un JScrollPane et l'ajouter à ce JPanel
        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
    public void refresh() {
        // Remove all existing card panels
        cardsPanel.removeAll();
        // Add new card panels based on updated data
        int cardsPerRow = 2; // Number of cards per row
        int cardWidth = 217;
        int cardHeight = 217;
        int horizontalGap = 20; // Horizontal gap between cards
        int verticalGap = 20; // Vertical gap between cards

        for (int row = 0; row < model.getRowCount(); row++) {
            int x = (row % cardsPerRow) * (cardWidth + horizontalGap); // Calculate x position
            int y = (row / cardsPerRow) * (cardHeight + verticalGap); // Calculate y position

            JPanel card = createCardPanel(row);
            card.setBackground(new Color(251, 187, 68));
            card.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(255, 128, 64)));
            //card.setBounds(x, y, cardWidth, cardHeight);
            //card.setLayout(null);
            cardsPanel.add(card);
        }
        // Revalidate and repaint the panel to reflect changes
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    
    private JPanel createCardPanel(int row) {
        JPanel card = new JPanel(new GridBagLayout());

        // Récupérer les données de la ligne spécifiée dans le modèle de données
        String nomProjet = (String) model.getValueAt(row, 1);
        
        java.sql.Date dateDebut = (java.sql.Date) model.getValueAt(row, 5);
        String description = dateDebut.toString();
        
        java.sql.Date dateFin = (java.sql.Date) model.getValueAt(row, 6);
        String budgetValue = dateFin.toString(); // Convert java.sql.Date to String

        Integer progressValue = (Integer) model.getValueAt(row, 12);

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
        	   
              try {
				new controllers.Projets().DetailProjet(row, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           }});
           
        
       

        return card;
    }
   
}
