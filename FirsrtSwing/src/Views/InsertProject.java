package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertProject extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3938293449889104031L;
	private JTextField nomProjetField, clientField , dateDebutField, dateFinField, budgetField,adresseProjetField;
    private JComboBox<String> echancierCombo, typeProjetCombo , chefProjetField;
    private JButton suivantButton;
   

    public InsertProject() {
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
        String[] chefProjet = {"chef A", "chef B", "chef C"};
        chefProjetField = new JComboBox<>(chefProjet);
        chefProjetField.setBounds(234, 218, 243, 36);
        
        panel.add(chefProjetField);

        JLabel label_4 = new JLabel("Date de Début:");
        label_4.setBounds(94, 265, 98, 36);
        panel.add(label_4);
        dateDebutField = new JTextField();
        dateDebutField.setBounds(234, 265, 243, 36);
        panel.add(dateDebutField);

        JLabel label_5 = new JLabel("Date de Fin:");
        label_5.setBounds(94, 312, 98, 36);
        panel.add(label_5);
        dateFinField = new JTextField();
        dateFinField.setBounds(234, 312, 243, 36);
        panel.add(dateFinField);

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
                // Ici, vous pouvez ajouter le code pour enregistrer les données du projet
                // Par exemple, vous pouvez récupérer les valeurs des champs comme suit :
                String nomProjet = nomProjetField.getText();
                String adresseProjet = adresseProjetField.getText();
                String client = clientField.getText();
                String chefProjet = (String) chefProjetField.getSelectedItem();
                String dateDebut = dateDebutField.getText();
                String dateFin = dateFinField.getText();
                String budget = budgetField.getText();
                String echancier = (String) echancierCombo.getSelectedItem();
                String typeProjet = (String) typeProjetCombo.getSelectedItem();

                // Ensuite, vous pouvez traiter ces valeurs comme bon vous semble, par exemple les imprimer :
                System.out.println("Nom de Projet: " + nomProjet);
                System.out.println("Adresse de Projet: " + adresseProjet);
                System.out.println("Client: " + client);
                System.out.println("Chef de Projet: " + chefProjet);
                System.out.println("Date de Début: " + dateDebut);
                System.out.println("Date de Fin: " + dateFin);
                System.out.println("Budget: " + budget);
                System.out.println("Échéancier: " + echancier);
                System.out.println("Type de Projet: " + typeProjet);

                // Vous pouvez également appeler une méthode pour enregistrer ces données dans une base de données, par exemple
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
}
