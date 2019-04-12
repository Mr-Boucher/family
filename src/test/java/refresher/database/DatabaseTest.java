package refresher.database;

import org.junit.Before;
import org.junit.Test;
import refresher.model.Person;
import refresher.util.Environment;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest
{
  private Database database;

  @Before
  public void setUp() throws Exception
  {
    database = new Database();
    database.initialize();
  }

  @Test
  public void readChildrenWithFather() throws Exception
  {
    Environment environment = new Environment();
    File file = environment.getFileFromResources("mysql_scripts//read_children_with_father.sql");

    String sql = environment.readStringFile(file);
    System.out.println( "executing:\n" + sql );

    Connection conn = database.getConnection();

    // Statements allow to issue SQL queries to the database
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    List<Person> childern = new ArrayList<>();

    while(resultSet.next()) {
      Person user = new Person();
      user.setFirstName(resultSet.getString("child_name"));
      user.setMothersName(resultSet.getString("mother_name"));
      user.setEmailAddress(resultSet.getString("email_address"));
      user.setPhoneNumber(resultSet.getString("phone_number"));

      childern.add(user);
    }

    System.out.println( childern );
  }
}