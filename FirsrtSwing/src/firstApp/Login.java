package firstApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    
	private static final long serialVersionUID = -3881870082354815456L;
	private JTextField usernameField;
    private JPasswordField passwordField;

    public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
   
	
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 300);
        setLocationRelativeTo(null); // Center the frame on screen
       
        
        // Creating components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(600, 200));
        panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 5, 5)); // Adding space between lines
        formPanel.setBackground(Color.ORANGE);
        formPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signInButton = new JButton("Sign In");
      
        // Adding components to the form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Adding buttons to the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.ORANGE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5)); // Adding space between buttons
        buttonPanel.add(loginButton);
        buttonPanel.add(signInButton);
     
        // Setting up background and borders
        panel.setBackground(Color.ORANGE);
       

        // Adding panels to the main panel
       
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding main panel to the frame
        add(panel);

        setVisible(true);
     // Assuming this code is inside the Login class

     // Adding action listener to the login button
     loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             String username = usernameField.getText();
             char[] passwordchar = passwordField.getPassword();
             // Call the method to process the username data
             processData(username,new String(passwordchar));
         }
     });
    }

     // Method to process the username data
     private void processData(String username, String password) {
         // Perform any necessary processing with the username
         // For example, pass it to another class or display it
         BackLog data = new BackLog();
         data.getValue(username , password);
     }


    
    
    
    
	

    
}
