package com.github.hannesknutsson.caver.model.user

class UserMapper {

    companion object {
        /** Maps the user object to a userView Object to hide unnecessary data in the API */
        fun toUserView(user : User) : UserView {
            return UserView(
                id = user.id,
                displayName = user.displayName,
                profilePictureUrl = user.profilePictureUrl
            )
        }
    }
}