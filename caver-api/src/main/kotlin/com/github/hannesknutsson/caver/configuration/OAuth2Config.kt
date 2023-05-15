package com.github.hannesknutsson.caver.configuration

import com.github.hannesknutsson.caver.service.UserService
import com.github.hannesknutsson.caver.security.SpotifyAuthenticationSuccessHandler
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService

@Configuration
class OAuth2Config(
        private val userService: UserService,
        private val oauth2Service : OAuth2AuthorizedClientService
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .successHandler(SpotifyAuthenticationSuccessHandler(userService, oauth2Service))
    }
}