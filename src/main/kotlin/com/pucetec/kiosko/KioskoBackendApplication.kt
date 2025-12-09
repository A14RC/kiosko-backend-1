package com.pucetec.kiosko

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KioskoBackendApplication

fun main(args: Array<String>) {
	runApplication<KioskoBackendApplication>(*args)
}
