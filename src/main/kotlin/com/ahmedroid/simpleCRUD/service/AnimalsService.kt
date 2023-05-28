package com.ahmedroid.simpleCRUD.service

import com.ahmedroid.simpleCRUD.entity.Animal
import org.springframework.stereotype.Service
import com.ahmedroid.simpleCRUD.repo.AnimalRepo

@Service
class AnimalsService(private val repo : AnimalRepo) {

    fun getAnimals(): List<Animal> = repo.getAnimals()

    fun addAnimal(animal: Animal): Animal = repo.addAnimal(animal)

    fun updateAnimal(animal: Animal): Animal = repo.updateAnimal(animal)

    fun deleteAnimal(animal: Animal): Unit = repo.deleteAnimal(animal)
}