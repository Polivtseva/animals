package com.example.animals.interfaces;

import com.example.animals.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal, Long> {
}
