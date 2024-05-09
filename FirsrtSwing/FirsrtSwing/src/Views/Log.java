package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Log extends JFrame {

    private static final long serialVersionUID = -3881870082354815456L;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private controllers.VerifyLogin verifylogin;

    public Log() throws SQLException {
    	
    	verifylogin =	new controllers.VerifyLogin();
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setUndecorated(true); // Remove default window decorations
          setSize(600, 300);
          setLocationRelativeTo(null); // Center the frame on screen

        // Creating components
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 200));
        panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 128)));
        JPanel formPanel = new JPanel();
        formPanel.setBounds(20, 71, 560, 146);
        formPanel.setBackground(new Color(255, 255, 255));
        formPanel.setBorder(new LineBorder(new Color(255, 255, 255), 20));
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(20, 20, 560, 51);
        headerPanel.setBackground(new Color(128, 0, 128));
        //headerPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 257, 32);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 57, 257, 32);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        usernameField = new JTextField();
        usernameField.setBounds(282, 20, 257, 32);
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField = new JPasswordField();
        passwordField.setBounds(282, 57, 257, 32);
        formPanel.setLayout(null);
        // Adding components to the form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
         
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/close.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
 
        // Setting up background and borders
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        panel.add(headerPanel);
        headerPanel.setLayout(null);
        JButton closeButton = new JButton(scaledCloseIcon);
        closeButton.setBounds(477, 5, 73, 49);
        headerPanel.add(closeButton);
        closeButton.setHorizontalAlignment(SwingConstants.RIGHT);
        
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setForeground(Color.RED);
        
        JLabel lblNewLabel = new JLabel("Log in");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(271, 18, 57, 23);
        headerPanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application when close button is clicked
            }

			
        });
        
        panel.add(formPanel);

        // Adding main panel to the frame
        getContentPane().add(panel);
        
                JButton loginButton = new JButton("Login");
                loginButton.setBounds(50, 221, 156, 23);
                panel.add(loginButton);
                loginButton.setFont(new Font("Arial", Font.BOLD, 14));
                loginButton.setBackground(Color.green);
                loginButton.setPreferredSize(new Dimension(5, 10));
                JButton signInButton = new JButton("Sign In");
                signInButton.setBounds(374, 221, 174, 23);
                panel.add(signInButton);
                signInButton.setFont(new Font("Arial", Font.BOLD, 14));
                signInButton.setBackground(new Color(51, 204, 255));
                signInButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        verifylogin.signIn();
                    }

			
                });
                loginButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
				
				verifylogin.login(new Object[]{usernameField.getText(),new String(passwordField.getPassword())});
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Close the application when close button is clicked
                    }

		
                });

        setVisible(true);
    }
    
    public void Rejectlog() {
    	   JOptionPane.showMessageDialog(this, "Passwords ou le nom incorrecte !!!!", "Error", JOptionPane.ERROR_MESSAGE);
           return ;
    }
    
   
}
