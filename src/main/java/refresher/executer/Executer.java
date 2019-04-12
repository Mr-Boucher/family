package refresher.executer;

public abstract class Executer
{
  public abstract ExecutionResult execute() throws ExecuterException;

  protected ExecutionResult doExecute() throws ExecuterException
  {
    System.out.println( "Started executing ???");
    ExecutionResult result = execute();
    System.out.println( "Finished executing ???");
    return result;
  }
}
