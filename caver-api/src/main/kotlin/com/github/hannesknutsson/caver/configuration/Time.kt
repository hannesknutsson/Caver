package com.github.hannesknutsson.caver.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class Time {

    @Bean
    fun clock() : Clock = Clock.systemDefaultZone()

}