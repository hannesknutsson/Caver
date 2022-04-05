package com.github.hannesknutsson.caver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaverApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<CaverApplication>(*args)
}
