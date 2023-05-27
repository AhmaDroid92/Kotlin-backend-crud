package com.ahmedroid.simpleCRUD

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class SimpleCrudApplication

fun main(args: Array<String>) {
	runApplication<SimpleCrudApplication>(*args)
}
