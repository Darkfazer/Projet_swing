package controllers;

import java.sql.SQLException;

import javax.swing.SwingUtilities;



public class VerifyLogin {
	
	private static Boolean loginSuccessful;
	private static models.Log log;
	private static Views.Log start;
	static Views.SignIn signIn;
    private static Views.Acceuil acceuil;
	public VerifyLogin() throws SQLException {
		 acceuil =  new controllers.Acceuil().getAcceuil();
		
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
          new controllers.Acceuil().start();
        acceuil =  new controllers.Acceuil().getAcceuil();
      } else {
   	   new Views.Log().Rejectlog();
   	   }
		
	}

	}
	public void backlog() throws SQLException {
		signIn.setVisible(false);
		signIn.dispose(); // Release resources
         // Open the home page
       start =  new Views.Log();
	}
	
	public void signIn() {
		 start.setVisible(false);
         start.dispose(); // Release resources
         // Open the home page
       signIn =  new Views.SignIn();
	}
	
	 public static models.Log getLog() {
		return log;
	}


	public static Views.Log getStart() {
		return start;
	}


	public static Views.SignIn getSignIn() {
		return signIn;
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
