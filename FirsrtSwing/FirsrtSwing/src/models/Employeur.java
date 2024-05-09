package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Employeur extends JDBC{

	public Employeur() throws SQLException {
		super();
		super.selectData(getConnection(), "SELECT * FROM employeur");
	}
	
	 public  DefaultTableModel selectEmpl(String option) throws SQLException {
	        PreparedStatement preparedStatement = null;
	        DefaultTableModel mode = new DefaultTableModel();
	        String query = "SELECT * FROM employeur WHERE post = ? ";

	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, option); 
	           
	            resultSet = preparedStatement.executeQuery();
	            java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

	            mode = new DefaultTableModel(); 
	            // Ajouter les colonnes au modèle de tableau
	            int columnCount = resultData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	            	
	            	if(i==1) { mode.addColumn("selectionner");}
	            	else {
	                mode.addColumn(resultData.getColumnName(i));}
	            
	            }

	            // Ajouter les lignes au modèle de tableau
	            while (resultSet.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                	
	                	if(i==1) {
	                		rowData[i - 1] = false;
	                      }else { rowData[i - 1] = resultSet.getObject(i);}
	                }
	                mode.addRow(rowData);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	        }
	        return mode;
	    }
	 
	 public void updateEmp(String value,String nomtache,String nomprojet) {
		 String sqlUpdate = "UPDATE employeur SET idtache = (SELECT id FROM maconnerie WHERE nomTache = ? AND idprojet = (SELECT idProjet FROM projets WHERE nomProjet =?)), idProjet =(SELECT idProjet FROM projets WHERE nomProjet =?) WHERE nom = ?";
		  try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlUpdate);) {
			  
			  preparedStatement.setString(1, nomtache);
			  preparedStatement.setString(2, nomprojet);
			  preparedStatement.setString(3, nomprojet);
			  preparedStatement.setString(4, value);
			  int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("Nombre de lignes affectées : " + rowsAffected);
	         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	 }
	 public void deleteUpdatedFields(String value) {
		    String sqlDelete = "UPDATE employeur SET idtache = NULL, idprojet = NULL WHERE nom = ?";
		    try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlDelete)) {
		        preparedStatement.setString(1, value);
		        int rowsAffected = preparedStatement.executeUpdate();
		        //System.out.println("Nombre de lignes affectées par la suppression des champs mis à jour : " + rowsAffected);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
