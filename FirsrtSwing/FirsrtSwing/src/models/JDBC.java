package models;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/gestionconst";
    private static final String USERNAME = "houcine";
    private static final String PASSWORD = "1234";
    protected ResultSetMetaData resultData;
    protected ResultSet resultSet;
    protected DefaultTableModel model;
 
    public JDBC() throws SQLException {
    	
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    
    
    public DefaultTableModel selectData(Connection connection, String query) throws SQLException {
        
       
        try (Statement statement = connection.createStatement()) {
            // Exécuter la requête SQL pour récupérer les données de la table
        	
            resultSet = statement.executeQuery(query);
            java.sql.ResultSetMetaData resultData = resultSet.getMetaData(); // Retrieve metadata while ResultSet is still open

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


    
    public void insertData(Connection connection, String query) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    public void closeResources(PreparedStatement preparedStatement, Object object) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
   
    

    public ResultSetMetaData getResultData() {
        return resultData;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
    
    public DefaultTableModel getModel() {
    	return model;
    }
}
