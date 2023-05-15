package com.github.hannesknutsson.caver.configuration

import com.github.hannesknutsson.caver.manager.UserManager
import com.github.hannesknutsson.caver.security.SpotifyAuthenticationSuccessHandler
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService

@Configuration
class OAuth2Config(
    private val userManager: UserManager,
    private val oauth2Service: OAuth2AuthorizedClientService
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .successHandler(SpotifyAuthenticationSuccessHandler(userManager, oauth2Service))
    }
}
