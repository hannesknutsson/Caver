package com.github.hannesknutsson.caver.controller

import com.github.hannesknutsson.caver.service.UserService
import com.github.hannesknutsson.caver.security.AuthorizedUser
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Controller
class IndexController(
        private val userService: UserService
) {

    @GetMapping("/")
    fun index(): String {
        return "index.html";
    }
}
