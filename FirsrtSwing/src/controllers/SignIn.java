package controllers;

import java.sql.SQLException;

public class SignIn {
	
	public SignIn() {
		
		
		
	}
	
public void InsertData(Object[] signInData) throws SQLException {
	
	
	models.SignIn info = new models.SignIn();
	
	
	if (signInData != null) {
	    String username = (String) signInData[0];
	    String userType = (String) signInData[1];
	    String password = (String) signInData[2];
		info.insertUser(username, userType, password);
	}
	

	
}

}
