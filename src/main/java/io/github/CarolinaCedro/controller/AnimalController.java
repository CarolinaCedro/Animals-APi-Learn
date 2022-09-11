package io.github.CarolinaCedro.controller;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/animais")
    public ResponseEntity animais() {
        return ResponseEntity.ok(animalService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity animaisById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(animalService.findById(id));
    }

    @PostMapping
    public ResponseEntity saveAnimals(@RequestBody Animal animal) {
        Animal a = animalService.save(animal);
        URI location = getUri(a.getID());
        return ResponseEntity.created(location).build();
    }


    @PutMapping("{id}")
    public ResponseEntity updateAnimals(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setID(id);

        Animal UpdateAnimal = animalService.update(animal, id);
        return UpdateAnimal != null ?
                ResponseEntity.ok(UpdateAnimal) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAnimals(@PathVariable("id") Long id) {
        animalService.delete(id);
        return ResponseEntity.ok().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
