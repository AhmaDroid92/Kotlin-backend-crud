package com.ahmedroid.simpleCRUD.repo

import com.ahmedroid.simpleCRUD.entity.Animal

interface AnimalRepo {

    fun getAnimals(): List<Animal>

    fun addAnimal(animal: Animal) : Animal

    fun updateAnimal(animal: Animal) : Animal

    fun deleteAnimal(animal: Animal) : Unit
}