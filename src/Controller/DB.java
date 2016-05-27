package Controller; 
import java.sql.*;

public class DB {

  private static Connection conn ; 
	
  public DB (){
	  try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      String database = "jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab";
      String user = "a+MatrNr";
      String pass = "Oracle-Passwort";

      // establish connection to database 
      try {
		 conn = DriverManager.getConnection(database, user, pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void saveData(String sql){
	  
	  try {
	      
	      Statement stmt = conn.createStatement();
	      try {
	        String insertSql = sql;
	        stmt.executeUpdate(insertSql);
	      } catch (Exception e) {
	        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
	      }

	      stmt.close();
	      conn.close();

	    } catch (Exception e) {
	      System.err.println(e.getMessage());
	    }	  
  }
  
  
 
  
}
