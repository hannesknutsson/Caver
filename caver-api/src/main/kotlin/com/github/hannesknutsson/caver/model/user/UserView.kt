package com.github.hannesknutsson.caver.model.user

import java.io.Serializable


data class UserView(
    var id: String,
    var displayName: String,
    var profilePictureUrl: String?,
) : Serializable