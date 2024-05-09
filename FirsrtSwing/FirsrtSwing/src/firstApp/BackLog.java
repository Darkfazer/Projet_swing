package firstApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.math.BigDecimal;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class BackLog extends JFrame {
   
    public BackLog() {
     
        // Set frame properties
        setTitle("Back Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500,500);
        setLocationRelativeTo(null); // Center the frame on screen
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setSize(500,500);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("ajouter projet +");
        btnNewButton.setBackground(new Color(255, 128, 64));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(150, 166, 173, 32);
        panel.add(btnNewButton);
        
       
       
        setVisible(true); // Make the frame visible
    }
}
