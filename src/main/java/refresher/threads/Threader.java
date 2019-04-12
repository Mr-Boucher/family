package refresher.threads;

import refresher.executer.Executer;

public class Threader
{
  private Executer process;

  public void initialize(Executer process )
  {
    this.process = process;
  }

  public void run()
  {
    process.execute();
  }

}
