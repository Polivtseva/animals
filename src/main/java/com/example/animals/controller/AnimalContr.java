package com.example.animals.controller;

import com.example.animals.entity.Animal;
import com.example.animals.entity.AnimalModel;
import com.example.animals.interfaces.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalContr {

    @Autowired
    private AnimalRepo animalRepo;

    @GetMapping("/animals")
    public List<Animal> animals() {
        return animalRepo.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal animalId(@PathVariable Long id) {
        return animalRepo.findById(id).get();
    }

    @PostMapping("/animals")
    public Animal animals(@RequestBody Animal animal) {
        return animalRepo.save(animal);
    }

    @PutMapping("/animals/{id}")
    public Animal editAnimal(@PathVariable Long id, @RequestBody AnimalModel model) {
        Animal animal = animalRepo.findById(id).get();
        System.out.println(model.getName());
        animal.setName(model.getName());
        animalRepo.save(animal);

        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalRepo.deleteById(id);
        return "Animal with id=" + id + " is deleted";
    }
}
