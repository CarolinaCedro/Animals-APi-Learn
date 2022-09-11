package io.github.CarolinaCedro.service;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    public Animal update(Animal animal, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Animal> optional = animalRepository.findById(id);
        if (optional.isPresent()) {
            Animal db = optional.get();
            db.setNome(animal.getNome());
            db.setCor(animal.getCor());
            db.setIdade(animal.getIdade());
            db.setEspecie(animal.getEspecie());
            db.setTamanho(animal.getTamanho());

            animalRepository.save(db);
            return db;
        }
        return null;
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}
