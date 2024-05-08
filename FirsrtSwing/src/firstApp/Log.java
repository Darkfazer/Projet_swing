package firstApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log extends JFrame {

    private static final long serialVersionUID = -3881870082354815456L;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField txtLogIn;

    public Log() {
    	
    	
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setUndecorated(true); // Remove default window decorations
          setSize(600, 300);
          setLocationRelativeTo(null); // Center the frame on screen

        // Creating components
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 200));
        panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        JPanel formPanel = new JPanel();
        formPanel.setBounds(20, 71, 560, 146);
        formPanel.setLayout(new GridLayout(3, 2, 5, 5)); // Adding space between lines
        formPanel.setBackground(Color.ORANGE);
        formPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(20, 20, 560, 51);
        headerPanel.setLayout(new GridLayout(2, 2, 5, 5)); // Adding space between lines
        headerPanel.setBackground(Color.ORANGE);
        //headerPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signInButton = new JButton("Sign In");
        loginButton.setBackground(Color.green);
        loginButton.setPreferredSize(new Dimension(10, 10));
        // Adding components to the form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        
        txtLogIn = new JTextField();
        formPanel.add(txtLogIn);
        txtLogIn.setText("LOG IN");
        txtLogIn.setColumns(10);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Adding buttons to the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 217, 560, 63);
        buttonPanel.setBackground(Color.ORANGE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5)); // Adding space between buttons
        JButton closeButton ;
        ImageIcon closeIcon = new ImageIcon("/src//sources/close.png"); // Replace with your icon path
        closeButton = new JButton(closeIcon);
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setForeground(Color.RED);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application when close button is clicked
            }

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        headerPanel.add(closeButton);
      
        buttonPanel.add(loginButton);
        buttonPanel.add(signInButton);
 
        // Setting up background and borders
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

        // Adding panels to the main panel
        panel.add(headerPanel);
        panel.add(formPanel);
        panel.add(buttonPanel);

        // Adding main panel to the frame
        getContentPane().add(panel);

        setVisible(true);
    }
}
