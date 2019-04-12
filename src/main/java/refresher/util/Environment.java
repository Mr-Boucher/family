package refresher.util;

import refresher.database.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Environment
{
  private Database database = new Database();

  public Database getDatabase()
  {
    return database;
  }


  public void initialize() throws Exception
  {
    database.initialize();
  }

  // get file from classpath, resources folder
  public File getFileFromResources(String fileName) {

    ClassLoader classLoader = getClass().getClassLoader();

    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }

  }

  /**
   *
   * @param file
   * @return
   * @throws IOException
   */
  public String readStringFile(File file) throws IOException
  {
    if (file == null)
      return null;

    StringBuilder builder = new StringBuilder();
    try (FileReader reader = new FileReader(file);
         BufferedReader br = new BufferedReader(reader)) {

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
        builder.append( line );
      }
    }

    return builder.toString();
  }

}
