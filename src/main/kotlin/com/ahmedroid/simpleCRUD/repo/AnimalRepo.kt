package com.ahmedroid.simpleCRUD.repo

import com.ahmedroid.simpleCRUD.entity.Animal

interface AnimalRepo {

    fun getAnimals(): List<Animal>
}