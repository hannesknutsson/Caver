package com.github.hannesknutsson.caver.service;

import com.github.hannesknutsson.caver.model.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.SpotifyApi
import java.time.Clock
import java.time.Instant

@Service
class SpotifyService(
        private val userService: UserService,
        private val clock: Clock,
        @Value("\${spring.security.oauth2.client.registration.custom.client-id}") private val clientId: String,
        @Value("\${oauth2.secret}") private val clientSecret: String
) {

    private val logger = LoggerFactory.getLogger(javaClass)
    companion object {
        fun getApiForUser(clientId: String, clientSecret: String, user: User) : SpotifyApi =
            SpotifyApi.builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setAccessToken(user.accessTokenValue)
                    .build()
    }

    @Scheduled(cron = "0 */5 * * * *")
    fun refreshAllTokens() {
        val users = userService.getAllUsers()
        for (user in users) {
            if (Instant.now(clock).plusSeconds(60 * 10).isAfter(user.accessTokenExpiresAt)) {
                val updatedUser = refreshAuthorizationToken(user)
                userService.saveUser(updatedUser)
                logger.info("Updated access token for user {}", user.displayName)
            }
        }
    }

    fun refreshAuthorizationToken(user: User) : User {
        val now = Instant.now(clock)
        val api = SpotifyApi.builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setAccessToken(user.accessTokenValue)
                .setRefreshToken(user.refreshTokenValue)
                .build()
        val newCredentialsForUser = api.authorizationCodeRefresh().build().execute()
        user.accessTokenValue = newCredentialsForUser.accessToken
        user.accessTokenIssuedAt = now
        user.accessTokenExpiresAt = now.plusSeconds(newCredentialsForUser.expiresIn.toLong())
        return user
    }
}
