package com.github.hannesknutsson.caver.configuration

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig(@Value("\${redis.hostname") private val hostname: String,
                  @Value("\${redis.port}") private val port: Int,
                  @Value("\${redis.username}") private val username: String,
                  @Value("\${redis.password}") private val password: String) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        logger.info("Setting up Redis Connection Factory...")
        val redisStandaloneConfiguration = RedisStandaloneConfiguration()
        redisStandaloneConfiguration.hostName = hostname
        redisStandaloneConfiguration.port = port
        redisStandaloneConfiguration.username = username
        redisStandaloneConfiguration.password = RedisPassword.of(password)

        return LettuceConnectionFactory(redisStandaloneConfiguration)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(redisConnectionFactory())
        return template
    }

}