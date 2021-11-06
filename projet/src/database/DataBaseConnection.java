
package database;

import java.sql.*;
import java.util.ArrayList;


public class DataBaseConnection {

	public static Connection connection = null;
	static Statement statement; 
	static PreparedStatement preparedStatement;
	static String url;
	static String databaseName;
	static String username;
	static String password;
	static int port;
	static String host_IP;
	static String host_DB;
  
  public static void initialiser() {
	  DataBaseConnection.host_IP = ParameterDataBase.HOST_IP;    
	  DataBaseConnection.host_DB = ParameterDataBase.HOST_DB;
	  DataBaseConnection.port = ParameterDataBase.PORT_DB;	
	  DataBaseConnection.databaseName = ParameterDataBase.DATABASE_NAME;
	  DataBaseConnection.username = ParameterDataBase.USERNAME_DB;
	  DataBaseConnection.password = ParameterDataBase.PASSWORD_DB;	  
    }

 public static  Connection connecter() throws ClassNotFoundException, SQLException{      
	
	  	Class.forName("com.mysql.jdbc.Driver");  
	  	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabasejava", "root", "");
	  	return connection;
 }
 
   public static Connection deconnecter() throws SQLException {	        
        connection.close(); 
        return connection;
    }

    public static ResultSet executionQuery(String sql) throws SQLException {
    	ResultSet resultSet = null;        
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static int executionUpdate(String sql) throws SQLException {             
        statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }
    
}
