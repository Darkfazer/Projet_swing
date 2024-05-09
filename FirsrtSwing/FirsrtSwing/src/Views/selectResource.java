package Views;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class selectResource extends JFrame {

    private static final long serialVersionUID = 5622089067006753143L;
    private JTextField txtEnmploys;
    private DefaultTableModel model;
    private JTable table;
    private  String selectedItem;

    public selectResource(JList<String> jList,String[] nom) throws SQLException {
    	getContentPane().setBackground(new Color(255, 255, 255));
        setSize(800, 700);
        getContentPane().setLayout(null);
        setTitle("Insertion de Projet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setUndecorated(true); // Remove default window decorations
        
        setLocationRelativeTo(null);
      
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/slide2.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance( 400, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
        JLabel slide = new JLabel(scaledCloseIcon);
        slide. setBounds(10, 49, 692, 100);
        getContentPane().add(slide);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
        panel.setBounds(10, 199, 143, 295);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());


        model = new models.Employeur().selectEmpl("ouvrier");
        jList.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
     	   @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Récupérer l'élément sélectionné dans la liste
                   selectedItem = jList.getSelectedValue();
                    try {
						model = new models.Employeur().selectEmpl(selectedItem);
						table.setModel(model);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}    
                    // Votre action à effectuer en fonction de l'élément sélectionné
                    System.out.println("Élément sélectionné : " + selectedItem);
                    
                    // Par exemple, vous pouvez mettre à jour d'autres composants en fonction de la sélection
                }
            }

     	
        });
        JScrollPane scrollPane = new JScrollPane(jList);
        jList.setFixedCellHeight(30); // Hauteur fixe pour chaque cellule
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(175, 81, 189));
        panel_1.setBounds(151, 199, 623, 295);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
       
       
       table = new JTable(model) {
           
			private static final long serialVersionUID = -7012984924076092893L;

			@Override
            public Class getColumnClass(int column) {
                if (column == 0) {
                    return Boolean.class; // Pour la première colonne, le type de données est boolean (cases à cocher)
                } else {
                    return super.getColumnClass(column);
                }
            }
        };
        JScrollPane scrollPane_1 = new JScrollPane(table);
        scrollPane_1.setBounds(10, 11, 519, 209);
        panel_1.add(scrollPane_1);
       
        JButton btnNewButton = new JButton("Ajouter");
        btnNewButton.setBounds(10, 241, 122, 31);
        panel_1.add(btnNewButton);
        
        JButton btnNewButton_2 = new JButton("Supprimer");
        btnNewButton_2.setBounds(402, 237, 98, 31);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le modèle de la table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // Créer un tableau pour stocker les valeurs de la colonne 1 des lignes sélectionnées
                ArrayList<String> values = new ArrayList<>();
                // Parcourir les lignes de la table
                for (int i = 0; i < model.getRowCount(); i++) {
                    // Vérifier si la case à cocher de la première colonne est cochée
                    Boolean isChecked = (Boolean) model.getValueAt(i, 0);
                    if (isChecked != null && isChecked) {
                        // Récupérer la valeur de la colonne 1 de la ligne actuelle
                        String value = (String) model.getValueAt(i, 1);
                        try {
							new models.Employeur().deleteUpdatedFields(value);
							 model.setRowCount(0); // Effacer toutes les lignes existantes
						    
						        model = new models.Employeur().selectEmpl("chefProjet");
						        // Mettre à jour la table avec le nouveau modèle
						        table.setModel(model);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        // Ajouter la valeur au tableau
                       
                    }
                }
               
            }
        });
        panel_1.add(btnNewButton_2);
        
        txtEnmploys = new JTextField();
        txtEnmploys.setHorizontalAlignment(SwingConstants.CENTER);
        txtEnmploys.setText("enmployés");
        txtEnmploys.setBounds(527, 55, 86, 20);
        panel_1.add(txtEnmploys);
        txtEnmploys.setColumns(10);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le modèle de la table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // Créer un tableau pour stocker les valeurs de la colonne 1 des lignes sélectionnées
                ArrayList<String> values = new ArrayList<>();
                // Parcourir les lignes de la table
                for (int i = 0; i < model.getRowCount(); i++) {
                    // Vérifier si la case à cocher de la première colonne est cochée
                    Boolean isChecked = (Boolean) model.getValueAt(i, 0);
                    if (isChecked != null && isChecked) {
                        // Récupérer la valeur de la colonne 1 de la ligne actuelle
                        String value = (String) model.getValueAt(i, 1);
                        try {
                        	if(selectedItem==null) {
							new models.Employeur().updateEmp(value,nom[0], nom[1]);
                        	}else {
                        		nom[0]=selectedItem;
                        	new models.Employeur().updateEmp(value,nom[0], nom[1]);	
                        	}
							 model.setRowCount(0); // Effacer toutes les lignes existantes
						       
						        model = new models.Employeur().selectEmpl("chefProjet");
						        // Mettre à jour la table avec le nouveau modèle
						        table.setModel(model);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        // Ajouter la valeur au tableau
                       
                    }
                }
               
            }
        });


        Header header = new Header();
        header.setBounds(0, 0, 800, 41); 
        getContentPane().add(header, BorderLayout.NORTH);
        
        JButton btnNewButton_1 = new JButton("Suivant >>");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        btnNewButton_1.setBounds(661, 521, 113, 31);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					new controllers.Produit().suivant(jList, nom);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }});
        getContentPane().add(btnNewButton_1);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        String[] data = {"peinture", "charpenterie", "Maçonnerie", "Item 4", "Item 5"};
        JList<String> jList = new JList<>(data);
        String[] nom = {"peinture","project R"};
        new selectResource(jList,nom);
    }
}
