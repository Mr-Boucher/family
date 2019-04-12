package refresher;

import refresher.executer.Executer;
import refresher.executer.ExecuterException;
import refresher.executer.ExecutionResult;

public class RefresherExecutor extends Executer
{
  public ExecutionResult execute() throws ExecuterException
  {
    System.out.println( "I am a RefresherExecutor" );
    return null;
  }
}
