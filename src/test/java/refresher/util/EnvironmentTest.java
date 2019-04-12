package refresher.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class EnvironmentTest
{
  @Test
  public void TestReadingFile() throws IOException
  {

    Environment environment = new Environment();
    File file = environment.getFileFromResources("database.properties");

    environment.readStringFile(file);
  }
}