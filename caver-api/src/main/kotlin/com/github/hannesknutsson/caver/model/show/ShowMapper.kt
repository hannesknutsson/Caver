package com.github.hannesknutsson.caver.model.show

class ShowMapper {
    companion object {
        fun fromSpotifyApi(show : se.michaelthelin.spotify.model_objects.specification.Show) : Show {
            return Show(
                id = show.id,
                name = show.name,
                publisher = show.publisher,
                description = show.description,
                imageUrl =  show.images.first().url
            )
        }
    }
}