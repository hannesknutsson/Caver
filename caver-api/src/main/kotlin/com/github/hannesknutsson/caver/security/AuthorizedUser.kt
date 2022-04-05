package com.github.hannesknutsson.caver.security

import com.github.hannesknutsson.caver.model.SpotifyAttributeConstants
import com.github.hannesknutsson.caver.model.exception.UnexpectedAuthenticationTypeException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken

class AuthorizedUser {
    companion object {
        fun getUserId(): String {
            val authentication = SecurityContextHolder.getContext().authentication
            if (authentication is OAuth2AuthenticationToken) {
                return authentication.principal.attributes.getValue(SpotifyAttributeConstants.ID_KEY) as String
            } else {
                throw UnexpectedAuthenticationTypeException(String.format("Expected %s was %s", OAuth2AuthenticationToken::class, authentication::class))
            }
        }
    }
}
