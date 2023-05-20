package com.github.hannesknutsson.caver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class CaverApplication

fun main(args: Array<String>) {
	@Suppress("SpreadOperator")
	runApplication<CaverApplication>(*args)
}
