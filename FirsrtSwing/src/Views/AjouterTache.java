package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterTache extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3938293449889104031L;
	private JTextField budgetField,depences,dureField , deparField;
    private JComboBox<String> echancierCombo , category,nomTache;
    private JButton suivantButton,ajouterbtn,backbtn;
    private  JEditorPane descrption;

    public AjouterTache() {
        setTitle("Ajouter une tache");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true); // Remove default window decorations
        setSize(850, 700);
        setLocationRelativeTo(null); // Center the frame on screen
       

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/slide2.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance( 400, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
        JLabel slide = new JLabel(scaledCloseIcon);
        slide. setBounds(0, 0, 692, 100);
        panel.add(slide);
        
        
        JLabel lblNomDeLa = new JLabel("Nom de la tache");
        lblNomDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNomDeLa.setBounds(0, 124, 98, 36);
        panel.add(lblNomDeLa);
        
        String[] taches = {"tache 1", "tache 2", "tache 3"}; 
        nomTache = new JComboBox<>(taches);
        nomTache.setBounds(121, 124, 243, 36);
        panel.add(nomTache);
        descrption = new JEditorPane();
        descrption.setText("Descrition");
        descrption.setBackground(new Color(192, 192, 192));
        descrption.setBounds(29, 299, 375, 244);
        panel.add(descrption);
        
        JLabel lblCatgorieDeLa = new JLabel("Catégorie de la tâche ");
        lblCatgorieDeLa.setBounds(403, 124, 117, 36);
        panel.add(lblCatgorieDeLa);
        String[] categorie = {"gros œuvre", "second oeuvre", "finition"};
        category = new JComboBox<>(categorie);
        category.setBounds(541, 124, 243, 36);
        
        panel.add(category);

        JLabel lblPriorit = new JLabel("Priorité ");
        lblPriorit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPriorit.setBounds(29, 182, 69, 36);
        panel.add(lblPriorit);
        String[] echancierOptions = {"Option 1", "Option 2", "Option 3"}; // Remplacer par vos propres options
        echancierCombo = new JComboBox<>(echancierOptions);
        echancierCombo.setBounds(121, 182, 243, 36);
        panel.add(echancierCombo);

        JLabel lblDureEstime = new JLabel("Durée estimée");
        lblDureEstime.setBounds(433, 182, 98, 36);
        panel.add(lblDureEstime);
        dureField = new JTextField();
        dureField.setBounds(541, 182, 243, 36);
        panel.add(dureField);

        JLabel lblCotEstim = new JLabel("Coût estimé ");
        lblCotEstim.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCotEstim.setBounds(29, 238, 69, 36);
        panel.add(lblCotEstim);
        budgetField = new JTextField();
        budgetField.setBounds(121, 238, 243, 36);
        panel.add(budgetField);

        JLabel lblLesDpencesActuelle = new JLabel("Les dépences actuelle");
        lblLesDpencesActuelle.setBounds(403, 238, 127, 36);
        panel.add(lblLesDpencesActuelle);
        depences = new JTextField();
        depences.setBounds(541, 241, 243, 31);
        panel.add(depences);
        depences.setColumns(10);

        JLabel lblLaDateDe = new JLabel("La date de depart   ");
        lblLaDateDe.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLaDateDe.setBounds(414, 293, 111, 36);
        panel.add(lblLaDateDe);

        deparField = new JTextField();
        deparField.setBounds(541, 296, 243, 31);
        panel.add(deparField);
        deparField.setColumns(10);
        
       

        suivantButton = new JButton("suivant >>");
        suivantButton.setBackground(new Color(128, 255, 128));
        suivantButton.setBounds(611, 571, 138, 31);
        suivantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nomTaches = (String) nomTache.getSelectedItem();
                String description = descrption.getText();
                String categorie = (String) category.getSelectedItem();
                String dateDebut = dureField.getText();
                String deparTache = deparField.getText();
                String budget = budgetField.getText();
                String echancier = (String) echancierCombo.getSelectedItem();
                

                // Ensuite, vous pouvez traiter ces valeurs comme bon vous semble, par exemple les imprimer :
                System.out.println("Nom de Projet: " + nomTaches);
               
                System.out.println("Client: " + description);
                System.out.println("categorie: " + categorie);
                System.out.println("Date de Début: " + dateDebut);
                System.out.println("Date de Fin: " + deparTache);
                System.out.println("Budget: " + budget);
                System.out.println("Échéancier: " + echancier);
               

                // Vous pouvez également appeler une méthode pour enregistrer ces données dans une base de données, par exemple
            }
        });
     
        panel.add(suivantButton);
       
        panel.setLayout(null);
        
        backbtn = new JButton("<< Back");
        backbtn.setBounds(10, 571, 117, 31);
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	new InsertProject();
            	
            }
        });
        panel.add(backbtn);
        
         ajouterbtn = new JButton("Ajouter +");
         ajouterbtn.setBounds(315, 571, 89, 31);
        panel.add(ajouterbtn);
        
       
        getContentPane().add(panel);
        getContentPane().add(new Header(),BorderLayout.NORTH);
       
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}
