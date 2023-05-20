package com.github.hannesknutsson.caver.security

import com.github.hannesknutsson.caver.model.SpotifyAttributeConstants
import com.github.hannesknutsson.caver.model.User
import com.github.hannesknutsson.caver.service.UserService
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class SpotifyAuthenticationSuccessHandler(
        private val userService: UserService,
        private val oauth2Service: OAuth2AuthorizedClientService) : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
        if (authentication is OAuth2AuthenticationToken) {
            val clientRegistrationId = authentication.authorizedClientRegistrationId;
            val client = oauth2Service.loadAuthorizedClient<OAuth2AuthorizedClient>(clientRegistrationId, authentication.name);
            if (client != null) {
                persistAuthenticatedUser(authentication, client)
            }
        }

        response.sendRedirect("/");
    }

    private fun persistAuthenticatedUser(authentication: OAuth2AuthenticationToken, client: OAuth2AuthorizedClient) {
        val spotifyAttributes = authentication.principal.attributes;

        val user = User(
                id = spotifyAttributes.getValue(SpotifyAttributeConstants.ID_KEY) as String,
                displayName = spotifyAttributes.getValue(SpotifyAttributeConstants.DISPLAY_NAME_KEY) as String,
                grantedAuthorities = authentication.principal.authorities.stream().map { v -> v.authority }.collect(Collectors.toList()),
                accessTokenValue = client.accessToken.tokenValue,
                accessTokenIssuedAt = client.accessToken.issuedAt!!,
                accessTokenExpiresAt = client.accessToken.expiresAt!!,
                refreshTokenValue = client.refreshToken?.tokenValue!!,
                refreshTokenIssuedAt = client.refreshToken?.issuedAt!!)

        userService.saveUser(user)
    }


}