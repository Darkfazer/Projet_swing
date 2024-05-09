package Views;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Acceuil extends JFrame {

    private static final long serialVersionUID = -8908347619125949159L;
  
    public Acceuil(String userType) throws SQLException {
        super("Gestion de Construction");
        getContentPane().setBackground(new Color(255, 255, 255));
        setAlwaysOnTop(true);
        setBackground(new Color(240, 240, 240));
        setFont(new Font("Arial", Font.ITALIC, 14));
        setForeground(new Color(242, 218, 79));
        setIconImage(Toolkit.getDefaultToolkit().getImage(Acceuil.class.getResource("/sources/close.png")));
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setType(Window.Type.POPUP);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));
      
            
         
       getContentPane().add(new Header(),BorderLayout.NORTH);
       getContentPane().add(new Tasks(),BorderLayout.WEST);
      getContentPane().add(new ProjectCard(),BorderLayout.CENTER);
     
        setVisible(true);
    }
}
