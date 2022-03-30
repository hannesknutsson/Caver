package com.github.hannesknutsson.caver.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class IndexController {

    //Continue here: https://www.baeldung.com/spring-boot-vue-js
    //And here: https://www.baeldung.com/sso-spring-security-oauth2
    @GetMapping("/")
    fun index(model: Model, principal: Principal): String {
        model.addAttribute("eventName", "FIFA 2018")
        println(principal)
        return "index"
    }


}
