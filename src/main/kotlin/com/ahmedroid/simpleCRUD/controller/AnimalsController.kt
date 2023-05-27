package com.ahmedroid.simpleCRUD.controller

import com.ahmedroid.simpleCRUD.entity.Animal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ahmedroid.simpleCRUD.service.AnimalsService

@RestController
@RequestMapping
class AnimalsController(private val service: AnimalsService) {

    @GetMapping("/api/animals")
    fun getAnimals(): List<Animal> = service.getAnimals()
}