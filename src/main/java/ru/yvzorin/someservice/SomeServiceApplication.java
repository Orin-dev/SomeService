package ru.yvzorin.someservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author Yury Zorin
 */
@EnableSpringDataWebSupport
@SpringBootApplication
public class SomeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SomeServiceApplication.class, args);
    }

}
