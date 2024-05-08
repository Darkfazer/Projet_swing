package controllers;

import java.sql.SQLException;

import javax.swing.SwingUtilities;



public class VerifyLogin {
	
	private static Boolean loginSuccessful;
	static models.Log log;
	static Views.Log start;
	static Views.SignIn signIn;
    private static Views.Acceuil acceuil;
	public VerifyLogin() throws SQLException {
	
		
	}
	
	
	public void login(Object[] signInData) throws SQLException{
		if (signInData != null) {
		    String username = (String) signInData[0];
		    String password = (String) signInData[1];
		log = new models.Log(username,password);
		
	
	loginSuccessful = (log.selectUser())? true : false;
	 
	  if (loginSuccessful) {
          // Close the login frame
          start.setVisible(false);
          start.dispose(); // Release resources
          // Open the home page
        acceuil =  new Views.Acceuil(log.getType());
      } else {
   	   new Views.Log().Rejectlog();
   	   }
		
	}

	}
	public void backlog() throws SQLException {
		signIn.setVisible(false);
		signIn.dispose(); // Release resources
         // Open the home page
         new Views.Log();
	}
	
	public void signIn() {
		 start.setVisible(false);
         start.dispose(); // Release resources
         // Open the home page
       signIn =  new Views.SignIn();
	}
	
	 public static void main(String[] args) throws SQLException {
	    	
		 SwingUtilities.invokeLater(new Runnable() {
			 
	            public void run() {
	             
	            	try {
						start =   new Views.Log();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	//new Views.Acceuil("log");
	         
	            	
	            }
	          
	        });
		

	}


	public static Views.Acceuil getAcceuil() {
		return acceuil;
	}

}
