package com.ahmedroid.simpleCRUD.repo

import com.ahmedroid.simpleCRUD.entity.Animal
import org.springframework.stereotype.Repository

@Repository
class AnimalRepoImpl : AnimalRepo {

    val animalsList = listOf(
        Animal(1L,"name", 30),
        Animal(1L,"name", 30),
        Animal(1L,"name", 30),
    )

    override fun getAnimals(): List<Animal> = animalsList
}