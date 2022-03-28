package com.github.hannesknutsson.caver

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
    }

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("eventName", "FIFA 2018")
        return "index"
    }
}