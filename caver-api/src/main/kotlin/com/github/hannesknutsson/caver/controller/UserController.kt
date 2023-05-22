package com.github.hannesknutsson.caver.controller

import com.github.hannesknutsson.caver.model.user.UserMapper
import com.github.hannesknutsson.caver.model.user.UserView
import com.github.hannesknutsson.caver.service.UserService
import com.github.hannesknutsson.caver.security.AuthorizedUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
        private val userService: UserService
) {

    @GetMapping
    fun index(): UserView {
        return UserMapper.toUserView(userService.getUser(AuthorizedUser.getUserId()));
    }
}
