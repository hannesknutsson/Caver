package com.github.hannesknutsson.caver.controller

import com.github.hannesknutsson.caver.model.show.Show
import com.github.hannesknutsson.caver.service.ShowService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shows")
class ShowController(
        private val showService: ShowService
) {
    @GetMapping
    fun getShows() : List<Show> {
        return showService.getAllShows();
    }
}
