package hr.algebra.hardwerebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HardwereBackendApplication

fun main(args: Array<String>) {
    runApplication<HardwereBackendApplication>(*args)
}
