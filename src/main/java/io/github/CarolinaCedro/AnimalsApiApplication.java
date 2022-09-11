package io.github.CarolinaCedro;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AnimalsApiApplication implements CommandLineRunner {
    @Autowired
    AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(AnimalsApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Animal animal = new Animal("Ana Carolina", "Feia", 1.67, "Amarelo", 27);
        Animal animal2 = new Animal("Ana Carolina", "Feia", 1.67, "Amarelo", 27);
        Animal animal3 = new Animal("Ana Carolina", "Feia", 1.67, "Amarelo", 27);
        animalRepository.saveAll(Arrays.asList(animal,animal2,animal3));
    }
}
