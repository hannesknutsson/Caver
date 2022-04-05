package com.github.hannesknutsson.caver.model

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.time.Instant

@RedisHash("user")
class User (
        val id: String,
        val displayName: String,
        val grantedAuthorities: List<String>,
        val accessTokenValue : String,
        val accessTokenIssuedAt : Instant,
        val accessTokenExpiresAt : Instant,
        val refreshTokenValue : String,
        val refreshTokenIssuedAt : Instant) : Serializable
