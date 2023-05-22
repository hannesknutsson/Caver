package com.github.hannesknutsson.caver.model.show

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable

@RedisHash("show")
data class Show(
    var id: String,
    var name: String,
    var publisher: String,
    var description: String,
    var imageUrl: String
) : Serializable
