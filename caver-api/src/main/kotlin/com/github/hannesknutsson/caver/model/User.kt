package com.github.hannesknutsson.caver.model

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.time.Instant

@RedisHash("user")
data class User (
        var id: String,
        var displayName: String,
        var grantedAuthorities: List<String>,
        var accessTokenValue : String,
        var accessTokenIssuedAt : Instant,
        var accessTokenExpiresAt : Instant,
        var refreshTokenValue : String,
        var refreshTokenIssuedAt : Instant) : Serializable
