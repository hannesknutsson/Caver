package com.github.hannesknutsson.caver

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal


@Controller
class MainController : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
    }

    //Continue here: https://www.baeldung.com/spring-boot-vue-js
    //And here: https://www.baeldung.com/sso-spring-security-oauth2
    @GetMapping("/")
    fun index(model: Model, principal: Principal): String {
        model.addAttribute("eventName", "FIFA 2018")
        println(principal)
        asödlfkjaösldfk
        return "index"
    }
}
