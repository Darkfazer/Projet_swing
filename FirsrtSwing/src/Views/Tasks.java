package Views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Tasks extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8295758189057141490L;
	public Tasks() {
		setBackground(new Color(238, 147, 11));
		setBorder(new LineBorder(new Color(255, 255, 255), 2));

	 setPreferredSize(new Dimension(200, 600)); // Définir la taille du menu latéral

     // Créer des boutons pour les différentes options du menu
     JLabel accueilButton = new JLabel("Accueil");
     accueilButton.setBackground(new Color(238, 147, 11));
     accueilButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
     accueilButton.setForeground(new Color(255, 255, 255));
     accueilButton.setHorizontalAlignment(SwingConstants.CENTER);
     JLabel projetsButton = new JLabel("Projets");
     projetsButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
     projetsButton.setForeground(new Color(255, 255, 255));
     projetsButton.setHorizontalAlignment(SwingConstants.CENTER);
     projetsButton.setBackground(new Color(238, 147, 11));
     JLabel clientsButton = new JLabel("Clients");
     clientsButton.setBackground(new Color(238, 147, 11));
     clientsButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
     clientsButton.setForeground(new Color(255, 255, 255));
     clientsButton.setHorizontalAlignment(SwingConstants.CENTER);
     JLabel equipesButton = new JLabel("Équipes");
     equipesButton.setBackground(new Color(238, 147, 11));
     equipesButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
     equipesButton.setForeground(new Color(255, 255, 255));
     equipesButton.setHorizontalAlignment(SwingConstants.CENTER);
     JLabel parametresButton = new JLabel("Paramètres");
     parametresButton.setBackground(new Color(238, 147, 11));
     parametresButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
     parametresButton.setForeground(new Color(255, 255, 255));
     parametresButton.setHorizontalAlignment(SwingConstants.RIGHT);

   

     // Ajouter les boutons au menu latéral
     setLayout(new GridLayout(5, 1, 0, 10)); // 5 lignes, 1 colonne, espacement vertical de 10 pixels
     add(accueilButton);
     add(projetsButton);
     add(clientsButton);
     add(equipesButton);
     add(parametresButton);
    
	}
}