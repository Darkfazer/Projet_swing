package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

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
        panel.setBorder(new LineBorder(new Color(255, 255, 255), 40));
        JPanel formPanel = new JPanel();
        formPanel.setBounds(20, 71, 560, 146);
        formPanel.setLayout(new GridLayout(3, 2, 5, 5)); // Adding space between lines
        formPanel.setBackground(Color.ORANGE);
        formPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(20, 20, 560, 51);
        headerPanel.setBackground(Color.ORANGE);
        //headerPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        usernameField = new JTextField();
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        JButton signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.setBackground(new Color(51, 204, 255));
        loginButton.setBackground(Color.green);
        loginButton.setPreferredSize(new Dimension(5, 10));
        // Adding components to the form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Adding buttons to the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 217, 560, 63);
        buttonPanel.setBackground(Color.ORANGE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5)); // Adding space between buttons
         
        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/close.png"); // Replace with your icon path
        Image scaledImage = closeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
      
        buttonPanel.add(loginButton);
        buttonPanel.add(signInButton);
 
        // Setting up background and borders
        panel.setBackground(Color.ORANGE);
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
        lblNewLabel.setBounds(271, 18, 57, 23);
        headerPanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application when close button is clicked
            }

			
        });
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
        
        panel.add(formPanel);
        panel.add(buttonPanel);

        // Adding main panel to the frame
        getContentPane().add(panel);

        setVisible(true);
    }
    
    public void Rejectlog() {
    	   JOptionPane.showMessageDialog(this, "Passwords ou le nom incorrecte !!!!", "Error", JOptionPane.ERROR_MESSAGE);
           return ;
    }
    
   
}
