package com.ahmedroid.simpleCRUD.controller

import com.ahmedroid.simpleCRUD.entity.Animal
import com.ahmedroid.simpleCRUD.entity.SimpleErrorEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ahmedroid.simpleCRUD.service.AnimalsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.IllegalArgumentException

@RestController
@RequestMapping
class AnimalsController(private val service: AnimalsService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun exceptionHandler(e: NoSuchElementException): ResponseEntity<SimpleErrorEntity> {
        return ResponseEntity(SimpleErrorEntity(), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun badRequestHandler(e: IllegalArgumentException): ResponseEntity<SimpleErrorEntity> {
        return ResponseEntity(SimpleErrorEntity(), HttpStatus.BAD_REQUEST)
    }

    @GetMapping("/api/animals")
    fun getAnimals(): List<Animal> = service.getAnimals()

    @GetMapping("/api/animal/{id}")
    fun getAnimalBy(@PathVariable id: Long) = service.getAnimals().first { it.id == id }

    @PostMapping("/api/createAnimal")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAnimal(@RequestBody animal: Animal) : Animal = service.addAnimal(animal)

    @PatchMapping("/api/updateAnimal")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateAnimal(@RequestBody animal: Animal) : Animal = service.updateAnimal(animal)

    @DeleteMapping("/api/deleteAnimal")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAnimal(@RequestBody animal: Animal): Unit = service.deleteAnimal(animal)
}