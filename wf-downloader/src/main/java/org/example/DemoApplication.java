package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String arg[]) {
        SpringApplication application = new SpringApplication(DemoApplication.class);

        application.run(arg);
    }


}
