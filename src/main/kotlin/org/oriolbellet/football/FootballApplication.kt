package org.oriolbellet.football

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FootballApplication

fun main(args: Array<String>) {
	runApplication<FootballApplication>(*args)
}
