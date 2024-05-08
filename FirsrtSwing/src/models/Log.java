package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Log extends JDBC {
    private String username;
    private String password;
    private String type;
    private static final String query = "SELECT type FROM utilisateurs WHERE username = ? AND password = ?";

    public Log(String username, String password) throws SQLException {
        super();
        this.username = username;
        this.password = password;
    }

    public Boolean selectUser() throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

            // Print column names
            int columnCount = resultData.getColumnCount();
           

            // Print data rows
            while (resultSet.next()) {
                System.out.println("Data:");
                for (int i = 1; i <= columnCount; i++) {
                	 Object value = resultSet.getObject(i);
                    type = (value != null) ? value.toString() : ""; // Convert object to string
                     System.out.println("  " + resultData.getColumnName(i) + ": " + type);
                 }
                return true;
            }

          
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return false;
    }

	public String getType() {
		return type;
	}


}
