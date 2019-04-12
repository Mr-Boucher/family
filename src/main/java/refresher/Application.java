package refresher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//    Threader threader = new Threader();
//    threader.initialize(new RefresherExecutor());
//    threader.run();

        SpringApplication.run(Application.class, args);
    }
}
