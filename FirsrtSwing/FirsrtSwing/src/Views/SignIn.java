package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

public class SignIn extends JFrame {

	  private static final long serialVersionUID = -3881870082354815456L;
	    private JTextField usernameField;
	    private JComboBox<String> userTypeComboBox;
	    private JPasswordField passwordField;
	    private JPasswordField confirmPasswordField;
	    public SignIn() {
	    	getContentPane().setEnabled(false);
	    	getContentPane().setBackground(new Color(225, 231, 24));
	    	
	    	
	          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	          //setUndecorated(true); // Remove default window decorations
	          setSize(600, 600);
	          setLocationRelativeTo(null); // Center the frame on screen

	        // Creating components
	      JPanel panel = new JPanel();
	        panel.setBorder(new LineBorder(new Color(255, 255, 255), 5));
	        JPanel headerPanel = new JPanel();
	        headerPanel.setBounds(10, 11, 580, 51);
	        headerPanel.setBackground(new Color(255, 128, 64));
	        String[] userTypes = {"Admin", "Employer"};
	         
	        ImageIcon closeIcon = new ImageIcon("C://Users//HYPER//eclipse-workspace//FirsrtSwing//src//sources/close.png"); // Replace with your icon path
	        Image scaledImage = closeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	        ImageIcon scaledCloseIcon = new ImageIcon(scaledImage);
	 
	        // Setting up background and borders
	        panel.setBackground(new Color(255, 255, 128));
	        panel.setLayout(null);
	       // panel.add(headerPanel);
	        headerPanel.setLayout(null);
	        headerPanel.setPreferredSize(new Dimension(600, 50));
	        
	        JLabel lblNewLabel = new JLabel("Authentifier");
	        lblNewLabel.setBounds(224, 11, 139, 23);
	        headerPanel.add(lblNewLabel);
	        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        

	        // Adding main panel to the frame
	        getContentPane().add(panel, BorderLayout.NORTH);
	        confirmPasswordField = new JPasswordField();
	        confirmPasswordField.setBounds(220, 241, 257, 27);
	        panel.add(confirmPasswordField);
	        JLabel compasswordLabel = new JLabel("Comfirm Password:");
	        compasswordLabel.setBounds(39, 235, 168, 33);
	        compasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        compasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        panel.add(compasswordLabel);
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(39, 197, 158, 27);
	        panel.add(passwordLabel);
	        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        userTypeComboBox = new JComboBox<String>(userTypes);
	        userTypeComboBox.setBounds(220, 154, 257, 33);
	        panel.add(userTypeComboBox);
	        passwordField = new JPasswordField();
	        passwordField.setBounds(220, 198, 257, 27);
	        panel.add(passwordField);
	        JLabel typeLabel = new JLabel("type:");
	        typeLabel.setBounds(49, 142, 111, 44);
	        panel.add(typeLabel);
	        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        
	                usernameField = new JTextField();
	                usernameField.setBounds(220, 102, 257, 27);
	                panel.add(usernameField);
	                //headerPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));

	                JLabel usernameLabel = new JLabel("Username:");
	                usernameLabel.setBounds(39, 98, 158, 33);
	                panel.add(usernameLabel);
	                usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	                usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
	                JButton signInButton = new JButton("Sign In");
	                signInButton.setBounds(326, 414, 145, 38);
	                panel.add(signInButton);
	                signInButton.setFont(new Font("Arial", Font.BOLD, 14));
	                signInButton.setBackground(new Color(0, 255, 0));
	                
	                getContentPane().add(headerPanel,BorderLayout.NORTH);
	                JButton closeButton = new JButton(scaledCloseIcon);
	                closeButton.setBounds(29, 0, 73, 49);
	                headerPanel.add(closeButton);
	                closeButton.setHorizontalAlignment(SwingConstants.RIGHT);
	                
	                closeButton.setFocusable(false);
	                closeButton.setContentAreaFilled(false);
	                closeButton.setBorderPainted(false);
	                closeButton.setForeground(Color.RED);
	                
	                  closeButton.addActionListener(new ActionListener() {
	                      public void actionPerformed(ActionEvent e) {
	                         try {
								new controllers.VerifyLogin().backlog();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} // Close the application when close button is clicked
	                          
	                      }

				
	                  });
	                getContentPane().add(panel,BorderLayout.CENTER);
	                signInButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        try {
								signIn();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                    }
	                });

        setVisible(true);
    }
    
    public void signIn() throws SQLException {
        String username = usernameField.getText();
        String userType = (String) userTypeComboBox.getSelectedItem();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Validate input (e.g., check if passwords match, username is not empty, etc.)
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        // Return username, user type, and password
        controllers.SignIn data = new controllers.SignIn();
        data.InsertData(new Object[]{username, userType, password});
        JOptionPane.showMessageDialog(this, "utilisateur ajouter avec succé", "....", JOptionPane.INFORMATION_MESSAGE);
        return ;
    }


  
}
