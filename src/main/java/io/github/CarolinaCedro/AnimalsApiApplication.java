package io.github.CarolinaCedro;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AnimalsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalsApiApplication.class, args);
    }
}
