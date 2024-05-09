package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignIn extends JDBC{
	 private static final String query = "INSERT INTO utilisateurs (username, type, password) VALUES (?, ?, ?)";
	 private  String username ;
	 private  String userType;
	 private  String password;
	 
	 public SignIn() throws SQLException {
		 super();
	        try {
	            insertUser(username, userType, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Gérer l'erreur d'insertion dans la base de données
	        } 
	    }

	    public void insertUser(String username, String userType, String password) throws SQLException {
	    	 PreparedStatement preparedStatement = null;
	        try {
	            // Préparation de la requête avec des paramètres
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, userType);
	            preparedStatement.setString(3, password);

	            // Exécution de la requête
	            preparedStatement.executeUpdate();
	            
	            System.out.println("Utilisateur enregistré avec succès !");
	        } finally {
	            // Fermeture des ressources
	            super.closeResources(preparedStatement, null);
	        }
	    }
	}
