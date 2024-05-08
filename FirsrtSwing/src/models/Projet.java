package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Projet extends  JDBC {

	public Projet() throws SQLException {
		super();
		super.selectData(getConnection(), "SELECT * FROM projets");
	}
	
	 public  DefaultTableModel selectProjet(String option) throws SQLException {
	        PreparedStatement preparedStatement = null;
	        String query = "SELECT * FROM projets WHERE echancier = ? ";

	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, option);
	           
	            resultSet = preparedStatement.executeQuery();
	            java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

	            model = new DefaultTableModel();
	            // Ajouter les colonnes au modèle de tableau
	            int columnCount = resultData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultData.getColumnName(i));
	            }

	            // Ajouter les lignes au modèle de tableau
	            while (resultSet.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    rowData[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(rowData);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	        }
	        return model;
	    }

 
}
