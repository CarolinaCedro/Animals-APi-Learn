package io.github.CarolinaCedro.service;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }


    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }
}
