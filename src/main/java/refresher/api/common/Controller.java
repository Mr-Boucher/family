package refresher.api.common;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Controller
{
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/health")
  public String health() {
    return "Not dead yet";
  }
}
