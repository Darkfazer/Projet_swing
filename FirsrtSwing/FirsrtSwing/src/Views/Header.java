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

public class Header extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8295758189057141490L;

    public Header() {
        setBackground(new Color(142, 44, 150));
        setBorder(new LineBorder(new Color(255, 255, 255), 2));
                       
                        JLabel lblLesTaches = new JLabel("Les taches");
                        lblLesTaches.setForeground(new Color(255, 255, 255));
                        lblLesTaches.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                JLabel lblLesProjets = new JLabel("Les projets");
                lblLesProjets.setForeground(new Color(255, 255, 255));
                lblLesProjets.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                JLabel lblLesEmplois = new JLabel("Les emplois");
                lblLesEmplois.setForeground(new Color(255, 255, 255));
                lblLesEmplois.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                JLabel lblLogOut = new JLabel("stockage");
                lblLogOut.setForeground(new Color(255, 255, 255));
                lblLogOut.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                
                JLabel lblLogOutIcon = new JLabel("log out");
                lblLogOutIcon.setHorizontalAlignment(SwingConstants.CENTER);
                lblLogOutIcon.setForeground(Color.WHITE);
                lblLogOutIcon.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                ImageIcon originalIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/log_out.jpeg");

                // Resize the image to a smaller size
                Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                
                
                        // Set the scaled icon to the label
                        lblLogOutIcon.setIcon(scaledIcon);
                        
                        JLabel lblHomme = new JLabel("Homme");
                        lblHomme.setForeground(Color.WHITE);
                        lblHomme.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
                        GroupLayout groupLayout = new GroupLayout(this);
                        groupLayout.setHorizontalGroup(
                        	groupLayout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(groupLayout.createSequentialGroup()
                        			.addGap(46)
                        			.addComponent(lblHomme, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        			.addGap(18)
                        			.addComponent(lblLesTaches, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        			.addGap(42)
                        			.addComponent(lblLesProjets)
                        			.addGap(39)
                        			.addComponent(lblLesEmplois)
                        			.addGap(37)
                        			.addComponent(lblLogOut, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        			.addGap(18)
                        			.addComponent(lblLogOutIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        			.addGap(134))
                        );
                        groupLayout.setVerticalGroup(
                        	groupLayout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(groupLayout.createSequentialGroup()
                        			.addGap(1)
                        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        				.addComponent(lblLogOutIcon, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        				.addComponent(lblLogOut, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        				.addComponent(lblLesEmplois, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        				.addComponent(lblLesProjets, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        				.addComponent(lblLesTaches, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        				.addComponent(lblHomme, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        			.addContainerGap())
                        );
                        setLayout(groupLayout);
                        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLesTaches, lblLesProjets, lblLesEmplois, lblLogOut, lblLogOutIcon, lblHomme}));
                        

       
    }

   
}
