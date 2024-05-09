package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class InserTache extends JFrame {
  

	private static final long serialVersionUID = 8027977745022267082L;
	
	    private JTextField chargesField;
	    private JTextField typeStructureField;
	    private JFormattedTextField dateTextField,datefinTextField;
	    private JComboBox<String>  tache,responsableField,echancierCombo;
	    private JPanel panelOne;
	    private JTextPane txtpnNotes;
	    private String responsable, charge,  dateDebut, dateFin,  strecture, descr,echancier,nomeTache,nomProjet;
	   private JLabel Maconnerie;
	   private  JList<String> jList;
 
    public InserTache(String nomPr) throws SQLException {
    	this.nomProjet = nomPr;
        setTitle("Insertion de Projet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //setUndecorated(true); // Remove default window decorations
        setSize(800, 700);
        setLocationRelativeTo(null); // Center the frame on screen
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/slide2.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance( 400, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
        JLabel slide = new JLabel(scaledCloseIcon);
        slide. setBounds(10, 0, 692, 100);
        
        panelOne = new JPanel();
        panelOne.setBackground(new Color(255, 255, 255));
        panelOne.setSize(800,700);
        Header header = new Header();
        header.setBackground(new Color(142, 44, 150));
        getContentPane().add(header,BorderLayout.NORTH);
        getContentPane().add(panelOne,BorderLayout.CENTER);
        panelOne.add(slide);
        MaconnerieForm();
        setVisible(true);
    }	
    
    public void MaconnerieForm() throws SQLException {
        setTitle("Formulaire Maçonnerie");
        setSize(800, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 141, 638, 317);

        JLabel lblResponsable = new JLabel("Responsable:");
        lblResponsable.setHorizontalAlignment(SwingConstants.CENTER);
        lblResponsable.setBounds(21, 55, 90, 23);
        panel.setLayout(null);   
        panel.add(lblResponsable);
        String[] chefProjet = new controllers.Projets().chefs();
        responsableField = new JComboBox<>(chefProjet);
        responsableField.setBounds(157, 55, 178, 23);
       panel.add(responsableField);
      
        JLabel lblCharges = new JLabel("Charges estimées:");
        lblCharges.setHorizontalAlignment(SwingConstants.CENTER);
        lblCharges.setBounds(10, 89, 101, 23);
        chargesField = new JTextField();
        chargesField.setBounds(157, 89, 178, 23);
        panel.add(lblCharges);
        panel.add(chargesField);

        JLabel lblDateDebut = new JLabel("Date de début:");
        lblDateDebut.setHorizontalAlignment(SwingConstants.CENTER);
        lblDateDebut.setBounds(31, 123, 90, 23);
       panel.add(lblDateDebut);
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####/##/##");
            dateTextField = new JFormattedTextField(dateFormatter);
            dateTextField.setColumns(10);
            dateTextField.setBounds(157, 123, 178, 23);
            
            panel.add(dateTextField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblDateFin = new JLabel("Date de fin:");
        lblDateFin.setHorizontalAlignment(SwingConstants.CENTER);
        lblDateFin.setBounds(31, 169, 90, 23);
      
        panel.add(lblDateFin);
       
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####/##/##");
            datefinTextField = new JFormattedTextField(dateFormatter);
            datefinTextField.setColumns(10);
            datefinTextField.setBounds(157, 169, 178, 23);
            
            panel.add(datefinTextField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblTypeStructure = new JLabel("Type de structure:");
        lblTypeStructure.setHorizontalAlignment(SwingConstants.CENTER);
        lblTypeStructure.setBounds(21, 203, 90, 23);
        typeStructureField = new JTextField();
        typeStructureField.setBounds(157, 203, 178, 23);
        panel.add(lblTypeStructure);
        panel.add(typeStructureField);
        String[] materiauxOptions = {"Brique", "Pierre", "Béton", "Autre"};

        JButton btnSave = new JButton("Enregistrer");
        btnSave.setBounds(416, 283, 114, 23);
        btnSave.addActionListener(new ActionListener() {
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
        panel.add(btnSave);
        panelOne.setLayout(null);

      panelOne.add(panel);
      
      Maconnerie = new JLabel("Maconnerie");
      Maconnerie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
      Maconnerie.setHorizontalAlignment(SwingConstants.CENTER);
      Maconnerie.setBounds(85, 11, 281, 33);
      panel.add(Maconnerie);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
      panel_1.setBackground(new Color(255, 255, 255));
      panel_1.setBounds(345, 55, 288, 152);
      panel.add(panel_1);
      panel_1.setLayout(null);
      
      txtpnNotes = new JTextPane();
      txtpnNotes.setBounds(10, 5, 268, 136);
      panel_1.add(txtpnNotes);
      txtpnNotes.setText("description");
      
     
      String[] echancierOptions = {"Court terme", "Moyen terme", "Long terme"}; // Remplacer par vos propres options
      echancierCombo = new JComboBox<>(echancierOptions);
      echancierCombo.setBounds(157, 242, 178, 23);
     
      panel.add(echancierCombo);
      
      JLabel lblNewLabel_1 = new JLabel("echancier :");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(45, 246, 80, 14);
      panel.add(lblNewLabel_1);
      DefaultListModel<String> listModel = new DefaultListModel<>();
      
      
      String[] taches = { "Maçonnerie", "plomberie", "Plâtrerie", "peinture", "Menuiserie", "paysagisme",
              "carrelage", "charpenterie", "électricité" };
       tache = new JComboBox(taches);
      tache.setBounds(264, 108, 164, 22);
     
    	  panelOne.add(tache);
	     
    	  JPanel panel_2 = new JPanel();
      tache.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String tacheSelectionnee = (String) tache.getSelectedItem();
    	       
    	        Maconnerie.setText(tacheSelectionnee);
    	        
    	        listModel.addElement(tacheSelectionnee);
    	        tache.removeItem(tacheSelectionnee);  
    	        if (tache.getItemCount() == 0) {
    	            panelOne.remove(tache); // Supprimer le JComboBox du panel
    	            panelOne.revalidate(); // Mettre à jour l'affichage
    	            panelOne.repaint();
    	        }
    	        Component[] components = panel.getComponents();
    	       
    	        for (Component component : components) {
    	            if (component instanceof JTextField) {
    	                ((JTextField) component).setText("");
    	               
    	            } 
    	        }
    	   
    	    }
    	});

      jList = new JList<>(listModel);

   // Ajout d'un écouteur de sélection à la JList
   jList.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
	   @Override
       public void valueChanged(ListSelectionEvent e) {
           if (!e.getValueIsAdjusting()) {
               // Récupérer l'élément sélectionné dans la liste
               String selectedItem = jList.getSelectedValue();
               
               // Votre action à effectuer en fonction de l'élément sélectionné
               System.out.println("Élément sélectionné : " + selectedItem);
               
               // Par exemple, vous pouvez mettre à jour d'autres composants en fonction de la sélection
           }
       }

	
   });
   JScrollPane scrollPane = new JScrollPane(jList);
   scrollPane.setBounds(10, 11, 107, 191);

// Ajout du JScrollPane au panel
panel_2.add(scrollPane);
   // Ajout de la JList au panel
 
     
      
      JButton btnNewButton = new JButton("suivant >>");
      btnNewButton.setBounds(427, 469, 104, 23);
      panelOne.add(btnNewButton);
      btnNewButton.addActionListener(new ActionListener() {
  	    @Override
  	    public void actionPerformed(ActionEvent e) {
  	      try {
  	    	  String[] names = new String[2];
  	    	  names[0]=  Maconnerie.getText();
  	    	  names[1]= nomProjet;
			new controllers.Employe().openRessource(jList,names);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  	      
  	        }
  	    });
      
      JButton btnNewButton_1 = new JButton("<< Back");
      btnNewButton_1.setBounds(32, 467, 89, 23);
      panelOne.add(btnNewButton_1);
      
     
      panel_2.setBounds(658, 189, 127, 213);
      panel_2.setBackground(new Color(142,44,150));
      panelOne.add(panel_2);
      panel_2.setLayout(null);
      JList<String> list = new JList<>(listModel);
      list.setBounds(10, 11, 107, 191);
      panel_2.add(list);
      list.setBackground(new Color(255, 255, 255));
      
      JLabel lblNewLabel = new JLabel("Les taches");
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(658, 174, 126, 14);
      panelOne.add(lblNewLabel);
      
              JButton btnCancel = new JButton("Supprimer");
              btnCancel.setBounds(668, 423, 105, 23);
              panelOne.add(btnCancel);
              btnCancel.addActionListener(new ActionListener() {
            	    @Override
            	    public void actionPerformed(ActionEvent e) {
            	        // Récupérer l'indice de l'élément sélectionné dans la liste
            	        int selectedIndex = jList.getSelectedIndex();
            	        
            	       
            	        if (selectedIndex != -1) {
            	           
            	           
            	            try {
								new models.Taches().deleteTache(jList.getSelectedValue(), getNomProjet());
            	            	//new models.Taches().deleteTache("Maçonnerie", "Anaconda");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
            	            listModel.remove(selectedIndex);
            	        }
            	    }
            	});
        
    }
    
    public void projecter() throws SQLException, ParseException {
      
         responsable = (String) responsableField.getSelectedItem();
         charge = chargesField.getText(); 
        dateDebut = dateTextField.getText();
        dateFin = datefinTextField.getText();
         strecture = typeStructureField.getText();
        descr = txtpnNotes.getText();
       echancier = (String) echancierCombo.getSelectedItem();
       nomeTache = Maconnerie.getText();
        if (responsable.isEmpty() || charge.isEmpty() || dateDebut.isEmpty() || dateFin.isEmpty() || strecture.isEmpty() || descr.isEmpty()|| echancier.isEmpty() ) {
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
            BigDecimal budgetdc = new BigDecimal((String) charge);
          
            new controllers.Taches().addtache(new Object[]{responsable,echancier,  sqlDate, sqlDatefin, budgetdc,descr,  strecture, nomeTache},0);
            JOptionPane.showMessageDialog(this, "la tache est enregestré avec succée", nomeTache, JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur: Le budget doit être un nombre valide.", "Erreur de Budget", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur: Format de date invalide.", "Erreur de Date", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

      
        return;
    }
 
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					new InserTache("Anaconda");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

	public String getNomProjet() {
		return nomProjet;
	}
}
