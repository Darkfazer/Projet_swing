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
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(251, 187, 68));
        panel_1.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(255, 128, 64)));
        panel_1.setBounds(29, 67, 210, 217);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Title");
        lblNewLabel.setBounds(78, 11, 27, 16);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        panel_1.add(lblNewLabel);
        
        JTextPane txtpnHdefhDiFejfjefj = new JTextPane();
        txtpnHdefhDiFejfjefj.setForeground(new Color(0, 0, 0));
        txtpnHdefhDiFejfjefj.setBackground(new Color(251, 187, 68));
        txtpnHdefhDiFejfjefj.setText("hdefh di fejfjefj eifjkjfe ffjdj dkdkehfh fùefkdnz  dpoff f ffe ef ff");
        txtpnHdefhDiFejfjefj.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtpnHdefhDiFejfjefj.setBounds(10, 50, 174, 77);
        panel_1.add(txtpnHdefhDiFejfjefj);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setValue(20);
        progressBar.setForeground(new Color(255, 128, 64));
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setBounds(10, 139, 163, 14);
        panel_1.add(progressBar);
        
        JButton btnNewButton = new JButton("Detaille");
        btnNewButton.setBackground(new Color(255, 128, 64));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(45, 183, 89, 23);
        panel_1.add(btnNewButton);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(270, 67, 204, 217);
        panel.add(panel_2);
        setVisible(true); // Make the frame visible
    }
}
