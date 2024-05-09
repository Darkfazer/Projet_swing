package models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Taches extends  JDBC {

	public Taches() throws SQLException {
		super();
		super.selectData(getConnection(), "SELECT * FROM maconnerie");
	}
	
	public int Idempl(String nom,int indix) throws SQLException {
		String sql = "SELECT id FROM employeur WHERE nom = ?";
		String sqlone = "SELECT idProjet FROM projets WHERE nomProjet = ?";
		int idEmploye= -1;
		 PreparedStatement preparedStatement = null;
		  try {
			  if(indix ==0) {
		        preparedStatement = getConnection().prepareStatement(sql);
		        }else { 
		        	  preparedStatement = getConnection().prepareStatement(sqlone);
		        }
		        preparedStatement.setString(1, nom);
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   
                    if (resultSet.next()) {
                    	 if(indix ==0) {
                    		 idEmploye = resultSet.getInt("id");
             		        }else {
             		        	 idEmploye = resultSet.getInt("idProjet");
             		        }
                       
                    }
                }
		       
		        return idEmploye;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		           
		        }
		    }
		    return idEmploye;
		}

	 public void deleteTache(String nomTache, String nomProjet) throws SQLException {
	        String query = "DELETE FROM maconnerie WHERE nomTache = ? AND idprojet = (SELECT idProjet FROM projets WHERE nomProjet = ?)";
	        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
	            preparedStatement.setString(1, nomTache);
	            preparedStatement.setString(2, nomProjet);
	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("La tâche a été supprimée avec succès.");
	            } else {
	                System.out.println("Aucune tâche correspondante n'a été trouvée.");
	            }
	        }
	    }
	
	 public Boolean InserTache(Object[] model ,String nomProjet) throws SQLException, ParseException {
		  
		    String query = "INSERT INTO maconnerie (idresponsable, echancier, dateDebut, dateFin, charges, remarque, structure,nomTache,idprojet) " +
		                   "VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
		  
		    System.out.println("Je suis en train d'insérer");

		    try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
	            preparedStatement.setInt(1, Idempl((String) model[0],0));
	            preparedStatement.setString(2, (String) model[1]);
	            preparedStatement.setDate(3, (Date) model[2]); 
	            preparedStatement.setDate(4, (Date) model[3]);
	            preparedStatement.setBigDecimal(5, (BigDecimal) model[4]);
	            preparedStatement.setString(6, (String) model[5]);
	            preparedStatement.setString(7, (String) model[6]);             
	            preparedStatement.setString(8, (String) model[7]); 
	            preparedStatement.setInt(9, Idempl((String) nomProjet,1)); 

	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("Nombre de lignes affectées : " + rowsAffected);
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	

}
