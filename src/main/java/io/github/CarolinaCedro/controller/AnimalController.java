package io.github.CarolinaCedro.controller;

import io.github.CarolinaCedro.entities.Animal;
import io.github.CarolinaCedro.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @PostMapping("/animais")
    public ResponseEntity saveAnimals(Animal animal){
        return ResponseEntity.ok(animalService.save(animal));
    }
}
