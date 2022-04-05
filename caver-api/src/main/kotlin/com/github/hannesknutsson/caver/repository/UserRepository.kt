package com.github.hannesknutsson.caver.repository

import com.github.hannesknutsson.caver.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, String>
