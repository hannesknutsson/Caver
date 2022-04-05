package com.github.hannesknutsson.caver.controller

import com.github.hannesknutsson.caver.manager.UserManager
import com.github.hannesknutsson.caver.security.AuthorizedUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController(
        private val userManager: UserManager
) {

    @GetMapping("/")
    fun index(): String {
        return "Logged in as " + userManager.getUser(AuthorizedUser.getUserId()).id
    }
}
