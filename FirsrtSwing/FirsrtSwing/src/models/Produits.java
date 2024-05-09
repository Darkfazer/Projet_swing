package models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.table.DefaultTableModel;

public class Produits extends JDBC {

	public Produits() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int Idempl(String nomtache,String nompro,int indix) throws SQLException {
		String sql = "SELECT id FROM maconnerie WHERE nomTache = ? AND idprojet = ?";
		String sqlone = "SELECT idProjet FROM projets WHERE nomProjet = ?";
		int id= -1;
		 PreparedStatement preparedStatement = null;
		  try {
			  if(indix ==0) {
		        preparedStatement = getConnection().prepareStatement(sql);
		        preparedStatement.setString(1,(String) nomtache);
		        preparedStatement.setInt(2,(Integer) Idempl(nomtache,nompro,1));
		        }else { 
		        	  preparedStatement = getConnection().prepareStatement(sqlone);
		        	  preparedStatement.setString(1,(String) nompro);
		        }
		        
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   
                    if (resultSet.next()) {
                    	 if(indix ==0) {
                    		 id = resultSet.getInt("id");
             		        }else {
             		        	 id = resultSet.getInt("idProjet");
             		        }
                       
                    }
                }
		       
		        return id;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		           
		        }
		    }
		    return id;
		}
	
	
	 public Boolean InsertProduits(Object[] model) throws SQLException, ParseException {
		  
		 String query = "INSERT INTO produits (nomProduit, type, idtache, idprojet, quantite, prix_total, description) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement preparedStatement = null;
		    System.out.println("Je suis en train d'insérer");

		    try {
		        preparedStatement = getConnection().prepareStatement(query);
		        preparedStatement.setString(1, (String) model[0]);
		        preparedStatement.setString(2, (String) model[1]);
		        preparedStatement.setInt(3, (Integer) Idempl((String) model[2],(String) model[3],0));
		        preparedStatement.setInt(4,(Integer)  Idempl((String) model[3],(String) model[3],1));    
		        preparedStatement.setInt(5, (Integer) model[4]);
		        preparedStatement.setBigDecimal(6, (BigDecimal) model[5]);
		        preparedStatement.setString(7, (String) model[6]);
		       
		     
		        preparedStatement.executeUpdate();
		        System.out.println("Projet enregistré avec succès !");
		        return true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		            System.out.println("Je n'ai pas réussi");
		        }
		    }
		    return false;
		}
	
	 public  DefaultTableModel selectpro(String tache,String projet) throws SQLException {
	        PreparedStatement preparedStatement = null;
	        DefaultTableModel mode = new DefaultTableModel();
	        String query = "SELECT * FROM produits WHERE idtache = (SELECT id FROM maconnerie WHERE nomTache = ? AND idprojet = (SELECT idProjet FROM projets WHERE nomProjet =?)) AND idprojet =(SELECT idProjet FROM projets WHERE nomProjet =?)";

	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, tache); 
	            preparedStatement.setString(2, projet); 
	            preparedStatement.setString(3, projet); 
	           
	            resultSet = preparedStatement.executeQuery();
	            java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

	            mode = new DefaultTableModel(); 
	            // Ajouter les colonnes au modèle de tableau
	            int columnCount = resultData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	            	
	            	
	                mode.addColumn(resultData.getColumnName(i));
	            
	            }

	            // Ajouter les lignes au modèle de tableau
	            while (resultSet.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                	
	                	rowData[i - 1] = resultSet.getObject(i);
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
	 
	 public void deleteProduit(int idProduit) {
		 String query = "DELETE FROM produits WHERE id= ?";
		 PreparedStatement preparedStatement = null;
		 
		    try {
		    	preparedStatement=getConnection().prepareStatement(query);
		        preparedStatement.setInt(1, (Integer) idProduit);
		       
		     
		        preparedStatement.executeUpdate();
		        System.out.println("Produit supprimé avec succès !");
		        return ;
		    } catch (SQLException e) {
		    	System.out.println("Je n'ai pas réussi");
		        e.printStackTrace();
		    } 
		           
		        
		    }
		 		
		 
	 }

