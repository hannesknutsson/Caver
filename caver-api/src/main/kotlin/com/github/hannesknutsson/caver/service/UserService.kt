package com.github.hannesknutsson.caver.service

import com.github.hannesknutsson.caver.model.user.User
import com.github.hannesknutsson.caver.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun saveUser(user: User) {
        logger.info("saving user with id={}", user.id)
        userRepository.save(user);
    }

    fun getUser(id: String) : User {
        logger.info("get user with id={}", id)
        return userRepository.findById(id).orElse(null);
    }

    fun getAllUsers() : List<User> {
        return userRepository.findAll().toList();
    }

}