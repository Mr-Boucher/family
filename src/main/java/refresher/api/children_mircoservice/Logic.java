package refresher.api.children_mircoservice;

import refresher.model.Person;
import refresher.util.Environment;
import refresher.util.Page;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Logic
{
  public Page<Person> readChildrenWithFather() throws Exception
  {
    Environment environment = new Environment();
    File file = environment.getFileFromResources("mysql_scripts//read_children_with_father.sql");

    String sql = environment.readStringFile(file);
    System.out.println( "executing:\n" + sql );

    Connection conn = environment.getDatabase().getConnection();

    // Statements allow to issue SQL queries to the database
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    List<Person> children = new ArrayList<>();

    while(resultSet.next()) {
      Person user = new Person();
      user.setFirstName(resultSet.getString("child_name"));
      user.setMothersName(resultSet.getString("mother_name"));
      user.setEmailAddress(resultSet.getString("email_address"));
      user.setPhoneNumber(resultSet.getString("phone_number"));
      user.setFathersName(resultSet.getString("father_name"));

      children.add(user);
    }

    System.out.println( children );

    Page<Person> page = new Page<>();
    page.setPageNumber( 1 );
    page.setTotalCount( 1 );
    page.setPageSize( 10 );
    page.setResultSet( children );

    return page;
  }
}
