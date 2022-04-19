package se.mau.webbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class WebbserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebbserverApplication.class, args);
    }
}
