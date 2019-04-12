package refresher.model;

import refresher.executer.ExecutionResult;

public class ThreadList extends ExecutionResult
{
  private final String message;

  public ThreadList(String message ) {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }
}
