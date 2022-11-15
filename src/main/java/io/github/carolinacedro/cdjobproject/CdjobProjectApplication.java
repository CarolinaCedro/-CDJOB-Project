package io.github.carolinacedro.cdjobproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class CdjobProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdjobProjectApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("senha123"));
    }

}
