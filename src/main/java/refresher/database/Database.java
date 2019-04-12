package refresher.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
  public void initialize() throws Exception
  {
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
  }

  public Connection getConnection() throws SQLException
  {
    Connection conn = null;

    try
    {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/family_db?" + "user=testuser&password=Password1");

    }
    catch(SQLException ex)
    {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      throw ex;
    }

    return conn;
  }
}
