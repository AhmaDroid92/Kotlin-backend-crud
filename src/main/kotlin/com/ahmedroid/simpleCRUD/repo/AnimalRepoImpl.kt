package com.ahmedroid.simpleCRUD.repo

import com.ahmedroid.simpleCRUD.entity.Animal
import org.springframework.stereotype.Repository
import kotlin.IllegalArgumentException

@Repository
class AnimalRepoImpl : AnimalRepo {

    val animalsList = mutableListOf(
        Animal(1L, "name", 30),
        Animal(2L, "name", 30),
        Animal(3L, "name", 30),
    )

    override fun getAnimals(): List<Animal> = animalsList

    override fun addAnimal(animal: Animal): Animal {
        if (animalsList.any { it.id == animal.id }) throw IllegalArgumentException("Animal already in the zoo")
        animalsList.add(animal)
        return animalsList.first { it.id == animal.id }
    }

    override fun updateAnimal(animal: Animal): Animal = animalsList.let {
        val currentAnimal = it.firstOrNull { it.id == animal.id } ?: throw NoSuchElementException()

        it.remove(currentAnimal)
        it.add(animal)

        animal
    }

    override fun deleteAnimal(animal: Animal): Unit = animalsList.let {
        val currentAnimal = it.firstOrNull { it.id == animal.id } ?: throw NoSuchElementException()

        it.remove(currentAnimal)
    }
}
