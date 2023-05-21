package com.github.hannesknutsson.caver.service

import com.github.hannesknutsson.caver.model.show.Show
import com.github.hannesknutsson.caver.model.exception.ShowException
import com.github.hannesknutsson.caver.repository.ShowRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ShowService(
        private val showRepository: ShowRepository,
        private val spotifyService: SpotifyService,
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun addShow(id: String) {
        logger.info("adding show with id={}", id)
        if (showRepository.existsById(id)) {
            throw ShowException("Show already exists");
        }
        val show = spotifyService.getShowById(id)
        showRepository.save(show);
    }

    fun deleteShow(id: String) {
        logger.info("delete show with id={}", id)
        if (!showRepository.existsById(id)) {
            throw ShowException("Show does not exist")
        }
        return showRepository.deleteById(id);
    }

    fun getAllShows() : List<Show> {
        return showRepository.findAll().toList();
    }

}