import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

public class SpringBootExample {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExample.class, args);
    }
}
